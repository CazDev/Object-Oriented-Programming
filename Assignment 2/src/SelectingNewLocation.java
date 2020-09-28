import java.util.*;

public class SelectingNewLocation implements State {

    public void Action(int x, int y, Stage stage, StateController stateController){
        Optional<Cell> clicked = Optional.empty();
        for (Cell c : stage.cellOverlay) {
            if (c.contains(x, y)) {
                clicked = Optional.of(c);
            }
        }
        if (clicked.isPresent() && stage.actorInAction.isPresent()) {
            stage.cellOverlay = new ArrayList<Cell>();
            stage.actorInAction.get().setLocation(clicked.get());
            stage.actorInAction.get().turns--;
            stage.menuOverlay.add(new MenuItem("Fire", x, y, () -> {
                stage.cellOverlay = stage.grid.getRadius(stage.actorInAction.get().loc, stage.actorInAction.get().range, false);
                stage.cellOverlay.remove(stage.actorInAction.get().loc);
                stateController.setState(stateController.SelectingTarget);
            }));
            stateController.setState(stateController.SelectingMenuItem);
        } 
    }
    
    public String toString() {
        return "SelectingNewLocation";
    }

}
import java.util.Optional;

public class ChoosingActor implements State {

    public void Action(int x, int y, Stage stage, StateController stateController){
        stage.actorInAction = Optional.empty();
        for (Actor a : stage.actors) {
            if (a.loc.contains(x, y) && a.isTeamRed() && a.turns > 0) {
                stage.cellOverlay = stage.grid.getRadius(a.loc, a.moves, true);
                stage.actorInAction = Optional.of(a);
                stateController.setState(stateController.SelectingNewLocation);
            }
        }
        if(!stage.actorInAction.isPresent()){
            stateController.setState(stateController.SelectingMenuItem);
            stage.menuOverlay.add(new MenuItem("Oops", x, y, () -> stateController.setState(stateController.ChoosingActor)));
            stage.menuOverlay.add(new MenuItem("End Turn", x, y+MenuItem.height, () -> stateController.setState(stateController.CPUMoving)));
            stage.menuOverlay.add(new MenuItem("End Game", x, y+MenuItem.height*2, () -> System.exit(0)));
        }
    }
    
    public String toString() {
        return "ChoosingActor";
    }

}
import java.util.*;

public class SelectingMenuItem implements State {

    public void Action(int x, int y, Stage stage, StateController stateController){
        for(MenuItem mi : stage.menuOverlay){
            if (mi.contains(x,y)){
                mi.action.run();
                stage.menuOverlay = new ArrayList<MenuItem>();
            }
        }
    }
    
    public String toString() {
        return "SelectingMenuItem";
    }

}
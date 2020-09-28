public class StateController {

    State ChoosingActor;
    State SelectingNewLocation;
    State CPUMoving;
    State SelectingMenuItem;
    State SelectingTarget;

    State state;

    public StateController() {
        ChoosingActor = new ChoosingActor();
        SelectingNewLocation = new SelectingNewLocation();
        CPUMoving = new CPUMoving();
        SelectingMenuItem = new SelectingMenuItem();
        SelectingTarget = new SelectingTarget();
    }

    public void setState(State state) {
        this.state = state;
    }
    
    public State getState() {
        return this.state;
    }

    public void action(int x, int y, Stage stage, StateController stateController){
        state.Action(x, y, stage, stateController);
    }
    
}
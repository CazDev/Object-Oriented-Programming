import java.awt.Graphics;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.*;

public class CPUMoving implements GameState {
    
    public static Lock lock = new ReentrantLock();
    
    @Override
    public void mouseClick(int x, int y, Stage s) {
    }

    @Override
    public void paint(Graphics g, Stage s) {
    
        //ExecutorService executor = Executors.newSingleThreadExecutor();
    
        for(Actor a: s.actors){
            if (!a.isTeamRed() && !a.moving && !(a instanceof ImpAdapter)){
                System.out.println("moving an actor"+a.toString());
                a.moving = true;
                //executor.submit(() -> {
                
                    Thread thread = new Thread(){
                        public void run(){
                            List<Cell> possibleLocs = s.getClearRadius(a.getLocation(), a.moves, true);
                            Optional<Cell> nextLoc = a.strat.chooseNextLoc(a, s, possibleLocs);
                            if (nextLoc.isPresent()){
                                a.setLocation(nextLoc.get());
                            }
                            a.moving = false;
                        }
                      };
                      thread.start();
                //});
            } 
        }
        s.currentState = new ChoosingActor();
        for(Actor a: s.actors){
            a.turns = 1;
        }
    }

}
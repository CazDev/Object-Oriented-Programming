import java.util.*;

public class GetToA0 implements MoveStrategy {

    @Override
    public Optional<Cell> chooseNextLoc(Actor a, Stage s, List<Cell> possibleLocs) {
        // ignore possible locs
        // build a path to A0 and travel as far along it as I can
        CPUMoving.lock.lock();
        PathFinder pf = new PathFinder();
        CPUMoving.lock.unlock();
        CPUMoving.lock.lock();
        List<Cell> path = pf.findPath(a.getLocation(), s.grid.cellAtColRow('A', 0).get(), s.grid, s.occupiedCells());
        CPUMoving.lock.unlock();
        if (path.size() == 0){
            System.out.println("empty path found");
            return Optional.empty();
        } else {
            System.out.println(a.moves);
            return Optional.of(path.get(Math.min(path.size()-1, a.moves)));
        }
    }

    @Override
    public String toString(){
        return "get to the chopper";
    }

}
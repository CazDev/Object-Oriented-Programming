import java.util.*;

class PathFinder {

    private class Node {
        int costSoFar;
        Cell current;
        List<Cell> pathSoFar;
        Node(Cell c, int cost, List<Cell> psf){
            costSoFar = cost;
            current = c;
            pathSoFar = psf;
        }
    }
    public List<Cell> findPath(Cell from, Cell to, Grid land, Set<Cell> occupied){
        System.out.println("pathfinding..." +from.col + from.row+ " -> " +to.col + to.row);
        
        CPUMoving.lock.lock();
        land.doToEachCell((c) -> c.ticked = false);
        Queue<Node> frontier = new PriorityQueue<Node>(1000, (a, b) -> Integer.compare(a.costSoFar, b.costSoFar));
        frontier.add(new Node(from, 0, new ArrayList<Cell>()));
        Node curr = frontier.remove();
        CPUMoving.lock.unlock();
        while (curr.current != to){
            CPUMoving.lock.lock();
            List<Cell> neighbours = land.getRadius(curr.current, 1, false);
            neighbours.removeAll(occupied);
            CPUMoving.lock.unlock();
            for (Cell c: neighbours){
                if (!c.ticked){
                    CPUMoving.lock.lock();
                    c.ticked = true;
                    List<Cell> newPath = new ArrayList<Cell>(curr.pathSoFar);
                    newPath.add(c);
                    frontier.add(new Node(c, curr.costSoFar + c.movementCost(), newPath));
                    CPUMoving.lock.unlock();
                }
            }
            if (frontier.size() > 0){
                CPUMoving.lock.lock();
                curr = frontier.remove();
                CPUMoving.lock.unlock();
            } else {
                break;
            }
        }
        
        System.out.println("... path found");
        return curr.pathSoFar;
        
    }

    public int pathCost(List<Cell> path){
        int ret = 0;
        for(Cell c: path){
            ret = ret + c.movementCost();
        }
        return ret;
    }


}
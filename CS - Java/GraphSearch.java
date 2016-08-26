import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphSearch {

	/**
	 * Searches the Graph passed in as an AdjcencyList(adjList) to find if a path exists from the start node to the goal node
	 * using General Graph Search.
	 *
	 * Assume the AdjacencyList contains adjacent nodes of each node in the order they should be added to the Structure.
	 *
	 * The structure(struct) passed in is an empty structure may behave as a Stack or Queue and the
	 * correspondingly search function should execute DFS(Stack) or BFS(Queue) on the graph.
	 *
	 * @param start
	 * @param struct
	 * @param adjList
	 * @param goal
	 * @return true if path exists false otherwise
	 */
	public static <T> boolean generalGraphSearch(T start, Structure<T> struct, Map<T, List<T>> adjList, T goal) {
		boolean bool = false;
		List<T> adj;
		List<T> checkedItems = new LinkedList<T>();
		struct.add(start);
		while (!struct.isEmpty()) {
		    T removedItem = struct.remove();
		    checkedItems.add(removedItem);
		    if (removedItem.equals(goal)) {
			   	bool = true;
			   	struct.clear();
		    } else {
		        adj = adjList.get(removedItem);
		        for (T items: adj) {
		        	if (!checkedItems.contains(items)) {
				        struct.add(items);
		        	}
			    }
		    }
		}
		return bool;
	}
	
	/**
	 * Searches the Graph passed in as an AdjcencyList(adjList) to find if a path exists from the start node to the goal node
	 * using Bredth First Search.
	 *
	 * Assume the AdjacencyList contains adjacent nodes of each node in the order they should be added to the Structure.
	 *
	 * @param start
	 * @param adjList
	 * @param goal
	 * @return true if path exists false otherwise
	 */
	public static <T> boolean breadthFirstSearch(T start, Map<T, List<T>> adjList, T goal) {
		return generalGraphSearch(start, new StructureQueue<T>(), adjList, goal);
	}
	
	/**
	 * Searches the Graph passed in as an AdjcencyList(adjList) to find if a path exists from the start node to the goal node
	 * using Depth First Search.
	 *
	 * Assume the AdjacencyList contains adjacent nodes of each node in the order they should be added to the Structure.
	 *
	 * @param start
	 * @param adjList
	 * @param goal
	 * @return true if path exists false otherwise
	 */
	public static <T> boolean depthFirstSearch(T start, Map<T, List<T>> adjList, T goal) {
		return generalGraphSearch(start, new StructureStack<T>(), adjList, goal);
	}
	
	/**
	 * Find the shortest distance between the start node and the goal node in the given a weighted graph
	 * in the form of an adjacency list where the edges only have positive weights
	 * Return the aforementioned shortest distance if there exists a path between the start and goal,-1
	 * otherwise.
	 *
	 *
	 * @param start
	 * @param adjList
	 * @param goal
	 * @return the shortest distance between the start and the goal node
	 */
	public static <T> int djikstraShortestPathAlgorithm(T start, Map<T, List<Pair<T, Integer>>> adjList, T goal) {
		int distance = -1;
		Set<T> settledSet = new HashSet<T>();
		Map<T, Integer> distanceMap = new HashMap<T, Integer>();
		List<T> unsettledSet = new LinkedList<T>();
		if (start.equals(goal)) {
			if (!adjList.get(start).isEmpty()) {
				distance = 0;
			}
		} else {
			distanceMap.put(start, 0);
			unsettledSet.add(start);
			while (!unsettledSet.isEmpty()) {
				//iterate through list to find lowest distance item
				T lowestItem = unsettledSet.get(0);
				Integer lowestDistance = distanceMap.get(lowestItem);
				for (T items: unsettledSet) {
					Integer dis = distanceMap.get(items);
					if (dis < lowestDistance) {
						lowestDistance = dis;
						lowestItem = items;
					}
				}
				unsettledSet.remove(lowestItem);
				T removedItem = lowestItem;
				settledSet.add(removedItem);
				List<Pair<T, Integer>> adj = adjList.get(removedItem);
				for (Pair<T, Integer> items: adj) {
					if (!settledSet.contains(items.a)) {
						if (distanceMap.containsKey(items.a)) {
							Integer oldDistance = distanceMap.get(items.a);
							Integer newDistance = (items.b + distanceMap.get(removedItem));
							if (newDistance < oldDistance) {
								distanceMap.put(items.a, newDistance);
							}
						} else {
							distanceMap.put(items.a, (items.b + distanceMap.get(removedItem)));
						}
						if (!unsettledSet.contains(items.a)) {
							unsettledSet.add(items.a);
					    }
					}
				}
			}
			if (distanceMap.containsKey(goal)) {
				distance = distanceMap.get(goal);
			}
		}
		return distance;
	}
	
}
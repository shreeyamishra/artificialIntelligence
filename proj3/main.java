package proj3;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class main {

	static PriorityQueue<Node> queue = null;
	static List<Polygon> poly1 = new ArrayList<Polygon>();

	public static void main(String[] args) {

		Rectangle field = new Rectangle(0, 0, 50, 10);
		//		   Rectangle bounds = new Rectangle();

		int[] xpoints = {2,2,4,4};
		int[] ypoints = {1,2,1,2};

		poly1.add(new Polygon(xpoints, ypoints , 4));
		//		Polygon poly = new Polygon(x, y, 4);



		Node startNode = new Node(new Point(1,1));
		Point goalPoint = new Point(49, 9);
		long startTime = 0;
		long endTime = 0;
		//		poly.getBounds().intersectsLine();

		Polygon goalPoly = new Polygon();
		goalPoly.addPoint(goalPoint.x, goalPoint.y);
		poly1.add(goalPoly);

		startTime = System.currentTimeMillis() % 1000;
		Node UniformCostSolution = UniformCostSearch(startNode, goalPoint);
		endTime = System.currentTimeMillis() % 1000;

		long uniformTime = endTime - startTime;
		//time for uniform cost search 

		startTime = System.currentTimeMillis() % 1000;
		Node AStarSolution = AStarSearch(startNode, goalPoint);
		endTime = System.currentTimeMillis() % 1000;

		long AStarTime = endTime - startTime;

		//time for a star search

		System.out.println("Uniform Cost Search Time: " + uniformTime);
		System.out.println("results");
		for (Node i = UniformCostSolution; i != null; i = i.previous) {
			System.out.println(i);
		}
		System.out.println();
		System.out.println("A Star Search Time: " + AStarTime);
		System.out.println("results");
		for (Node i = AStarSolution; i != null; i = i.previous) {
			System.out.println(i);
		}

	}



	private static Node UniformCostSearch(Node node, Point goal) {
		queue = new PriorityQueue<Node>(50, new Comparator<Node>() {
			public int compare(Node a, Node b) {
				if (a.totalCost > b.totalCost)
					return 1;
				else if (a.totalCost < b.totalCost)
					return -1;
				else 
					return 0;
			}
		});

		if(!queue.contains(node.point.getX()) && !queue.contains(node.point.getY()))
			queue.add(node);

		while (!queue.isEmpty()) {
			Node o = queue.poll();

			if (o.point.equals(goal)) {
				return o;
				//return the object if it's the goal state

			}

			for(int i = 0; i < poly1.size(); i++) {
				Polygon poly = poly1.get(i);
				for(int k = 0; k < poly.npoints; k++) {
					Line2D line = new Line2D.Double(o.point.x + 0.1, o.point.y + 0.1, poly.xpoints[k] - 0.1, poly.ypoints[k] - 0.1);
					boolean intersectsPolygon = false;
					for (int q = 0; q < poly1.size(); q++) {
						if (line.intersects(poly1.get(q).getBounds2D())) {
							intersectsPolygon = true;		
							//							System.out.println(intersectsPolygon);
						}
					}

					if (!intersectsPolygon) {
						Node next = new Node(new Point(poly.xpoints[k], poly.ypoints[k]));
						next.previous = o;
						next.totalCost = Math.sqrt(Math.pow(o.point.x - next.point.x, 2) + (Math.pow(o.point.y - next.point.y, 2))) + o.totalCost;
						queue.add(next);
					}

					Line2D realLine = new Line2D.Double(o.point.x, o.point.y, poly.xpoints[k], poly.ypoints[k]);
					System.out.println("Uniform Cost Search");
					System.out.println(realLine.getX1());
					System.out.println(realLine.getY1());
					System.out.println(realLine.getX2());
					System.out.println(realLine.getY2());
					System.out.println(realLine.contains(goal));
					if (!intersectsPolygon && realLine.contains(goal)) {
						Node next = new Node(new Point(goal.x, goal.y));
						next.previous = o;
						next.totalCost = Math.sqrt(Math.pow(o.point.x - next.point.x, 2) + (Math.pow(o.point.y - next.point.y, 2))) + o.totalCost;
						queue.add(next);
					}
				}
			}

			System.out.println(queue);

		}
		return null;
	}

	private static Node AStarSearch(Node node, final Point goal) {
		queue = new PriorityQueue<Node>(50, new Comparator<Node>() {
			@Override
			public int compare(Node a, Node b) {
				double costA = a.totalCost + Math.sqrt(Math.pow(a.point.x - goal.x, 2) + (Math.pow(a.point.y - goal.y, 2)));
				double costB = b.totalCost + Math.sqrt(Math.pow(b.point.x - goal.x, 2) + (Math.pow(b.point.y - goal.y, 2)));

				if (costA > costB)
					return 1;
				else if (costA < costB)
					return -1;
				else 
					return 0;
			}
		});
		if(!queue.contains(node.point.getX()) && !queue.contains(node.point.getY()))
			queue.add(node);

		while (!queue.isEmpty()) {
			Node o = queue.poll();

			if (o.point.equals(goal)) {
				return o;
			}

			for(int i = 0; i < poly1.size(); i++) {
				Polygon poly = poly1.get(i);
				for(int k = 0; k < poly.npoints; k++) {
					Line2D line = new Line2D.Double(o.point.x + 0.1, o.point.y + 0.1, poly.xpoints[k] - 0.1, poly.ypoints[k] - 0.1);
					boolean intersectsPolygon = false;
					for (int q = 0; q < poly1.size(); q++) {
						if (line.intersects(poly1.get(q).getBounds2D())) {
							intersectsPolygon = true;
						}
					}

					if (!intersectsPolygon) {
						Node next = new Node(new Point(poly.xpoints[k], poly.ypoints[k]));
						next.previous = o;
						next.totalCost = Math.sqrt(Math.pow(o.point.x - next.point.x, 2) + (Math.pow(o.point.y - next.point.y, 2))) + o.totalCost;
						queue.add(next);
					}

					Line2D realLine = new Line2D.Double(o.point.x, o.point.y, poly.xpoints[k], poly.ypoints[k]);
					System.out.println("A Star Search");
					System.out.println(realLine.getX1());
					System.out.println(realLine.getY1());
					System.out.println(realLine.getX2());
					System.out.println(realLine.getY2());
					System.out.println(realLine.contains(goal));
					if (!intersectsPolygon && realLine.contains(goal)) {
						Node next = new Node(new Point(goal.x, goal.y));
						next.previous = o;
						next.totalCost = Math.sqrt(Math.pow(o.point.x - next.point.x, 2) + (Math.pow(o.point.y - next.point.y, 2))) + o.totalCost;
						queue.add(next);
					}
				}
			}

			System.out.println(queue);

		}
		return null;
	}

}

class Node {
	Point point;
	Node previous;
	double totalCost;

	public Node(Point point) {
		this.point = point;
	}
	public String toString() {
		return point.toString();
	}
}

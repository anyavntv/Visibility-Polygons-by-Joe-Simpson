package tests;

//import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.swing.JFrame;
import javax.swing.JPanel;

import visibilityPolygon.CCWPolygon;
import visibilityPolygon.VisibilityPolygon;

public class DrawVisibilityPolygons {

	public static void main(String[] args) {
		onVertexNotConvex();
	}

	private static void DC1() {
		CCWPolygon inputPol;
		List<Point2D> viewPoints;

		List<Point2D> vertices = new ArrayList<>();
		vertices.add(new Point2D.Double(2, 2));
		vertices.add(new Point2D.Double(13 / 4, 2));
		vertices.add(new Point2D.Double(3, 3));
		vertices.add(new Point2D.Double(5, 3));
		vertices.add(new Point2D.Double(5, 5));
		vertices.add(new Point2D.Double(15 / 4, 21 / 4));
		vertices.add(new Point2D.Double(4, 4));
		vertices.add(new Point2D.Double(9 / 4, 15 / 4));

		inputPol = new CCWPolygon(vertices);

		viewPoints = new ArrayList<>();
		viewPoints.add(new Point2D.Double(5 / 2, 5 / 2));
		viewPoints.add(new Point2D.Double(9 / 4, 3 / 1));

		assert (inputPol != null && viewPoints != null);
		Figure fig = new Figure(inputPol, viewPoints, 120);
	}

	private static void DC2() {
		CCWPolygon inputPol;
		List<Point2D> viewPoints;

		List<Point2D> vertices = new ArrayList<>();
		vertices.add(new Point2D.Double(171601 / 1000, 96672 / 1000));
		vertices.add(new Point2D.Double(170845 / 1000, 159416 / 1000));
		vertices.add(new Point2D.Double(176892 / 1000, 151101 / 1000));
		vertices.add(new Point2D.Double(180294 / 1000, 171889 / 1000));
		vertices.add(new Point2D.Double(101297 / 1000, 171889 / 1000));
		vertices.add(new Point2D.Double(100919 / 1000, 151101 / 1000));
		vertices.add(new Point2D.Double(109991 / 1000, 159038 / 1000));
		vertices.add(new Point2D.Double(111124 / 1000, 97428 / 1000));
		vertices.add(new Point2D.Double(102431 / 1000, 104610 / 1000));
		vertices.add(new Point2D.Double(102053 / 1000, 83065 / 1000));
		vertices.add(new Point2D.Double(179160 / 1000, 78529 / 1000));
		vertices.add(new Point2D.Double(177649 / 1000, 93271 / 1000));
		vertices.add(new Point2D.Double(165553 / 1000, 87601 / 1000));
		inputPol = new CCWPolygon(vertices);

		viewPoints = new ArrayList<>();
		viewPoints.add(new Point2D.Double(106211 / 1000, 93838 / 1000));
		viewPoints.add(new Point2D.Double(167821 / 1000, 83443 / 1000));
		viewPoints.add(new Point2D.Double(104699 / 1000, 162629 / 1000));
		viewPoints.add(new Point2D.Double(175948 / 1000, 162818 / 1000));

		assert (inputPol != null && viewPoints != null);
		Figure fig = new Figure(inputPol, viewPoints, 4);
	}

	private static void DC3Original() {
		CCWPolygon inputPol;
		List<Point2D> viewPoints;

		List<Point2D> vertices = new ArrayList<>();
		vertices.add(new Point2D.Double(1, 6));
		vertices.add(new Point2D.Double(7, 6));
		vertices.add(new Point2D.Double(7, 3 / 2));
		vertices.add(new Point2D.Double(6, 0));
		vertices.add(new Point2D.Double(5, 1));
		vertices.add(new Point2D.Double(4, 5));
		vertices.add(new Point2D.Double(4, 3));
		vertices.add(new Point2D.Double(2, 3));
		vertices.add(new Point2D.Double(0, 5));
		inputPol = new CCWPolygon(vertices);

		viewPoints = new ArrayList<>();
		viewPoints.add(new Point2D.Double(3, 5));

		assert (inputPol != null && viewPoints != null);
		Figure fig = new Figure(inputPol, viewPoints, 50);
	}

	private static void DC3Corrected() {
		CCWPolygon inputPol;
		List<Point2D> viewPoints;

		List<Point2D> vertices = new ArrayList<>();
		vertices.add(new Point2D.Double(1, 6));
		vertices.add(new Point2D.Double(0, 5));
		vertices.add(new Point2D.Double(2, 3));
		vertices.add(new Point2D.Double(4, 3));
		vertices.add(new Point2D.Double(4, 5));
		vertices.add(new Point2D.Double(5, 1));
		vertices.add(new Point2D.Double(6, 0));
		vertices.add(new Point2D.Double(7, 3 / 2));
		vertices.add(new Point2D.Double(7, 6));
		inputPol = new CCWPolygon(vertices);

		viewPoints = new ArrayList<>();
		viewPoints.add(new Point2D.Double(3, 5));

		assert (inputPol != null && viewPoints != null);
		Figure fig = new Figure(inputPol, viewPoints, 50);
	}

	private static void interiorConvex() {
		CCWPolygon inputPol;
		List<Point2D> viewPoints;

		List<Point2D> vertices = new ArrayList<>();
		vertices.add(new Point2D.Double(6, 6));
		vertices.add(new Point2D.Double(4, 6));
		vertices.add(new Point2D.Double(2, 2));
		vertices.add(new Point2D.Double(6, 2));

		inputPol = new CCWPolygon(vertices);

		viewPoints = new ArrayList<>();
		viewPoints.add(new Point2D.Double(4, 4));

		assert (inputPol != null && viewPoints != null);
		Figure fig = new Figure(inputPol, viewPoints, 50);
	}

	private static void interiorNotConvex() {
		CCWPolygon inputPol;
		List<Point2D> viewPoints;

		List<Point2D> vertices = new ArrayList<>();
		vertices.add(new Point2D.Double(-2, 2));
		vertices.add(new Point2D.Double(6, 2));
		vertices.add(new Point2D.Double(4, 6));
		vertices.add(new Point2D.Double(1, 4));
		vertices.add(new Point2D.Double(-1, 6));
		vertices.add(new Point2D.Double(-2, 4));

		inputPol = new CCWPolygon(vertices);

		viewPoints = new ArrayList<>();
		viewPoints.add(new Point2D.Double(4, 4));

		assert (inputPol != null && viewPoints != null);
		Figure fig = new Figure(inputPol, viewPoints, 50);
	}

	private static void onEdgeConvex() {
		CCWPolygon inputPol;
		List<Point2D> viewPoints;

		List<Point2D> vertices = new ArrayList<>();
		vertices.add(new Point2D.Double(6, 6));
		vertices.add(new Point2D.Double(4, 6));
		vertices.add(new Point2D.Double(2, 2));
		vertices.add(new Point2D.Double(6, 2));
		inputPol = new CCWPolygon(vertices);

		viewPoints = new ArrayList<>();
		viewPoints.add(new Point2D.Double(4, 2));


		assert (inputPol != null && viewPoints != null);
		Figure fig = new Figure(inputPol, viewPoints, 50);
	}

	public static void onEdgeNotConvex() {

		CCWPolygon inputPol;
		List<Point2D> viewPoints;

		List<Point2D> vertices = new ArrayList<>();
		vertices.add(new Point2D.Double(-2, 2));
		vertices.add(new Point2D.Double(6, 2));
		vertices.add(new Point2D.Double(4, 6));
		vertices.add(new Point2D.Double(1, 4));
		vertices.add(new Point2D.Double(-1, 6));
		vertices.add(new Point2D.Double(-2, 4));
		inputPol = new CCWPolygon(vertices);

		viewPoints = new ArrayList<>();
		viewPoints.add(new Point2D.Double(-2, 3));


		assert (inputPol != null && viewPoints != null);
		Figure fig = new Figure(inputPol, viewPoints, 40);
	}

	public static void onVertexIsConvex() {

		CCWPolygon inputPol;
		List<Point2D> viewPoints;

		List<Point2D> vertices = new ArrayList<>();
		vertices.add(new Point2D.Double(6, 6));
		vertices.add(new Point2D.Double(4, 6));
		vertices.add(new Point2D.Double(2, 2));
		vertices.add(new Point2D.Double(6, 2));
		inputPol = new CCWPolygon(vertices);

		viewPoints = new ArrayList<>();
		viewPoints.add(new Point2D.Double(6, 2));


		assert (inputPol != null && viewPoints != null);
		Figure fig = new Figure(inputPol, viewPoints, 50);
	}

	public static void onVertexNotConvex() {

		CCWPolygon inputPol;
		List<Point2D> viewPoints;

		List<Point2D> vertices = new ArrayList<>();
		vertices.add(new Point2D.Double(-2, 2));
		vertices.add(new Point2D.Double(6, 2));
		vertices.add(new Point2D.Double(4, 6));
		vertices.add(new Point2D.Double(1, 3));
		vertices.add(new Point2D.Double(-1, 6));
		vertices.add(new Point2D.Double(-2, 4));
		inputPol = new CCWPolygon(vertices);

		viewPoints = new ArrayList<>();
		viewPoints.add(new Point2D.Double(-1, 6));



		assert (inputPol != null && viewPoints != null);
		Figure fig = new Figure(inputPol, viewPoints, 50);
	}
}


class Figure extends JPanel {

	private Path2D inputPol;
	private List<Path2D> visPolygons;
	private List<Path2D> viewPoints;

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g.create();
		g2d.translate(this.getWidth() / 6, this.getHeight() / 1.3);

		g2d.scale(1, -1);
		g2d.setColor(Color.GRAY);
		g2d.fill(inputPol);

		g2d.setColor(Color.GREEN);
		for (Path2D curr : visPolygons)
			g2d.fill(curr);

		g2d.setColor(Color.BLACK);
		for (Path2D curr : viewPoints)
			g2d.fill(curr);

		g2d.dispose();
	}

	public Figure(CCWPolygon inputPol, List<Point2D> viewPoints, int scaling) {

		List<CCWPolygon> CCWVisPolygons = VisibilityPolygon.computeVisPol(inputPol, viewPoints);

		visPolygons = CCWVisPolygons.stream().map(x -> x.scale(scaling).getPolygon()).collect(Collectors.toList());

		this.inputPol = inputPol.scale(scaling).getPolygon();

		this.viewPoints = new ArrayList<>();
		for (Point2D curr : viewPoints) {
			Path2D.Double temp = new Path2D.Double();
			temp.append(new Ellipse2D.Double(curr.getX() * scaling, curr.getY() * scaling, 5, 5), true);
			this.viewPoints.add(temp);
		}
		
		JFrame frame = new JFrame();
		frame.setTitle("Visibility");
		frame.setSize(800, 700);

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		Container contentPane = frame.getContentPane();
		contentPane.add(this);
		frame.setVisible(true);
	}
}

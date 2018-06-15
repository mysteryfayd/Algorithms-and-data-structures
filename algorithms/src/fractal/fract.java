package fractal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import javax.swing.JApplet;
import javax.swing.JFrame;


public class fract extends JApplet{

    private boolean drawn = false;
    private Graphics2D g2 = null;

    @Override
    public void paint(Graphics g) {

        if (drawn)
            return;
        drawn = true;

        super.paint(g);

        g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setPaint(Color.gray);

        /* Расчет координат треугольника для прорисовки 1 фрактала */
        double a = 350; // Длина стороны треугольника (px)
        double p1x = 250; // Координата x нижней левой точки основания треугольника (px)
        double p1y = 400; // Координата y нижней левой точки основания треугольника (px)
        double p2x = p1x + a;
        double p2y = p1y;
        double h = Math.sqrt(Math.pow(a, 2) - Math.pow((a / 2), 2) / 4);
        double pmx = (p1x + p2x) / 2;
        double pmy = (p1y + p2y) / 2;
        double p3x = pmx + (h * (p1y - pmy)) / (a / 2);
        double p3y = pmy + (h * (p1x - pmx)) / (a / 2);

        /* фрактал */
        drawCurveKochRecur(new Line2D.Double(p1x, p1y, p2x, p2y), 4); // Основание
        drawCurveKochRecur(new Line2D.Double(p3x, p3y, p1x, p1y), 4); // Левая
        drawCurveKochRecur(new Line2D.Double(p2x, p2y, p3x, p3y), 4); // Правая

        /* Расчет координат треугольника для прорисовки 2 фрактала */
        double b = 230; // Длина стороны треугольника (px)
        double p1x1 = 310; // Координата x нижней левой точки основания треугольника (px)
        double p1y1 = 360; // Координата y нижней левой точки основания треугольника (px)
        double p2x1 = p1x1 + b;
        double p2y1 = p1y1;
        double h1 = Math.sqrt(Math.pow(b, 2) - Math.pow((b / 2), 2) / 4);
        double pmx1 = (p1x1 + p2x1) / 2;
        double pmy1 = (p1y1 + p2y1) / 2;
        double p3x1 = pmx1 + (h1 * (p1y1 - pmy1)) / (b / 2);
        double p3y1 = pmy1 + (h1 * (p1x1 - pmx1)) / (b / 2);

        drawCurveKochRecur(new Line2D.Double(p1x1, p1y1, p2x1, p2y1), 3); // Основание
        drawCurveKochRecur(new Line2D.Double(p3x1, p3y1, p1x1, p1y1), 3); // Левая
        drawCurveKochRecur(new Line2D.Double(p2x1, p2y1, p3x1, p3y1), 3); // Правая

        /* Расчет координат треугольника для прорисовки 3 фрактала */
        double c = 130; // Длина стороны треугольника (px)
        double p1x2 = 358; // Координата x нижней левой точки основания треугольника (px)
        double p1y2 = 327; // Координата y нижней левой точки основания треугольника (px)
        double p2x2 = p1x2 + c;
        double p2y2 = p1y2;
        double h2 = Math.sqrt(Math.pow(c, 2) - Math.pow((c / 2), 2) / 4);
        double pmx2 = (p1x2 + p2x2) / 2;
        double pmy2 = (p1y2 + p2y2) / 2;
        double p3x2 = pmx2 + (h2 * (p1y2 - pmy2)) / (c / 2);
        double p3y2 = pmy2 + (h2 * (p1x2 - pmx2)) / (c / 2);

        drawCurveKochRecur(new Line2D.Double(p1x2, p1y2, p2x2, p2y2), 2); // Основание
        drawCurveKochRecur(new Line2D.Double(p3x2, p3y2, p1x2, p1y2), 2); // Левая
        drawCurveKochRecur(new Line2D.Double(p2x2, p2y2, p3x2, p3y2), 2); // Правая

        /* Расчет координат треугольника для прорисовки 4 фрактала */
        double d = 50; // Длина стороны треугольника (px)
        double p1x3 = 398; // Координата x нижней левой точки основания треугольника (px)
        double p1y3 = 300; // Координата y нижней левой точки основания треугольника (px)
        double p2x3 = p1x3 + d;
        double p2y3 = p1y3;
        double h3 = Math.sqrt(Math.pow(d, 2) - Math.pow((d / 2), 2) / 4);
        double pmx3 = (p1x3 + p2x3) / 2;
        double pmy3 = (p1y3 + p2y3) / 2;
        double p3x3 = pmx3 + (h3 * (p1y3 - pmy3)) / (d / 2);
        double p3y3 = pmy3 + (h3 * (p1x3 - pmx3)) / (d / 2);

        drawCurveKochRecur(new Line2D.Double(p1x3, p1y3, p2x3, p2y3), 1); // Основание
        drawCurveKochRecur(new Line2D.Double(p3x3, p3y3, p1x3, p1y3), 1); // Левая
        drawCurveKochRecur(new Line2D.Double(p2x3, p2y3, p3x3, p3y3), 1); // Правая
    }

    private void drawCurveKochRecur(Line2D line, int maxIter, int curIter) {
        if (curIter == maxIter) // скрытые линии
            drawLine(line);

        if (curIter <= maxIter) {
            double a = line.getP1().distance(line.getP2());
            a = a / 3;
            double h = Math.sqrt(Math.pow(a, 2) - Math.pow((a / 2), 2) / 4);

            Point2D ps = line.getP1();
            Point2D pe = line.getP2();

            Point2D pm = new Point2D.Double((ps.getX() + pe.getX()) / 2, (ps.getY() + pe.getY()) / 2);
            Point2D p1 = new Point2D.Double((2 * ps.getX() + pe.getX()) / 3, (2 * ps.getY() + pe.getY()) / 3);
            Point2D p2 = new Point2D.Double((2 * pe.getX() + ps.getX()) / 3, (2 * pe.getY() + ps.getY()) / 3);
            Point2D p3 = new Point2D.Double(
                    pm.getX() + (h * (-p2.getY() + pm.getY())) / (a / 2),
                    pm.getY() + (h * (p2.getX() - pm.getX())) / (a / 2)
            );

            // Рекурсия
            curIter++;
            drawCurveKochRecur(new Line2D.Double(ps, p1), maxIter, curIter);
            drawCurveKochRecur(new Line2D.Double(p1, p3), maxIter, curIter);
            drawCurveKochRecur(new Line2D.Double(p3, p2), maxIter, curIter);
            drawCurveKochRecur(new Line2D.Double(p2, pe), maxIter, curIter);
        }
    }

    private void drawCurveKochRecur(Line2D line, int maxIter) {
        drawCurveKochRecur(line, maxIter, 0);
    }

    public void drawLine(Line2D line) {
        g2.draw(new Line2D.Double(line.getP1(), line.getP2()));
    }

    public static void main(String s[]) {
        JFrame f = new JFrame("ibraimov.a.i115");
        f.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        JApplet applet = new fract();
        f.getContentPane().add("Center", applet);
        applet.init();
        f.pack();
        f.setSize(new Dimension(900, 600));
        f.show();
    }
}

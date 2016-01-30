package spencer.hanson.modules.grapher;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by spencerh on 1/30/2016.
 */

public abstract class Graph {
    protected ArrayList<Point> points;
    protected int xm;
    protected int ym;
    protected int xc;
    protected int yc;
    protected int size;
    protected int height;
    protected int width;

    public Graph(int width, int height) {
        points = new ArrayList<Point>();
        this.width = width;
        this.height = height;
        xm = 0;
        ym = 0;
        xc = 0;
        yc = 0;
        size = 0;
    }


    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public abstract void initPoints();
    public abstract BasicStroke getStroke();
    public abstract Color getColor();

    public void graph(Graphics2D g2d) {
        g2d.setColor(getColor());
        g2d.setStroke(getStroke());
        for (int i = 0; i < points.size(); i++) {
            g2d.fillRect(points.get(i).x * xm - xc, getHeight() - points.get(i).y * ym - yc, size, size);
            if (i == 0) {
                g2d.drawLine(points.get(0).x * xm - xc, getHeight() - points.get(0).y * ym - yc, points.get(1).x * xm - xc, getHeight() - points.get(1).y * ym - yc);
            } else {
                g2d.drawLine(points.get(i - 1).x * xm - xc, getHeight() - points.get(i - 1).y * ym - yc, points.get(i).x * xm - xc, getHeight() - points.get(i).y * ym - yc);
            }
        }
    }




}

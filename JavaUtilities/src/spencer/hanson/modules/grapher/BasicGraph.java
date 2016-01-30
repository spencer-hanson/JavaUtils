package spencer.hanson.modules.grapher;

import java.awt.*;

/**
 * Created by spencerh on 1/30/2016.
 */
public abstract class BasicGraph extends Graph {

    protected Color color;
    protected int linesize;

    public BasicGraph(int width, int height, int xm, int ym, int xc, int yc, int size, int linesize, Color color) {
        super(width, height);
        this.xm = xm; //x multiplier
        this.ym = ym; //y multiplier
        this.xc = xc; //x constant
        this.yc = yc; //y constant
        this.size = size; //size of point
        this.color = color; //color of graph
        this.linesize = linesize; //size o line

        initPoints();
    }

    @Override
    public BasicStroke getStroke() {
        BasicStroke stroke =
                new BasicStroke(linesize,
                        BasicStroke.CAP_ROUND,
                        BasicStroke.JOIN_ROUND);
        return stroke;
    }

    @Override
    public Color getColor() {
        return color;
    }
}

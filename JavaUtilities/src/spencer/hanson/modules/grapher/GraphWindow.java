package spencer.hanson.modules.grapher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;

/**
 * Created by spencerh on 1/30/2016.
 */
public class GraphWindow extends JFrame implements ComponentListener {

    private ArrayList<Graph> graphs;

    public static int WINDOW_WIDTH;
    public static int WINDOW_HEIGHT;

    public void initComponents() { }

    public void init() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        WINDOW_HEIGHT = 500;
        WINDOW_WIDTH = 600;
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        initComponents();
        setVisible(true);
    }

    public GraphWindow(ArrayList<Graph> graphs) {
        super("Graph Window");
        this.graphs = graphs;
        init();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.black);
        for(int x = 0;x<getWidth()/10;x++) {
            g.drawLine(x*10, 0, x*10, getHeight());
        }
        for(int y = 0;y<getHeight()/10;y++) {
            g.drawLine(0, y*10, getWidth(), y*10);
        }


        Graphics2D g2d = (Graphics2D)g;

        for(int i = 0;i<graphs.size();i++) {
            graphs.get(i).graph(g2d);
        }

    }

    @Override
    public void componentResized(ComponentEvent e) {
        Dimension d = this.getSize();
        WINDOW_WIDTH = d.width;
        WINDOW_HEIGHT = d.height;
    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }
}

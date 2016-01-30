package spencer.hanson.modules;

import spencer.hanson.UtilModule;
import spencer.hanson.modules.grapher.BasicGraph;
import spencer.hanson.modules.grapher.Graph;
import spencer.hanson.modules.grapher.GraphWindow;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by spencerh on 1/30/2016.
 */
public class Grapher extends UtilModule {
    @Override
    public void run() {
        //graph the number of ones in a binary integer
        ArrayList<Graph> graphs = new ArrayList<Graph>();
        graphs.add(new BasicGraph(GraphWindow.WINDOW_WIDTH, GraphWindow.WINDOW_HEIGHT, 10, 10, 10, GraphWindow.WINDOW_HEIGHT/2-200, 3, 10, Color.red) {
            @Override
            public void initPoints() {
                for(int x = 0;x<128;x++) {
                    int i = x;
                    i = i - ((i >>> 1) & 0x55555555);
                    i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
                    i = (i + (i >>> 4)) & 0x0f0f0f0f;
                    i = i + (i >>> 8);
                    i = i + (i >>> 16);
                    i = i & 0x3f;
                    points.add(new Point(x, i));//((i>>2)+(i>>4)+(i>>8))));
                }
            }
        });


        new GraphWindow(graphs);
    }
}

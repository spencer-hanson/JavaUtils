package spencer.hanson;

import spencer.hanson.modules.LineCounter;
import spencer.hanson.modules.MassRenamer;
import spencer.hanson.modules.UnZipper;

public class Main {

    public static void main(String[] args) {

        new MassRenamer().run();
        new LineCounter().run();
        new UnZipper().run();
    }
}

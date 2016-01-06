package spencer.hanson;

import java.util.Scanner;

/**
 * Created by spencerh on 1/5/2016.
 */
public abstract class UtilModule {

    protected void println(String str) {
        System.out.println(str);
    }

    protected void print(String str) {
        System.out.print(str);
    }

    protected void err(String str) {
        System.err.println(str);
    }

    protected String getStr() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        return str;
    }

    protected int getInt() {
        boolean done = false;
        int ans = -8;
        while(!done) {
            String str = getStr();
            try {
                ans = Integer.parseInt(str);
                done = true;
            } catch (NumberFormatException e) {
                err("Error, invalid number, try again");
            } catch(Exception e2) { e2.printStackTrace(); System.exit(-1); }
        }
        return ans;
     }

    public abstract void run();
}

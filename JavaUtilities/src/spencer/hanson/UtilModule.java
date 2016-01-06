package spencer.hanson;

import javax.swing.*;
import java.util.Scanner;

/**
 * Created by spencerh on 1/5/2016.
 */
public abstract class UtilModule {

    protected void println(String str) {
        print(str + "\n");
    }

    protected void print(String str) {
        System.out.print(str);
    }

    protected void println(int i) { println(i + " "); }

    protected void err(String str) {
        System.err.println(str);
    }

    protected String getStr() {
         Scanner sc = new Scanner(System.in);
         System.out.print(">");
         return sc.nextLine();
    }

    protected void guiMsg(String str) {
        JOptionPane.showMessageDialog(null, str);
    }

    protected void guiMsg(String str, String title) {
        JOptionPane.showMessageDialog(null, str, title, JOptionPane.DEFAULT_OPTION);
    }

    protected  void errMsg(String str, String title) {
        JOptionPane.showMessageDialog(null, str, title, JOptionPane.ERROR_MESSAGE);
    }

    protected void guiInfoMsg(String str, String title) {
        JOptionPane.showMessageDialog(null, str, title, JOptionPane.INFORMATION_MESSAGE);
    }

    protected static void guiWarnMsg(String str, String title) {
        JOptionPane.showMessageDialog(null, str, title, JOptionPane.WARNING_MESSAGE);
    }

    protected String guiInput(String str) {
        str = JOptionPane.showInputDialog(str);
        return str;
    }

    protected int guiInputInt(String str) {
        String temp = "Error";
        temp = str;
        int num = 0;
        str = JOptionPane.showInputDialog(str);
        try {
            num = Integer.parseInt(str);
        } catch(Exception e) {
            errMsg("Error! Not a number!","Error");
            num = guiInputInt(temp);
        }
        return num;
    }

    protected int guiConfirmMsg(String str, String title) {
        int num = JOptionPane.showConfirmDialog (null, str, title, JOptionPane.YES_NO_OPTION);
        return num;
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

package spencer.hanson.modules;

import spencer.hanson.UtilModule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by spencerh on 1/5/2016.
 */
public class TextMod extends UtilModule {

    public String array2Str(String[] str) {
        String temp = "";
        for(String txt: str) {
            temp += txt;
        }
        return temp;
    }

    public <T> String array2Str(ArrayList<T> arr) {
        String str = "";

        for(int i = 0;i<arr.size();i++) {
            str += arr.toString();
        }
        return str;
    }

    public static String[] str2Array(String str) {
        String arr[] = new String[str.length()];
        int start = 0;
        int count = 0;
        for(int i = 0;i<=str.length()-1;i++) {
            if(str.charAt(i) == ' ') {
                arr[count] = str.substring(start, i);
                count++;
                start = i;
            }
        }
        return arr;
    }

    public static int getNextIndexOf(String str, char ch, int start) {
        int index = Integer.MAX_VALUE;
        for(int i = start;i<=str.length()-1;i++) {
            if(str.charAt(i) == ch) {
                index = i;
                break;
            }
        }
        return index;
    }

    public <T> int twoDimArraySize(T[][] str) { //the size of a two-dimensional array in one dimension
        int count = 0;
        for(int x = 0;x<str.length;x++) {
            for(int y = 0;y<str[x].length;y++) {
                count++;
            }
        }
        return count;
    }

    public <T> ArrayList<T> twoDim2oneDimArray(T[][] arr1) { //two dimensional array to a one-dimensional array,
        int size = twoDimArraySize(arr1);
        ArrayList<T> arr2 = new ArrayList<T>(size);

        for(int x = 0;x<arr1.length;x++) {
            for(int y = 0;y<arr1[x].length;y++) {
                arr2.add(arr1[x][y]);
            }
        }
        return arr2;
    }

    //BROKEN
//    public String formatDown(String str, int rows) {
//        char arr[] = str.toCharArray();
//        Character newArr[][] = new Character[str.length()][str.length()];
//
//        int cur_x = 0;
//        int cur_y = 0;
//        for(int i = 0;i<str.length();i++) {
//            newArr[cur_x][cur_y] = arr[i];
//            cur_y++;
//            if (cur_y > rows) {
//                cur_x++;
//                cur_y = 0;
//            }
//        }
//
//
//        return array2Str(twoDim2oneDimArray(newArr)).trim();
//    }


    public String formatBackwards(String str, boolean R2L) {
        String end = "";
        if(R2L) {
            for(int i = 0;i<=str.length()-1;i++) {
                end = str.substring(i, i+1) + end;
            }

        } else {
            String[] array = str.split("\\s+");
            for(int i = 0;i<array.length;i++) {
                array[i] = formatBackwards(array[i], true);
                end = end + " " + array[i];
            }

        }

        return end;
    }

    protected String getStr() {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        try {
            return sc.readLine();
        } catch(Exception e) { e.printStackTrace(); System.exit(-1); return null; }

    }

    @Override
    public void run() {
        String txt = "This is some text.";

        /////
        //while(true) {
        //System.out.println("Type some text to be formatted");
        //txt = getStr();
        //txt = formatBackwards(txt, true);
            println(formatBackwards(txt, true) + "\n");
            println(formatBackwards(txt, false) + "\n");
            //println(formatDown(txt, 10) + "\n");//broken
            //println(formatDown(txt, 5) + "\n");//broken
            println(getNextIndexOf(txt, 'e', 0));
            println(getNextIndexOf(txt, 'e', 12));
        //println("\n\n\n");
        //println(txt);
        //println("\n\n\n");
        //}
    }
}

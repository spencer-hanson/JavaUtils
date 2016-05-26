package spencer.hanson.modules;

import spencer.hanson.UtilModule;
import spencer.hanson.modules.matrixencrypt.Matrix;

/**
 * Created by spencerh on 5/26/2016.
 */
public class MatrixEncrypt extends UtilModule {

    private double[][] makeDivisorMatrix(String str) {
        double data[][] = new double[str.length()][str.length()];
        int size = str.length();
        for(int i = 0;i<size;i++) {
            data[i][0] = 1.0f;
            for(int j = 1;j<size;j++) {
                data[i][j] = Math.pow(i+1, j);
            }

        }

        return data;
    }

    private double[][] makeProductMatrix(String str) {
        double data[][] = new double[str.length()][1];
        int size = str.length();
        for(int i = 0;i<size;i++) {
            data[i][0] = (double)((int)str.charAt(i));
        }

        return data;
    }



    public double[] getCoEffs(double[][] data) {
        double[] result = new double[data.length];
        for(int i = 0;i<data.length;i++) {
            result[i] = data[i][0];
        }
        return result;
    }

    public String decryptMsg(double[] coeffs, int length) {
        String msg = "";
        for (int j = 1; j < length + 1; j++) {
            double num = 0;
            for (int i = 0; i < coeffs.length; i++) {
                num += coeffs[i] * (Math.pow(j, i));
            }
            msg += (char)Math.round(num);
        }
        return msg;
    }

    @Override
    public void run() {
        println("Enter something to be encrypted");
        String txt = getStr();

        Matrix A =  new Matrix(makeDivisorMatrix(txt));
        //A.show();
        //println("---");
        Matrix b = new Matrix(makeProductMatrix(txt));
        //b.show();
        //println("---");
        Matrix v = A.solve(b);
        //v.show();
        //println("---");
        double[] coeffs = getCoEffs(v.getData());
        println("Here are your coefficients: 0-n");
        for(int i = 0;i<coeffs.length;i++) {
            println("" + coeffs[i]);
        }

        println("Decrypted:");
        println(decryptMsg(coeffs, txt.length()) + "");

    }
}

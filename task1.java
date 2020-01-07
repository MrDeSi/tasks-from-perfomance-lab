import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class task1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        double max = -32768;
        double min = 32767;
        double mid = 0;
        ArrayList<Double> list = new ArrayList<>();
        while (reader.ready()) {
            double s = Double.parseDouble(reader.readLine());
            if (s>max) max=s;
            if (s<min) min=s;
            list.add(s);
            mid = mid+s;
        }

        reader.close();

        double [] x = new double[list.size()];
        for (int i=0; i<x.length; i++) {
            x[i]=list.get(i);
        }

        for (int i=0; i<x.length; i++) {
            for (int k=i; k<x.length; k++) {
                if (x[i]>x[k]) {
                    double qqq = x[i];
                    x[i] = x[k];
                    x[k] = qqq;
                }
            }
        }

        double [] f = new double[5];

        // 90 ПЕРЦЕНТИЛЬ
        int i = (int) (((double) 90/100)*x.length);
        double i2 = x[i-1];
        double i3 = ((double) 90/100)*(x.length-1)+1;
        double i4 = i3 % (int) i3;
        double i5 = (x[i]-x[i-1])*i4+i2;
        f[0]=i5;
        // МЕДИАНА
        if (x.length%2==0) {
            f[1]=(x[x.length/2]+x[x.length/2-1])/2;
        }
        else f[1]=x[x.length/2];
        // МАКСИМАЛЬНОЕ ЗНАЧЕНИЕ
        f[2]=max;
        // МИНИМАЛЬНОЕ ЗНАЧЕНИЕ
        f[3]=min;
        // СРЕДНЕЕ АРИФМЕТИЧЕСКОЕ
        f[4]=mid/list.size();

        for (int j=0; j<f.length; j++) {
            System.out.printf("%.2f %n", f[j]);
        }

    }
}

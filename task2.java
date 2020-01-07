import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class task2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedReader reader1 = new BufferedReader(new FileReader(args[1]));
        double [] p = new double [10];
        int c = 0;
        while (reader.ready()) {
            String s = reader.readLine();
            String [] ss = s.split(" ");
            if (c==0) {
                p[0] = Double.parseDouble(ss[0]);
                p[1] = Double.parseDouble(ss[1]);
                p[8] = Double.parseDouble(ss[0]);
                p[9] = Double.parseDouble(ss[1]);
            }
            if (c==1) {
                p[2] = Double.parseDouble(ss[0]);
                p[3] = Double.parseDouble(ss[1]);
            }
            if (c==2) {
                p[4] = Double.parseDouble(ss[0]);
                p[5] = Double.parseDouble(ss[1]);
            }
            if (c==3) {
                p[6] = Double.parseDouble(ss[0]);
                p[7] = Double.parseDouble(ss[1]);
            }
            c++;
        }
        reader.close();

        while (reader1.ready()) {
            String s = reader1.readLine();
            String [] ss = s.split(" ");
            double rx1=Double.parseDouble(ss[0]);
            double ry1=Double.parseDouble(ss[1]);
            //System.out.println(rx1 + " " + ry1);
            //double rx2 = 8;
            //double ry2 = 8;
            double rx2=Math.random()*1000;
            double ry2=Math.random()*1000;

            boolean q = true;

            if (((rx1==p[0]) && (ry1==p[1])) || ((rx1==p[2]) && (ry1==p[3])) || ((rx1==p[4]) && (ry1==p[5])) || ((rx1==p[6]) && (ry1==p[7]))){
                //System.out.println("точка является вершиной");
                System.out.println(0);
            }
            else {

                for (int t=0; t<8; t=t+2) {
                    double n1 = Math.sqrt((rx1 - p[t]) * (rx1 - p[t]) + (ry1 - p[t + 1]) * (ry1 - p[t + 1]));
                    double n2 = Math.sqrt((p[t + 2] - rx1) * (p[t + 2] - rx1) + (p[t + 3] - ry1) * (p[t + 3] - ry1));
                    double n3 = Math.sqrt((p[t + 2] - p[t]) * (p[t + 2] - p[t]) + (p[t + 3] - p[t + 1]) * (p[t + 3] - p[t + 1]));
                    //System.out.println(n1+" "+n2+" "+n3);
                    if (n1 + n2 == n3) {
                        //System.out.println("точка находится на стороне");
                        System.out.println(1);
                        q = false;
                        break;
                    }
                }

                int counter=0;
                double uu;
                double ii;

                for (int t=0; t<8; t=t+2) {

                    //System.out.println("проверяется отрезок с координатами ("+p[t]+";"+p[t+1]+") и ("+p[t+2]+";"+p[t+3]+")")

                    if ((rx1 > rx2)) {
                        double y=rx1;
                        rx1=rx2;
                        rx2=y;
                    }
                    if ((ry1 > ry2)) {
                        double y=ry1;
                        ry1=ry2;
                        ry2=y;
                    }

                    double b1;
                    double b2;
                    double k1;
                    double k2;
                    double xx;
                    double yy;

                    if (p[t + 2] - p[t] == 0) {
                        xx = p[t];
                        k2 = (ry1 - ry2) / (rx1 - rx2);
                        b2 = ry1 - k2 * rx1;
                        yy = k2 * xx + b2;
                    }
                    else if (rx2 - rx1 == 0) {
                        xx = rx1;
                        k1 = (p[t + 1] - p[t + 3]) / (p[t] - p[t + 2]);
                        b1 = p[t + 1] - k1 * p[t];
                        yy = k1 * xx + b1;
                    }
                    else {
/*                        if ((p[t] > p[t + 2])) {
                            uu=p[t];
                            ii=p[t+2];
                        }
                        if ((p[t+1] > p[t + 3])) {
                            uu=p[t+1];
                            ii=p[t+3];
                        }*/
                        k1 = (p[t + 1] - p[t + 3]) / (p[t] - p[t + 2]);
                        k2 = (ry1 - ry2) / (rx1 - rx2);
                        b1 = p[t + 1] - k1 * p[t];
                        b2 = ry1 - k2 * rx1;
                        if (k1==k2) q = false;
                        xx = (b2-b1)/(k1-k2);
                        yy = k1 * xx + b1;
                    }

                    //System.out.println("угловые кэфы "+k1+" "+k2);

                    //if (k1 != k2) {

                        //System.out.println("точка пересечения прямых: "+xx+";"+yy);
                        double z1 = Math.sqrt((xx - p[t]) * (xx - p[t]) + (yy - p[t + 1]) * (yy - p[t + 1]));
                        double z2 = Math.sqrt((p[t + 2] - xx) * (p[t + 2] - xx) + (p[t + 3] - yy) * (p[t + 3] - yy));
                        double z3 = Math.sqrt((p[t + 2] - p[t]) * (p[t + 2] - p[t]) + (p[t + 3] - p[t + 1]) * (p[t + 3] - p[t + 1]));
                        double v1 = Math.sqrt((xx - rx1) * (xx - rx1) + (yy - ry1) * (yy - ry1));
                        double v2 = Math.sqrt((rx2 - xx) * (rx2 - xx) + (ry2 - yy) * (ry2 - yy));
                        double v3 = Math.sqrt((rx2 - rx1) * (rx2 - rx1) + (ry2 - ry1) * (ry2 - ry1));
                        BigDecimal dec1 = new BigDecimal(Double.toString(z1+z2));
                        BigDecimal dec2 = new BigDecimal(Double.toString(z3));
                        dec1 = dec1.setScale(6, RoundingMode.HALF_UP);
                        dec2 = dec2.setScale(6, RoundingMode.HALF_UP);
                        BigDecimal dec3 = new BigDecimal(Double.toString(v1+v2));
                        BigDecimal dec4 = new BigDecimal(Double.toString(v3));
                        dec3 = dec3.setScale(6, RoundingMode.HALF_UP);
                        dec4 = dec4.setScale(6, RoundingMode.HALF_UP);

                        if ((dec1.equals(dec2)) && (dec3.equals(dec4))) {
                        //if (!((xx < Math.max(p[t], rx1)) || (xx > Math.min(p[t+2], rx2)))) {
                            //System.out.println("good");
                            counter++;
                        }
                    //}

                }


                if (q) {
                    //System.out.println(counter+ " раза пересек ребра");
                    if (counter%2==0) {
                        //System.out.println("точка не принадлежит многоугольнику");
                        System.out.println(3);
                    }
                    else {
                        //System.out.println("точка принадлежит многоугольнику");
                        System.out.println(2);
                    }
                }
            }
        }

        reader1.close();

    }
}

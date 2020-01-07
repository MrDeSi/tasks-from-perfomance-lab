import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class task3 {
    public static void main(String[] args) throws IOException {
        File dir = new File(args[0]);
        File[] x=dir.listFiles();
        String [] z = new String[dir.listFiles().length];
        int y=1;
        double g=0;
        int h=0;
        for (int i=0; i<z.length; i++ ) {
            z[i]= String.valueOf(x[i]);
            BufferedReader reader = new BufferedReader(new FileReader(z[i]));

            while (reader.ready()) {
                String s = reader.readLine();
                double q = Double.parseDouble(s);
                //System.out.println(y+" "+q);
                if (q>g) {
                    g=q;
                    h=y;
                    //System.out.println(h+" "+g);
                }
                else if (q==g) {
                    if (y<h) h=y;
                }
                y++;
            }
            y=1;
            reader.close();
        }
        //System.out.println(h+" "+g);
        System.out.println(h);

    }
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;

public class task4 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        ArrayList<String> list = new ArrayList();
        ArrayList<String> list2 = new ArrayList();
        ArrayList<LocalTime> list3 = new ArrayList();
        ArrayList<LocalTime> list4 = new ArrayList();
        while (reader.ready()) {
            String s = reader.readLine();
            String[] h = (s.split(" "));
            if (h[0].length()==4) {
                list.add("0"+h[0]);
            }
            else list.add(h[0]);
            if (h[1].length()==4) {
                list2.add("0"+h[1]);
            }
            else list2.add(h[1]);
        }
        reader.close();

        //System.out.println(list);
        //System.out.println(list2);

        LocalTime start = LocalTime.of(7, 59);
        LocalTime over = LocalTime.of(20, 0);
        int u=0;
        int max=0;
        boolean c;
        while (start!=over) {
            c=false;
            start=start.plusMinutes(1);
            String x = start.toString();
            for (int i=0; i<list.size(); i++) {
                if (x.equals(list.get(i))) {
                    //System.out.println("ВОШЕЛ В БАНК");
                    u++;
                    if (u==max) list3.add(start);
                }
            }
            for (int i=0; i<list2.size(); i++) {
                if (x.equals(list2.get(i))) {
                    //System.out.println("ПОКИНУЛ БАНК");
                    u--;
                    if (max==u+1) c=true;
                    //System.out.println(c);
                }
            }
            if (max<u) {
                list3.clear();
                list4.clear();
                max=u;
                list3.add(start);
            }
            if (c) list4.add(start);
            //System.out.println(start+" в банке "+u+" посетителей");
        }
        //System.out.println(max);

        for (int i=0; i<list3.size(); i++) {
            if (list3.get(i).toString().startsWith("0")) {
                if (list4.get(i).toString().startsWith("0")) {
                    System.out.println(list3.get(i).toString().substring(1)+" "+list4.get(i).toString().substring(1));
                }
                else System.out.println(list3.get(i).toString().substring(1)+" "+list4.get(i));
            }
            else System.out.println(list3.get(i)+" "+list4.get(i));
        }
    }
}

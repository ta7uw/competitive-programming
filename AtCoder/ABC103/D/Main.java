package AtCoder.ABC103.D;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner(System.in);
        Task task = new Task();
        task.solve(sc, out);
        out.flush();
        sc.close();
    }
    static class Task{
        public void solve(Scanner sc, PrintWriter out){
            int N = nint(sc);
            int M = nint(sc);
            List<Integer[]> warList = new ArrayList<>();
            for (int i=0; i<M; i++){
                int a = nint(sc);
                int b = nint(sc);
                Integer[] ab = {a, b};
                warList.add(ab);
            }
            warList =  warList.stream()
                    .sorted(Comparator.comparing(x -> x[1]))
                    .collect(Collectors.toList());
            int removeBridge = 0;
            int result = 0;
            for (int i =0; i<warList.size(); i++){
                int a = warList.get(i)[0];
                int b = warList.get(i)[1];
                if (i==0){
                    removeBridge = b - 1;
                    result ++;
                }else if(a > removeBridge){
                    removeBridge = b-1;
                    result ++;
                }
            }
            out.println(result);
        }
    }

    static int nint(Scanner sc){
        return Integer.parseInt(sc.next());
    }
    static long nlong(Scanner sc){
        return Long.parseLong(sc.next());
    }
    static double ndouble(Scanner sc){
        return Double.parseDouble(sc.next());
    }
    static float nfloat(Scanner sc){
        return Float.parseFloat(sc.next());
    }
    static String nstr(Scanner sc){
        return  String.valueOf(sc.next());
    }
    static long[] longLine(Scanner sc, int size){
        long[] lLine = new long[size];
        for (int i = 0; i < size; i++) {
            lLine[i] = nlong(sc);
        }
        return lLine;
    }
    static int[] intLine(Scanner sc, int size){
        int[] iLine = new int[size];
        for (int i = 0; i < size; i++) {
            iLine[i] = nint(sc);
        }
        return iLine;
    }
    static String[] strLine(Scanner sc, int size){
        String[] strLine = new String[size];
        for (int i = 0; i < size; i++) {
            strLine[i] = nstr(sc);
        }
        return strLine;
    }
}
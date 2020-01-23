package opp.util;

public class CommonUtil {

    public static void print(Object o){
        System.out.println(o);
    }

    public static void printString(Object o){
        String result = "";
        if (o != null){
            result = o.toString();
        }
        print(result);
    }
}

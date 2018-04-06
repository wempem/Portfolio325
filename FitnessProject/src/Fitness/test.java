package Fitness;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Created by Jay on 4/28/2017.
 */
public class test {
    public static void main(String[] args){
        ArrayList<String> al = new ArrayList<>();
        al.add("adb");
        al.add("123");
        al.add("3.1415");

        System.out.println(numberOfIntegers(al));
    }

    public static int numberOfIntegers(ArrayList<String> list) {
        String regex = "[0-9]+";
        int ret = 0;
        Pattern p = Pattern.compile(regex);
        for (int i = 0; i <= list.size() - 1; i++) {
            if (p.matcher(list.get(i)).matches()) {
                ret += 1;
            }
        }
        return ret;
    }
}


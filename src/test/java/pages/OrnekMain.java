package pages;

import io.cucumber.java.sl.In;

import java.util.*;

public class OrnekMain {
    public static void main(String[] args) {

        List<Integer> liste = new ArrayList<>();
        Set<Integer> kume = new HashSet<>();
        Map<String ,String > harita = new HashMap<>();

        liste.add(100);
        liste.add(200);
        liste.add(400);
        liste.add(200);
        System.out.println(liste.toString());
        System.out.println();
        kume.add(100);
        kume.add(200);
        kume.add(400);
        kume.add(200);
        System.out.println(kume.toString());

        String cumle = "Bugün hava cok sicaktir";
        String [] array = cumle.split(" ");
        for (int i = array.length-1 ; i >= 0 ; i--) {
            System.out.print(array[i] + " ");

        }

    }
}

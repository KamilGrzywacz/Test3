package pl.kurs.Zad4;

import java.util.ArrayList;
import java.util.List;

public class MinMaxRunner {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(10);
        integerList.add(12);
        integerList.add(13);
        integerList.add(12);
        integerList.add(13);
        integerList.add(15);
        System.out.println(integerList);
        System.out.println(MinMaxService.getMinMax(integerList).getMax());
        System.out.println(MinMaxService.getMinMax(integerList).getMin());
        System.out.println(MinMaxService.getMinMax(integerList));

        List<String> stringList = new ArrayList<>();
        stringList.add("Adam");
        stringList.add("Beata");
        stringList.add("Zenon");
       stringList.add("Arek");
        System.out.println(MinMaxService.getMinMax(stringList));

    }
}

package pl.kurs.Zad4;

import java.util.List;

public class MinMaxService {
    public static <T extends Comparable<T>> MinMax<T> getMinMax(List<T> elements) {
        T min = elements.get(0);
        T max = elements.get(0);

        for (int i = 1; i < elements.size(); i++) {
            T object = elements.get(i);
            if (object.compareTo(min) < 0) {
                min = object;
            }
            if (object.compareTo(max) > 0) {
                max = object;
            }
        }

        return new MinMax<>(min, max);
    }


}
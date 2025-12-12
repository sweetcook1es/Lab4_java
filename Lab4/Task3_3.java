package Lab4;

import java.util.List;

public class Task3_3 {

    @FunctionalInterface
    public interface ReduceFunction<T> {
        T apply(T accumulator, T current);
    }

    public static class ReduceUtils {

        public static <T> T reduceList(List<T> list, ReduceFunction<T> reducer, T initialValue) {
            // проверяем список на null или пустоту
            if (list == null || list.isEmpty()) {
                // начальное значение
                return initialValue;
            }

            // инициализируем начальным значением
            T accumulator = initialValue;

            // сокращения ко всем элементам
            for (T item : list) {
                accumulator = reducer.apply(accumulator, item);
            }
            return accumulator;
        }
    }
}
package Lab4;

import java.util.ArrayList;
import java.util.List;

public class Task3_2 {
    @FunctionalInterface
    public interface TestFunction<T> {
        boolean test(T t);
    }

    public static class FilterUtils {
        public static <T> List<T> filterList(List<T> list, TestFunction<T> predicate) {
            List<T> result = new ArrayList<>();
            for (T item : list) {
                if (predicate.test(item)) {
                    result.add(item);
                }
            }
            return result;
        }
    }
}
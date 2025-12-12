package Lab4;

import java.util.ArrayList;
import java.util.List;

public class Task3_1 {

    @FunctionalInterface
    // принимает объект типа T и возвращает объект типа R
    public interface ApplyFunction<T, R> {
        R apply(T t);
    }

    public static class FunctionUtils {

        public static <T, R> List<R> applyToList(List<T> list, ApplyFunction<T, R> function) {
            // новый список для результатов
            List<R> result = new ArrayList<>();

            for (T item : list) {
                // применяем функцию к текущему элементу
                R transformedItem = function.apply(item);
                // добавляем результат в новый список
                result.add(transformedItem);
            }
            return result;
        }
    }
}
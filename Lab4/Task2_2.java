package Lab4;

import java.util.List;

public class Task2_2 {

    public static class BoxUtils {
        // поиска максимального значения среди всех чисел
        public static double findMax(List<Task1_1.Box<? extends Number>> boxes) {
            // проверка на null и пустой список
            if (boxes == null || boxes.isEmpty()) {
                throw new IllegalArgumentException("Список коробок пуст");
            }

            // минимальным возможным значением double
            double max = Double.MIN_VALUE;

            // проходим по всем коробкам в списке
            for (Task1_1.Box<? extends Number> box : boxes) {
                // извлекаем значение из коробки (коробка становится пустой)
                Number value = box.get();

                // проверяем, что коробка не была пустой
                if (value != null) {
                    double num = value.doubleValue();

                    // обновляем максимальное значение, если текущее больше
                    if (num > max) {
                        max = num;
                    }
                }
            }
            return max;
        }
    }
}
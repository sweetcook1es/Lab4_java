package Lab4;
import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n");
            System.out.println("1. Задание 1.1 - Обобщенная коробка");
            System.out.println("2. Задание 1.3 - Сравнимое");
            System.out.println("3. Задание 2.2 - Поиск максимума в коробках");
            System.out.println("4. Задание 3.1 - Функция");
            System.out.println("5. Задание 3.2 - Фильтр");
            System.out.println("6. Задание 3.3 - Сокращение");
            System.out.println("7. Задание 3.4 - Коллекционирование");
            System.out.println("0. Выход");
            System.out.print("Выберите задание: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод. Попробуйте снова.");
                continue;
            }

            switch (choice) {
                case 1:
                    Task1_1();
                    break;
                case 2:
                    Task1_3();
                    break;
                case 3:
                    Task2_2();
                    break;
                case 4:
                    Task3_1();
                    break;
                case 5:
                    Task3_2();
                    break;
                case 6:
                    Task3_3();
                    break;
                case 7:
                    Task3_4();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Выход");
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова");
            }
        }

        scanner.close();
    }


    private static void Task1_1() {
        System.out.println("\nЗАДАНИЕ 1.1: Обобщенная коробка");
        // коробка для целых чисел
        Task1_1.Box<Integer> integerBox = new Task1_1.Box<>();
        boolean running = true;
        while (running) {
            System.out.println("1. Положить число в коробку");
            System.out.println("2. Извлечь число из коробки");
            System.out.println("3. Проверить, пуста ли коробка");
            System.out.println("4. Показать состояние коробки");
            System.out.println("0. Выход из программы");
            System.out.print("Выберите: ");

            int choice = readInt();

            switch (choice) {
                case 1:
                    System.out.print("\nВведите целое число для коробки: ");
                    int number = readInt();
                    integerBox.put(number);
                    System.out.println("- Число " + number + " помещено в коробку");
                    break;
                case 2:
                    System.out.println("\nИзвлечение значения:");
                    Integer value = integerBox.get();
                    System.out.println("- Извлечено из коробки: " + value);
                    break;
                case 3:
                    System.out.println("\nПроверка после извлечения:");
                    System.out.println("- Коробка пуста? " + integerBox.isEmpty());
                    break;
                case 4:
                    System.out.println("\nПроверка состояния коробки:");
                    System.out.println("- Коробка пуста? " + integerBox.isEmpty());
                    System.out.println("- Содержимое: " + integerBox.peek());
                    System.out.println("- Содержимое: " + integerBox);
                    break;
                case 0:
                    System.out.println("Выход");
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова");
            }
        }
    }

    private static void Task1_3() {
        System.out.println("ЗАДАНИЕ 1.3: Сравнимое");

        System.out.print("\nВведите первое число для сравнения: ");
        int num1 = readInt();
        System.out.print("Введите второе число для сравнения: ");
        int num2 = readInt();

        Task1_3.ComparableInteger comp1 = new Task1_3.ComparableInteger(num1);
        int result = comp1.compare(num2);

        System.out.println("\nРезультат сравнения:");
        System.out.println("Число 1: " + num1);
        System.out.println("Число 2: " + num2);

        if (result < 0) {
            System.out.println("Результат: " + num1 + " < " + num2);
        } else if (result > 0) {
            System.out.println("Результат: " + num1 + " > " + num2);
        } else {
            System.out.println("Результат: " + num1 + " = " + num2);
        }
    }

    private static void Task2_2() {
        System.out.println("ЗАДАНИЕ 2.2: Поиск максимума в коробках");

        List<Task1_1.Box<? extends Number>> boxes = new ArrayList<>();

        System.out.print("\nСколько добавить коробок? ");
        int count = readInt();

        if (count <= 0) {
            System.out.println("Количество должно быть больше 0.");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.print("Введите число для того чтобы положить в коробку (целое или дробное): ");
            double num = readDouble();
            Task1_1.Box<Double> box = new Task1_1.Box<>();
            box.put(num);
            boxes.add(box);
            System.out.println("Число " + num + " помещено в коробку " + (i + 1));
        }

        try {
            System.out.println("\nПоиск максимального значения");
            double max = Task2_2.BoxUtils.findMax(boxes);
            System.out.println("Максимальное значение: " + max);

            System.out.println("\nСостояние коробок после поиска:");
            for (int i = 0; i < boxes.size(); i++) {
                System.out.println("Коробка " + (i + 1) + ": " + boxes.get(i));
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static void Task3_1() {
        System.out.println("ЗАДАНИЕ 3.1: Функция");

        System.out.println("\nСтроки -> Длины строк");
        System.out.print("Введите несколько слов через пробел: ");
        String input1 = scanner.nextLine();
        List<String> strings1 = Arrays.asList(input1.split("\\s+"));

        System.out.println("\nИсходный список: " + strings1);
        List<Integer> lengths = Task3_1.FunctionUtils.applyToList(strings1, String::length);
        System.out.println("Результат (длины строк): " + lengths);

        System.out.println("\nЧисла -> Положительные значения");
        System.out.print("Введите несколько чисел через пробел (включая отрицательные): ");
        String input2 = scanner.nextLine();
        List<Integer> numbers = parseIntegerList(input2);

        System.out.println("\nИсходный список: " + numbers);
        List<Integer> absoluteValues = Task3_1.FunctionUtils.applyToList(numbers,
                n -> n < 0 ? -n : n);
        System.out.println("Результат (положительные значения): " + absoluteValues);

        System.out.println("\nМассивы -> Максимумы");
        System.out.print("Сколько массивов хотите создать? ");
        int arrayCount = readInt();

        List<int[]> arrays = new ArrayList<>();
        for (int i = 0; i < arrayCount; i++) {
            System.out.print("Введите числа для массива " + (i + 1) + " через пробел: ");
            String arrayInput = scanner.nextLine();
            int[] array = parseIntArray(arrayInput);
            arrays.add(array);
        }

        System.out.println("\nИсходные массивы:");
        for (int i = 0; i < arrays.size(); i++) {
            System.out.println("  Массив " + (i + 1) + ": " + Arrays.toString(arrays.get(i)));
        }

        List<Integer> maxValues = Task3_1.FunctionUtils.applyToList(arrays,
                arr -> Arrays.stream(arr).max().orElse(0));
        System.out.println("Результат (максимумы массивов): " + maxValues);
    }

    private static void Task3_2() {
        System.out.println("ЗАДАНИЕ 3.2: Фильтр");

        System.out.println("\nСтроки длиннее 2 символов");
        System.out.print("Введите несколько слов через пробел: ");
        String input1 = scanner.nextLine();
        List<String> strings1 = Arrays.asList(input1.split("\\s+"));

        System.out.println("\nИсходный список: " + strings1);
        List<String> filteredStrings = Task3_2.FilterUtils.filterList(strings1,
                s -> s.length() >= 3);
        System.out.println("Результат (длина >= 3): " + filteredStrings);

        System.out.println("\nНеположительные числа");
        System.out.print("Введите несколько чисел через пробел: ");
        String input2 = scanner.nextLine();
        List<Integer> numbers = parseIntegerList(input2);

        System.out.println("\nИсходный список: " + numbers);
        List<Integer> nonPositive = Task3_2.FilterUtils.filterList(numbers,
                n -> n <= 0);
        System.out.println("Результат (<= 0): " + nonPositive);

        System.out.println("\nМассивы без положительных элементов");
        System.out.print("Сколько массивов хотите создать? ");
        int arrayCount = readInt();

        List<int[]> arrays = new ArrayList<>();
        for (int i = 0; i < arrayCount; i++) {
            System.out.print("Введите числа для массива " + (i + 1) + " через пробел: ");
            String arrayInput = scanner.nextLine();
            int[] array = parseIntArray(arrayInput);
            arrays.add(array);
        }

        System.out.println("\nИсходные массивы:");
        for (int i = 0; i < arrays.size(); i++) {
            System.out.println("  Массив " + (i + 1) + ": " + Arrays.toString(arrays.get(i)));
        }

        List<int[]> negativeArrays = Task3_2.FilterUtils.filterList(arrays,
                arr -> Arrays.stream(arr).allMatch(n -> n <= 0));

        System.out.println("\nМассивы без положительных элементов:");
        for (int i = 0; i < negativeArrays.size(); i++) {
            System.out.println("  [" + (i + 1) + "]: " + Arrays.toString(negativeArrays.get(i)));
        }
    }

    private static void Task3_3() {
        System.out.println("ЗАДАНИЕ 3.3: Сокращение");

        System.out.println("\nКонкатенация строк");
        System.out.print("Введите несколько слов через пробел: ");
        String input1 = scanner.nextLine();
        List<String> strings = Arrays.asList(input1.split("\\s+"));

        System.out.println("\nИсходный список: " + strings);
        String concatenated = Task3_3.ReduceUtils.reduceList(strings,
                (acc, s) -> acc + " " + s, "");
        System.out.println("Результат конкатенации: \"" + concatenated.trim() + "\"");
        System.out.println("Длина результата: " + concatenated.trim().length());

        System.out.println("\nСумма чисел");
        System.out.print("Введите несколько чисел через пробел: ");
        String input2 = scanner.nextLine();
        List<Integer> numbers = parseIntegerList(input2);

        System.out.println("\nИсходный список: " + numbers);
        Integer sum = Task3_3.ReduceUtils.reduceList(numbers, Integer::sum, 0);
        System.out.println("Сумма: " + sum);

        System.out.println("\nОбщее количество элементов во вложенных списках");
        System.out.print("Сколько списков хотите создать? ");
        int listCount = readInt();

        List<List<Integer>> listOfLists = new ArrayList<>();
        for (int i = 0; i < listCount; i++) {
            System.out.print("\nВведите числа для списка " + (i + 1) + " через пробел: ");
            String listInput = scanner.nextLine();
            List<Integer> innerList = parseIntegerList(listInput);
            listOfLists.add(innerList);
        }

        System.out.println("\nИсходные списки:");
        for (int i = 0; i < listOfLists.size(); i++) {
            System.out.println("  Список " + (i + 1) + ": " + listOfLists.get(i) +
                    " (размер: " + listOfLists.get(i).size() + ")");
        }

        // список размеров
        List<Integer> sizes = Task3_1.FunctionUtils.applyToList(listOfLists, List::size);
        System.out.println("Размеры списков: " + sizes);

        Integer totalSize = Task3_3.ReduceUtils.reduceList(sizes, Integer::sum, 0);
        System.out.println("Общее количество элементов: " + totalSize);
    }

    private static void Task3_4() {
        System.out.println("ЗАДАНИЕ 3.4: Коллекционирование");

        System.out.println("\nРазделение чисел на группы");
        System.out.print("Введите несколько чисел через пробел: ");
        String numbersInput = scanner.nextLine();
        List<Integer> numbers = parseIntegerList(numbersInput);

        System.out.println("\nИсходный список: " + numbers);

        Map<String, List<Integer>> grouped = Task3_4.CollectUtils.collectToList(
                numbers,
                () -> {
                    Map<String, List<Integer>> map = new HashMap<>();
                    map.put("positive", new ArrayList<>());
                    map.put("negative", new ArrayList<>());
                    map.put("zero", new ArrayList<>());
                    return map;
                },
                (map, num) -> {
                    if (num > 0) {
                        map.get("positive").add(num);
                    } else if (num < 0) {
                        map.get("negative").add(num);
                    } else {
                        map.get("zero").add(num);
                    }
                }
        );

        System.out.println("Результат группировки:");
        System.out.println("- Положительные: " + grouped.get("positive"));
        System.out.println("- Отрицательные: " + grouped.get("negative"));
        System.out.println("- Нули: " + grouped.get("zero"));

        System.out.println("\nГруппировка строк по длине");
        System.out.print("Введите несколько слов через пробел: ");
        String stringsInput = scanner.nextLine();
        List<String> strings = Arrays.asList(stringsInput.split("\\s+"));

        System.out.println("\nИсходный список: " + strings);

        Map<Integer, List<String>> groupedByLength = Task3_4.CollectUtils.collectToList(
                strings,
                HashMap::new,
                (map, str) -> {
                    int length = str.length();
                    if (!map.containsKey(length)) {
                        map.put(length, new ArrayList<>());
                    }
                    map.get(length).add(str);
                }
        );

        System.out.println("Группировка по длине:");
        for (Map.Entry<Integer, List<String>> entry : groupedByLength.entrySet()) {
            System.out.println("- Длина " + entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("\nУникальные строки");
        System.out.print("Введите несколько слов через пробел (могут быть повторения): ");
        String duplicateInput = scanner.nextLine();
        List<String> duplicateStrings = Arrays.asList(duplicateInput.split("\\s+"));

        System.out.println("\nИсходный список: " + duplicateStrings);

        Set<String> uniqueSet = Task3_4.CollectUtils.collectToList(
                duplicateStrings,
                HashSet::new,
                (set, str) -> set.add(str)
        );

        System.out.println("Уникальные строки: " + uniqueSet);
        System.out.println("Количество уникальных: " + uniqueSet.size());
    }

    private static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Неверный формат. Введите целое число: ");
            }
        }
    }

    private static double readDouble() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Неверный формат. Введите число: ");
            }
        }
    }

    private static boolean readBoolean() {
        while (true) {
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("true") || input.equals("t") || input.equals("1")) {
                return true;
            } else if (input.equals("false") || input.equals("f") || input.equals("0")) {
                return false;
            } else {
                System.out.print("Неверный формат. Введите true/false: ");
            }
        }
    }

    private static List<Integer> parseIntegerList(String input) {
        List<Integer> result = new ArrayList<>();
        String[] parts = input.split("\\s+");

        for (String part : parts) {
            try {
                result.add(Integer.parseInt(part));
            } catch (NumberFormatException e) {

            }
        }

        return result;
    }

    private static int[] parseIntArray(String input) {
        String[] parts = input.split("\\s+");
        int[] result = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            try {
                result[i] = Integer.parseInt(parts[i]);
            } catch (NumberFormatException e) {
                result[i] = 0; // Значение по умолчанию для некорректных данных
            }
        }

        return result;
    }
}
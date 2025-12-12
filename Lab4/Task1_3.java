package Lab4;

public class Task1_3 {

    public interface Comparable<T> {
        int compare(T other);
    }

    public static class ComparableInteger implements Comparable<Integer> {

        private final Integer value;

        public ComparableInteger(Integer value) {
            this.value = value;
        }

        // сравнения для целых чисел
        @Override
        public int compare(Integer other) {
            return value.compareTo(other);
        }

        @Override
        public String toString() {
            return "ComparableInteger{" + "value=" + value + '}';
        }
    }
}
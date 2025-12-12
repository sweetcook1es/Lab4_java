package Lab4;

public class Task1_1 {

    public static class Box<T> {
        private T content;

        public Box() {
            this.content = null;
        }

        // для размещения объекта в коробку
        public void put(T item) {
            if (content != null) {
                throw new IllegalStateException("Коробка уже содержит объект");
            }
            this.content = item;
        }

        // для извлечения объекта из коробки
        public T get() {
            T item = content;
            content = null;
            return item;
        }

        // проверки коробки на пустоту
        public boolean isEmpty() {
            return content == null;
        }

        // просмотра содержимого коробки без его извлечения
        public T peek() {
            return content;
        }

        @Override
        public String toString() {
            return "Box{" + "content=" + content + '}';
        }
    }
}
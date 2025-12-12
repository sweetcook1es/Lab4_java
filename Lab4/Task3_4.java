package Lab4;

import java.util.*;

public class Task3_4 {
    @FunctionalInterface
    public interface CollectorFunction<T, P> {
        void apply(P container, T item);
    }

    @FunctionalInterface
    public interface Supplier<T> {
        T get();
    }

    public static class CollectUtils {
        public static <T, P> P collectToList(List<T> list,
                                             Supplier<P> containerSupplier,
                                             CollectorFunction<T, P> collector) {
            P container = containerSupplier.get();
            for (T item : list) {
                collector.apply(container, item);
            }
            return container;
        }
    }
}
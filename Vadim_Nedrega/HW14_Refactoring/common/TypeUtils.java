package vadim_nedrega.HW14_Refactoring.common;

import java.util.Map;

/**
 * https://stackoverflow.com/questions/1704634/simple-way-to-get-wrapper-class-type-in-java
 */
public final class TypeUtils {
    private TypeUtils() {
    }

    // safe because both Long.class and long.class are of type Class<Long>
    @SuppressWarnings("unchecked")
    public static <T> Class<T> wrap(Class<T> c) {
        return c.isPrimitive() ? (Class<T>) PRIMITIVES_TO_WRAPPERS.get(c) : c;
    }

    @SuppressWarnings("unchecked")
    public static <T> Class<T> unwrap(Class<T> c) {
        Class<T> result = null;
        if (c.isPrimitive()) {
            result = c;
        } else {
            for (Map.Entry<Class<?>, Class<?>> entry : PRIMITIVES_TO_WRAPPERS.entrySet()) {
                if (entry.getValue() == c) {
                    result = (Class<T>) entry.getKey();
                }
            }
        }
        if (result == null) {
            throw new IllegalArgumentException("Primitive type error");
        }
        return result;
    }

    private static final Map<Class<?>, Class<?>> PRIMITIVES_TO_WRAPPERS = Map.of(
            boolean.class, Boolean.class,
            byte.class, Byte.class,
            char.class, Character.class,
            double.class, Double.class,
            float.class, Float.class,
            int.class, Integer.class,
            long.class, Long.class,
            short.class, Short.class,
            void.class, Void.class);
}

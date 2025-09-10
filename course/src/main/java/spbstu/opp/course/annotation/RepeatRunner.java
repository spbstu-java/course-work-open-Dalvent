package spbstu.opp.course.annotation;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class RepeatRunner {

    public static void run(Object instance) {
        Class<?> clazz = instance.getClass();

        for (Method method : clazz.getDeclaredMethods()) {
            if (!method.isAnnotationPresent(Repeat.class))
                continue;

            int modifier = method.getModifiers();
            if (!(Modifier.isPrivate(modifier) || Modifier.isProtected(modifier)))
                continue;

            int repeatCount = method.getAnnotation(Repeat.class).value();

            method.setAccessible(true);
            Object[] argsForMethod = buildArgs(method.getParameterTypes());
            for (int i = 0; i < repeatCount; i++) {
                try {
                    method.invoke(instance, argsForMethod);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException("Ошибка вызова метода " + method.getName(), e);
                }
            }
        }
    }

    private static Object[] buildArgs(Class<?>[] types) {
        Object[] args = new Object[types.length];
        for (int i = 0; i < types.length; i++) {
            Class<?> t = types[i];
            args[i] = Array.get(Array.newInstance(t, 1), 0);
        }
        return args;
    }
}
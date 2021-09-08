package vadim_nedrega.HW21_ClassLoader;

import vadim_nedrega.HW21_ClassLoader.FileModuleLoader.FileModuleExceptions;
import vadim_nedrega.HW21_ClassLoader.FileModuleLoader.FileModuleLoader;
import vadim_nedrega.HW21_ClassLoader.ModuleLoaderInterface.ModuleLoader;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;


public class Program_21_01 {
    public static void main(String[] args) throws ClassNotFoundException,
            FileModuleExceptions, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {

        ModuleLoader moduleLoader = new FileModuleLoader("D:/Обучение IT/Java Elementary/Test");
        Class<?> clazz = moduleLoader.findClass("vadim_nedrega.HW21_ClassLoader.ClassForLoading.Player");

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("==========================================================");

        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println("==========================================================");

        Object player1 = clazz.getDeclaredConstructor(String.class, int.class, boolean.class)
                .newInstance("Player", 35, true);

        Method method1 = clazz.getDeclaredMethod("getId");
        System.out.println("Возраст по умолчанию: " + method1.invoke(player1));

        Method method = clazz.getDeclaredMethod("setId", int.class);
        method.invoke(player1, 20);

        System.out.println("Возраст после изменения: " + method1.invoke(player1));


    }
}

package vadim_nedrega.HW15_Annotations;


import vadim_nedrega.HW15_Annotations.MyAnnotations.ClassInfo;
import vadim_nedrega.HW15_Annotations.MyAnnotations.FieldInfo;
import vadim_nedrega.HW15_Annotations.MyAnnotations.MethodInfo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Program_15_01 {
    public static void main(String[] args) {
        PlayerHW15 player = new PlayerHW15();
        Class<?> clazz = player.getClass();
        if (clazz.isAnnotationPresent(ClassInfo.class)) {
            ClassInfo declaredAnnotation = clazz.getDeclaredAnnotation(ClassInfo.class);
            System.out.println("Authors: " + Arrays.toString(declaredAnnotation.author()));
            System.out.println("Version: " + declaredAnnotation.version());
        }

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        try {
            Method isAddicted = clazz.getDeclaredMethod("isAddicted");
            MethodInfo declaredAnnotation = isAddicted.getDeclaredAnnotation(MethodInfo.class);
            System.out.println("Authors: " + Arrays.toString(declaredAnnotation.author()));
            System.out.println("Info: " + declaredAnnotation.info());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        try {
            Field id = clazz.getDeclaredField("id");
            Field isAddicted = clazz.getDeclaredField("isAddicted");
            FieldInfo declaredAnnotation = id.getDeclaredAnnotation(FieldInfo.class);
            FieldInfo declaredAnnotation1 = isAddicted.getDeclaredAnnotation(FieldInfo.class);
            System.out.println("For Field id:");
            System.out.println("Authors: " + Arrays.toString(declaredAnnotation.author()));
            System.out.println("Using info: " + declaredAnnotation.usingInfo());
            System.out.println("For Field isAddicted:");
            System.out.println("Authors: " + Arrays.toString(declaredAnnotation1.author()));
            System.out.println("Using info: " + declaredAnnotation1.usingInfo());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}

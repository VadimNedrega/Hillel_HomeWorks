package vadim_nedrega.HW13_Reflection.src.vadim_nedrega.HW13_Reflection;

import vadim_nedrega.HW13_Reflection.src.vadim_nedrega.HW13_Reflection.DataInfo.Data;
import vadim_nedrega.HW13_Reflection.src.vadim_nedrega.HW13_Reflection.Player.Player;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Program13_01 {
    public static void main(String[] args) {
        Data<Player> playerData = null;
        Class<?> class1 = null;
        try {
            class1 = Class.forName(ClassPath.getPlayerDataClass());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String className = class1.getName();
        System.out.println(className);

        Constructor<?>[] constructor = class1.getConstructors();
        try {
            Constructor<?> constructor1 = class1.getDeclaredConstructor();
            playerData = (Data<Player>) constructor1.newInstance();

        } catch (NoSuchMethodException |
                InvocationTargetException |
                InstantiationException |
                IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println("Конструкторы:");
        for (Constructor<?> constr : constructor) {
            System.out.println(constr);
        }

        System.out.println();
        System.out.println("Поля:");
        Field[] field = class1.getDeclaredFields();
        for (Field f : field) {
            System.out.println(f);
            f.setAccessible(true);
        }

        System.out.println();
        System.out.println("Методы:");
        Method[] methods = class1.getMethods();
        for (Method m : methods) {
            System.out.println(m);
            m.setAccessible(true);
        }

        Player player = new Player();
        player.setId(6);
        player.setName("Player_6");
        player.setAddicted(true);

        Map<Player, Integer> newPlayerMap = new HashMap<>();
        newPlayerMap.put(player, 6);

        try {
            Method getData = class1.getDeclaredMethod("getData");
            Method addData = class1.getDeclaredMethod("addData", Map.class);
            Method setData = class1.getDeclaredMethod("setData", Map.class);
            Method findPlayerByName = class1.getDeclaredMethod("findPlayerByName", String.class);
            PrintPlayerMap printPlayerMap = new PrintPlayerMap();
            printPlayerMap.print((Map<Player, Integer>) getData.invoke(playerData));
            System.out.println("=================================");
            addData.invoke(playerData, newPlayerMap);
            printPlayerMap.print((Map<Player, Integer>) getData.invoke(playerData));
            System.out.println("=================================");
            ((Map<Player, Integer>) getData.invoke(playerData)).
                    remove((Player) findPlayerByName.invoke(playerData, "Player_3"));
            printPlayerMap.print((Map<Player, Integer>) getData.invoke(playerData));
            System.out.println("=================================");
            setData.invoke(playerData, new HashMap<>());
            printPlayerMap.print((Map<Player, Integer>) getData.invoke(playerData));
        } catch (NoSuchMethodException |
                InvocationTargetException |
                IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}

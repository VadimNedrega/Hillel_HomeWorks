package vadim_nedrega.HW22_GarbageCollector;

import java.util.concurrent.TimeUnit;

public class Program_22_01 {
    public static void main(String[] args) throws InterruptedException {
        long m1, m2, m3;
        Runtime rt = Runtime.getRuntime();
        System.out.println(rt.maxMemory()/1024/1024 + " Mb");
        for (int i = 0; i < 5; i++) {
            m1 = rt.freeMemory();
            createObjects(1_000_000_000L);
            m2 = rt.freeMemory();
            System.gc();
            TimeUnit.SECONDS.sleep(10);
            m3 = rt.freeMemory();
            System.out.println("Количество свободной памяти до создания объектов: " + m1/1024 + " Kb\n" +
                    "Количество свободной памяти после создания объектов: " + m2/1024 + " Kb\n" +
                    "Количество свободной памяти после запуска GC: " + m3/1024 + " Kb\n" +
                    "Освобождено памяти: " + (m3 - m2)/1024 + " Kb");
            System.out.println("-------------------------");
        }
    }
    public static void createObjects(long count) {
        for (int i = 0; i < count; i++) {
            new Object();
        }
    }
}

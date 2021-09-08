package vadim_nedrega.HW19_Multithreading.WorkForThreads;

import java.util.concurrent.TimeUnit;

public class SimpleCalculation implements Work {
    private final int a;
    private final int b;

    public SimpleCalculation(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void justDoIt() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("Начало работы с классом: " + this.getClass().getSimpleName());
        int c = a + b;
        System.out.println("Результат простейшего вычисления: " + a + " + " + b + " = " + c);
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Окончание работы с классом: " + this.getClass().getSimpleName());
        System.out.println("================================================================");
    }
}

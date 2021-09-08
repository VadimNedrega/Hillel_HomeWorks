package vadim_nedrega.HW20_Multithreading_1.CyclicBarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Program_20_04 {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new BarAction());
        System.out.println("Запуск потоков");

        for (int i = 0; i < 6; i++) {
            FootballFan2 fan = new FootballFan2(cyclicBarrier);
            fan.setFanName("Fan_" + i);
            fan.setFanId(i);
            TimeUnit.SECONDS.sleep(1);
        }



    }
    public static class BarAction implements Runnable {
        public void run() {
            System.out.println("3 фаната купили билеты");
        }
    }
}

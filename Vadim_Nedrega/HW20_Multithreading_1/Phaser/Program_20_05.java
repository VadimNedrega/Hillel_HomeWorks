package vadim_nedrega.HW20_Multithreading_1.Phaser;

import java.util.concurrent.Phaser;

public class Program_20_05 {
    public static void main(String[] args) throws InterruptedException {
        Phaser phaser = new Phaser(1);
        new Thread(new FootballFan4(phaser, "Фан №1")).start();
        new Thread(new FootballFan4(phaser, "Фан №2")).start();
        new Thread(new FootballFan4(phaser, "Фан №3")).start();

        int phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        phaser.arriveAndDeregister();

    }
}

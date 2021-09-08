package vadim_nedrega.HW20_Multithreading_1.Exchanger;

import java.util.concurrent.Exchanger;

public class PutFootballFan3 implements Runnable{
    private final Exchanger<FootballFan3> exchanger;
    private FootballFan3 fan3;

    public PutFootballFan3(Exchanger<FootballFan3> exchanger) {
        this.exchanger = exchanger;
        fan3 = new FootballFan3();
        fan3.setFanName("Пробный фан");
        fan3.setFanId(123);
    }

    @Override
    public void run() {
        try {
            Thread.currentThread().setName("Поток пробного фана");
            fan3 = exchanger.exchange(fan3);
            System.out.println(Thread.currentThread().getName() + " - поменял на: " + fan3.getFanName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

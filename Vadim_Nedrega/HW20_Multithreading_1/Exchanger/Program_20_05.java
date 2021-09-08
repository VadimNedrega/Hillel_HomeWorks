package vadim_nedrega.HW20_Multithreading_1.Exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class Program_20_05 {
    public static void main(String[] args) throws InterruptedException {
        Exchanger<FootballFan3> ex = new Exchanger<>();
        new Thread(new PutFootballFan3(ex)).start();
        new Thread(new GetFootballFan3(ex)).start();
    }
}

package vadim_nedrega.HW20_Multithreading_1.Semaphore;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Program_20_02 {
    public static void main(String[] args) {
        Semaphore cashbox = new Semaphore(3);
        List<FootballFan> fanList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            FootballFan fan = new FootballFan();
            fan.setFanName("Fan_" + i);
            fan.setFanId(i);
            fanList.add(fan);
        }

        for(FootballFan fan: fanList){
            fan.cashbox = cashbox;
            fan.start();
        }
    }
}

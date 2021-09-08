package vadim_nedrega.HW8_Observer;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Program_08_01 {
    public static void main(String[] args) throws InterruptedException {
        Dispatcher dispatcher = new Dispatcher();
        Observer phone = new Phone();
        Calendar stopTheKiln = new GregorianCalendar();

        dispatcher.addObserver(phone);
        dispatcher.setDataStop("Печь Cimprogetti Twin-D Reversy остановлена в: ", stopTheKiln.getTime(),
                " Механическая поломка клапана 203");
        Thread.sleep(5000);
        Calendar startTheKiln = new GregorianCalendar();
        dispatcher.setStartInfo("Запуск печи, время: ", startTheKiln.getTime());
    }
}

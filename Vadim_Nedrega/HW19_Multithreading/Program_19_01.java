package vadim_nedrega.HW19_Multithreading;

import vadim_nedrega.HW19_Multithreading.WorkForThreads.GetRandomNumbers;
import vadim_nedrega.HW19_Multithreading.WorkForThreads.PrintText;
import vadim_nedrega.HW19_Multithreading.WorkForThreads.SimpleCalculation;

import java.util.concurrent.TimeUnit;

public class Program_19_01 {
    public static void main(String[] args) throws Exception {
        System.out.println("Главный поток в работе");
        ThreadPool threadPool = null;

        GetRandomNumbers getRandomNumbers = new GetRandomNumbers();
        PrintText printText = new PrintText("Abra-Kadabra");
        SimpleCalculation simpleCalculation = new SimpleCalculation(5, 12);


        try {
            threadPool = new ThreadPool(6);
            threadPool.add(getRandomNumbers);
            threadPool.add(printText);
            threadPool.add(simpleCalculation);

            TimeUnit.MINUTES.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        threadPool.close();
        System.out.println("Главный поток работу закончил");
    }
}

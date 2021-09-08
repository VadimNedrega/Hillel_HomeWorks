package vadim_nedrega.HW20_Multithreading_1.Forkjoin;

import java.util.Date;
import java.util.concurrent.ForkJoinPool;

public class Program_20_06 {
    public static void main(String[] args) throws InterruptedException {
        int nThreads = Runtime.getRuntime().availableProcessors();
        long sum = 0;
        System.out.println("Доступных ядер: " + nThreads);

        int[] numbers = new int[100000000];
        System.out.println(numbers.length);

        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 10000);
        }

        System.out.println("Начало суммирования одним потоком: " + new Date());
        for (int number : numbers) {
            sum += number;
        }
        System.out.println(sum);
        System.out.println("Конец суммирования одним потоком: " + new Date());

        System.out.println("__________________________________________________________");

        System.out.println("Начало суммирования 4-мя потоками: " + new Date());
        ForkJoinPool forkJoinPool = new ForkJoinPool(nThreads);
        long result = forkJoinPool.invoke(new Sum(0,numbers.length, numbers));
        System.out.println(result);
        System.out.println("Конец суммирования 4-мя потоками: " + new Date());

    }
}

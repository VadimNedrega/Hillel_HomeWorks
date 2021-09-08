package vadim_nedrega.HW19_Multithreading.Examples;

public class Program_19_02 {
    public static void main(String[] args) {
        Test test = new Test();
        Thread thread = new Thread(test);
        thread.start();
        System.out.println("Главный поток");
    }

    static class Test implements Runnable {
        @Override
        public void run() {
            System.out.println("Побочный поток");
        }
    }
}

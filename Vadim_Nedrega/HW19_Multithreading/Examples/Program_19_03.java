package vadim_nedrega.HW19_Multithreading.Examples;

public class Program_19_03 {
    public static void main(String[] args) {
        new Thread(() -> System.out.println("Побочный поток"));
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Побочный поток");
            }
        });
        thread.start();
        System.out.println("Главный поток");
    }
}

package vadim_nedrega.HW19_Multithreading.Examples;

public class Program_19_04 {
    public static void main(String[] args) {
        AffableThread mSecondThread = new AffableThread();
        mSecondThread.start();
        System.out.println("Главный поток завершён...");

    }

    static class AffableThread extends Thread {
        @Override
        public void run() {
            System.out.println("Привет из побочного потока!");
        }
    }

}

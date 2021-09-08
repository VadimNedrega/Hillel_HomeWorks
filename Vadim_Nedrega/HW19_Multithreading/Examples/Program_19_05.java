package vadim_nedrega.HW19_Multithreading.Examples;

public class Program_19_05 {
    static EggVoice egg;

    public static void main(String[] args) {
        egg = new EggVoice();
        System.out.println("Спор начат...");
        egg.start();
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
            System.out.println("курица!");
        }
        if (egg.isAlive()) {
            try {
                egg.join();
            } catch (InterruptedException ignored) {
            }
            System.out.println("Первым появилось яйцо!");
        } else {
            System.out.println("Первой появилась курица!");
        }
        System.out.println("Спор закончен!");
    }
}


class EggVoice extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                sleep(1000);
            } catch (InterruptedException ignored) {
            }
            System.out.println("яйцо!");
        }
    }
}

package vadim_nedrega.HW19_Multithreading.Examples;

public class Program_19_06 {
    public static int mValue = 0;
    static Incremenator mInc;

    public static void main(String[] args) {
        mInc = new Incremenator();
        System.out.print("Значение = ");
        mInc.start();
        for (int i = 1; i <= 3; i++) {
            try {
                Thread.sleep(i * 2 * 1000);
            } catch (InterruptedException e) {
            }
            mInc.changeAction();
        }
        mInc.interrupt();
    }

}

class Incremenator extends Thread {
    private volatile boolean mIsIncrement = true;

    public void changeAction() {
        mIsIncrement = !mIsIncrement;
    }

    @Override
    public void run() {
        do {
            if (!Thread.interrupted()) {
                if (mIsIncrement) Program_19_06.mValue++;
                else Program_19_06.mValue--;
                System.out.print(Program_19_06.mValue + " ");
            } else return;
            try {

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        } while (true);
    }
}


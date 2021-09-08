package vadim_nedrega.HW20_Multithreading_1.Forkjoin;

import java.util.concurrent.RecursiveTask;

public class Sum extends RecursiveTask<Long> {
    private final int low;
    private final int high;
    private final int [] arr;

    public Sum(int low, int high, int[] arr) {
        this.low = low;
        this.high = high;
        this.arr = arr;
    }

    @Override
    protected Long compute() {
        if(high - low <= 100) {
            long sum = 0;
            for(int i = low; i < high; ++i)
                sum += arr[i];
            return sum;
        } else {
            int mid = low + (high - low) / 2;
            Sum left  = new Sum(low, mid, arr);
            Sum right = new Sum(mid, high, arr);
            left.fork();
            long rightResult = right.compute();
            long leftResult  = left.join();
            return leftResult + rightResult;
        }
    }
}

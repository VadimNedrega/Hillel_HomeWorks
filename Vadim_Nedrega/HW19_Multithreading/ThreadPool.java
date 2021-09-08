package vadim_nedrega.HW19_Multithreading;

import vadim_nedrega.HW19_Multithreading.WorkForThreads.Work;
import vadim_nedrega.HW19_Multithreading.WorkForThreads.WorkForThreadsExceptions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ThreadPool implements AutoCloseable {
    private final List<Thread> threadList = new ArrayList<>();
    private final Deque<Work> works = new ArrayDeque<>();

    public ThreadPool() {
        final int threadCount = Runtime.getRuntime().availableProcessors() * 2;
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(this::run);
            thread.setName("Поток_" + i);
            threadList.add(thread);
        }
        for (Thread thread : threadList) {
            thread.start();
        }
    }

    public ThreadPool(final int threadCount) {
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(this::run);
            threadList.add(thread);
        }
        for (Thread thread : threadList) {
            thread.start();
        }
    }

    private void run() {
        while (!Thread.currentThread().isInterrupted()) {
            if (threadList.isEmpty()) {
                Thread.yield();
            } else {
                Work work = works.poll();
                try {
                    if (work != null) {
                        work.justDoIt();
                    }
                } catch (WorkForThreadsExceptions workForThreadsExceptions) {
                    workForThreadsExceptions.printStackTrace();
                }
            }
        }
    }

    public void add(Work work) {
        works.add(work);
    }

    @Override
    public void close() throws Exception {
        for (Thread thread : threadList) {
            thread.interrupt();
        }
    }
}

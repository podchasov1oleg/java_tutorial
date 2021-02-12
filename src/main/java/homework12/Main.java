package homework12;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class Main {
    static final int SIZE = 10_000_000;
    static final int HALF = SIZE / 2;


    public static void main(String[] args) {
        withoutTreads();
        withThreads();
    }

    private static void withThreads() {
        float[] array = new float[SIZE],
            part1 = new float[HALF],
            part2 = new float[HALF];

        Arrays.fill(array, 1f);

        long beginTime = System.currentTimeMillis(), startTime,
            arCpTime, ar1ProcTime, ar2ProcTime, arsConcatTime;

        System.arraycopy(array, 0, part1,0, part1.length);
        System.arraycopy(array, part1.length, part2,0, part2.length);

        arCpTime = System.currentTimeMillis() - beginTime;

        Worker w1, w2;
        Thread t1 = new Thread(w1 = new Worker(part1));
        Thread t2 = new Thread(w2 = new Worker(part2));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ar1ProcTime = w1.getEndTime();
        ar2ProcTime = w2.getEndTime();

        startTime = System.currentTimeMillis();
        array = ArrayUtils.addAll(w1.getArray(), w2.getArray());
        arsConcatTime = System.currentTimeMillis() - startTime;

        System.out.println("Array copy time (ms):" + arCpTime);
        System.out.println("Array 1 process time (ms):" + ar1ProcTime);
        System.out.println("Array 2 process time (ms):" + ar2ProcTime);
        System.out.println("Arrays concatenation time (ms):" + arsConcatTime);
        System.out.println("Time spent with threads (ms):" + (System.currentTimeMillis() - beginTime));
    }

    private static void withoutTreads() {
        float[] arr = new float[SIZE];
        long time;

        Arrays.fill(arr, 1f);

        time = System.currentTimeMillis();
        processArray(arr);
        System.out.println("Time spent without threads (ms): " + (System.currentTimeMillis() - time));
    }

    private static void processArray(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    static class Worker implements Runnable {
        float[] array;
        long startTime, endTime;

        public Worker(float[] array) {
            this.array = array;
            this.startTime = System.currentTimeMillis();
        }

        @Override
        public void run() {
            processArray(array);
            this.endTime = System.currentTimeMillis() - this.startTime;
        }

        public long getEndTime() {
            return this.endTime;
        }

        public float[] getArray() {
            return array;
        }
    }
}

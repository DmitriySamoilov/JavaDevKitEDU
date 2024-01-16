package hwSem5;

import java.util.concurrent.CountDownLatch;

public class Philosopher extends Thread {
    final int nameNumber;
    private int feedingCount;
    final Fork rightFork;
    final Fork leftFork;
    final CountDownLatch cdl;

    public Philosopher(int nameNumber, int feedingCount, Fork rightFork, Fork leftFork, CountDownLatch cdl) {
        this.nameNumber = nameNumber;
        this.feedingCount = feedingCount;
        this.rightFork = rightFork;
        this.leftFork = leftFork;
        this.cdl = cdl;
    }

    @Override
    public void run() {
        try {
            while (feedingCount > 0) {
                eat();
                think();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        cdl.countDown();
        System.out.printf("Философ %s питание закончил\n", nameNumber);
    }

    private void eat() throws InterruptedException {
        if (leftFork.getIsFree() && rightFork.getIsFree()) {
            leftFork.setState(false);
            rightFork.setState(false);
            System.out.printf("Философ %s обедает\n", nameNumber);
            sleep((long) (Math.random() * 1000));
            leftFork.setState(true);
            rightFork.setState(true);
            feedingCount--;
        }
    }

    private void think() throws InterruptedException {
        System.out.printf("Филосов %s размышляет\n", nameNumber);
        sleep((long) (Math.random() * 5000));
    }
}

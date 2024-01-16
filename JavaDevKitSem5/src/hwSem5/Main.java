package hwSem5;

import java.util.concurrent.CountDownLatch;

/*
1. Пять безмолвных философов сидят вокруг круглого стола, перед каждым философом стоит тарелка спагетти.
2. Вилки лежат на столе между каждой парой ближайших философов.
3. Каждый философ может либо есть, либо размышлять.
4. Философ может есть только тогда, когда держит две вилки — взятую справа и слева.
5. Философ не может есть два раза подряд, не прервавшись на размышления (можно не учитывать)
Описать в виде кода такую ситуацию. Каждый философ должен поесть три раза
*/
public class Main {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(5);
        int feedingCount = 3;

        Fork fork1 = new Fork();
        Fork fork2 = new Fork();
        Fork fork3 = new Fork();
        Fork fork4 = new Fork();
        Fork fork5 = new Fork();

        Philosopher ph1 = new Philosopher(1,feedingCount,fork1,fork2,cdl);
        Philosopher ph2 = new Philosopher(2,feedingCount,fork2,fork3,cdl);
        Philosopher ph3 = new Philosopher(3,feedingCount,fork3,fork4,cdl);
        Philosopher ph4 = new Philosopher(4,feedingCount,fork4,fork5,cdl);
        Philosopher ph5 = new Philosopher(5,feedingCount,fork5,fork1,cdl);

        ph1.start();
        ph2.start();
        ph3.start();
        ph4.start();
        ph5.start();

        cdl.await();
        System.out.println("Все философы поели.");
    }
}

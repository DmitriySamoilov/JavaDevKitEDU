
public class Main {
    public static void main(String[] args) {

        System.out.println("Hello and welcome!");
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 3; i++) {
            new MyThread().start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(new MyRunnable()).start();
        }
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                System.out.println("И снова на арене" + Thread.currentThread());
            }).start();
        }
        Thread tic = new Thread(new TicTac("["));
        Thread tac = new Thread(new TicTac("]"));
        tic.start();
        tac.start();
    }
}
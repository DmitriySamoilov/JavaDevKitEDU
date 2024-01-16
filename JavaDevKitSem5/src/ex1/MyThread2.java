package ex1;

public class MyThread2 extends Thread{
    private Friend friend1, friend2;

    public MyThread2(Friend friend1, Friend friend2) {
        this.friend1 = friend1;
        this.friend2 = friend2;
    }

    @Override
    public void run() {
        friend1.bow(friend2);
    }

}

package hwSem5;

public class Fork {
    private Boolean isFree;

    public Fork() {
        this.isFree = true;
    }

    public synchronized Boolean getIsFree() {
        return isFree;
    }

    public synchronized void setState(Boolean state) {
        isFree = state;
    }
}

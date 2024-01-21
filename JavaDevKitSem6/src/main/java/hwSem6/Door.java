package hwSem6;

public class Door {
    boolean isPrize = false;
    boolean isGamerChooseOnFirstTurn = false;
    boolean isMasterChoose = false;
    boolean isGamerChooseOnFinalTurn = false;

    Door(){}

    @Override
    public String toString() {
        return "isPrize " + isPrize
                + " isGamerChooseOnFirstTurn " + isGamerChooseOnFirstTurn
                + " isMasterChoose " + isMasterChoose
                + " isGamerChooseOnFinalTurn " + isGamerChooseOnFinalTurn;
    }
}

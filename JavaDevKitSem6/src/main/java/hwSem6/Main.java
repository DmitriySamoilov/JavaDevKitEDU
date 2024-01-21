package hwSem6;

import java.util.HashMap;

/**
 В качестве задачи предлагаю вам реализовать код для демонстрации парадокса Монти Холла
 и наглядно убедиться в верности парадокса
(запустить игру в цикле на 1000 и вывести итоговый счет).
Необходимо:
Создать свой Java Maven или Gradle проект;
Самостоятельно реализовать прикладную задачу;
    Наиболее популярной является задача с дополнительным условием — участнику игры заранее известны следующие правила :
        автомобиль равновероятно размещён за любой из трёх дверей;
        ведущий знает, где находится автомобиль;
        ведущий в любом случае обязан открыть дверь с козой (но не ту, которую выбрал игрок) и предложить игроку изменить выбор;
        если у ведущего есть выбор, какую из двух дверей открыть (то есть, игрок указал на верную дверь, и за обеими
        оставшимися дверями — козы), он выбирает любую из них с одинаковой вероятностью.
Сохранить результат в HashMap<шаг теста, результат>
Вывести на экран статистику по победам и поражениям
 */
public class Main {
    public static void main(String[] args) {
        //Strategy1 - always change the first choice
        HashMap<Integer, Boolean> testResultTable1 = new HashMap<>();
        double wins = 0;
        double losses = 0;
        for (int i = 0; i < 1000; i++) {
            Boolean test = MontyHallParadoxStrategy1();
            if (test) {wins++;} else {losses++;}
            testResultTable1.put(i,test);
        }
        System.out.printf("Result Strategy 1 : win %.2f percent lose %.2f percent " +
                "- always change the first choice\n",(wins / (wins+losses) * 100),(losses / (wins+losses) * 100));

        //Strategy2 - never change the first choice
        HashMap<Integer, Boolean> testResultTable2 = new HashMap<>();
        wins = 0;
        losses = 0;
        for (int i = 0; i < 1000; i++) {
            Boolean test = MontyHallParadoxStrategy2();
            if (test) {wins++;} else {losses++;}
            testResultTable2.put(i,test);
        }
        System.out.printf("Result Strategy 2 : win %.2f percent lose %.2f percent " +
                "- never change the first choice\n",(wins / (wins+losses) * 100),(losses / (wins+losses) * 100));

        //Strategy3 - make a random choice at the end
        HashMap<Integer, Boolean> testResultTable3 = new HashMap<>();
        wins = 0;
        losses = 0;
        for (int i = 0; i < 1000; i++) {
            Boolean test = MontyHallParadoxStrategy3();
            if (test) {wins++;} else {losses++;}
            testResultTable3.put(i,test);
        }
        System.out.printf("Result Strategy 3 : win %.2f percent lose %.2f percent " +
                "- make a random choice at the end\n",(wins / (wins+losses) * 100),(losses / (wins+losses) * 100));
    }
    static Boolean MontyHallParadoxStrategy1(){
        //Game starts
        Door [] doors = {new Door(),new Door(),new Door()};
        doors [(int) (Math.random() * 2.99999)].isPrize = true;

        //Gamer makes the first choice
        doors [(int) (Math.random() * 2.99999)].isGamerChooseOnFirstTurn = true;

        //Master makes his turn
        boolean loopContinue = true;
        int doorNumber;
        while (loopContinue){
            doorNumber = (int) (Math.random() * 2.99999);
            if (doors[doorNumber].isPrize || doors[doorNumber].isGamerChooseOnFirstTurn) {
            } else {
                doors[doorNumber].isMasterChoose = true;
                loopContinue = false;
            }
        }

        //Gamer makes the final choice
        for (Door door: doors){
            if (door.isMasterChoose || door.isGamerChooseOnFirstTurn){
            }else {
                door.isGamerChooseOnFinalTurn = true;
            }
        }

        //Final check the game result
        for (Door door: doors){
            if (door.isPrize && door.isGamerChooseOnFinalTurn) return true;
        }
        return false;
    }
    static Boolean MontyHallParadoxStrategy2(){
        //Game starts
        Door [] doors = {new Door(),new Door(),new Door()};
        doors [(int) (Math.random() * 2.99999)].isPrize = true;


        //Gamer makes a final unalterable choice
        doors [(int) (Math.random() * 2.99999)].isGamerChooseOnFinalTurn = true;

        //Final check the game result
        for (Door door: doors){
            if (door.isPrize && door.isGamerChooseOnFinalTurn) return true;
        }
        return false;
    }
    static Boolean MontyHallParadoxStrategy3(){
        //Game starts
        Door [] doors = {new Door(),new Door(),new Door()};
        doors [(int) (Math.random() * 2.99999)].isPrize = true;


        //Gamer makes the first choice
        doors [(int) (Math.random() * 2.99999)].isGamerChooseOnFirstTurn = true;

        //Master makes his turn
        boolean flag = true;
        int doorNumber;
        while (flag){
            doorNumber = (int) (Math.random() * 2.99999);
            if (doors[doorNumber].isPrize || doors[doorNumber].isGamerChooseOnFirstTurn) {
            } else {
                    doors[doorNumber].isMasterChoose = true;
                    flag = false; //loop end
            }
        }

        //Gamer makes the final choice
        flag = true;
        while (flag){
            doorNumber = (int) (Math.random() * 2.99999);
            if (doors[doorNumber].isMasterChoose){
            }else {
                doors[doorNumber].isGamerChooseOnFinalTurn = true;
                flag = false; //loop end
            }
        }
        //Final check the game result
        for (Door door: doors){
            if (door.isPrize && door.isGamerChooseOnFinalTurn) return true;
        }
        return false;
    }
}

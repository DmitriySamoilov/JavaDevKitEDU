package Task3;
/*Напишите обобщенный класс Pair, который представляет собой пару значений разного типа. Класс должен иметь
методы getFirst(), getSecond() для получения значений каждого из составляющих пары, а также переопределение
метода toString(), возвращающее строковое представление пары. */
public class Pair <O1, O2>{
    private O1 first;
    private O2 second;

    public Pair(O1 first, O2 second){
        this.first = first;
        this.second = second;
    }

    public O1 getFirst(){return first;}

    public O2 getSecond(){return second;}

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}

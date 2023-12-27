package Task1;
/*Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы: sum(),
 multiply(), divide(), subtract(). Параметры этих методов – два числа разного типа, над которыми
 должна быть произведена операция.*/
public class Calc {
    public static <T extends Number> double sum(T num1, T num2){
        return num1.doubleValue() + num2.doubleValue();
    }

    public static <T extends Number> double multiply(T num1, T num2){
        return num1.doubleValue() * num2.doubleValue();
    }

    public static <T extends Number> double divide(T num1, T num2){
        if (num2.doubleValue() == 0) {
            throw new ArithmeticException("Деление на ноль");}
        return num1.doubleValue() / num2.doubleValue();
    }
    public static <T extends Number> double subtract(T num1, T num2){
        return num1.doubleValue() - num2.doubleValue();
    }

    public static void main(String[] args) {
        System.out.println(sum(0.01 , 1.22));
        System.out.println(multiply(-1.02, 8));
        System.out.println(divide(-112.23, 0.005));
        System.out.println(subtract(0.123, 896));
    }
}

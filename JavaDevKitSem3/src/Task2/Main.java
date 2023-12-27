package Task2;
/*Напишите обобщенный метод compareArrays(), который принимает два массива и возвращает true,
если они одинаковые, и false в противном случае. Массивы могут быть любого типа данных, но должны
иметь одинаковую длину и содержать элементы одного типа по парно.*/

public class Main {

    public static void main(String[] args) {
        Integer[] arr1 = {1,2,3};
        Integer[] arr2 = {1,2};
        System.out.println(compareArrays(arr1,arr2));

        Integer [] arr3 = {1,2,3};
        Float[] arr4 = {1f,2f,3f};
        System.out.println(compareArrays(arr3,arr4));

        Float[] arr5 = {1f,2f,3f};
        Float[] arr6 = {3f,2f,1f};
        System.out.println(compareArrays(arr5,arr6));

        Object[] arr7 = {1, 2f, 3.0};
        Object[] arr8 = {3, 2f, 1.0};
        System.out.println(compareArrays(arr7,arr8));

    }

    public static <T> boolean compareArrays (T [] array1, T [] array2){
        if (array1.length != array2.length){return false;}
        for (int i =0; i < array1.length; i++){
            if (! array1[i].getClass().equals(array2[i].getClass())){
                return false;
            }
        }
        return true;
    }
}

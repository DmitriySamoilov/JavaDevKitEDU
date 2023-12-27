package homeWork;

public class Main {
    public static void main(String[] args) {
        ListOfEmployees list = new ListOfEmployees("MyList");

        list.addEmployee(new Employee("Николай", "9210660567", 12));
        list.addEmployee(new Employee("Фёдор", "9222660578", 42));
        list.addEmployee(new Employee("Поликарп", "922366089", 52));
        list.addEmployee(new Employee("Семён", "92346605656", 22));
        list.addEmployee(new Employee("Арсений", "9235660545", 9));
        list.addEmployee(new Employee("Арсения", "9235660548", 59));
        list.addEmployee(new Employee("Арсен", "9235660584", 32));
        list.addEmployee(new Employee("Арсен", "9035110587", 12));

        System.out.println(list.findEmployeeByID("1002"));

        System.out.println(list.findEmployeesByWorkExperience(30));

        System.out.println(list.findEmployeesPhoneNumberByName("Арсен"));
    }
}

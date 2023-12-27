package homeWork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ListOfEmployees {
    private String name;
    private List<Employee> employeesList;

    ListOfEmployees(String name){
        this.name = name;
        this.employeesList = new ArrayList<>();
    }

    /*Добавить метод добавление нового сотрудника в справочник*/
    public void addEmployee(Employee e){
        this.employeesList.add(e);
    }

    /*Добавить метод, который ищет сотрудника по табельному номеру*/
    public Employee findEmployeeByID(String ID){
        for (Employee e : this.employeesList) {
            if (e.getID().equals(ID)) {
                return e;
            }
        }
        return null;
    }

    /*Добавить метод, который ищет сотрудника по стажу (может быть список)*/
    public List<Employee> findEmployeesByWorkExperience(Integer workExperience){
        List<Employee> result = new ArrayList<>();
        for (Employee e : this.employeesList) {
            if (e.getWorkExperience() >= workExperience) {
                result.add(e);
            }
        }
        return result;
    }
    /*Добавить метод, который возвращает номер телефона сотрудника по имени (может быть список)*/
    public HashMap<String,String> findEmployeesPhoneNumberByName(String name){
        HashMap<String,String> result = new HashMap<>();
        for (Employee e : this.employeesList) {
            if (e.getName().toLowerCase().contains(name.toLowerCase())) {
                result.put("ID"+ e.getID() + e.getName(),e.getPhoneNumber());
            }
        }
        return result;
    }
}

package homeWork;

public class Employee {
    private static Integer counterID = 1000;
    private String ID;
    private String phoneNumber;
    private String name;
    private Integer workExperience;

    Employee(String name, String phoneNumber, Integer workExperience){
        this.ID = (++counterID).toString();
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.workExperience = workExperience;
    }

    public String getID() {
        return ID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public Integer getWorkExperience() {
        return workExperience;
    }

    @Override
    public String toString() {
        return "ID" + ID + " " + name + " Experience " + workExperience + " months";
    }
}

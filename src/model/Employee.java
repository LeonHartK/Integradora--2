package model;

public class Employee {
    private String nameEmployee;
    private String phoneEmployee;
    private String id;

    public Employee(){

    }

    public Employee(String nameEmployee, String phoneEmployee, String id){
        this.nameEmployee=nameEmployee;
        this.phoneEmployee=phoneEmployee;
        this.id=id;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getPhoneEmployee() {
        return phoneEmployee;
    }

    public void setPhoneEmployee(String phoneEmployee) {
        this.phoneEmployee = phoneEmployee;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

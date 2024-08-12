package Models;

public class Manager {
    private String firstname;
    private String surname;
    private int salary;

    public Manager(String firstname, String surname, int salary) {
        this.firstname = firstname;
        this.surname = surname;
        this.salary = salary;
    }
    public Manager(){

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        if(!firstname.isBlank()) {
            this.firstname = firstname;
        } else {
            throw new IllegalArgumentException("Firstname cannot be blank");
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if(!surname.isBlank()) {
            this.surname = surname;
        } else {
            throw new IllegalArgumentException("Surname cannot be blank");
        }
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        if(salary >= 0) {
            this.salary = salary;
        } else {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
    }

    @Override
    public String toString() {
        return "\nManager{" +
                "firstname='" + firstname + '\'' +
                "surname='" + surname + '\'' +
                "salary=" + salary +
                '}';
    }
}

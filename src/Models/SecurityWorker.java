package Models;

public class SecurityWorker {
    private String firstname;
    private String surname;
    private int salary;
    private static String securityCompany = "SecurityComp";

    public SecurityWorker(String firstname, String surname, int salary) {
        this.firstname = firstname;
        this.surname = surname;
        this.salary = salary;
    }
    public SecurityWorker(){

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

    public static String getSecurityCompany() {
        return securityCompany;
    }

    public static void setSecurityCompany(String securityCompany) {
        if(!securityCompany.isBlank()) {
            SecurityWorker.securityCompany = securityCompany;
        } else {
            throw new IllegalArgumentException("SecurityCompany cannot be blank");
        }
    }

    @Override
    public String toString() {
        return "\nSecurityWorker{" +
                "firstname='" + firstname + '\'' +
                "surname='" + surname + '\'' +
                "salary=" + salary +
                '}';
    }
}

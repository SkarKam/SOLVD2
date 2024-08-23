package models.persons.employees;

import models.persons.Person;

import java.time.LocalDate;
import java.util.Objects;

public abstract class CenterEmployee extends Person implements ICenterEmployee{
    private static final String centerName = "SunnyCenter";
    protected LocalDate dateOfEmployment;

    public CenterEmployee(String name, String surname) {
        super(name,surname);
        dateOfEmployment = LocalDate.now();

    }


    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }


    public abstract int calculateSalary();

    public final int getAge(){
        return LocalDate.now().getYear() - dateOfEmployment.getYear();
    }


    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CenterEmployee that = (CenterEmployee) o;
        return Objects.equals(name, that.name) && Objects.equals(surname, that.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    @Override
    public String toString() {
        return "CenterEmployee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfEmployment=" + dateOfEmployment +
                '}';
    }
}

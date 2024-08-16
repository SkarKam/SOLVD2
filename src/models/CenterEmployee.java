package models;

import java.time.LocalDate;
import java.util.Objects;

public abstract class CenterEmployee {
    protected String name;
    protected String surname;
    protected LocalDate dateOfEmployment;

    public CenterEmployee(String name, String surname) {
        this.name = name;
        this.surname = surname;
        dateOfEmployment = LocalDate.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(!name.isBlank()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be blank.");
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if(!surname.isBlank()) {
            this.surname = surname;
        } else {
            throw new IllegalArgumentException("Surname cannot be blank.");
        }
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }


    public abstract int calculateSalary();

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

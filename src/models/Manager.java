package models;

import models.employees.CenterEmployee;

import java.util.Objects;

public class Manager extends CenterEmployee {
    private int salary;
    private static int bonus = 1000;
    private boolean isObligationFulfilled = true;

    public Manager(String name, String surname) {
        super(name, surname);
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

    public static int getBonus() {
        return bonus;
    }

    public static void setBonus(int bonus) {
        if(bonus >= 500 && bonus < 2000) {
            Manager.bonus = bonus;
        } else {
            throw new IllegalArgumentException("Bonus must be between 500 and 2000");
        }
    }

    public boolean isObligationFulfilled() {
        return isObligationFulfilled;
    }

    public void setObligationFulfilled(boolean obligationFulfilled) {
        isObligationFulfilled = obligationFulfilled;
    }

    @Override
    public int calculateSalary() {
        if(isObligationFulfilled()) {
            return salary + bonus;
        } else {
            return salary;
        }
    }

    @Override
    public String toString() {
        return "Manager{" +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                "salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return salary == manager.salary && isObligationFulfilled == manager.isObligationFulfilled;
    }

    @Override
    public int hashCode() {
        return Objects.hash(salary, isObligationFulfilled);
    }
}

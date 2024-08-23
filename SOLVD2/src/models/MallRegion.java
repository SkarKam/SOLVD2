package models;

import models.employees.Janitor;
import models.employees.Manager;
import models.employees.SecurityWorker;

import java.util.Arrays;
import java.util.Objects;

//rename
public class MallRegion {
    private String sectionName;
    private Manager manager;
    private Janitor[] janitors;
    private SecurityWorker[] securityWorkers;

    public MallRegion(String sectionName, Manager manager, Janitor[] janitors, SecurityWorker[] securityWorkers) {
        this.sectionName = sectionName;
        this.manager = manager;
        this.janitors = janitors;
        this.securityWorkers = securityWorkers;
    }

    public MallRegion(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        if(!sectionName.isBlank()) {
            this.sectionName = sectionName;
        } else {
            throw new IllegalArgumentException("Section name cannot be blank.");
        }
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        if(manager!=null) {
            this.manager = manager;
        } else {
            throw new IllegalArgumentException("Manager cannot be null.");
        }
    }

    public Janitor[] getWorkers() {
        return janitors;
    }

    public void setWorkers(Janitor[] janitors) {
        this.janitors = janitors;
    }

    public void addWorkers(Janitor janitor){
        if(janitor !=null) {
            this.janitors[getSecurityWorkers().length] = janitor;
        } else {
            throw new IllegalArgumentException("Worker cannot be null.");
        }
    }

    public SecurityWorker[] getSecurityWorkers() {
        return securityWorkers;
    }

    public void setSecurityWorkers(SecurityWorker[] securityWorkers) {
        this.securityWorkers = securityWorkers;
    }
    public void addSecurityWorker(SecurityWorker securityWorkers) {
        if(securityWorkers!=null) {
            this.securityWorkers[getSecurityWorkers().length] = securityWorkers;
        } else {throw new IllegalArgumentException("Security worker cannot be null.");}
    }

    public int getAllWorkersSalary(){
        int result = 0;
        for(Janitor janitor : janitors){
            result+= janitor.getSalary();
        }
        return result;
    }
    public int getAllWorkersSectionAvgSalary(){
        int result = 0;
        int counter = 0;
        for(Janitor janitor : janitors){
            result += janitor.getSalary();
            counter++;
        }
        for(SecurityWorker securityWorker : securityWorkers){
            result += securityWorker.getHoursWorked();
            counter++;
        }
        result+=manager.getSalary();
        counter++;
        return result/counter;
    }

    @Override
    public String toString() {
        return "\nCenterWorkersSection{" +
                "sectionName='" + sectionName + '\'' +
                "manager=" + manager +
                "workers=" + Arrays.toString(janitors) +
                "securityWorkers=" + Arrays.toString(securityWorkers) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MallRegion that = (MallRegion) o;
        return Objects.equals(sectionName, that.sectionName) && Objects.equals(manager, that.manager) && Objects.deepEquals(janitors, that.janitors) && Objects.deepEquals(securityWorkers, that.securityWorkers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sectionName, manager, Arrays.hashCode(janitors), Arrays.hashCode(securityWorkers));
    }
}

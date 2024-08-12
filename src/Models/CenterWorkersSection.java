package Models;

import java.util.Arrays;

public class CenterWorkersSection {
    private String sectionName;
    private Manager manager;
    private Worker[] workers;
    private SecurityWorker[] securityWorkers;

    public CenterWorkersSection(String sectionName, Manager manager, Worker[] workers, SecurityWorker[] securityWorkers) {
        this.sectionName = sectionName;
        this.manager = manager;
        this.workers = workers;
        this.securityWorkers = securityWorkers;
    }

    public CenterWorkersSection(String sectionName, Manager manager, Worker[] workers) {}

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

    public Worker[] getWorkers() {
        return workers;
    }

    public void setWorkers(Worker[] workers) {
        this.workers = workers;
    }

    public void addWorkers(Worker worker){
        if(worker!=null) {
            this.workers[getSecurityWorkers().length] = worker;
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
        for(Worker worker : workers){
            result+=worker.getSalary();
        }
        return result;
    }
    public int getAllWorkersSectionAvgSalary(){
        int result = 0;
        int counter = 0;
        for(Worker worker : workers){
            result += worker.getSalary();
            counter++;
        }
        for(SecurityWorker securityWorker : securityWorkers){
            result += securityWorker.getSalary();
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
                "workers=" + Arrays.toString(workers) +
                "securityWorkers=" + Arrays.toString(securityWorkers) +
                '}';
    }
}

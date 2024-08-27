
import models.*;
import models.parkings.Parking;
import models.persons.employees.CenterEmployee;
import models.persons.employees.Janitor;
import models.persons.employees.Manager;
import models.persons.employees.SecurityWorker;
import models.premises.Premise;
import models.premises.Shop;
import utils.CenterEmployeeUtil;

import java.awt.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Shop shop1, shop2;
        Premise premise1, premise2;
        ShopCenter shopCenter;
        Parking parking;
        Address address;
        MallRegion mallRegion1, mallRegion2;
        SecurityWorker securityWorker1, securityWorker2, securityWorker3, securityWorker4;
        Janitor janitor1, janitor2, janitor3, janitor4;
        Manager manager1, manager2;


        shop1 = new Shop("Decatlon", LocalDate.of(2024,8,10));
        shop2 = new Shop("Carrefour", LocalDate.of(2024,8,1));


        premise1 = new Premise(shop1, new Dimension(20,40));
        premise2 = new Premise(shop2, new Dimension(30,50));

        address = new Address("Lorne St","Sackville","Nova Scotia");

        parking = new Parking(4);

        securityWorker1 = new SecurityWorker("John","Doe");
        securityWorker2 = new SecurityWorker("Oliver","Los");
        securityWorker3 = new SecurityWorker("George","Kos");
        securityWorker4 = new SecurityWorker("Noah","Tos");

        janitor1 = new Janitor("Arthur","Eos");
        janitor2 = new Janitor("Leo","Ross");
        janitor3 = new Janitor("Jack","Sos");
        janitor4 = new Janitor("Harry","Pot");

        manager1 = new Manager("Olivia","Doe");
        manager2 = new Manager("Markus","Wulfhart");

        mallRegion1 = new MallRegion("North", manager1, new Janitor[] {janitor1, janitor2}, new SecurityWorker[]{securityWorker1, securityWorker2});
        mallRegion2 = new MallRegion("South", manager2, new Janitor[] {janitor3, janitor4}, new SecurityWorker[]{securityWorker3, securityWorker4});

        shopCenter = new ShopCenter("Sunnyville", parking, address);


        //Showing whole hierarchy
        System.out.println("Whole hierarchy:\n"+shopCenter);

        //Testing overload methods in Premise class
        //For m2
        System.out.println();
        System.out.println("Properties/method tests:\n");
        System.out.println("Overload (m2): "+Premise.getDimensionCost(40));
        //For width, length
        System.out.println("Overload (width, length): "+Premise.getDimensionCost(20,20));

        //Testing static property and method
        System.out.println("Property: "+Premise.getMonthlyCost());

        //LocalDate
        System.out.println("LocalDate: "+premise1.getRentalDate());
        System.out.println("LocalDate: "+premise2.getRentalDate());
        System.out.println("LocalDate: "+shop1.getPaymentDate());
        System.out.println("LocalDate: "+shop2.getPaymentDate());

        //Methods test
        System.out.println("All normal workers (excluding security and manager):"+ mallRegion1.getAllWorkersSalary());
        System.out.println("Avg salary of section workers(including security, workers, manager):"+ mallRegion1.getAllWorkersSectionAvgSalary());

        janitor1.setSalary(3000);
        manager1.setSalary(5000);
        securityWorker1.setRate(35);
        securityWorker1.setHoursWorked(168);

        System.out.println(CenterEmployeeUtil.getFullName(janitor1));
        System.out.println(CenterEmployeeUtil.getFullName(securityWorker1));
        System.out.println(CenterEmployeeUtil.getFullName(manager1));

        System.out.println(CenterEmployeeUtil.parseDateOfEmployement(janitor1));
        System.out.println(CenterEmployeeUtil.parseDateOfEmployement(securityWorker1));
        System.out.println(CenterEmployeeUtil.parseDateOfEmployement(manager1));


        System.out.println(CenterEmployeeUtil.getSalaries(janitor1));
        System.out.println(CenterEmployeeUtil.getSalaries(manager1));
        System.out.println(CenterEmployeeUtil.getSalaries(securityWorker1));

        System.out.println("Welcome to shop center system.");


        Shop.save(shop1);
        Shop shop3 = Shop.load();

        System.out.println("\n"+shop1.equals(shop3)+"\n");

        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose action: \n1) Display all employees\n2) Add new employee\n3) Exit program");
            switch(scanner.next()){
                case "1":
                    System.out.println(mallRegion1.getManager());
                    System.out.println(Arrays.toString(mallRegion1.getWorkers()));
                    System.out.println(Arrays.toString(mallRegion1.getSecurityWorkers()));
                    break;
                case "2":
                    System.out.println("Write employee name:");
                    String name  = scanner.next();
                    System.out.println("Write employee surname:");
                    String surname  = scanner.next();
                    if(name.isBlank() || surname.isBlank()){
                        System.out.println("Error: invalid name");
                        break;
                    }
                    System.out.println("Choose type of worker: \n 1) Manager \n 2) Janitor \n 3) Security \n 4) Exit");

                    switch(scanner.next()){
                        case "1":
                            try{
                                CenterEmployee centerEmployee1 = new Manager(name,surname);
                                System.out.println("Successfully added new manger named: "+centerEmployee1.getName() +" "+centerEmployee1.getSurname());
                            }catch (Exception e){
                                System.out.println(e.getMessage());
                            }
                            break;
                        case "2":
                            try{
                                CenterEmployee centerEmployee1 = new Janitor(name,surname);
                                System.out.println("Successfully added new manger named: "+centerEmployee1.getName() +" "+centerEmployee1.getSurname());
                            }catch (Exception e){
                                System.out.println(e.getMessage());
                            }
                            break;
                        case "3":
                            try{
                                CenterEmployee centerEmployee1 = new SecurityWorker(name,surname);
                                System.out.println("Successfully added new manger named: "+centerEmployee1.getName() +" "+centerEmployee1.getSurname());
                            }catch (Exception e){
                                System.out.println(e.getMessage());
                            }
                            break;
                        case "4":
                            break;
                        default:
                            System.out.println("You choose invalid option. Try again");
                    }
                    break;
                case "3":
                    System.out.println("Exiting program");
                    System.exit(0);
                default:
                    System.out.println("Invalid option choice. Try again.");
            }
        }

    }

}
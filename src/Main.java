import Models.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Shop shop1, shop2;
        Premise premise1, premise2;
        Dimension dimension1, dimension2;
        ShopCenter shopCenter;
        Parking parking;
        Address address;
        CenterWorkersSection centerWorkersSection1, centerWorkersSection2;
        SecurityWorker securityWorker1, securityWorker2, securityWorker3, securityWorker4;
        Worker worker1, worker2, worker3, worker4;
        Manager manager1, manager2;


        shop1 = new Shop("Decatlon",3.5f, LocalDate.of(2024,8,10));
        shop2 = new Shop("Carrefour",1.8f, LocalDate.of(2024,8,1));

        dimension1 = new Dimension(20,41);
        dimension2 = new Dimension(60,70);

        premise1 = new Premise(shop1, dimension1);
        premise2 = new Premise(shop2, dimension2);

        address = new Address("Lorne St","Sackville","Nova Scotia");

        parking = new Parking(800,4);

        securityWorker1 = new SecurityWorker("John","Doe",4000);
        securityWorker2 = new SecurityWorker("Oliver","Los",3800);
        securityWorker3 = new SecurityWorker("George","Kos",4200);
        securityWorker4 = new SecurityWorker("Noah","Tos",4100);

        worker1 = new Worker("Arthur","Eos",3000);
        worker2 = new Worker("Leo","Ross",2100);
        worker3 = new Worker("Jack","Sos",2800);
        worker4 = new Worker("Harry","Pot",2900);

        manager1 = new Manager("Olivia","Doe",6000);
        manager2 = new Manager("Markus","Wulfhart",6000);

        centerWorkersSection1 = new CenterWorkersSection("North", manager1, new Worker[] {worker1, worker2}, new SecurityWorker[]{securityWorker1, securityWorker2});
        centerWorkersSection2 = new CenterWorkersSection("South", manager2, new Worker[] {worker3, worker4}, new SecurityWorker[]{securityWorker3, securityWorker4});

        shopCenter = new ShopCenter("Sunnyville", new Premise[] {premise1, premise2}, parking, address, new CenterWorkersSection[]{ centerWorkersSection1, centerWorkersSection2 });


        //Showing whole hierarchy
        System.out.println("Whole hierarchy:\n"+shopCenter);

        //Testing overload methods in Premise class
        //For m2
        System.out.println();
        System.out.println("Properties/method tests:\n");
        System.out.println("Overload (m2): "+Premise.getCostForDimensionForMonth(40));
        //For width, length
        System.out.println("Overload (width, length): "+Premise.getCostForDimensionForMonth(20,20));

        //Testing static property and method
        System.out.println("Property: "+Premise.getCostForM2ForMonth());
        System.out.println("Method: "+Premise.getCostFor40M2ForYear());

        //LocalDate
        System.out.println("LocalDate: "+premise1.getRentalDate());
        System.out.println("LocalDate: "+premise2.getRentalDate());
        System.out.println("LocalDate: "+shop1.getPaymentDate());
        System.out.println("LocalDate: "+shop2.getPaymentDate());

        //Methods test
        System.out.println("All normal workers (excluding security and manager):"+centerWorkersSection1.getAllWorkersSalary());
        System.out.println("Avg salary of section workers(including security, workers, manager):"+centerWorkersSection1.getAllWorkersSectionAvgSalary());
        System.out.println("Surface: " + dimension1.getSurface());
    }
}
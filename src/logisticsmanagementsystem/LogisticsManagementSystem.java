/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package logisticsManagementsystem;

import java.util.Scanner;

public class LogisticsManagementSystem {

    static final int Max_Cities = 30;
    static final int Max_Deliveries = 50;
    static final double FUEL_PRICE = 310.0;
        
    static String[] cities = new String[Max_Cities];
    static int City_Count = 0;
    static int [][] Distance = new int [Max_Cities][Max_Cities];
        
    static String[] Vehicle_Type = {"Van","Truck","Lorry"};
    static int[] Capacity = {1000,5000,10000};
    static int[] Rate_Per_km = {30,40,80};
    static int[] Avg_Speed  = {60,50,45};
    static int[] Fuel_Efficiency = {12,6,4};
        
    static Delivery[] deliveries = new Delivery [50];
    static int Delivery_Count = 0;
    
    static Scanner sc = new Scanner(System.in);
    
    static class Delivery{}
    
    
    public static void main(String[] args) {
        while (true){
            System.out.println("------- DELIVERY COST ESTIMATION -------- ");
            System.out.println("1. City Managment");
            System.out.println("2. Distance Managment");
            System.out.println("3. Handle Delivery");
            System.out.println("4. Report");
            System.out.println("5. Save and Exit");
            
            int choice = sc.nextInt();
            switch (choice){
                case 1: City_Managment();
                break;
                case 2: Distance_Managment();
                break;
                case 3: Handle_Delivery();
                break;
                case 4: Report();
                break;
                case 5: Save_Data();
                break;
                
            }
        }

    }
    static void City_Managment(){
        int choice;
        do{
        System.out.println("--- CITY MANAGEMENT ---");
        System.out.println("1. Add City");
        System.out.println("2. Rename City");
        System.out.println("3. Remove City");
        System.out.print("Choose option: ");
        choice = sc.nextInt();
        sc.nextLine();
        
         switch (choice) {
            case 1: Add_City();
            break;
            case 2: Rename_City();
            break;
            case 3: Remove_City();
            break;
            case 4: List_Cities();
            break;
            default:
                System.out.println("Invalid option");
         }
        }while(choice!=0);
    }
    
    
    static void Add_City(){
        if (City_Count >= Max_Cities) {
            System.out.println("City limit reached");
            return;
        }
        System.out.print("Enter new city name : ");
        String name = sc.nextLine();
        cities[City_Count] = name;
        City_Count++;
        System.out.println("City added successfully");
    }
    
    
    
    
    static void Rename_City(){
        System.out.print("Enter city index to rename: ");
        int x = sc.nextInt();
        if (x < 0 || x >= City_Count) {
            System.out.println("Invalid index");
            return;
        }
        
        System.out.print("Enter new name: ");
        cities[x] = sc.nextLine();
        System.out.println("City renamed: ");
    
    }
    
    
    
    
    static void Remove_City(){ 
        System.out.print("Enter index to remove: ");
        int i = sc.nextInt();
        if (i < 0 || i >= City_Count) {
            System.out.println("Invalid index");
            return;
        }
        for (int j = i; j < City_Count - 1; j++) {
            cities[j] = cities[j + 1];
            for (int k = 0; k < City_Count; k++) {
                Distance[j][k] = Distance[j + 1][k];
                Distance[k][j] = Distance[k][j + 1];
            }
        }
        City_Count--;
        System.out.println("City removed");
        
    }
    
   
    
    static void List_Cities(){
        System.out.println("Cities: ");
        for (int y = 0; y < City_Count; y++) {
            System.out.println(y + " " + cities[y]);
        }
    }
    
    
   
    static void Distance_Managment(){
        if (City_Count < 2) {
            System.out.println("Add at least two cities");
            return;
        }
        System.out.println("--- DISTANCE MANAGEMENT ---");
        System.out.println("Enter first city index: ");
        int i = sc.nextInt();
        System.out.println("Enter second city index: ");
        int j = sc.nextInt();
        if (i == j) {
            System.out.println("Distance from a city: ");
            return;
        }
        System.out.println("Enter distance in km: ");
        int k = sc.nextInt();
        Distance[i][j] = k;
        Distance[j][i] = k;
        System.out.println("Successfully");
    }
    
    
    
    
    
    static void Handle_Delivery(){
        if (City_Count < 2) {
            System.out.println("Add cities ");
            return;
        }

        Show_Cities();
        System.out.print("Enter source city index: ");
        int source = sc.nextInt();
        System.out.print("Enter destination city index: ");
        int destination = sc.nextInt();

        if (source == destination) {
            System.out.println("Source and destination must be different");
            return;
        }

        int distance = Distance[source][destination];
        if (distance == 0) {
            System.out.println("Distance not defined between selected cities");
            return;
        }

        System.out.print("Enter weight in kg: ");
        double weight = sc.nextDouble();

        System.out.println("Choose vehicle: ");
        for (int z = 0; z < Vehicle_Type.length; z++) {
            System.out.println((z + 1) + ". " + Vehicle_Type[z] + " (Capacity: " + Capacity[z] + "kg)");
        }
        int z = sc.nextInt() - 1;
        
        if (weight > Capacity[z]) {
            System.out.println("Weight exceeds vehicle capacity!");
            return;
        }
        
        
        
        double cost = distance * Rate_Per_km[z] * (1 + (weight / 10000.0));
        double time = distance / (double) Avg_Speed[z];
        double fuelUsed = distance / (double) Fuel_Efficiency[z];
        double fuelCost = fuelUsed * FUEL_PRICE;
        double totalCost = cost + fuelCost;
        double profit = cost * 0.25;
        double customerCharge = totalCost + profit;
        
        
        System.out.println("=== DELIVERY COST ESTIMATION ===");
        System.out.println("From: " + cities[source]);
        System.out.println("To: " + cities[destination]);
        System.out.println("Vehicle Type is : " + Vehicle_Type[z]);
        System.out.println("Distance is : " + distance + " km");
        System.out.printf("Base Cost is : "+ cost);
        System.out.printf("Fuel Cost is : "+ fuelCost);
        System.out.printf("Total Cost is : "+ totalCost);
        System.out.printf("Profit is : "+ profit);
        System.out.printf("Customer Charge is : "+ customerCharge);
        System.out.printf("Estimated Time is : "+ time);
        
    }
    
    
    
     static class Delivery {
        String fromCity;
        String toCity;
        double distance;
        double time;
        double profit;
        double Customer_Charge;
    
        

        Delivery(String from, String to, double dist, double t, double p, double charge){
            fromCity = from;
            toCity = to;
            distance = dist;
            time = t;
            profit = p;
            
        }
    } 
     
    
    
    static void Report(){
    }
    static void Show_Cities(){
    }
    static void Save_Data(){
    }
    
    


    
}  
    
    
    
    
        
   

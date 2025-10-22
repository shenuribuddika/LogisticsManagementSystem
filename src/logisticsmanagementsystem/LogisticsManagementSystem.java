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
    }
    
    
    
    
    
    
    static void Distance_Managment(){
    }
    static void Handle_Delivery(){
    }
    static void Report(){
    }
    static void Save_Data(){
    }
    
    


    
}  
    
    
    
    
        
   

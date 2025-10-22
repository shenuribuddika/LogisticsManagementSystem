/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package logisticsmanagementsystem;

import java.util.Scanner;

public class LogisticsManagementSystem {

    static final int Max_Cities = 30;
    static final int Max_Deliveries = 50;
    static final double FUEL_PRICE = 310.0;
        
    static String[] cities = new String[Max_Cities];
    static int City_Count = 0;
    static int[][] Distance = new int[Max_Cities][Max_Cities];
        
    static String[] Vehicle_Type = {"Van","Truck","Lorry"};
    static int[] Capacity = {1000,5000,10000};
    static int[] Rate_Per_km = {30,40,80};
    static int[] Avg_Speed  = {60,50,45};
    static int[] Fuel_Efficiency = {12,6,4};
        
    static String [] Deliveries = new String[Max_Deliveries];
    static int Delivery_Count = 0;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
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

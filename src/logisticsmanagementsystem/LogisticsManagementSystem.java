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
    
}  
    
    
    
    
        
   

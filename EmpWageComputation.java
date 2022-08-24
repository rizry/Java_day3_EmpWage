package com.java.day3;

import java.util.Random;

public class EmpWageComputation{

  public static void main(String[] args) {
    System.out.println("--Welcome to Employee Wage Computation Program--\n");

    String attendanceString = EmpWageComputation.checkAttendance();
    System.out.println(attendanceString);

    System.out.println("Employee's today's wage: " + getDailyWage(attendanceString) + "$");

  }

  private static String checkAttendance() {
    Random random = new Random();
    boolean randomBool = random.nextBoolean();

    if (randomBool) return "Employee is present.";
    else return "Employee is absent.";

  }

  private static int getDailyWage(String str) {

   boolean isPresent = str.contains("present") || str.contains("Present");

   int empRatePerHr = 20;
   int hrsWorked = 0;

   if (isPresent) hrsWorked = 8;
   int dailyWage = empRatePerHr * hrsWorked;
   return dailyWage;
 }

}
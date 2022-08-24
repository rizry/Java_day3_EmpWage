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
    int randomNum = random.nextInt(0, 4);

    switch (randomNum) {
      case 1:
        return "employee is present full time";

      case 2:
        return "employee is present part time";

      default:
        return "employee is absent";
    }

  }

  private static int getDailyWage(String str) {

   Byte empRatePerHr = 20;
   Byte hrsWorked = 0;
   Byte fullTimeHrs = 8;   //assumed
   Byte partTimeHrs = 4;   //assumed

   if (str.contains("full time")) hrsWorked = fullTimeHrs;
   else if (str.contains("part time")) hrsWorked = partTimeHrs;

   int dailyWage = empRatePerHr * hrsWorked;
   return dailyWage;
 }

}
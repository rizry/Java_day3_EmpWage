package com.java.day3;

import java.util.Random;

public class EmpWageComputation{

  public static void main(String[] args) {
    System.out.println("--Welcome to Employee Wage Computation Program--\n");

    System.out.println("Employee's wage for this month: " + getMonthlyWage() + "$");

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

  private static int getDailyWage() {

   Byte empRatePerHr = 20;
   Byte hrsWorked = 0;
   Byte fullTimeHrs = 8;   //assumed
   Byte partTimeHrs = 4;   //assumed

   String str = checkAttendance();

   if (str.contains("full time")) hrsWorked = fullTimeHrs;
   else if (str.contains("part time")) hrsWorked = partTimeHrs;

   int dailyWage = empRatePerHr * hrsWorked;
   return dailyWage;
 }


 private static int getMonthlyWage() {

  int monthlyWage = 0;
  short daysWorked;

  for (daysWorked = 0; daysWorked < 20;) {

    int dailyWage = getDailyWage(); //getting employee's daily wage for each day

    if (dailyWage > 0) {            //checking if the employee is present i.e. has dailyWage>0
      monthlyWage += dailyWage;
      daysWorked++;                 //only increasing number of days worked if the employee HAS worked, either full time or part time
      }
    }

    return monthlyWage;
}


}
package com.java.day3;

import java.util.Random;

public class EmpWageComputation{

   static Byte empRatePerHr = 20;    //declaring the constants
   static Byte fullTimeHrs = 8;
   static Byte partTimeHrs = 4;

  public static void main(String[] args) {
    System.out.println("--Welcome to Employee Wage Computation Program--\n");

    System.out.println("Employee's wage for this month: " + new EmpWageComputation().getMonthlyWage() + "$");

  }

   String checkAttendance() {
    Random random = new Random();
    int randomNum = random.nextInt(0, 3);

    switch (randomNum) {
      case 1:
        return "employee is present full time";

      case 2:
        return "employee is present part time";

      default:
        return "employee is absent";
    }

  }

   int getDailyWage() {

   Byte hrsWorked = 0;
   String str = checkAttendance();

   if (str.contains("full time")) hrsWorked = EmpWageComputation.fullTimeHrs;
   else if (str.contains("part time")) hrsWorked = EmpWageComputation.partTimeHrs;

   int dailyWage = EmpWageComputation.empRatePerHr * hrsWorked;
   return dailyWage;
 }


  int getMonthlyWage() {
    int monthlyWage = 0;
    short daysWorked = 0;
    short hoursWorked = 0;

    System.out.print("Employee wage each day");

    while (daysWorked < 20 && hoursWorked < 100) {
      int dailyWage = getDailyWage(); //getting employee's daily wage for each day
      System.out.print(" " + dailyWage);

      String str = (dailyWage == 0) ? "absent" : dailyWage / EmpWageComputation.empRatePerHr == EmpWageComputation.fullTimeHrs ? "full time" : "part time";

      switch (str) {
        case "full time":
          hoursWorked += 8;
          daysWorked++;
          break;
        case "part time":
          hoursWorked += 4;
          daysWorked++;
          break;
      }
    }

    System.out.println("\n");
    System.out.println("Employee has worked " + hoursWorked + " hours in "+daysWorked +" days this month.\n");

    monthlyWage= hoursWorked * EmpWageComputation.empRatePerHr;

    return monthlyWage;
  }

}

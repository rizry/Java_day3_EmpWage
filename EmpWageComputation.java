package com.java.day9;

import java.util.Random;

public class EmpWageComputation {

  public static void main(String[] args) {
    System.out.println("--Welcome to Employee Wage Computation Program--");
    Scanner sc = new Scanner(System.in);

    Company company1 = new Company("Amazon", (short) 45, (short) 18, (short) 120);
    System.out.println(company1);

    Company company2 = new Company("Google", (short) 50, (short) 15, (short) 150);
    System.out.println(company2);

    System.out.print("\n\nEnter another company name ");
    String companyName = sc.nextLine();

    System.out.print("Enter the company wage per hour ");
    short wagePerHr = sc.nextShort();

    System.out.print("Enter the number of days to work per month ");
    short daysToWork = sc.nextShort();

    System.out.print("Enter the number of hours per month ");
    short hrsToWork = sc.nextShort();
    sc.close();

    Company company3 = new Company(companyName, wagePerHr, daysToWork, hrsToWork);
    System.out.println(company3);

  }

}

class Company {

  String name = "";
  static short fullTimeHrs = 7;
  static short partTimeHrs = 5;
  short wagePerHr;
  short daysToWork;
  short hrsToWork;
  int monthlyWage;
  int hrsWorked;
  int daysWorked;

  public Company(String name, short wagePerHr, short daysToWork, short hrsToWork) {
    this.name = name;
    this.wagePerHr = wagePerHr;
    this.daysToWork = daysToWork;
    this.hrsToWork = hrsToWork;
    calculateEmpWage();

  }

  public String toString() {
    return "\nEmployee at " + name + " has made " + monthlyWage + "$ by working " + hrsWorked + " hours in " + daysWorked
    + " days this month ";

  }

  void calculateEmpWage() {

    System.out.print("\nEmployee daily wage ");

    while (daysWorked < daysToWork && hrsWorked < hrsToWork) {
      int dailyWage = getDailyWage(wagePerHr); //getting employee's daily wage for each day

      System.out.print(dailyWage + " ");

      String str = (dailyWage == 0) ? "absent" : dailyWage / wagePerHr == Company.fullTimeHrs ? "full time" : "part time";

      switch (str) {
        case "full time":
          hrsWorked += Company.fullTimeHrs;
          daysWorked++;
          break;
        case "part time":
          hrsWorked += Company.partTimeHrs;
          daysWorked++;
          break;
      }
    }
    monthlyWage = hrsWorked * wagePerHr;

  }

  int getDailyWage(short wagePerHr) {

    short hrsWorked = 0;

    String str = checkAttendance();

    if (str.contains("full time")) hrsWorked = Company.fullTimeHrs;
    else if (str.contains("part time")) hrsWorked = Company.partTimeHrs;

    int dailyWage = wagePerHr * hrsWorked;
    return dailyWage;
  }

  String checkAttendance() {

    Random random = new Random();
    int randomNum = random.nextInt(3);

    switch (randomNum) {
      case 1:
        return "employee is present full time";

      case 2:
        return "employee is present part time";

      default:
        return "employee is absent";
    }
  }

}
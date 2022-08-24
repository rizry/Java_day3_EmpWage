package com.java.day3;

import java.util.Random;

public class EmpWageComputation{

  public static void main(String[] args) {
    System.out.println("--Welcome to Employee Wage Computation Program--\n");

    String attendanceString = EmpWageComputation.checkAttendance();
    System.out.println(attendanceString);

  }

  private static String checkAttendance() {
    Random random = new Random();
    boolean randomBool = random.nextBoolean();

    if (randomBool) return "Employee is present.";
    else return "Employee is absent.";

  }
}
package com.java.payroll;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int option;
		EmployeeRecordList empRecList = EmployeeRecordList.Add();
		Scanner sc = new Scanner(System.in);
		System.out.println("\t\tHello Welcome to JRG ");
		System.out.println("(1.) Register Emp &&  (2.)Get Total Weekly GrossIncome");
		System.out.print("Choose Action to start !(type 1 , 2 ) : ");
		option = sc.nextInt();
		while (option != 1 && option != 2) {
			System.out.print("Choose Action to start !(type 1 , 2 ) : ");
			option = sc.nextInt();
		}

		switch (option) {

		case 1:
			System.out.println("Register employee is running...");

			try {

				empRecList.getInformation();
				empRecList.saveInfo(empRecList);
				empRecList.displayInfo();

			} catch (Exception e) {
				e.printStackTrace();
				
			}
			empRecList.saveInfo(empRecList);
			break;
		case 2:
			int timeIn[] = { 0 };
			int timeOut[] = { 0 };
			EmployeeTime emptime = new EmployeeTime();
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter employee code: ");
			String code = scan.nextLine();
			empRecList = EmployeeRecordList.Add();
			for (int i = 0; i < empRecList.size(); i++) {
				Source_RecordList sr = (Source_RecordList) empRecList.get(i);
				if (sr.employee_Code.equalsIgnoreCase(code)) {
					System.out.println("The time format is (12:00 - 24:00)");
					emptime.displayResult(timeIn, timeOut);
					System.out.printf("Employee Name: %s",sr.employee_Name);
					System.out.printf("\nEmployee Level: %s",sr.employee_Level);
					System.out.printf("\nEmployee Code: %s",sr.employee_Code);
					System.out.printf("\nEmployee Rate: %s",sr.employee_Rate);
					System.out.println("\nYour total work hours is: " + emptime.result);
					System.out.println("Your Daily Salary is: $" + emptime.dailyResult);
					System.out.println("Your weekly salary is: $" + emptime.finalResult);
					break;
				}
			}

			break;
		}

	}

}

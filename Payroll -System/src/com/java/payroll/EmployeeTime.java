package com.java.payroll;

import java.util.Scanner;

interface Time {
	long getTime(int timeIn[], int timeOut[]);
}

public class EmployeeTime implements Time {

	long result;
	double finalResult;
	double dailyResult;

	@Override
	public long getTime(int timeIn[], int timeOut[]) {
		String[] day = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" };
		Scanner sc = new Scanner(System.in);
		int[] getTime = new int[1];
		for (String days : day) {
			System.out.println(days);
			for (int i = 0; i < getTime.length; i++) {
				System.out.print("Enter Time in: ");
				timeIn[i] = sc.nextInt();
				System.out.print("Enter Time out: ");
				timeOut[i] = sc.nextInt();
				result += (timeOut[i] - timeIn[i]);
				dailyResult = (timeOut[i] - timeIn[i]) * 2;
			}
		}

		finalResult = result * 2;
		return (long) finalResult;
	}

	public int displayResult(int timeIn[], int timeOut[]) {
		int store = 0;
		store = (int) getTime(timeIn, timeOut);

		return (int) store;
	}

}

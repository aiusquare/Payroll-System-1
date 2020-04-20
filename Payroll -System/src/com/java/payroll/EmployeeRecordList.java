package com.java.payroll;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

interface Payroll {
	void displayInfo();

	void saveInfo(EmployeeRecordList list);

}

public class EmployeeRecordList extends ArrayList implements Payroll {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5365609682592948968L;

	/**
	 * @category Payroll
	 */

	private static EmployeeRecordList empRecList;

	private EmployeeRecordList() {
		super();
	}

	@SuppressWarnings("unchecked")
	public void getInformation() {
		Source_RecordList srl = new Source_RecordList();
		InputStreamReader isr = new InputStreamReader(System.in);
		Scanner sc = new Scanner(isr);

		try {

			System.out.print("Enter Employee name: ");
			srl.employee_Name = sc.nextLine();
			System.out.print("Enter Employee Code: ");
			srl.employee_Code = sc.nextLine();
			System.out.print("Enter Employee Level: ");
			srl.employee_Level = sc.nextInt();
			System.out.print("Enter Employee Rate: ");
			srl.employee_Rate = sc.nextInt();
		} catch (Exception e) {
			e.printStackTrace();
		}
		add(srl);
		System.out.println("New Employee has been Added! ");

	}

	@Override
	public void displayInfo() {

		for (int i = 0; i < empRecList.size(); i++) {
			System.out.println("\nEmployee Information! ");
			Source_RecordList srl = (Source_RecordList) empRecList.get(i);
			System.out.printf("Employee Name: %s\n", srl.employee_Name);
			System.out.printf("Employee Code: %s\n", srl.employee_Code);
			System.out.printf("Employee Level: %s\n", srl.employee_Level);
			System.out.printf("Employee Rate: %s\n", srl.employee_Rate);

		}
	}

	public static EmployeeRecordList Add() {
		File file = new File("Employee_Records.itm");
		File eof = file.getAbsoluteFile();

		if (eof.exists() && eof != null) {
			try {
				FileInputStream fis = new FileInputStream(eof);
				ObjectInputStream ois = new ObjectInputStream(fis);
				empRecList = (EmployeeRecordList) ois.readObject();
			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else

		{
			empRecList = new EmployeeRecordList();
		}
		return empRecList;
	}

	@Override
	public void saveInfo(EmployeeRecordList list) {
		try {

			FileOutputStream out = new FileOutputStream("Employee_Records.itm");
			ObjectOutputStream oos = new ObjectOutputStream(out);
			oos.writeObject(list);
			oos.close();
			out.close();
		} catch (SecurityException | IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}

	}

}


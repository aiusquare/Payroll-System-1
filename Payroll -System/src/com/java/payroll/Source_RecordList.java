package com.java.payroll;

import java.io.Serializable;
import java.util.ArrayList;

public class Source_RecordList extends ArrayList implements Serializable {
	/**
	 * 
	 */
	protected static final long serialVersionUID = 1L;
	String employee_Code;
	String employee_Name;
	int employee_Level;
	int employee_Rate;
	private final ArrayList grossIncome;

	// creating constructor
	public Source_RecordList(String empCode, String empName, int empLevel, int empRate) {
		this.grossIncome = new ArrayList();
		this.employee_Code = empCode;
		this.employee_Level = empLevel;
		this.employee_Name = empName;
		this.employee_Rate = empRate;
	}

	public Source_RecordList() {
		this.grossIncome = new ArrayList();

	}

	public long getIncome(int salary) {
		double gross = 0;
		gross = (double) grossIncome.get(salary);
		return (long) gross;

	}

	public void setSalary(double grossSalary) {
		grossIncome.add(grossSalary);
	}
}

package com.example.TablePerSubClassExample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="empNo")
public class SalariedEmployer extends Employer{
	
	@Column(nullable=true)
	private double annualSalary;

	
	public SalariedEmployer(int empNo, String eName, double annualSalary) {
		super(empNo, eName);
		this.annualSalary = annualSalary;
	}

	public SalariedEmployer() {
		
	}
	
	public double getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(double annualSalary) {
		this.annualSalary = annualSalary;
	}
	
}

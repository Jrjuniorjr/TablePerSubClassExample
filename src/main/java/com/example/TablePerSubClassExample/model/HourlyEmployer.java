package com.example.TablePerSubClassExample.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="empNo")
public class HourlyEmployer extends Employer{

	private int noHoursPerDay;
	private double hourlyRate;
	public int getNoHoursPerDay() {
		return noHoursPerDay;
	}
	public void setNoHoursPerDay(int noHoursPerDay) {
		this.noHoursPerDay = noHoursPerDay;
	}
	public double getHourlyRate() {
		return hourlyRate;
	}
	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	
	
}

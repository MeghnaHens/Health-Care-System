package com.cg.hcs.bean;

import java.util.Date;

public class Appointment {
	User user;
	DiagnosticCenter center;
	Test test;
	public DiagnosticCenter getCenter() {
		return center;
	}
	public void setCenter(DiagnosticCenter center) {
		this.center = center;
	}
	Date date;
	boolean approved;

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Test getTest() {
		return test;
	}
	public void setTest(Test test) {
		this.test = test;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public  Appointment(User user,Test test,DiagnosticCenter center,Date date,boolean approved)
	{
		
		this.user=user;
		this.test=test;
		this.date=date;
		this.approved=approved;
		this.center=center;
	}
}

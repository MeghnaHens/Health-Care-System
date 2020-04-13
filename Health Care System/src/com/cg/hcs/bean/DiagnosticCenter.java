package com.cg.hcs.bean;
import java.util.List;

public class DiagnosticCenter {
	public String centerName;
	static int id=1;
	public String centerId="D";
	List<Test> listOfTests;
	List<Appointment> appointmentList;
	public DiagnosticCenter(String centerName,List<Test> listOfTests)
	{
		this.centerId=this.centerId+(id++);
		this.centerName=centerName;
		this.listOfTests=listOfTests;
		this.id=this.id++;
	}
	public String getCenterId() {
		return centerId;
	}
	public String getCenterName() {
		return this.centerName;
	}
	public List<Test> getListOfTests() {
		return listOfTests;
	}
	public void setListOfTests(List<Test> listOfTests) {
		this.listOfTests = listOfTests;
	}
	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}
	public void setAppointmentList(List<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}
	public DiagnosticCenter(){
		
	}
}


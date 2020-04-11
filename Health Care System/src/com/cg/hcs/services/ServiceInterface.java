package com.cg.hcs.services;

import java.util.HashMap;
import java.util.List;

import com.cg.hcs.bean.*;

public interface ServiceInterface {
	public abstract void addCenter(String centerName,List<Test>testArray,List<DiagnosticCenter>centerArray);
	public abstract void removeCenter(String centerId,List<DiagnosticCenter>centerArray);
	public abstract void removeTestFromCenter(List<DiagnosticCenter>centerArray,String diagnostic,String testName);
	public abstract boolean isDiagnosticCenterPresent(String diagnostic,List<DiagnosticCenter> centerArray);
	public abstract void addTestInCenter(List<DiagnosticCenter>centerArray,String diagnostic,String testName);
	public abstract boolean approveAppointment();
	public abstract void Register(List<User> customer, String password);
	public abstract boolean login(Admin a,String id,String pass,List<Admin> adminList,HashMap<Admin,String> adminHash);
}

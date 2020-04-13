package com.cg.hcs.services;

import java.util.HashMap;
import java.util.List;

import com.cg.hcs.bean.*;

public interface ServiceInterface {
	public abstract void addCenter(String centerName,List<Test>testArray,List<DiagnosticCenter>centerArray);
	public abstract boolean removeCenter(String centerId,List<DiagnosticCenter>centerArray);
	public abstract void removeTestFromCenter(List<DiagnosticCenter>centerArray,String diagnostic,String testName);
	public abstract boolean isDiagnosticCenterPresent(String diagnostic,List<DiagnosticCenter> centerArray);
	public abstract void addTestInCenter(List<DiagnosticCenter>centerArray,String diagnostic,String testName);
	public abstract boolean login(Admin a,String pass,List<Admin> adminList,HashMap<Admin,String> adminHash);
}

package com.cg.hcs.dao;

import java.util.ArrayList;
import java.util.List;

import com.cg.hcs.bean.DiagnosticCenter;
import com.cg.hcs.bean.Test;

public class DiagnosticCenterDaoImpl extends DiagnosticCenterDao{
	
	TestDaoImpl td=new TestDaoImpl();
	
	List<DiagnosticCenter> centerArray=new ArrayList<DiagnosticCenter>();
	
	@Override
	public void addExistingCenter() {
		DiagnosticCenter d1=new DiagnosticCenter("Gariahat",TestDaoImpl.testArray);
		DiagnosticCenter d2=new DiagnosticCenter("Kestopur",TestDaoImpl.testArray);
		DiagnosticCenter d3=new DiagnosticCenter("Beleghata",TestDaoImpl.testArray);
		DiagnosticCenter d4=new DiagnosticCenter("Joramandir",TestDaoImpl.testArray);
		this.centerArray.add(d1);
		this.centerArray.add(d2);
		this.centerArray.add(d3);
		this.centerArray.add(d4);
		
	}

	@Override
	public List<DiagnosticCenter> getCenterList() {
		return this.centerArray;
	}
}

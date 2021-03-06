package com.cg.hcs.services;
import java.util.HashMap;
import java.util.List;
import com.cg.hcs.bean.*;
public class ServiceImplementation implements ServiceInterface {
	
	@Override
	public void addCenter(String centerName,List<Test>testArray,List<DiagnosticCenter>centerArray) {
		DiagnosticCenter d= new DiagnosticCenter(centerName,testArray);
		centerArray.add(d);
	}
	
	@Override
	public boolean removeCenter(String centerId,List<DiagnosticCenter>centerArray) {
		for(int i=0;i<centerArray.size();i++) 
		{
			DiagnosticCenter center=centerArray.get(i);
			if((center.centerId).equals(centerId)) 
			{
				centerArray.remove(i);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean isDiagnosticCenterPresent(String diagnostic,List<DiagnosticCenter> centerArray) {
		for(int i=0;i<centerArray.size();i++) {
			DiagnosticCenter center=centerArray.get(i);
			if((center.getCenterId()).equals(diagnostic))
				return true;
		}
		return false;
	}
	
	@Override
	public boolean login(Admin adm,String pass,List<Admin> adminList,HashMap<Admin,String> adminHash) {  
		if(adminHash.containsValue(pass)) {
			return true;
		}
		else
			return false;
	}
	
	@Override
	public void addTestInCenter(List<DiagnosticCenter> centerArray,String diagnostic,String testName) {
		for(int i=0;i<centerArray.size();i++) {
			DiagnosticCenter center=centerArray.get(i);
			if((center.getCenterId()).equals(diagnostic))
			{
				Test t=new Test(testName);
				//testArray.add(t);
				//center.setListOfTests(testArray);
				//System.out.println(center.getListOfTests());
				center.getListOfTests().add(t);
		    }
		   }
		}
	@Override
	public void removeTestFromCenter(List<DiagnosticCenter> centerArray,String diagnostic,String testName) {
		for(int i=0;i<centerArray.size();i++) {
			DiagnosticCenter center=centerArray.get(i);
				if((center.getCenterId()).equals(diagnostic))
				{
					for(int j=0;j<center.getListOfTests().size();j++) {
						Test t=center.getListOfTests().get(j);
						if(t.getTestName().equalsIgnoreCase(testName)) 
						{
							center.getListOfTests().remove(t);
						}
			    }
		   }
	   }
	}
}

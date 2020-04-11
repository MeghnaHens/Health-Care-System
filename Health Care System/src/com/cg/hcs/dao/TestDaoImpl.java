package com.cg.hcs.dao;

import java.util.ArrayList;
import java.util.List;

import com.cg.hcs.bean.Test;

public class TestDaoImpl extends TestDao{
	public static List<Test> testArray=new ArrayList<Test>();
	@Override
	public void addPreAssignedTest() {
		Test t1=new Test("Blood Test");
		Test t2=new Test("X-Ray");
		Test t3=new Test("Urine Test");
		Test t4=new Test("Blood Sugar Test");
		Test t5=new Test("TSH test");
		TestDaoImpl.testArray.add(t1);
		TestDaoImpl.testArray.add(t2);
		TestDaoImpl.testArray.add(t3);			
		TestDaoImpl.testArray.add(t4);
		TestDaoImpl.testArray.add(t5);	
	}	
	@Override
	public List<Test> getTestList(){
		return TestDaoImpl.testArray;
	}
}

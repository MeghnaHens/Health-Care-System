package com.cg.hcs.bean;

public class Test {
	public String testId="T";
	static int id=1;
	public String testName;
	public Test(String testName)
	{
		this.testId=testId+(id++);
		this.testName=testName;
		this.id=this.id++;
	}
	
	Test(){
		
	}
	public String getTestName() {
		return testName;
	}
}

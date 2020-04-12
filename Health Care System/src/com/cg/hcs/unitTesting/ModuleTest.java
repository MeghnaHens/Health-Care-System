package com.cg.hcs.unitTesting;
import org.junit.*;
import com.cg.hcs.dao.*;
import com.cg.hcs.services.*;
public class ModuleTest {
	
	DiagnosticCenterDaoImpl cd=new DiagnosticCenterDaoImpl();
	ServiceImplementation s=new ServiceImplementation();
	TestDaoImpl t=new TestDaoImpl();
	
	@Test
	public void addDiagnosticCenterTest() {
		String centerName="Durgapur";
		int expected=cd.getCenterList().size()+1;
		s.addCenter(centerName,t.getTestList(),cd.getCenterList());
		int actual=cd.getCenterList().size();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void removeDiagnosticCenterTest() {
		String centerId="D4";
		int expected=cd.getCenterList().size()-1;
		s.removeCenter(centerId,cd.getCenterList());
		int actual=cd.getCenterList().size();
		Assert.assertEquals(expected, actual);
	}
}

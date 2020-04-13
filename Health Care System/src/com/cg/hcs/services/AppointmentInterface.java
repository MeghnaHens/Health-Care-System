package com.cg.hcs.services;

import java.time.format.DateTimeFormatter;
import java.util.List;

import com.cg.hcs.bean.DiagnosticCenter;
import com.cg.hcs.bean.Test;
import com.cg.hcs.bean.User;

public interface AppointmentInterface {

	public abstract void makeAppointment(User user,String centerName,String testName,List<DiagnosticCenter>centerArray,List<Test>testArray,String date,String time);
	public abstract void showAppointment();
}

package com.cg.hcs.dao;

import java.util.ArrayList;
import java.util.List;

import com.cg.hcs.bean.Appointment;

public class AppointmentDaoImpl extends AppointmentDao{

	List<Appointment> appointlist=new ArrayList<>();
	@Override
	public void addAppointment(Appointment appoint) {
	appointlist.add(appoint);
		
	}

	@Override
	public List<Appointment> getAppointmentList() {
	return appointlist;
	}

}

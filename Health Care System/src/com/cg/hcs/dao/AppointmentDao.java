package com.cg.hcs.dao;

import java.util.List;

import com.cg.hcs.bean.Appointment;

public abstract class AppointmentDao {
	public abstract void addAppointment(Appointment appoint);
	public abstract List<Appointment> getAppointmentList();
}

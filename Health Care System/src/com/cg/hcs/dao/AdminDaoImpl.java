package com.cg.hcs.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cg.hcs.bean.Admin;

public class AdminDaoImpl extends AdminDao{
	
	DiagnosticCenterDaoImpl dc=new DiagnosticCenterDaoImpl();
	List<Admin> admin=new ArrayList<Admin>();
	HashMap<Admin, String> adminHash = new HashMap<>();
	Admin a1=new Admin("Meghna","Hens","Female","Admin","meghna@gmail.com",8967330644L,"Meghna@1998",dc.getCenterList());
	Admin a2=new Admin("Neha","Biswakarma","Female","Admin","neha@gmail.com",8013805556L,"Neha@1996",dc.getCenterList());
	Admin a3=new Admin("Karishma","Upadhyay","Female","Admin","karishma@gmail.com",8109993685L,"Karisma@1998",dc.getCenterList());
	Admin a4=new Admin("Nikhil","Gupta","Male","Admin","nikhil@gmail.com",9768519113L,"Nikhil@1998",dc.getCenterList());
	
	@Override
	public void addAdmin() {
		this.admin.add(a1);
		this.admin.add(a2);
		this.admin.add(a3);
		this.admin.add(a4);
		this.adminHash.put(a1,a1.getUserPassword());
		this.adminHash.put(a2,a2.getUserPassword());
		this.adminHash.put(a3,a3.getUserPassword());
		this.adminHash.put(a4,a4.getUserPassword());
	}

	@Override
	public HashMap<Admin, String> getAdminHash() {
		return this.adminHash;
	}

	@Override
	public List<Admin> getAdminList() {
		return this.admin;
	}
	
}

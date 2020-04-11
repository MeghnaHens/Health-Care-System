package com.cg.hcs.dao;

import java.util.HashMap;
import java.util.List;

import com.cg.hcs.bean.Admin;

public abstract class AdminDao {
	
	public abstract void addAdmin();
	public abstract HashMap<Admin, String> getAdminHash();
	public abstract List<Admin> getAdminList();
	
}

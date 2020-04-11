package com.cg.hcs.dao;

import java.util.List;

import com.cg.hcs.bean.*;

public abstract class DiagnosticCenterDao {
	public abstract void addExistingCenter();
	public abstract List<DiagnosticCenter> getCenterList();
}

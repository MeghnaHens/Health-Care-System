package com.cg.hcs.dao;

import java.util.List;

import com.cg.hcs.bean.*;

public abstract class TestDao {
	public abstract void addPreAssignedTest();
	public abstract List<Test> getTestList();
}

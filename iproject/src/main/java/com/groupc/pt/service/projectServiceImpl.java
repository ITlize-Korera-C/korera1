package com.groupc.pt.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.groupc.pt.dao.projectDao;
import com.groupc.pt.model.Projects;
@Service
@Transactional(readOnly = true)
public class projectServiceImpl implements projectService{
	@Autowired
	private projectDao projectDao;
	@Override
	public long save(Projects Kuser) {
		return projectDao.save(Kuser);
	}
	
	@Override
	public Projects getU(long id) {
		return projectDao.get(id);
	}

	@Override
	public List<Projects> userlist() {
		return projectDao.list();
	}
	@Transactional
	@Override
	public void update(long id, Projects Kuser) {
		projectDao.update(id, Kuser);
	}
	@Transactional
	@Override
	public void deleteU(long id) {
		 projectDao.deleteU(id);
	}

//	@Override
//	public List<Projects> returnList(Projects p1) {
//		return projectDao.getProj(p1);
//	}



}

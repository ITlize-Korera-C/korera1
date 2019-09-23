package com.groupc.pt.service;

import java.util.List;

import com.groupc.pt.model.Projects;

public interface projectService {
	   long save(Projects Kuser);
	   Projects getU(long id);
	   List<Projects> userlist();
	   void update(long id, Projects Kuser);
	   void deleteU(long id);	
}

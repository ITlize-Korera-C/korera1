package com.groupc.pt.service;

import java.util.List;

import com.groupc.pt.model.Projects;

public interface formulaPage {
	List<Long> getAllResByProjId(Projects projects);
	
}

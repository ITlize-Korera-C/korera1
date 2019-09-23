package com.groupc.pt.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.groupc.pt.model.Fields;

public interface fieldDao {
	   long save(Fields fl,long projectId);

	   Fields get(long id);

	   List<Fields> list();

	   void update(long id, Fields fl);

	   void deleteU(long id);

	   List<Fields> getByProject(long projectId);

}

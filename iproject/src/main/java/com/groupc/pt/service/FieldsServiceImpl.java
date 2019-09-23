package com.groupc.pt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.ls.LSInput;

import com.groupc.pt.dao.fieldDao;
import com.groupc.pt.model.Fields;
@Service
@Transactional(readOnly = true)
public class FieldsServiceImpl implements FieldsService {
	@Autowired
	private fieldDao fieldDao;

	@Override
	public Fields getU(Long id) {
		return fieldDao.get(id);
	}

	@Override
	public List<Fields> userlist() {
		return fieldDao.list();
	}

	@Override
	public void update(Long id, Fields userField) {
		fieldDao.update(id, userField);
	}

	@Override
	public void deleteU(Long id) {
		 fieldDao.deleteU(id);
	}

	
	@Override
	public List<Fields> getFieldsByProject(Long projectId) {
		List<Fields> list;
		list = fieldDao.getByProject(projectId);
		return list;
	}
	
	@Transactional
	@Override
	public void saveAndUpdate(List<Fields> fields, Long projId) {
		for(Fields fl: fields) {
			if(fl.getFieldId()==null) {
				fieldDao.save(fl, projId);
			}
			else {
				fieldDao.update(fl.getFieldId(),fl);
			}
		}
		
	}

}

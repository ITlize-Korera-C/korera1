package com.groupc.pt.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.groupc.pt.dao.PRFieldValuesDAO;
import com.groupc.pt.model.PRFieldValues;;
@Service
@Transactional(readOnly = true)
public class PRFServiceImpl implements PRFService{
	@Autowired
	private PRFieldValuesDAO prf;
	@Override
	public long save(PRFieldValues Kuser) {
		return prf.save(Kuser);
	}
	
	@Override
	public PRFieldValues getU(long id) {
		return prf.get(id);
	}

	@Override
	public List<PRFieldValues> userlist() {
		return prf.list();
	}

	@Override
	public void update(long id, PRFieldValues Kuser) {
		prf.update(id, Kuser);
	}

	@Override
	public void deleteU(long id) {
		prf.deleteU(id);
	}


}

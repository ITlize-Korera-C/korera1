package com.groupc.pt.service;

import java.util.List;
import java.util.Map;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import com.groupc.pt.model.PRFieldValues;

public interface PRFService {
	   long save(PRFieldValues k);
	   PRFieldValues getU(long id);
	   List<PRFieldValues> userlist();
	   void update(long id, PRFieldValues k);
	   void deleteU(long id);

}

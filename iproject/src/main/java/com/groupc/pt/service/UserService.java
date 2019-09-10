package com.groupc.pt.service;

import java.util.List;

import com.groupc.pt.model.User;;

public interface UserService {
//user
   long save(User User);
   User getU(long id);
   List<String> userlist();
   void update(long id, User User);
   void deleteU(long id);
   Boolean autho(User user);

}

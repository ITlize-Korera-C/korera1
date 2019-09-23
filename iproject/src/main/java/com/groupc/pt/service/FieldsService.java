package com.groupc.pt.service;

import java.util.List;

import com.groupc.pt.model.*;

public interface FieldsService {
   Fields getU(Long id);
   List<Fields> userlist();
   void update(Long id, Fields userField);
   void deleteU(Long id);
   List<Fields> getFieldsByProject(Long projectId);
   void saveAndUpdate(List<Fields> fields, Long projId);
}

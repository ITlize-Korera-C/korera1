package com.groupc.pt.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.groupc.pt.model.Fields;
import com.groupc.pt.model.Projects;

import javassist.expr.NewArray;

@Repository
public class fieldDaoImpl implements fieldDao {

   @Autowired
   private SessionFactory sc;

   @Override
   public long save(Fields Fields,long projectId) {
      Session session = sc.getCurrentSession();
      Projects projects = (Projects)session.get(Projects.class, projectId);
      Fields.setProject(projects);
      session.save(Fields);
      return Fields.getFieldId();
   }

   @Override
   public Fields get(long id) {
      return sc.getCurrentSession().get(Fields.class, id);
      
   }

   @Override
   public List<Fields> list() {
      Session session = sc.getCurrentSession();
      CriteriaBuilder cb = session.getCriteriaBuilder();
      CriteriaQuery<Fields> cq = cb.createQuery(Fields.class);
      Root<Fields> root = cq.from(Fields.class);
      cq.select(root);
      Query<Fields> query = session.createQuery(cq);
      return query.getResultList();
     
   }

   @Override
   public void update(long id, Fields Fields) {
      Session session = sc.getCurrentSession();
      Fields Fields2 = session.byId(Fields.class).load(id);
      Fields2.setFieldName(Fields.getFieldName());
      Fields2.setIsVisible(Fields.getIsVisible());
      Fields2.setTypeOfField(Fields.getTypeOfField());
      session.flush();
   }

   @Override
   public void deleteU(long id) {
      Session session = sc.getCurrentSession();
      Fields Fields = session.byId(Fields.class).load(id);
      session.delete(Fields);
      session.flush();
   }
   
   @Override
   public List<Fields> getByProject(long projectId){
	   Projects projects = sc.getCurrentSession().getReference(Projects.class, projectId);
	   Set<Fields> flSet =projects.getFields();
	   ArrayList<Fields> fList = new ArrayList<Fields>();
	   for(Fields fields: flSet) {
		   fList.add(fields);
	   }
	   return fList;   
   }

}

package com.groupc.pt.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.groupc.pt.model.Projects;

@Repository
public class projectDaoImpl implements projectDao{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(Projects project) {
	      sessionFactory.getCurrentSession().save(project);
	      return project.getId();
	}

	@Override
	public Projects get(long id) {
	return sessionFactory.getCurrentSession().get(Projects.class, id);
	}

	@Override
	public List<Projects> list() {
	      Session session = sessionFactory.getCurrentSession();
	      CriteriaBuilder cb = session.getCriteriaBuilder();
	      CriteriaQuery<Projects> cq = cb.createQuery(Projects.class);
	      Root<Projects> root = cq.from(Projects.class);
	      cq.select(root);
	      Query<Projects> query = session.createQuery(cq);
	      return query.getResultList();
	   }

	@Override
	public void update(long id, Projects project) {
	      Session session = sessionFactory.getCurrentSession();
	      Projects Kuser2 = session.byId(Projects.class).load(id);
	      Kuser2.setName(project.getName());
	      session.flush();
	   }
	@Override
	public void deleteU(long id) {
	      Session session = sessionFactory.getCurrentSession();
	      Projects Kuser = session.byId(Projects.class).load(id);
	      session.delete(Kuser);
	      session.flush();
	}


}

package com.groupc.pt.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.groupc.pt.model.PRFieldValues;

@Repository
public class PRFieldValuesDAOImpl implements PRFieldValuesDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public long save(PRFieldValues fieldValue) {
	      sessionFactory.getCurrentSession().save(fieldValue);
	      return fieldValue.getFieldId();
	}

	@Override
	public PRFieldValues get(long id) {
		return sessionFactory.getCurrentSession().get(PRFieldValues.class, id);
	}

	@Override
	public List<PRFieldValues> list() {
		Session session = sessionFactory.getCurrentSession();
	      CriteriaBuilder cb = session.getCriteriaBuilder();
	      CriteriaQuery<PRFieldValues> cq = cb.createQuery(PRFieldValues.class);
	      Root<PRFieldValues> root = cq.from(PRFieldValues.class);
	      cq.select(root);
	      Query<PRFieldValues> query = session.createQuery(cq);
	      return query.getResultList();
	}

	@Override
	public void update(long id, PRFieldValues fl) {
	      Session session = sessionFactory.getCurrentSession();
	      PRFieldValues newFieldValue = session.byId(PRFieldValues.class).load(id);
	      newFieldValue.setFieldId(fl.getFieldId());
	      newFieldValue.setFieldValue(fl.getFieldValue());
	      session.flush();
	}

	@Override
	public void deleteU(long id) {
		Session session = sessionFactory.getCurrentSession();
		PRFieldValues fieldValue = session.byId(PRFieldValues.class).load(id);
		session.delete(fieldValue);
		session.flush();	
	}

}

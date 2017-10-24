package com.metacube.shoppingcart.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.modal.Product;



public abstract class GenericHibernateDao<T, ID extends Serializable> implements AbstractDao<T,ID>
 {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Class<T> modelClass;

	public Class<T> getModelClass()
	{
		return modelClass;
	}

	public GenericHibernateDao(Class<T> modelClass) {
		this.modelClass = modelClass;
	}

	@Override public Iterable<T> findAll()
	{
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(getModelClass());
		List<T> productList = cr.list();
		return productList;
	}
	
	@Override
	public T findOne(ID primaryKey) {
		Session session = this.sessionFactory.getCurrentSession();
		
		 Product product = (Product)session.get(Product.class, primaryKey);
		 
		return (T) product;
	}
	
	/**
	 * method to delete particular product with given id from database
	 */
	public Status delete(ID primaryKey) {
		Status result = Status.Success;
		System.out.println("in hibernate");
		Session session = this.sessionFactory.getCurrentSession();
		Product product = (Product)session.get(Product.class, primaryKey); 
        session.delete(product);
		return result; 
		
	}
	
	/**
	 * method to save particular product entity in the database
	 */
	public <S extends T> Status save(S entity) {
		Status result = Status.Success;
		try {
		Session session = this.sessionFactory.getCurrentSession();
		//getting transaction object from session object
		//session.beginTransaction();

		/*saving the product*/
		session.save(entity);
		System.out.println("Inserted Successfully");

		/*Committing the transaction*/
		//session.getTransaction().commit();
		}catch(Exception e) {
		result = Status.Error_Occured;
		}
		return result;
		}
		
	
	
	/**
	 * method to update the product
	 * @param product
	 * @param primaryKey
	 * @return
	 */
	public Status edit(Product product, ID primaryKey) {
		
		// TODO Auto-generated method stub
		Status result = Status.Added;
		try {
		Session session = this.sessionFactory.getCurrentSession();
		//session.beginTransaction();

		/*casting the entity into product*/
		Product update = (Product) product;

		/*loading the object using session*/
		Product entity = (Product) session.get(Product.class,primaryKey);

		/*updating the values*/
		entity.setName(update.getName());
		entity.setPrice(update.getPrice());
		session.update(entity);


		/*commit the changes*/
		//session.getTransaction().commit();
		}catch(Exception e) {
		result = Status.Error_Occured;
		}
		return result;
		}

	}

	





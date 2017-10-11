package com.metacube.shoppingcart.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.metacube.shoppingcart.dto.UserDto;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.modal.Cart;

import com.metacube.shoppingcart.modal.Product;
import com.metacube.shoppingcart.modal.User;

/**
 * ClassName : GenericHibernateDao
 * 
 * @author : Vaishali Jain Description: Give definition of all the methods
 *         related to database
 * @param <T>
 * @param <ID>
 */
public abstract class GenericHibernateDao<T, ID extends Serializable>
		implements AbstractDao<T, ID> {

	// object of session factory
	@Autowired
	private SessionFactory sessionFactory;

	// parameterize constructor
	public GenericHibernateDao(Class<T> modelClass) {
		this.modelClass = modelClass;

	}

	// getter to get session factory
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	// setter to set session factory
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Class<T> modelClass;

	// getter to get modal class
	public Class<T> getModelClass() {
		return modelClass;
	}

	/**
	 * Method to add product entity to the database
	 */
	@Override
	public <S extends T> Status save(final S entity) {
		Status result = Status.Success;
		try {
			// to get current session
			Session session = this.sessionFactory.getCurrentSession();
			session.save(entity);
		} catch (Exception e) {
			result = Status.Error_Occured;
		}
		return result;
	}

	/**
	 * method to find product on the basis of id
	 */
	@Override
	public T findOne(ID primaryKey) {
		// to get current session
		Session session = this.sessionFactory.getCurrentSession();
		// Criteria query
		Criteria cr = session.createCriteria(getModelClass()).add(
				Restrictions.eq("id", primaryKey));
		Product product = (Product) cr.uniqueResult();
		return (T) product;
	}

	@Override
	public UserDto findOne(String name) {
		// to get current session
		Session session = this.sessionFactory.getCurrentSession();
		// Criteria query
		Criteria cr = session.createCriteria(getModelClass()).add(
				Restrictions.eq("mail", name));
		User user = (User) cr.uniqueResult();
		return getUserMiniCartDetails(user);
	}

	public UserDto getUserMiniCartDetails(User user) {
		@SuppressWarnings("unchecked")
		
		Double totalPrice = 0.00;
		UserDto userCartDetail = new UserDto();
		userCartDetail.setUser(user);
		Session session = this.sessionFactory.getCurrentSession();

		Criteria cr = session.createCriteria(Cart.class).add(
				Restrictions.eq("userId", user.getUserId()));

		List<Cart> cartList = cr.list();
		System.out.println(cartList.get(0).getProductId());
		System.out.println(user.getUserId());
		System.out.println(cartList.size());
		userCartDetail.setTotalProduct(cartList.size());
		for (int i = 0; i < cartList.size(); i++) {

			int id = cartList.get(i).getProductId();
			cr = session.createCriteria(Product.class).add(
					Restrictions.eq("id", id));
			Product curproduct = (Product) cr.uniqueResult();
			totalPrice += curproduct.getPrice();

		}
		userCartDetail.setTotalPrice(totalPrice);

		return userCartDetail;
	}

	/**
	 * method to get all products
	 */
	@Override
	public Iterable<T> findAll() {
		// to get current session
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(getModelClass());
		List<T> personsList = cr.list();
		return personsList;
	}

	/**
	 * method to delete product on the basis of id
	 */
	@Override
	public Status delete(final ID primaryKey) {
		Status result = Status.Success;
		try {
			// to get current session
			Session session = this.sessionFactory.getCurrentSession();
			Product product = (Product) session.get(Product.class, primaryKey);
			session.delete(product);
		} catch (Exception e) {
			result = Status.Error_Occured;
		}
		return result;
	}

	/**
	 * method to edit product
	 */
	@Override
	public <S extends T> Status edit(S entity, ID primaryKey) {

		Status result = Status.Added;
		try {
			// to get current session
			Session session = this.sessionFactory.getCurrentSession();
			Product update = (Product) entity;
			Product product = (Product) session.get(Product.class, primaryKey);
			product.setName(update.getName());
			product.setPrice(update.getPrice());
			session.update(product);
		} catch (Exception e) {
			result = Status.Error_Occured;
		}
		return result;
	}
	
	public Status addToCart(Cart cart){
		Status result = Status.Success;
		try {
			
			// to get current session
			Session session = this.sessionFactory.getCurrentSession();
			session.save(cart);
		} catch (Exception e) {
			result = Status.Error_Occured;
		}
		return result;
	}
}

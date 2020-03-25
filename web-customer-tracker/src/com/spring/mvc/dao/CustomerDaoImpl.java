package com.spring.mvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvc.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {

		Session session = sessionFactory.getCurrentSession();

		Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);

		List<Customer> customers = query.getResultList();

		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {

		Session session = sessionFactory.getCurrentSession();

		session.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int customerId) {

		Session session = sessionFactory.getCurrentSession();

		Customer customer = session.get(Customer.class, customerId);

		return customer;
	}

	@Override
	public void delete(int id) {

		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("delete from Customer where id=:id");

		query.setParameter("id", id);

		query.executeUpdate();

	}

	@Override
	public List<Customer> search(String name) {

		Session session = sessionFactory.getCurrentSession();

		Query theQuery = null;

		if (name != null) {
			theQuery = session.createQuery("from Customer WHERE firstName like :name or lastName like :name");
			theQuery.setParameter("name", name);
		} else {
			theQuery = session.createQuery("from Customer");
		}
		List<Customer> cus = theQuery.getResultList();
		return cus;
	}

}

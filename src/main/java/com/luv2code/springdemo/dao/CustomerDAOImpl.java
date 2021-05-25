
package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    // SF in dispatcher-servlet.xml file
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        final Session session = sessionFactory.getCurrentSession();
        final Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);
        final List<Customer> customers = query.getResultList();
        return customers;
    }

    @Override
    public void saveCustomer(final Customer customer) {
        final Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);

    }

    @Override
    public Customer getCustomer(final int id) {
        final Session session = sessionFactory.getCurrentSession();
        final Customer customer = session.get(Customer.class, id);
        return customer;
    }

    @Override
    public void deleteCustomer(final int id) {
        final Session session = sessionFactory.getCurrentSession();
        final Query query = session.createQuery("delete from Customer where id=:customerId");
        query.setParameter("customerId", id);
        query.executeUpdate();
    }

}

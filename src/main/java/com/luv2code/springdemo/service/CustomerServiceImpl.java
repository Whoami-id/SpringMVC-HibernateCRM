
package com.luv2code.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDAO CustomerDAO;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return CustomerDAO.getCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(final Customer customer) {
        CustomerDAO.saveCustomer(customer);

    }

    @Override
    @Transactional
    public Customer getCustomer(final int id) {
        return CustomerDAO.getCustomer(id);
    }

    @Override
    @Transactional
    public void deleteCustomer(final int id) {
        CustomerDAO.deleteCustomer(id);

    }

}

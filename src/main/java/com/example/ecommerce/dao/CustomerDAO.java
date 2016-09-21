package com.example.ecommerce.dao;

import com.example.ecommerce.api.Customer;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by ndodakheswa on 2016/05/12.
 */
public class CustomerDAO extends AbstractDAO<Customer> {
    /**
     * Constructor
     *
     * @param sessionFactory Hibernate session factory
     */
    public CustomerDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    /**
     * Method returns all customers stored in the database.
     */
    public List<Customer> findAllCustomers() { return list(namedQuery("com.example.ecommerce.Customer.findAllCustomers")); }

    public List<Customer> findCustomerByName(String name) {
        StringBuilder builder = new StringBuilder("%");
        builder.append(name).append("%");
        return list(namedQuery("com.example.ecommerce.Customer.findCustomerByName")
                .setParameter("name", builder.toString())
        );
    }
}

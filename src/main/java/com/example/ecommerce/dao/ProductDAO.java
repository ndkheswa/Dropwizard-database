package com.example.ecommerce.dao;

import com.example.ecommerce.api.Product;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by ndodakheswa on 2016/06/12.
 */
public class ProductDAO extends AbstractDAO<Product> {
    /**
     * Constructor
     *
     * @param sessionFactory Hibernate session factory
     */
    public ProductDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    /**
     * Method returns all products stored in the database.
     */
    public List<Product> findAllProducts() { return list(namedQuery("com.example.ecommerce.Product.findAllProducts")); }

    public List<Product> findProductByName(String name) {
        StringBuilder builder = new StringBuilder("%");
        builder.append(name).append("%");
        return list(namedQuery("com.example.ecommerce.Product.findProductByName")
                .setParameter("name", builder.toString())
        );
    }
}

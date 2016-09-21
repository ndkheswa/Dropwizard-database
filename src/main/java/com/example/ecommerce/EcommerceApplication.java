package com.example.ecommerce;

import com.example.ecommerce.dao.CustomerDAO;
import com.example.ecommerce.dao.ProductDAO;
import com.example.ecommerce.api.Customer;
import com.example.ecommerce.api.Product;
import com.example.ecommerce.resources.CustomerResource;
import com.example.ecommerce.resources.ProductResource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

/**
 * Created by ndodakheswa on 2016/05/11.
 */
public class EcommerceApplication extends Application<EcommerceConfiguration> {

    public static void main(String[] args) throws Exception{
        new EcommerceApplication().run(args);
    }
    /**
     * Hibernate bundle
     */
    private HibernateBundle<EcommerceConfiguration> hibernateBundle = new HibernateBundle<EcommerceConfiguration>(Customer.class, Product.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(EcommerceConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    @Override
    public void initialize(Bootstrap<EcommerceConfiguration> bootstrap)
    {
        bootstrap.addBundle(new SwaggerBundle<EcommerceConfiguration>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(EcommerceConfiguration ecommerceConfiguration) {
                // this would be the preferred way to set up swagger, you can also construct the object here programtically if you want
                return ecommerceConfiguration.swaggerBundleConfiguration;
            }
        });
        bootstrap.addBundle(hibernateBundle);
    }

    @Override
    public void run(EcommerceConfiguration configuration, Environment environment) throws Exception {
        final CustomerDAO customerDAO = new CustomerDAO(hibernateBundle.getSessionFactory());
        final ProductDAO productDAO = new ProductDAO(hibernateBundle.getSessionFactory());
        environment.jersey().register(new CustomerResource(customerDAO));
        environment.jersey().register(new ProductResource(productDAO));
     }
}

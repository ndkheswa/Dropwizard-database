package com.example.ecommerce;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

/**
 * Created by ndodakheswa on 2016/05/11.
 */
public class EcommerceConfiguration extends Configuration {

    /**gem
     * A factory used to connect to a relational database  manaentsystem.
     * Factories are used by Dropwizard to group together related parameters
     * such as connection driver, URL, password, etc.
     */
    private DataSourceFactory dataSourceFactory = new DataSourceFactory();

    /**
     * A getter for the datasource factory
     */
    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() {
        return dataSourceFactory;
    }

    @JsonProperty("swagger")
    public SwaggerBundleConfiguration swaggerBundleConfiguration;
}

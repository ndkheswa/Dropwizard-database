package com.example.ecommerce.resources;

import com.codahale.metrics.annotation.Timed;
import com.example.ecommerce.api.Product;
import com.example.ecommerce.dao.ProductDAO;
import com.google.common.base.Optional;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by ndodakheswa on 2016/05/12.
 */
@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
@Api("/product")
public class ProductResource {
    /**
     * The DAO object to manipulate product
     */
    private ProductDAO ecommerceDAO;

    /**
     * Constructor
     */
    public ProductResource(ProductDAO ecommerceDAO) {
        this.ecommerceDAO = ecommerceDAO;
    }

    @GET
    @UnitOfWork
    @ApiOperation("All products")
    public List<Product> findAllProducts() { return ecommerceDAO.findAllProducts(); }

    @GET
    @Path("/{name}")
    @UnitOfWork
    @Timed
    @ApiOperation(value="Search product by name", notes="some day this will do more, it believes in a growth mentality.")
    @ApiResponses(value={
            @ApiResponse(code=404, message="Product not found"),
    })
    public List<Product> findProductByName(@PathParam("name") Optional<String> name) {
        if (name.isPresent()) {
            return ecommerceDAO.findProductByName(name.get());
        } else {
            return ecommerceDAO.findAllProducts();
        }
    }
}

package com.example.ecommerce.resources;

import com.example.ecommerce.api.Customer;
import com.example.ecommerce.dao.CustomerDAO;
import com.google.common.base.Optional;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by ndodakheswa on 2016/05/12.
 */


@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
@Api("/customer")
public class CustomerResource {

    /**
     * The DAO object to manipulate customers
     */
    private CustomerDAO ecommerceDAO;

    /**
     * Constructor
     */
    public CustomerResource(CustomerDAO ecommerceDAO) {
        this.ecommerceDAO = ecommerceDAO;
    }

    @GET
    @UnitOfWork
    @ApiOperation("All customers")
    public List<Customer> findAll() { return ecommerceDAO.findAllCustomers(); }

    @GET
    @Path("/{name}")
    @UnitOfWork
    @ApiOperation(value="Search customer by name", notes="some day this will do more, it believes in a growth mentality.")
    @ApiResponses(value={
            @ApiResponse(code=404, message="Customer not found"),
    })
    public List<Customer> findCustomerByName(@PathParam("name") Optional<String> name) {
        if (name.isPresent()) {
            return ecommerceDAO.findCustomerByName(name.get());
        } else {
            return ecommerceDAO.findAllCustomers();
        }
    }
}

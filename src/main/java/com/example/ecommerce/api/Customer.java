package com.example.ecommerce.api;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@NamedQueries({
        @NamedQuery(name = "com.example.ecommerce.Customer.findAllCustomers",
                query = "select e from Customer e"),
        @NamedQuery(name = "com.example.ecommerce.Customer.findCustomerByName",
                query = "select e from Customer e "
                        + "where e.firstName LIKE :name" )
})
/**
 * Created by ndodakheswa on 2016/05/11.
 */
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Customer first name
     */
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    private String phone;

    private String address;

    /**
     * Constructor
     */
    public Customer() {
    }

    /**
     * Constructor
     * @param firstName
     */
    public Customer(String firstName) { this.firstName = firstName; }

    @JsonProperty
    public String getFirstName() { return firstName; }

    /**
     *
     * @return lastName
     */
    @JsonProperty
    public String getLastName() { return lastName; }

    /**
     *
     * @return email
     */
    @JsonProperty
    public String getEmail() { return email; }

    @JsonProperty
    public String getPhone() { return phone; }

    @JsonProperty
    public String getAddress() { return address; }
}

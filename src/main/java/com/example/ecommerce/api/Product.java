package com.example.ecommerce.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "product")
@NamedQueries({
        @NamedQuery(name = "com.example.ecommerce.Product.findAllProducts",
                query = "select e from Product e"),
        @NamedQuery(name = "com.example.ecommerce.Product.findProductByName",
                query = "select e from Product e "
                        + "where e.name LIKE :name" )
})

/**
 * Created by ndodakheswa on 2016/06/12.
 */
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * Product name
     */
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private long price;

    @Column(name = "category_id")
    private int category;

    /**
     * Constructor
     */
    public Product() {
    }

    /**
     * Constructor
     * @param productName
     */
    public Product(String productName) { this.name = productName; }

    @JsonProperty
    public String getName() { return name; }

    /**
     *
     * @return price
     */
    @JsonProperty
    public long getPrice() { return price; }

    /**
     *
     * @return description
     */
    @JsonProperty
    public String getDescription() { return description; }

    //@JsonProperty
    //public int getCategory() { return category; }

    @JsonProperty
    public String getId() { return id; }
}

package org.datanucleus.samples.jdo.tutorial;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class Product
{
    String name = null;
    String description = null;
    double price = 0.0;

    protected Product()
    {
    }

    public Product(String name, String desc, double price)
    {
        this.name = name;
        this.description = desc;
        this.price = price;
    }
}
package com.designPattern.priciple.ocp;

public class ComputerBook implements IComputerBook {

    private String name;
    private Integer price;
    private String author;
    private String scope;

    @Override
    public String getScope() {
        return this.scope;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Integer getPrice() {
        return this.price;
    }

    @Override
    public String getAuthor() {
        return this.author;
    }
}
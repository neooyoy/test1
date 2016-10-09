package com.designPattern.priciple.ocp;

public class NovelBook implements IBook {
    private String name;
    private Integer price;
    private String author;

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

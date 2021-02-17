package com.example.demo.model.service;

import java.math.BigDecimal;

public class OfferServiceModel {
    private String description;
    private String engine;
    private Integer imageUrl;
    private long mileage;
    private BigDecimal price;
    private Integer year;
    private String transmission;
    private Integer modelId;

    public String getDescription() {
        return description;
    }

    public OfferServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getEngine() {
        return engine;
    }

    public OfferServiceModel setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }

    public OfferServiceModel setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public long getMileage() {
        return mileage;
    }

    public OfferServiceModel setMileage(long mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public OfferServiceModel setYear(Integer year) {
        this.year = year;
        return this;
    }

    public String getTransmission() {
        return transmission;
    }

    public OfferServiceModel setTransmission(String transmission) {
        this.transmission = transmission;
        return this;
    }

    public Integer getModelId() {
        return modelId;
    }

    public OfferServiceModel setModelId(Integer modelId) {
        this.modelId = modelId;
        return this;
    }
}

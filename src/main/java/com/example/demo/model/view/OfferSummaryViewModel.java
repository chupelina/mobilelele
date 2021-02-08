package com.example.demo.model.view;

import com.example.demo.model.entities.ModelEntity;
import com.example.demo.model.entities.enums.EngineEnum;
import com.example.demo.model.entities.enums.TransmissionEnum;

import java.math.BigDecimal;

public class OfferSummaryViewModel {
    private int year;
    private EngineEnum engine;
    private String imageUrl;
    private long mileage;
    private BigDecimal price;
    private TransmissionEnum transmission;
    private ModelEntity model;

    public int getYear() {
        return year;
    }

    public OfferSummaryViewModel setYear(int year) {
        this.year = year;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferSummaryViewModel setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferSummaryViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public long getMileage() {
        return mileage;
    }

    public OfferSummaryViewModel setMileage(long mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferSummaryViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferSummaryViewModel setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public ModelEntity getModel() {
        return model;
    }

    public OfferSummaryViewModel setModel(ModelEntity model) {
        this.model = model;
        return this;
    }
}


package com.example.demo.model.service;

import com.example.demo.model.entities.enums.EngineEnum;
import com.example.demo.model.entities.enums.TransmissionEnum;
import com.example.demo.model.validation.YearPastOrPresent;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class OfferServiceModel {
    @NotEmpty
    @Size(min = 10, max = 512)
    private String description;
    @NotNull
    private EngineEnum engine;
    @NotNull
    private String imageUrl;
    @NotNull
    @Positive
    private long mileage;
    @DecimalMin("100")
    private BigDecimal price;
    @YearPastOrPresent(minYear = 1930)
    private Integer year;
    @NotNull
    private TransmissionEnum transmission;
    @NotNull
    private long modelId;

    public String getDescription() {
        return description;
    }

    public OfferServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferServiceModel setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferServiceModel setImageUrl(String imageUrl) {
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

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferServiceModel setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public long getModelId() {
        return modelId;
    }

    public OfferServiceModel setModelId(long modelId) {
        this.modelId = modelId;
        return this;
    }
}

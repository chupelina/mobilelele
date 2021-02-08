package com.example.demo.model.entities;

import com.example.demo.model.entities.enums.EngineEnum;
import com.example.demo.model.entities.enums.TransmissionEnum;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity{
    private String description;
    @Enumerated(value = EnumType.STRING)
    private EngineEnum engine;
    private String imageUrl;
    private long mileage;
    private BigDecimal price;
    private int year;
    @Enumerated(value =  EnumType.STRING)
    private TransmissionEnum transmission;
    @ManyToOne
    private ModelEntity model;
//    @ManyToOne
//    private UserEntity seller;


    public int getYear() {
        return year;
    }

    public OfferEntity setYear(int year) {
        this.year = year;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferEntity setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public long getMileage() {
        return mileage;
    }

    public OfferEntity setMileage(long mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferEntity setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public ModelEntity getModel() {
        return model;
    }

    public OfferEntity setModel(ModelEntity model) {
        this.model = model;
        return this;
    }

//    public UserEntity getSeller() {
//        return seller;
//    }
//
//    public OfferEntity setSeller(UserEntity seller) {
//        this.seller = seller;
//        return this;
//    }

    @Override
    public String toString() {
        return "OfferEntity{" +
                "description='" + description + '\'' +
                ", engine=" + engine +
                ", imageUrl='" + imageUrl + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                ", transmission=" + transmission +
                ", model=" + model +
//                ", seller=" + seller +
                ", id=" + id +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}

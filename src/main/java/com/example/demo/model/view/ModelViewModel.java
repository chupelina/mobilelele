package com.example.demo.model.view;

import com.example.demo.model.entities.BrandEntity;
import com.example.demo.model.entities.enums.CategoryEnum;

public class ModelViewModel {
    private String name;
    private CategoryEnum category;
    private String imageUrl;
    private int startYear;
    private int endYear;

    public String getName() {
        return name;
    }

    public ModelViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public ModelViewModel setCategory(CategoryEnum category) {
        this.category = category;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ModelViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getStartYear() {
        return startYear;
    }

    public ModelViewModel setStartYear(int startYear) {
        this.startYear = startYear;
        return this;
    }

    public int getEndYear() {
        return endYear;
    }

    public ModelViewModel setEndYear(int endYear) {
        this.endYear = endYear;
        return this;
    }

    @Override
    public String toString() {
        return "ModelViewModel{" +
                "name='" + name + '\'' +
                ", category=" + category +
                ", imageUrl='" + imageUrl + '\'' +
                ", startYear=" + startYear +
                ", endYear=" + endYear +
                '}';
    }
}

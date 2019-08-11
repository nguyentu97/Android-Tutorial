package com.example.helloworld.recycleview;

public class Places {
    String namePlaces;
    int isMoreDetail;
    int isPromotion;

    public Places() {
    }

    public Places(String namePlaces, int isMoreDetail, int isPromotion) {
        this.namePlaces = namePlaces;
        this.isMoreDetail = isMoreDetail;
        this.isPromotion = isPromotion;
    }

    public String getNamePlaces() {
        return namePlaces;
    }

    public void setNamePlaces(String namePlaces) {
        this.namePlaces = namePlaces;
    }

    public int getIsMoreDetail() {
        return isMoreDetail;
    }

    public void setIsMoreDetail(int isMoreDetail) {
        this.isMoreDetail = isMoreDetail;
    }

    public int getIsPromotion() {
        return isPromotion;
    }

    public void setIsPromotion(int isPromotion) {
        this.isPromotion = isPromotion;
    }
}

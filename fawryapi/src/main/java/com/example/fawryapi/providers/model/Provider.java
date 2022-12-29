package com.example.fawryapi.providers.model;

public abstract class Provider {
    private double fees = 0.9;

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    protected String to;
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    double amount;

    public double getAmount() {
        if (discount == 0) {
            return amount;
        }
        return amount*discount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    protected double discount = 0;
    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    private String providerName;


    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }



    private String category;

    public Provider(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public abstract boolean handleRequest(String to);
    public abstract boolean handleRequestAmount(double amount);

    public abstract void submitRequest(String to, double amount);

    @Override
    public String toString() {
        return getProviderName();
    }
}


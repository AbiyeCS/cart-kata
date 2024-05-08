package org.example;

import java.util.ArrayList;

public class Cart {
    private final Pricing pricing;
    private final ArrayList<String> skus;

    public Cart(Pricing pricing){
        skus = new ArrayList<>();
        this.pricing = pricing;
    }

    public void scan(String sku){
        if (sku == null || sku.isEmpty()) return;
        skus.add(sku);
    }

    public int total(){
        return pricing.getSum(skus);
    }
}

package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class Pricing {
    private final HashMap<String, Integer> skuPrices;
    private final HashMap<String, Discount> discounts;

    public Pricing(HashMap<String, Discount> discounts) {
        this.discounts = discounts;
        this.skuPrices = new HashMap<>() {
            {
                put("A", 50);
                put("B", 35);
                put("C", 25);
                put("D", 12);
            }
        };
    }

    public int getSum(ArrayList<String> skus) {
        HashMap<String, Integer> countPerSku = new HashMap<>();
        int total = 0;

        for (String sku : skus) {
            countPerSku.compute(sku, (key, val) -> (val == null ? 1 : val + 1));

            Discount discount = discounts.get(sku);
            int count = countPerSku.get(sku);

            if (discount != null && count % discount.quantity == 0) {
                total += discount.price - (discount.quantity - 1) * skuPrices.get(sku);
            } else {
                total += skuPrices.get(sku);
            }
        }
        return total;
    }
}

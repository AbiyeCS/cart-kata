package org.example;

import org.example.Exception.NoFileFoundException;
import org.example.Model.Item;
import org.example.Util.JsonUtil;

import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws NoFileFoundException {
        HashMap<String, Discount> discounts = new HashMap<>();
        discounts.put("A", new Discount(3, 130));
        discounts.put("B", new Discount(2, 60));
        Pricing pricing = new Pricing(discounts);
        Cart cart = new Cart(pricing);

        try {
            Item[] itemsArray =
                    JsonUtil.readJSONString(
                            Files.readString(
                                    JsonUtil.JSON_FILE_ROOT.resolve("DataSource1.json")),
                            Item[].class);
            List<Item> items = Arrays.asList(itemsArray);

            for (Item item : items) {
                for (int i = 0; i < item.getQuantity(); i++) {
                    cart.scan(item.getCode());
                }
            }

            System.out.println("Total Price: £" + cart.total());

        } catch (Exception e) {
            throw new NoFileFoundException("No file found");
        }
    }
}
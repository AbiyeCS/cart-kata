import org.example.Cart;
import org.example.Discount;
import org.example.Model.Item;
import org.example.Pricing;
import org.example.Util.JsonUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartTest {
    private Cart cart;
    private Pricing pricing;
    HashMap<String, Discount> discounts = new HashMap<>();

    @BeforeEach
    public void setUp(){
        discounts = new HashMap<>();
        discounts.put("A", new Discount(3, 140));
        discounts.put("B", new Discount(2, 60));
        pricing = new Pricing(discounts);
        cart = new Cart(pricing);
    }

    private int price(String goods) {
        cart = new Cart(pricing);
        for (char item : goods.toCharArray()) {
            cart.scan(String.valueOf(item));
        }
        return cart.total();
    }

    @Test
    public void blankSkuShouldHaveNoPrice() {
        cart.scan("");
        assertEquals(0, cart.total());
    }

    @Test
    public void productAShouldCost50() {
        cart.scan("A");
        assertEquals(price("A"), cart.total());
    }

    @Test
    public void productBShouldCost35() {
        cart.scan("B");
        assertEquals(price("B"), cart.total());
    }

    @Test
    public void shouldCost140forAAA() {
        cart.scan("A");
        cart.scan("A");
        cart.scan("A");
        assertEquals(price("AAA"), cart.total());
    }

    @Test
    public void testCartWithMultipleItems() {
        assertEquals(140, price("AAA"));
        assertEquals(60, price("BB"));
        assertEquals(95, price("BBB"));
        assertEquals(25, price("C"));
        assertEquals(75, price("CCC"));
        assertEquals(12, price("D"));
        assertEquals(24, price("DD"));
        assertEquals(122, price("CDBA"));
        assertEquals(285, price("AAAABBB"));
        assertEquals(237, price("ABCDAAB"));
        assertEquals(257, price("BBABABCD"));
    }

    @Test
    public void canReadJsonInput() throws Exception {
        String jsonInput = "{\"code\":\"A\",\"quantity\":3}";
        Item item = JsonUtil.readJSONString(jsonInput, Item.class);
        assertEquals("A", item.getCode());
        assertEquals(3, item.getQuantity());
    }
}

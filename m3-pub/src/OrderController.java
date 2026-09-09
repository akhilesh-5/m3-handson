import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A plain-Java controller. 
 *
 * Only {@link #listOrders()} is hand-written and will pass its test
 * on day one. {@link #getOrderById(long)} and
 * {@link #createOrder(String, int)} are TODO stubs; their tests
 * fail until the student autocompletes them.
 */
public class OrderController {

    public record Order(long id, String item, int qty) {}

    private final Map<Long, Order> store = new HashMap<>();
    private long nextId = 1;

    public OrderController() {
        Order seed = new Order(nextId++, "seed-item", 1);
        store.put(seed.id(), seed);
    }

    /** GET /orders -- return every stored order. Hand-written. */
    public List<Order> listOrders() {
        return new ArrayList<>(store.values());
    }

    /** GET /orders/{id} -- return the matching order, or null if
     *  none exists. TODO: complete with Copilot. */
    public Order getOrderById(long id) {
        // TODO: look up id in `store` and return it (or null).
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be positive");
        }
        return store.get(id);
    }

    /** POST /orders -- create a new order, assign it the next id,
     *  store it, and return it. TODO: complete with Copilot. */
    public Order createOrder(String item, int qty) {
        if (item == null || item.isEmpty()) {
            throw new IllegalArgumentException("Item cannot be null or empty");
        }
        if (qty <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        // TODO: validate item/qty, allocate nextId, put in store, return.
        Order order = new Order(nextId++, item, qty);
        store.put(order.id(), order);
        return order;
    }

    public static void main(String[] args) {
        OrderController controller = new OrderController();
        System.out.println("Initial orders: " + controller.listOrders());

        Order created = controller.createOrder("book", 2);
        System.out.println("Created order: " + created);
        System.out.println("Found order: " + controller.getOrderById(created.id()));
    }
}

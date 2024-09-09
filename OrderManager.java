package daniel_gerbi_natanel_michel7;

import java.util.LinkedHashSet;
import java.util.Set;

public class OrderManager {
    
	private Set<Orders> orders;
    private StoreFacade storeFacade;
    
    public OrderManager(StoreFacade storeFacade) {
        this.orders = new LinkedHashSet<>();
        this.storeFacade = storeFacade;
    }

    public boolean addOrder(Orders order) {
        return orders.add(order);
    }

    public Set<Orders> getOrders() {
        return orders;
    }
}

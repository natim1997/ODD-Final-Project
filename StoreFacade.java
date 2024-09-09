package daniel_gerbi_natanel_michel7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class StoreFacade {
	private final int DOLLAR_VALUE = 4;
	private static StoreFacade instance = null;
	private Set<Products> productsList;
	private ArrayList<Shipping> shippingCompany;
	private Set<Orders> OrdersList;
	
	private StoreManager storeManager;
    private ProductManager productManager;
    private OrderManager orderManager;

	private StoreFacade() {
		productsList = new TreeSet<>();
		shippingCompany = new ArrayList<>();
		shippingCompany.add(new DHL("Daniel", "050-2594575"));
		shippingCompany.add(new FedEx("Nati", "050-3333335"));
		OrdersList = new LinkedHashSet<>();
		Keeper k = new Keeper();
		this.storeManager = new StoreManager(this);
		this.orderManager = new OrderManager(this);
		this.productManager = new ProductManager(this);
		}

	public ProductManager getProductManager() {
		return productManager;
	}

	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}

	public boolean addProduct(Products product) {
		boolean flagAdded = productsList.add(product);
		if (!flagAdded) {
			System.out.println("Product with ID " + product.getSerialId() + " already exists.");
		}
		return flagAdded;
	}

	public ArrayList<Shipping> getShippingList() {
		return shippingCompany;
	}

	public void addShippingCompany(Shipping shipping) {
		shippingCompany.add(shipping);
	}

	void displayProducts() {
		for (Products product : productsList) {
			System.out.println("The Product is : " + product.getProductName());
			System.out.println("The Price (₪) is : " + product.getSellingPrice());
			System.out.println("Stock: " + product.getStock());
			System.out.println("Orders: " + product.getOrdersList());
			System.out.println();
		}
	}

	public Set<Products> getProductsList() {
		return productsList;
	}

	public void setProductsList(Set<Products> productsList) {
		this.productsList = productsList;
	}

	@Override
	public int hashCode() {
		return Objects.hash(productsList);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StoreFacade other = (StoreFacade) obj;
		return Objects.equals(productsList, other.productsList);
	}

	public boolean removeProduct(String productId) {
		return productsList.removeIf(product -> product.getSerialId().equals(productId));
	}

	public boolean addOrderToProduct(String serialId, Customer customer, int quantity, shippingType shippingType,
			String orderId) {
		Products product = findProductBySerialId(serialId);
		if (product == null) {
			System.out.println("Product with serial ID " + serialId + " not found.");
			return false;
		}

		if (product.isOrderExist(orderId)) {
			System.out.println("An order with ID " + orderId + " already exists for this product.");
			return false;
		}

		if (product.getStock() < quantity) {
			System.out.println("Insufficient stock for this order.");
			return false;
		}

		Orders newOrder = new Orders(customer, quantity, product, shippingType, orderId);
		product.getOrdersList().add(newOrder);
		this.OrdersList.add(newOrder);
		product.setStock(product.getStock() - quantity);

		return true;
	}

	public Products findProductBySerialId(String serialId) {
		for (Products product : productsList) {
			if (product.getSerialId().equals(serialId)) {
				return product;
			}
		}
		return null;
	}

	public boolean undoLastOrder(String serialId) {
		Products product = findProductBySerialId(serialId);
		if (product == null) {
			System.out.println("Product with serial ID " + serialId + " not found.");
			return false;
		}

		Set<Orders> orders = product.getOrdersList();
		if (orders.isEmpty()) {
			System.out.println("No orders found for this product.");
			return false;
		}
		Orders lastOrder = null;
		for (Orders order : orders) {
			lastOrder = order;
		}

		if (lastOrder != null) {
			orders.remove(lastOrder);
			product.setStock(product.getStock() + lastOrder.getAmount());
			System.out.println("Order " + lastOrder.getOrderId() + " has been cancelled due to store issues.");
			return true;
		}
		return false;
	}

	public void displayProductInfo(Products product) {
		System.out.println("Product Name: " + product.getProductName());
		System.out.println("Stock: " + product.getStock());

		int totalProfit = 0;
		for (Orders order : product.getOrdersList()) {
			System.out.println("Order ID: " + order.getOrderId());
			System.out.println("Amount: " + order.getAmount());
			System.out.println("Delivery Type: " + order.getShippingType()); 

			int profit = (order.getAmount() * (product.getSellingPrice() - product.getCostPrice()));
			totalProfit += profit;
			System.out.println("Profit from this order: " + profit);
		}
		System.out.println("Total Profit from Product: " + totalProfit);
	}

	public void displayAllProducts() {
		for (Products product : productsList) {
			displayProductInfo(product);
			System.out.println("---------"); 
		}
	}

	public StoreMemento saveToMemento() {
		Set<Products> clonedProducts = new TreeSet<>();
		for (Products product : this.productsList) {
			clonedProducts.add(product.clone());
		}
		return new StoreMemento(clonedProducts);
	}

	public void restoreMemento(StoreMemento memento) {
		this.productsList = new TreeSet<>(memento.getState());
	}

	public static StoreFacade getInstance() {
		if (instance == null) {
			instance = new StoreFacade();
		}
		return instance;
	}

	public Iterator<Products> getProductIterator() {
		return productsList.iterator();
	}
	public Iterator<Orders> getOrderIterator() {
		return OrdersList.iterator();
	}
	public Shipping findCheapestShippingOption(Orders order) {
		Shipping cheapest = null;
		double lowestFee = Double.MAX_VALUE;
		for (Shipping company : shippingCompany) {
			double fee = company.calculateShippingFee(order);
			if (fee < lowestFee) {
				lowestFee = fee;
				cheapest = company;
			}
		}
		return cheapest;
	}

	public ShippingDetails processOrder(Orders order) {
		Shipping cheapestOption = findCheapestShippingOption(order);
		double shippingFee = cheapestOption.calculateShippingFee(order);
		double orderPrice = shippingFee + (order.getProduct().sellingPrice * order.getAmount());
		OrdersList.add(order);
		return new ShippingDetails(cheapestOption.getName(), shippingFee, order.getShippingType());
	}

	public Set<Orders> getOrdersList() {
		return OrdersList;
	}

	public void setOrdersList(Set<Orders> ordersList) {
		OrdersList = ordersList;
	}

	public int getDOLLAR_VALUE() {
		return DOLLAR_VALUE;
	}

	public boolean hasProducts() {
        return !productsList.isEmpty();
    }
	public boolean hasOrders() {
        return !OrdersList.isEmpty();
    }

}

package daniel_gerbi_natanel_michel7;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Products implements Comparable<Products>, Cloneable {

	protected String productName;
	protected int costPrice;
	protected int sellingPrice;
	protected int stock;
	protected double weight;
	protected String serialId;

	private Set<Orders> OrdersList = new LinkedHashSet<>();

	public Products(String productName, int costPrice, int sellingPrice, int stock, String serialId, double weight) {
		this.productName = productName;
		this.costPrice = costPrice;
		this.sellingPrice = sellingPrice;
		this.stock = stock;
		this.serialId = serialId;
		this.weight = weight;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String product_name) {
		this.productName = product_name;
	}

	public int getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(int cost_price) {
		this.costPrice = cost_price;
	}

	public int getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(int selling_price) {
		this.sellingPrice = selling_price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Set<Orders> getOrdersList() {
		return OrdersList;
	}

	public void setOrdersList(Set<Orders> ordersList) {
		OrdersList = ordersList;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getSerialId() {
		return serialId;
	}

	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}

	@Override
	public int compareTo(Products o) {
		return this.getSerialId().compareTo(o.getSerialId());
	}

	public boolean undoLastOrder() {
		if (OrdersList.isEmpty()) {
			return false;
		}
		Iterator<Orders> iterator = OrdersList.iterator();
		Orders lastOrder = null;

		while (iterator.hasNext()) {
			lastOrder = iterator.next();
		}

		if (lastOrder != null) {
			iterator.remove();
			System.out.println("Order " + lastOrder.getOrderId() + " has been cancelled due to store issues,to see the changes press 8 in the menu.");
			stock += lastOrder.getAmount();
			return true;
		}
		return false;
	}
	
	public boolean isOrderExist(String orderId) {
			for (Orders order : OrdersList) {
				if (order.getOrderId().equals(orderId)) {
					return true;
				}
			}
			return false;
		}
	
	public void displayProductDetails() {
		System.out.println("Product Name: " + productName);
		System.out.println("Weight Product: " + weight);
		System.out.println("Product ID: " + serialId);
		System.out.println("Current Stock: " + stock);
		System.out.println("Product Type: " + this.getClass().getSimpleName());

		int totalProfit = 0;
		for (Orders order : OrdersList) {
			System.out.println("Order ID: " + order.getOrderId() + ", Quantity: " + order.getAmount() + ",Customer: " + order.getCustomer());
			int profit = (order.getAmount() * (sellingPrice - costPrice));
			totalProfit += profit;
		}
		System.out.println("Total Profit from Product: " + totalProfit);
	}

	public Orders addOrders(Customer customer, int amount, Products product, shippingType shippingType,
			String orderId) {
		if (amount > this.stock) {
			System.out.println("Invalid stock.please try again");
			return null;
		}
		this.stock -= amount;
		Orders NewOneOrder = new Orders(customer, amount, product, shippingType, orderId);
		this.OrdersList.add(NewOneOrder);
		StoreFacade.getInstance().getOrdersList().add(NewOneOrder);
		return NewOneOrder;

	}
	
	public Orders addOrdersTo(Customer customer, int amount, Products product,String orderId) {
		if (amount > this.stock) {
			System.out.println("Invalid stock.please try again");
			return null;
		}
		this.stock -= amount;
		Orders NewOneOrder = new Orders(customer, amount, product,orderId);
		this.OrdersList.add(NewOneOrder);
		StoreFacade.getInstance().getOrdersList().add(NewOneOrder);
		return NewOneOrder;

	}
	
	
	public void displayProductInfo() {
		System.out.println("Product Name: " + productName);
		System.out.println("Product ID: " + serialId);
		System.out.println("Current Stock: " + stock);
	}

	public Products clone() {
		try {
			Products cloned = (Products) super.clone();
			cloned.OrdersList = new LinkedHashSet<>();
			for (Orders order : this.OrdersList) {
				cloned.OrdersList.add(order.clone());
			}
			return cloned;
		} catch (CloneNotSupportedException e) {
			throw new AssertionError(); 
		}
	}

	public void displayOrderInfo(StoreFacade storeFacade) {
		System.out.println("Product Name: " + productName);
		System.out.println("Product ID: " + serialId);
		System.out.println("Current Stock: " + stock);
		System.out.println("Product Type: " + this.getClass().getSimpleName());

		for (Orders order : OrdersList) {
			System.out.println("Order ID: " + order.getOrderId() + ", Quantity: " + order.getAmount() + ", Customer: " + order.getCustomer());
		}
	}
}
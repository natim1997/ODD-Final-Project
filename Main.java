package daniel_gerbi_natanel_michel7;

import java.util.Iterator;
import java.util.Scanner;

public class Main {

	private static Scanner s = new Scanner(System.in);
	private static StoreMemento backup;

	public static void printMenu() {
		System.out.println("Choose option:");

		System.out.println("1)  example running");
		System.out.println("2)  Add new Product");
		System.out.println("3)  Remove Product");
		System.out.println("4)  Update Product's Invetory");
		System.out.println("5)  Add new Order");
		System.out.println("6)  Undo - Remove Last Order");
		System.out.println("7)  Show All Product's Detalis");
		System.out.println("8)  Show All Exsits Product");
		System.out.println("9)  Print Product's Orders");
		System.out.println("10) Reconstruction  Of The System");
		System.out.println("11)  Exit - Press E/e ");

	}

	public static void initializeData(StoreFacade storeFacade) {

		FactoryThroughWebsite soldInWebsite = new FactoryThroughWebsite();
		FactorySoldInStore soldInStore = new FactorySoldInStore();
		FactorySoldToWholesalers soldToWholesalers = new FactorySoldToWholesalers();

		Customer customer1 = new Customer("dani", "0587035555");
		Customer customer2 = new Customer("yossi", "0587036666");
		Customer customer3 = new Customer("avi", "0587037777");
		Customer customer4 = new Customer("moshe", "0587038888");
		Customer customer5 = new Customer("netanel", "0587039999");

		Products product1 = soldInWebsite.createProduct("speakers", 100, 250, 60, "England", "aaa", 6);

		storeFacade.addProduct(product1);

		product1.addOrders(customer1, 2, product1, shippingType.STANDARD, "a");
		product1.addOrders(customer1, 3, product1, shippingType.EXPRESS, "b");
		product1.addOrders(customer1, 4, product1, shippingType.STANDARD, "c");

		Products product2 = soldInWebsite.createProduct("airpords", 20, 100, 150, "Garmany", "bbb", 7);

		storeFacade.addProduct(product2);

		product2.addOrders(customer2, 2, product2, shippingType.STANDARD, "d");
		product2.addOrders(customer2, 3, product2, shippingType.EXPRESS, "e");
		product2.addOrders(customer2, 4, product2, shippingType.STANDARD, "f");

		Products product3 = soldInWebsite.createProduct("mixers", 70, 120, 15, "Spain", "ccc", 8);

		storeFacade.addProduct(product3);

		product3.addOrders(customer3, 2, product3, shippingType.STANDARD, "h");
		product3.addOrders(customer3, 3, product3, shippingType.EXPRESS, "i");
		product3.addOrders(customer3, 4, product3, shippingType.STANDARD, "j");

		Products product4 = soldInStore.createProduct("TV", 10, 20, 50, "ddd", 5);

		storeFacade.addProduct(product4);

		product4.addOrders(customer4, 2, product4, shippingType.STANDARD, "k");
		product4.addOrders(customer4, 3, product4, shippingType.EXPRESS, "l");
		product4.addOrders(customer4, 4, product4, shippingType.STANDARD, "m");

		Products product5 = soldInStore.createProduct("computers", 20, 30, 45, "eee", 10);

		storeFacade.addProduct(product5);

		product5.addOrders(customer5, 2, product5, shippingType.STANDARD, "n");
		product5.addOrders(customer5, 3, product5, shippingType.EXPRESS, "o");
		product5.addOrders(customer5, 4, product5, shippingType.STANDARD, "p");

		Products product6 = soldInStore.createProduct("keyBoards", 100, 300, 70, "fff", 11);

		storeFacade.addProduct(product6);

		product6.addOrders(customer2, 2, product6, shippingType.STANDARD, "q");
		product6.addOrders(customer2, 3, product6, shippingType.EXPRESS, "r");
		product6.addOrders(customer2, 4, product6, shippingType.STANDARD, "s");

		Products product7 = soldToWholesalers.createProduct("xbox", 500, 1500, 90, "ggg", 12);

		storeFacade.addProduct(product7);

		product7.addOrders(customer2, 2, product7, shippingType.STANDARD, "t");
		product7.addOrders(customer2, 3, product7, shippingType.EXPRESS, "u");
		product7.addOrders(customer2, 4, product7, shippingType.STANDARD, "v");

		Products product8 = soldToWholesalers.createProduct("playstation", 2000, 3500, 200, "hhh", 13);

		storeFacade.addProduct(product8);

		product8.addOrders(customer2, 2, product8, shippingType.STANDARD, "w");
		product8.addOrders(customer2, 3, product8, shippingType.EXPRESS, "x");
		product8.addOrders(customer2, 4, product8, shippingType.STANDARD, "y");

		Products product9 = soldToWholesalers.createProduct("phones", 2500, 6000, 450, "iii", 14);

		storeFacade.addProduct(product9);

		product9.addOrders(customer2, 2, product9, shippingType.STANDARD, "z");
		product9.addOrders(customer2, 3, product9, shippingType.EXPRESS, "zz");
		product9.addOrders(customer2, 4, product9, shippingType.STANDARD, "zzz");
		System.out.println("Example running created successfuly");
	}

	public static void addNewProduct(StoreFacade storeFacade) {
		System.out
				.println("Enter product type (1 - Sold Through Website, 2 - Sold In Store, 3 - Sold To Wholesalers):");
		int productType = s.nextInt();
		s.nextLine();

		System.out.println("Enter product name:");
		String name = s.nextLine();

		System.out.println("Enter cost price:");
		int costPrice = s.nextInt();

		System.out.println("Enter selling price:");
		int sellingPrice = s.nextInt();

		System.out.println("Enter stock quantity:");
		int stock = s.nextInt();
		s.nextLine();

		System.out.println("Enter product serial ID:");
		String serialId = s.nextLine();

		System.out.println("Enter product weight:");
		double weight = s.nextDouble();

		s.nextLine();
		Products product;
		switch (productType) {
		case 1:
			System.out.println("Enter destination country:");
			String country = s.nextLine();
			product = new FactoryThroughWebsite().createProduct(name, costPrice, sellingPrice, stock, country, serialId,
					weight);
			break;
		case 2:
			product = new FactorySoldInStore().createProduct(name, costPrice, sellingPrice, stock, serialId, weight);
			break;
		case 3:
			product = new FactorySoldToWholesalers().createProduct(name, costPrice, sellingPrice, stock, serialId,
					weight);
			break;
		default:
			System.out.println("Invalid product type.");
			return;
		}
		boolean added = storeFacade.addProduct(product);
		if (added) {
			System.out.println("Product added successfully,to see the changes press 8 in the menu.");
		} else {
			System.out.println("A product with this serial ID already exists.");
		}
	}

	public static void removeProduct(StoreFacade storeFacade) {
		if (!storeFacade.hasProducts()) {
			System.out.println("There are no products in the store.");
			return;
		}
		displayAllProductInfo(storeFacade);
		System.out.println("Enter the serial ID of the product to remove:");
		String serialId = s.next();

		boolean removed = storeFacade.removeProduct(serialId);
		if (removed) {
			System.out.println("Product successfully removed,to see the changes press 8 in the menu.");
			s.nextLine();
		} else {
			System.out.println("No product found with the serial ID: " + serialId);
			s.nextLine();
		}
	}

	public static void updateProductDetails(StoreFacade storeFacade, StoreManager storeManager) {
		if (!storeFacade.hasProducts()) {
			System.out.println("There are no products in the store.");
			return;
		}
		displayAllProductInfo(storeFacade);
		System.out.println("Enter product serial ID to update:");
		String serialId = s.next();
		System.out.println("Enter new stock quantity:");
		int newStock = s.nextInt();
		boolean updated = storeManager.updateProductStock(serialId, newStock);
		if (updated) {
			System.out.println("Product updated successfully,to see the changes press 8 in the menu.");
			s.nextLine();
		} else {
			System.out.println("Product not found.");
			s.nextLine();
		}
	}

	public static void displayProductsByType(StoreFacade storeFacade, int type) {
		Iterator<Products> iterator = storeFacade.getProductIterator();
		while (iterator.hasNext()) {
			Products product = iterator.next();
			if (matchesProductType(product, type)) {
				if (type == 1) {
					System.out.println("Serial ID: " + product.getSerialId() + ", Name: " + product.getProductName()
							+ ", Quantity: " + product.getStock() + ", Product price: "
							+ (product.sellingPrice / storeFacade.getDOLLAR_VALUE()) + "$" + " Weight Product: "
							+ product.getWeight());
				} else {
					System.out.println("Serial ID: " + product.getSerialId() + ", Name: " + product.getProductName()
							+ ", Quantity: " + product.getStock() + ", Product price: " + product.sellingPrice + " NIS"
							+ " Weight Product: " + product.getWeight());
				}
			}
		}
	}

	public static boolean matchesProductType(Products product, int type) {
		return (type == 1 && product instanceof SoldThroughWebsite) || (type == 2 && product instanceof SoldInStore)
				|| (type == 3 && product instanceof SoldToWholesalers);
	}

	public static void addNewOrder(StoreFacade storeFacade) {
		if (!storeFacade.hasProducts()) {
			System.out.println("There are no products in the store.");
			return;
		}
		System.out.println("Select product type for the order:");
		System.out.println("1 - Sold Through Website, 2 - Sold In Store, 3 - Sold To Wholesalers");
		int productType = s.nextInt();
		if(productType != 1 && productType != 2 && productType != 3) {
			System.out.println("Invalid choose,please try again");
			s.nextLine();
			return;
		}
		displayProductsByType(storeFacade, productType);

		System.out.println("Enter the serial ID of the product for the order:");
		String serialId = s.next();

		Products product = storeFacade.findProductBySerialId(serialId);
		if (product == null) {
			System.out.println("No product found with the serial ID: " + serialId);
			s.nextLine();
			return;
		}
		System.out.println("Please enter customer name:");
		String customerName = s.next();
		
		System.out.println("Please enter customer mobile");
		String customerMobile = s.next();
		
		System.out.println("Enter the quantity for the order:");
		int quantity = s.nextInt();
		while (quantity > product.getStock()) {
			System.out.println(
					"The quantity of the order is larger then the product's stock, please enter smaller amount of the product:");
			quantity = s.nextInt();
		}
		if (productType == 1) {
			System.out.println("Choose shipping type: 1 for STANDARD, 2 for EXPRESS");
			int shippingChoice = s.nextInt();
			shippingType shippingType = null;

			if (shippingChoice == 1) {
				shippingType = shippingType.STANDARD;
			} else if (shippingChoice == 2) {
				shippingType = shippingType.EXPRESS;
			} else {
				System.out.println("Invalid shipping type selected.");
				s.nextLine();
				return;
			}
			System.out.println("Enter the order ID:");
			String orderId = s.next();
			if (!product.isOrderExist(orderId)) {
				Orders NewOrder = product.addOrders(new Customer(customerName,customerMobile), quantity, product, shippingType,
						orderId);
				if (NewOrder != null) {
					System.out.println("Order added successfully.");
					ShippingDetails shippingDetails = storeFacade.processOrder(NewOrder);
					System.out.println("Your order details:");
					System.out.println("Product price: "
							+ (NewOrder.getProduct().getSellingPrice() * quantity) / storeFacade.getDOLLAR_VALUE()
							+ "$");
					System.out.println("Quantity: " + quantity);
					System.out.println("Customer name: " + NewOrder.getCustomer());
					System.out.println("Shipping Price: " + shippingDetails.getShippingFee() + "$");
					System.out.println("Shipping Type: " + shippingDetails.getShippingType());
					System.out.println("Shipping Company: " + shippingDetails.getShippingCompany());
					System.out.println("Total Order Price: "
							+ (((NewOrder.getProduct().getSellingPrice() * quantity) / storeFacade.getDOLLAR_VALUE())
									+ shippingDetails.getShippingFee() + "$"));
					System.out.println("To see the changes press 8 in the menu.");
				}
			} else {
				System.out.println("An order with this ID already exists.");
			}
		} else {
			System.out.println("Enter the order ID:");
			String orderId = s.next();
			if (!product.isOrderExist(orderId)) {
				Orders NewOrder = product.addOrdersTo(new Customer(customerName, customerMobile), quantity, product, orderId);
				if (NewOrder != null) {
					System.out.println("Order added successfully.");
					System.out.println("Your order details:");
					System.out.println("Product price: " + NewOrder.getProduct().getSellingPrice() + " NIS");
					System.out.println("Quantity: " + quantity);
					System.out.println("Customer name: " + NewOrder.getCustomer());
					System.out.println(
							"Total Order Price: " + (NewOrder.getProduct().getSellingPrice() * quantity) + " NIS");
					System.out.println("To see the changes press 8 in the menu.");
				}
			} else {
				System.out.println("An order with this ID already exists.");
			}
		}
		s.nextLine();

	}

	public static void displayOrdersList(StoreFacade storeFacade) {
		Iterator<Products> iterator = storeFacade.getProductIterator();

		if (!iterator.hasNext()) {
			System.out.println("There are no orders in the store.");
			return;
		}
		while (iterator.hasNext()) {
			Products product = iterator.next();
			product.displayOrderInfo(storeFacade);
			System.out.println("----------------------");
		}

	}

	public static void undoAllLastOrder(StoreFacade storeFacade) {
		if (!storeFacade.hasOrders()) {
			System.out.println("There are no Orders for this product.");
			return;
		}
		displayOrdersList(storeFacade);
		System.out.println("Enter the serial ID of the product for which to undo the last order:");
		String serialId = s.next();

		Products product = storeFacade.findProductBySerialId(serialId);
		if (product == null) {
			System.out.println("No product found with the serial ID: " + serialId);
			s.nextLine();
			return;
		}

		if (product.undoLastOrder()) {
			s.nextLine();
		} else {
			System.out.println("There are no orders to undo for this product.");
		}
	}

	public static void displayAllProductDetails(StoreFacade storeFacade) {
		if (!storeFacade.hasProducts()) {
			System.out.println("There are no products in the store.");
			return;
		}
		displayAllProductInfo(storeFacade);
		System.out.println("Enter the serial ID of the product:");
		String serialId = s.next();

		Products product = storeFacade.findProductBySerialId(serialId);
		if (product == null) {
			System.out.println("No product found with the serial ID: " + serialId);
			s.nextLine();
			return;
		}
		product.displayProductDetails();
		System.out.println("----------------------");
		if (product instanceof SoldThroughWebsite) {
			for (Orders order : product.getOrdersList()) {
				ShippingDetails shippingDetails = storeFacade.processOrder(order);
				System.out.println("Shipping Type: " + shippingDetails.getShippingType());
				System.out.println("Shipping Company: " + shippingDetails.getShippingCompany());
				System.out.println("Shipping Fee: " + shippingDetails.getShippingFee() + "$");
				System.out.println("----------------------");
			}
		} else if (product instanceof SoldInStore) {
			SoldInStore inStoreProduct = (SoldInStore) product;
			for (Orders order : product.getOrdersList()) {
				Customer customer = order.getCustomer();
				int quantity = order.getAmount();
				inStoreProduct.generateInvoiceCustomer(product, customer, quantity);
				inStoreProduct.generateInvoiceAccountant(product, quantity);
			}
		} else if (product instanceof SoldToWholesalers) {
			SoldToWholesalers wholesalerProduct = (SoldToWholesalers) product;
			for (Orders order : product.getOrdersList()) {
				int quantity = order.getAmount();
				wholesalerProduct.generateInvoiceAccountant(product, quantity);
			}
		}
		s.nextLine();
	}

	public static int calculateProductProfit(Products product) {
		int productProfit = 0;
		for (Orders order : product.getOrdersList()) {
			int profitPerOrder = (order.getAmount() * (product.getSellingPrice() - product.getCostPrice()));
			productProfit += profitPerOrder;
		}
		return productProfit;
	}

	public static void displayAllProductDetailsAndTotalProfit(StoreFacade storeFacade) {
		Iterator<Products> iterator = storeFacade.getProductIterator();
		int totalStoreProfit = 0;

		if (!iterator.hasNext()) {
			System.out.println("There are no products in the store.");
			return;
		}

		while (iterator.hasNext()) {
			Products product = iterator.next();
			product.displayProductDetails();
			totalStoreProfit += calculateProductProfit(product);
			System.out.println("----------------------");
		}
		System.out.println("Total Profit for the Store: " + totalStoreProfit);
	}

	public static void displayAllProductInfo(StoreFacade storeFacade) {
		Iterator<Products> iterator = storeFacade.getProductIterator();

		if (!iterator.hasNext()) {
			System.out.println("There are no products in the store.");
			return;
		}
		while (iterator.hasNext()) {
			Products product = iterator.next();
			product.displayProductInfo();
			System.out.println("----------------------");
		}
	}

	public static void displayProductOrdersAndProfit(StoreFacade storeFacade) {
		if (!storeFacade.hasProducts()) {
			System.out.println("There are no products in the store.");
			return;
		}
		displayAllProductInfo(storeFacade);
		System.out.println("Enter the serial ID of the product:");
		String serialId = s.next();

		Products product = storeFacade.findProductBySerialId(serialId);
		if (product == null) {
			System.out.println("No product found with the serial ID: " + serialId);
			s.nextLine();
			return;
		}

		int totalProfit = 0;
		if (product instanceof SoldThroughWebsite) {
			for (Orders order : product.getOrdersList()) {
				int profitPerOrder = order.getAmount() * (product.getSellingPrice() - product.getCostPrice());
				System.out.println("Order ID: " + order.getOrderId() + ", customer: " + order.getCustomer() + ", Profit: "
						+ (profitPerOrder / storeFacade.getDOLLAR_VALUE()) + "$");
				totalProfit += (profitPerOrder / storeFacade.getDOLLAR_VALUE());
			}
			System.out.println("Total Profit from All Orders of this Product: " + totalProfit + "$");

		} else {
			for (Orders order : product.getOrdersList()) {
				int profitPerOrder = order.getAmount() * (product.getSellingPrice() - product.getCostPrice());
				System.out.println("Order ID: " + order.getOrderId() + ", customer: " + order.getCustomer() + ", Profit: " + profitPerOrder + " NIS");
				totalProfit += profitPerOrder;
			}
			System.out.println("Total Profit from All Orders of this Product: " + totalProfit + " NIS");
		}
		s.nextLine();
	}

	public static void backupSystem(StoreFacade storeFacade) {
		backup = storeFacade.saveToMemento();
		System.out.println("System state has been backed up.");
	}

	public static void restoreSystem(StoreFacade storeFacade) {
		if (backup != null) {
			storeFacade.restoreMemento(backup);
			System.out.println("System state has been restored to the last backup.");
		} else {
			System.out.println("No backup found.");
		}
	}

	public static void main(String[] args) {

		StoreFacade storeFacade = StoreFacade.getInstance();
		StoreManager storeManager = new StoreManager(storeFacade);

		String choice;
		do {
			printMenu();
			choice = s.nextLine();
			switch (choice) {
			case "1":
				initializeData(storeFacade);
				break;
			case "2":
				addNewProduct(storeFacade);
				break;
			case "3":
				removeProduct(storeFacade);
				break;
			case "4":
				updateProductDetails(storeFacade, storeManager);
				break;
			case "5":
				addNewOrder(storeFacade);
				break;
			case "6":
				undoAllLastOrder(storeFacade);
				break;
			case "7":
				displayAllProductDetails(storeFacade);
				break;
			case "8":
				displayAllProductDetailsAndTotalProfit(storeFacade);
				break;
			case "9":
				displayProductOrdersAndProfit(storeFacade);
				break;
			case "10":
				System.out.println("1 - Backup, 2 - Restore");
				int subChoice = s.nextInt();
				s.nextLine();
				if (subChoice == 1) {
					backupSystem(storeFacade);
				} else if (subChoice == 2) {
					restoreSystem(storeFacade);
				}
				break;
			case "E":
			case "e":
				System.out.println("Thank you for visiting our store see you next time,Good Bye :)");
				break;
			default:
				if (!choice.equalsIgnoreCase("e") && !choice.equalsIgnoreCase("E"))
					System.out.println("Wrong option. Please try again:\n");
			}
		} while (!choice.equalsIgnoreCase("e") && !choice.equalsIgnoreCase("E"));

	}

}

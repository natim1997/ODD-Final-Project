package daniel_gerbi_natanel_michel7;

public class SoldInStore extends Products implements Invoice {

	public SoldInStore(String productName, int costPrice, int sellingPrice, int stock,String serialId,double weight) {
		super(productName, costPrice, sellingPrice, stock,serialId, weight);
	}
	public void generateInvoiceCustomer(Products product, Customer customer, int quantity) {
        double sumPrice = product.getSellingPrice() * quantity;
        double vat = sumPrice * 0.17;
        double sumPriceWithVat = sumPrice + vat;
        System.out.println("Customer Name : " + customer.getCustomerName());
        System.out.println("The Product is : " + product.getProductName());
        System.out.println("The Quantity is : " + quantity);
        System.out.println("sum Price (₪) (including VAT): " + sumPriceWithVat);
        System.out.println("----------------------");
    }
	@Override
    public void generateInvoiceAccountant(Products product, int quantity) {
        int sumCost = product.getCostPrice() * quantity;
        int sumRevenue = product.getSellingPrice() * quantity;
        int profit = sumRevenue - sumCost;
        System.out.println("The Product is : " + product.getProductName());
        System.out.println("Quantity Sold: " + quantity);
        System.out.println("sum Revenue (₪): " + sumRevenue);
        System.out.println("Total Cost (₪): " + sumCost);
        System.out.println("Profit (₪): " + profit);
        System.out.println("----------------------");
	}
}

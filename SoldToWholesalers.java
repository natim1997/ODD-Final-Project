package daniel_gerbi_natanel_michel7;

public class SoldToWholesalers extends Products implements Invoice {

	public SoldToWholesalers(String product_name, int cost_price, int selling_price, int stock,String serialId,double weight) {
		super(product_name, cost_price, selling_price, stock,serialId,weight);
		
	}
	@Override
	public void generateInvoiceAccountant(Products product, int quantity) {
        int sumCost = product.getCostPrice() * quantity;
        int sumRevenue = product.getSellingPrice() * quantity;
        int profit = sumRevenue - sumCost;
        System.out.println("The Product is : " + product.getProductName());
        System.out.println("Quantity Sold: " + quantity);
        System.out.println("Total Revenue (₪): " + sumRevenue);
        System.out.println("Total Cost (₪): " + sumCost);
        System.out.println("Profit (₪): " + profit);
        System.out.println("----------------------");
    }
}

package daniel_gerbi_natanel_michel7;

public class FactoryThroughWebsite {
	public  Products createProduct(String productName, int costPrice, int sellingPrice, int stock,
			String dest_country,String serialId,double weight) {
		return new SoldThroughWebsite(productName, costPrice, sellingPrice, stock, dest_country, serialId,weight);
        }
    }


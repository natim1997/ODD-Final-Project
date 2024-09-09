package daniel_gerbi_natanel_michel7;


import java.util.Set;
import java.util.TreeSet;

public class ProductManager {
    private Set<Products> products;

    private StoreFacade storeFacade;
    
    public ProductManager(StoreFacade storeFacade) {
        this.products = new TreeSet<>();
        this.storeFacade = storeFacade;
    }

    public boolean updateProduct(String serialId, int newStock) {
        for (Products product : products) {
            if (product.getSerialId().equals(serialId)) {
                product.setStock(newStock);
                return true;
            }
        }
        return false;
    } 
    
    public boolean addProduct(Products product,StoreFacade storeFacade) {
		boolean flagAdded = storeFacade.getProductsList().add(product);
		if (!flagAdded) {
			System.out.println("Product with ID " + product.getSerialId() + " already exists.");
		}
		return flagAdded;
	}

    public boolean removeProduct(String serialId) {
        return products.removeIf(product -> product.getSerialId().equals(serialId));
    }
    
    public Set<Products> getProducts() {
        return products;
    }
    public boolean updateStock(int orderedQuantity,Products product) {
		if (product.getStock() >= orderedQuantity) {
			product.setStock(product.getStock() - orderedQuantity);
			return true;
		}
		return false;
	}
}
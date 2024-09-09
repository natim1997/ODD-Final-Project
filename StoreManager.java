package daniel_gerbi_natanel_michel7;

import java.util.Iterator;

public class StoreManager {

    private StoreFacade storeFacade;

    public StoreManager(StoreFacade storeFacade) {
        this.storeFacade = storeFacade;
    }

    public boolean addProduct(Products product) {
        return storeFacade.getProductsList().add(product);
    }

    public boolean removeProduct(String serialId) {
        return storeFacade.getProductsList().removeIf(product -> product.getSerialId().equals(serialId));
    }
    public boolean updateProductStock(String serialId, int newStock) {
        Products product = findProductBySerialId(serialId);
        if (product != null) {
            product.setStock(newStock);
            return true;
        }
        return false;
    }

    public Products findProductBySerialId(String serialId) {
        for (Products product : storeFacade.getProductsList()) {
            if (product.getSerialId().equals(serialId)) {
                return product;
            }
        }
        return null;
    }

    public boolean undoLastOrder(String serialId) {
        Products product = findProductBySerialId(serialId);
        return product != null && product.undoLastOrder();
    }

    public void displayAllProductDetails() {
        for (Products product : storeFacade.getProductsList()) {
            product.displayProductDetails();
            System.out.println("----------------------");
        }
    }

    public void displayProductInfo() {
        Iterator<Products> iterator = storeFacade.getProductsList().iterator();
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
}
package daniel_gerbi_natanel_michel7;

import java.util.Set;
import java.util.TreeSet;

public class StoreMemento {
	private Set<Products> products;

	public StoreMemento(Set<Products> products) {
		this.products = new TreeSet<>(products);
		for (Products product : products) {
			this.products.add(product.clone());
		}
	}

	Set<Products> getState() {
		return products;
	}
}
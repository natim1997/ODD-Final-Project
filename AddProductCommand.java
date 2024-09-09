package daniel_gerbi_natanel_michel7;

public class AddProductCommand implements Command {
	private ProductManager productManager;
	private Products product;
	private StoreFacade storeFacade;

	public AddProductCommand(ProductManager productManager, Products product) {
		this.productManager = productManager;
		this.product = product;
	}

	@Override
	public boolean execute() {
		boolean add = productManager.addProduct(product, storeFacade);
		if (!add) {
			System.out.println("Product with ID " + product.getSerialId() + " already exists.");
		}
		return add;
	}
}

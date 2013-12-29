/* This class, when implemented, will describe a product which consists of vehicles or
 * accessories. It will contain both vehicles and accessories in one array list making
 * the order class a lot more easy to follow! */

public abstract class Product {
	
	String productName; // Product name for vehicle is the model, for accessory it is explainatory...
	String infoTxt; // Informational text about the product, some kind of description...
	int price; // The price of the product...
	
	public Product(String productName, String infoTxt, int price) {
		this.productName = productName;
		this.infoTxt = infoTxt;
		this.price = price;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getInfoTxt() {
		return infoTxt;
	}

	public void setInfoTxt(String infoTxt) {
		this.infoTxt = infoTxt;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}

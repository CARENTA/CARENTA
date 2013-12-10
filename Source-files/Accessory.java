
public class Accessory {
	private String productNbr;
	private int price;
	private String name;
	private String info;
	// Skapar alla variablar för subklassen Accessory som är en subklass till Product.

	public Accessory(String productNbr, int price, String name, String info){
		this.productNbr = productNbr;
		this.price = price;
		this.name = name;
		this.info = info;
	}

	public String getProductNbr() {
		return productNbr;
	}
	public void setProductNbr(String productNbr) {
		this.productNbr = productNbr;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}

	// Skapar getter och setter.
}

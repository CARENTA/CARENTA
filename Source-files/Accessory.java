
/* This class describes an accessory with the following attributes and methods! */

public class Accessory extends Product {

	private int productNbr;
	private String name;
	private int price;
	private String info;

	public Accessory(int productNbr, String name, int price, String info) {
		this.productNbr = productNbr;
		this.name = name;
		this.price = price;
		this.info = info;
	}

	public int getProductNbr() {
		return productNbr;
	}
	public void setProductNbr(int productNbr) {
		this.productNbr = productNbr;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
}

/* This class describes an accessory with the following attributes and methods! */

public class Accessory extends Product {

	private int productNbr; // Used for identifying which product...

	public Accessory(int productNbr, String productName, int price, String infoTxt) {
		
		super(productName, infoTxt, price); // Heritage...
		
		this.productNbr = productNbr;
	}

	public int getProductNbr() {
		return productNbr;
	}

	public void setProductNbr(int productNbr) {
		this.productNbr = productNbr;
	}
}

package omsa.aksesuarlar;

public class Araclar {

	private int id;
	private String price;
	private String brand;
	private String product;
	private int no;
	
	public Araclar() {
		super();
	}
	
	public Araclar(int no, int id, String price, String brand, String product) {
		super();
		this.no = no;
		this.id = id;
		this.price = price;
		this.brand= brand;
		this.product = product;
	}
	
	public int getId() {
		return id;
	}
	public String getPrice() {
		return price;
	}
	public String getBrand() {
		return brand;
	}
	public String getProduct() {
		return product;
	}
	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return no + " id = " + id + ", Fiyat = " + price + ", Marka = " + brand + ", Ürün = " + product + "\n";
	}

	
}
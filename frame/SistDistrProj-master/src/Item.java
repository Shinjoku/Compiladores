import java.sql.Date;

public class Item {
	private String name;
	private int id;
	private int quant;
	private float price;
	private float unitValor;
	
	public Item(int id, String name, int quant, float price, float unitValor) {
		this.name = name;
		this.id = id;
		this.quant = quant;
		this.price = price;
		this.unitValor = unitValor;
	}

	
	public String getName() {
		return this.name;
	}
	
	public int getId() {
		return this.id;
	}
	
	public int getQuant() {
		return this.quant;
	}
	
	public void addQuant(int number) {
		this.quant = this.quant + number;
	}
	
	public void subQuant(int number) {
		this.quant = this.quant - number;
	}
	
	public float getPrice() {
		return this.price;
	}
	
	public void setPrice(float newPrice) {
		this.price = newPrice;
	}
	
	public float getValor() {
		return this.unitValor;
	}
	
	public void setValor(float newValor) {
		this.unitValor = newValor;
	}
}

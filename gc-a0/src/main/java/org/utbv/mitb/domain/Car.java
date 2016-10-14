package org.utbv.mitb.domain;

public class Car {

	public String id;
	public String model;
	public int year;
	public String manufacturer;
	public String color;
	public int price;
	public boolean sold;
	private String brand;

	public Car(String model, int year, String manufacturer, String color) {
		this.model = model;
		this.year = year;
		this.manufacturer = manufacturer;
		this.color = color;
	}

	public Car(String model, int year, String manufacturer, String color, int price, boolean sold) {
		this(model, year, manufacturer, color);
		this.price = price;
		this.sold = sold;
	}

	public Car(String randomId, String randomBrand, int randomYear, String randomColor, int randomPrice,
			boolean randomSoldState) {
		this.id = randomId;
		this.setBrand(randomBrand);
		this.year = randomYear;
		this.color = randomColor;
		this.price = randomPrice;
		this.sold = randomSoldState;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isSold() {
		return sold;
	}

	public void setSold(boolean sold) {
		this.sold = sold;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;

		if (!(obj instanceof Car))
			return false;

		Car compare = (Car) obj;

		return compare.model.equals(this.model);
	}

	@Override
	public int hashCode() {
		int hash = 1;

		return hash * 31 + model.hashCode();
	}

	@Override
	public String toString() {
		return "Car{" + "model=" + model + ", year=" + year + ", manufacturer=" + manufacturer + ", color=" + color
				+ ", price=" + price + '}';
	}
}

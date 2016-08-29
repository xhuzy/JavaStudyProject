import java.util.Date;

public class Car {
	private String color;
	private double weight;
	private Date createDate;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	private String driveCar(double speed,String str) {
		String result = "My car color" + this.color + ",can run with speed: " + speed;

		return result;
	}
}


public class Car {
	private String name;
	private String brand;
	private String model;
	private int power;
	private double weight;
	private double speed;
	private double distance;
	//constructors
	public Car(String brand,String model,int power,double weight,int id) {
		this.name="Car n. "+id;
		this.brand=brand;
		this.model=model;
		this.power=power;
		this.weight=weight;
		this.speed=0.0;
		this.distance=0;
	}
	public Car(Car c) {
		this.name=c.name;
		this.brand=c.brand;
		this.model=c.model;
		this.power=c.power;
		this.weight=c.weight;
		this.speed=0.0;
		this.distance=0;
	}
	//getters and setters
	public String getName() {
		return name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance+=distance;
	}
	//methods
	public void accelleration() {
			this.speed+=((power/weight)*100);
			distancePerMinute();
	}
	public void braking() {
		if(distance>0) {
			this.speed-=(weight/100);
			distancePerMinute();
		}
	}
	public void distancePerMinute() {
		this.distance+=(this.speed*0.016);
	}
	public String toString() {
		return "name=" + name + ", brand=" + brand + ", model=" + model + ", power=" + power + ", weight=" + weight;
	}
}

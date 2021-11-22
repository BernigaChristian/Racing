import java.util.ArrayList;
import java.util.Random;

public class Track {
	private String name;
	private int distance;
	Car cars[];
	//private ArrayList<Car> cars=new ArrayList<>();
	//constructors
	public Track(String name,int distance,Car subscriptions[]) {
		this.name=name;
		this.distance=distance;
		//ARRAY VERSION
		cars=new Car[subscriptions.length];
		for(int i=0;i<subscriptions.length;i++)
			cars[i]=new Car(subscriptions[i]);
		//ARRAYLIST VERSION
		/*for(int i=0;i<subscriptions.length;i++)
			cars.add(new Car(subscriptions[i]));*/
	}
	public Track(Track t){
		this.name=t.name;
		this.distance=t.distance;
		cars=new Car[t.cars.length];
		for(int i=0;i<cars.length;i++)
			cars[i]=new Car(t.cars[i]);
	}
	//getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	//methods
	public int add(Car c){
		for(int i=0;i<cars.length;i++){
			if(cars[i]==null){
				cars[i]=c;
				return i;
			}
		}
		return -1;
	}
	public int remove(int index){
		if(index>= cars.length||index<0)
			return -1;
		cars[index]=null;
		return index;
	}
	public int searchCarsByBrand(String brand){
		int counter=0;
		for(int i=0;i<cars.length;i++){
			if(cars[i]!=null&&cars[i].getBrand().equalsIgnoreCase(brand))
				counter++;
		}
		return counter;
	}
	public String[] searchBrand(String brand){
		int k=0;
		String list[]=new String[searchCarsByBrand(brand)];
		for(int i=0;i<list.length;i++){
			if(cars[i]!=null&&cars[i].getBrand().equalsIgnoreCase(brand)){
				list[k]=cars[i].getName();
				k++;
			}
		}
		return list;
	}
	//ARRAYLIST RACESIMULATION VERSION
	public void raceSimulation() {
		while(cars[0].getDistance()<distance) {
			for(int i=0;i<cars.length;i++) {
				if(new Random().nextInt(2)==1)
					cars[i].accelleration();
				else
					cars[i].braking();
				sort();
			}
			//showDistances();
		}
	}
	//ARRAYLIST RACESIMULATION VERSION
	/*public void raceSimulation() {
		while(cars.get(0).getDistance()<distance) {
			for(int i=0;i<cars.size();i++) {
				if(new Random().nextInt(2)==1)
					cars.get(i).accelleration();
				else
					cars.get(i).braking();
				sort();
			}
			//showDistances();
		}
	}*/
	//ARRAYLIST SORT VERSION
	public void sort() {
		Car temp;
		for(int i=0;i<cars.length;i++) {
			for(int j=0;j<cars.length-1;j++) {
				if(cars[j].getDistance()<cars[j+1].getDistance()) {
					temp=cars[j];
					cars[j]=cars[j+1];
					cars[j+1]=temp;
				}
			}
		}
	}
	//ARRAYLIST SORT VERSION
	/*public void sort() {
		Car temp;
		for(int i=0;i<cars.size();i++) {
			for(int j=0;j<cars.size()-1;j++) {
				if(cars.get(j).getDistance()<cars.get(j+1).getDistance()) {
					temp=cars.get(j);
					cars.set(j,cars.get(j+1));
					cars.set(j+1,temp);
				}
			}
		}
	}*/
	//ARRAY SHOWDISTANCE VERSION
	public void showDistances() {
		System.out.println("VIRTUAL RACE RANKING");
		for(int i=0;i<cars.length;i++) {
			System.out.println(cars[i].getName()+": "+cars[i].getDistance()+" km");
		}
		System.out.println("\n");
	}
	//ARRAYLIST SHOWDISTANCE VERSION
	/*public void showDistances() {
		System.out.println("VIRTUAL RACE RANKING");
		for(int i=0;i<cars.size();i++) {
			System.out.println(cars.get(i).getName()+": "+cars.get(i).getDistance()+" km");
		}
		System.out.println("\n");
	}*/
	//ARRAY WINNER VERSION
	public Car winner() {
		raceSimulation();
		return cars[0];
	}
	//ARRAYLIST WINNER VERSION
	/*public Car winner() {
		raceSimulation();
		return cars.get(0);
	}*/
	//ARRAYLIST RANKING VERSION
	public String ranking(){
		String ranking="RACE RESULTS\n";
		for(int i=0;i< cars.length;i++)
			ranking+=((i+1)+" position: "+cars[i].getName()+"\n");
		return ranking;
	}
	//ARRAYLIST RANKING VERSION
	/*public String ranking(){
		String ranking="RACE RESULTS\n";
		for(int i=0;i< cars.size();i++)
			ranking+=((i+1)+" position: "+cars.get(i).getName()+"\n");
		return ranking;
	}*/
	public String toString(){return "TRACK: "+name+"\nLENGTH: "+distance+"\nWINNER: "+winner().toString();}
}

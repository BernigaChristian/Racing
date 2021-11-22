import java.util.Random;
public class Main {
	public static void carSubscription(Car cars[]){
		String models[]= {"Panda","Punto","A1","A3","A3 Sportback","Model S"};
		String brands[]= {"Fiat","Fiat","Audi","Audi","Audi","Tesla"};
		int power[]= {90,70,180,224,240,670};
		int weight[]= {980,1025,1175,1295,1300,2500};
		for(int i=0;i<brands.length;i++){
			cars[i]=new Car(brands[i],models[i],power[i],weight[i],i);
		}
	}
	public static void main(String[] args) {
		Track tracks[]=new Track[5];
		String trackNames[]={"Monte Carlo","Monza","Spa","Baku","Suzuka"};
		Car cars[]=new Car[6];
		carSubscription(cars);
		for(int i=0;i<tracks.length;i++){
			tracks[i]=new Track(trackNames[i],(new Random().nextInt(3)+3)*60,cars);	//avarage f1 track length: 3/4 km, avarage f1 race laps:60);
			System.out.println(tracks[i].toString()+"\n"+tracks[i].ranking()+"\n\n");
		}
	}
}


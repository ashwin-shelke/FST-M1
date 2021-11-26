package activities;

public class Car {
	
	String color;
	String transmission;
	int make;
	int tyres;
	int doors;
	Car(){
		tyres=4;
		doors=4;
	}
	
	public void displayCharacteristics() {
		System.out.println("Color of the car is "+color);
		System.out.println("Transmission of the car "+transmission);
		System.out.println("make of car is "+make);
		System.out.println("Number of tyres "+tyres);
		System.out.println("Number of doors "+doors);
	}
	public void accelarate() {
		System.out.println("Car is moving forward.");
	}
	
	public void brake() {
		System.out.println("Car has stopped.");
	}

}

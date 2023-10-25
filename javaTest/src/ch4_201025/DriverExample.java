package ch4_201025;

public class DriverExample {
	public static void main(String[] args) {
		Driver driver = new Driver();
		
		Bus bus = new Bus();
		driver.drive(bus); // driver.drive(new Bus()); 와 동일
		
		Taxi taxi = new Taxi();
		driver.drive(taxi); // driver.drive(new Taxi()); 와 동일
		
		Train train = new Train();
		driver.drive(train);
	}
}

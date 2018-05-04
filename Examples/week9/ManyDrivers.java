public class ManyDrivers {

    public static void main(String[] args) {

	Vehicle theCar = new Vehicle(10,30);

	(new Driver(theCar)).start();
	(new Driver(theCar)).start();
	(new Driver(theCar)).start();
	(new Driver(theCar)).start();
    }

}
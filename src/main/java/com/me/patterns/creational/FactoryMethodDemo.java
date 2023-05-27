/**
 * Goal:
 *     Define a (factory) method to create objects without specifying of which class. Instead of
 *     calling directly its constructor, we let the factory decide which object to initialise.
 * Use cases:
 *     - Simple object initialisation (few parameters).
 *     - If we expect the implementation of the interface to frequently change.
 */


import java.util.Scanner;
import java.io.IOException;

interface Car {
    void drive();
}

class SportCar implements Car {

    @Override
    public void drive() {
        System.out.println("Vroooom");
    }
}

class FamilyCar implements Car {

    @Override
    public void drive() {
        System.out.println("Brum brum");
    }
}

class CarFactory {

    public Car getCar(String type) throws IOException {
        if (type.equalsIgnoreCase("SPORT")) {
            return new SportCar();
        } else if (type.equalsIgnoreCase("FAMILY")) {
            return new FamilyCar();
        } else {
            throw new IOException("Car type is not valid.");
        }
    }
}

public class FactoryMethodDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which car type to do you want?");
        String carType = scanner.nextLine();
        CarFactory factory = new CarFactory();
        try {
            Car car = factory.getCar(carType);
            car.drive();
        } catch (IOException e) {
            System.out.println(e);
        }
        scanner.close();
    }
}
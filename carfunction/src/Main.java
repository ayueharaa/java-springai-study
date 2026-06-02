package carfunction.src;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Car car1 = new Car();

        car1.isRunning = false;
        car1.speed = 0;
        car1.gear = 0;

        new Main().menu(sc, car1);

    }

    public void menu (Scanner sc, Car car) {
        while(true) {
            System.out.println("1. Toggle Car On/Off");
            System.out.println("2. Increase Speed");
            System.out.println("3. Decrease Speed");
            System.out.println("4. Change Direction");
            System.out.println("5. Get Speed");
            System.out.println("6. Exit");

            int choice = sc.nextInt();

            switch(choice) {
                case 1:
                    toggleIsRunning(car);
                    break;
                case 2:
                    System.out.print("Enter speed increment: ");
                    int increment = sc.nextInt();
                    increaseSpeed(car, increment);
                    break;
                case 3:
                    System.out.print("Enter speed decrement: ");
                    int decrement = sc.nextInt();
                    decreaseSpeed(car, decrement);
                    break;
                case 4:
                    System.out.print("Enter direction (left/right): ");
                    String direction = sc.next();
                    changeDirection(car, direction);
                    break;
                case 5:
                    getSpeed(car);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            replayMenu(sc, car);
        }
    }

    public void replayMenu(Scanner sc, Car car) {
        System.out.println("Do you want to replay the menu? (yes/no)");
        String replayChoice = sc.next();
        if(replayChoice.equalsIgnoreCase("yes")) {
            menu(sc, car);
        } else {
            System.out.println("Goodbye!");
        }
    }

    public void toggleIsRunning(Car car) {
        car.toggleIsRunning();
    }

    public void increaseSpeed(Car car, int increment) {
        car.increaseSpeed(increment);
    }

    public void decreaseSpeed(Car car, int decrement) {
        car.increaseSpeed(-decrement);
    }

    public void changeDirection (Car car, String direction) {
        if(car.speed == 0) {
            System.out.println("Car is stationary. Cannot change direction.");
        } else if (car.speed > 40) {
            System.out.println("Car is moving too fast to change direction safely.");
        } else {
            System.out.println("Changing direction to " + direction);
        }
    }

    public void getSpeed(Car car) {
        car.getSpeed();
    }
}
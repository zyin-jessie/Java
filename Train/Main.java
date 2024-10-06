import java.util.*;

public class Main {
    public static void main(String[] args) {
        Train train = new Train();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.print("Function Available: ");
            System.out.println("\n[1] Add Car");
            System.out.println("[2] Remove Car");
            System.out.println("[3] Switch Cars");
            System.out.println("[4] Load Cargo");
            System.out.println("[5] Unload Cargo");
            System.out.println("[6] Display Train");
            System.out.println("[7] Exit");
            System.out.print("Choose Function: ");

       int choice = scanner.nextInt();
       switch (choice) {
            case 1:
                train.addCar();
                break;
            case 2:
                System.out.print("Enter car number to remove: ");
                int removeNumber = scanner.nextInt();
                train.removeCar(removeNumber);
                break;
            case 3:
                System.out.print("Choose first car number to switch: ");
                int car1 = scanner.nextInt();
                System.out.print("Choose second car number to switch: ");
                int car2 = scanner.nextInt();
                train.switchCars(car1, car2);
                break;
            case 4:
                System.out.print("Choose car number to load cargo: ");
                int loadCar = scanner.nextInt();
                System.out.print("Choose cargo: ");
                String cargo = scanner.next();
                train.loadCargo(loadCar, cargo);
                break;
            case 5:
                System.out.print("Enter car number to unload cargo: ");
                int unloadCar = scanner.nextInt();
                train.unloadCargo(unloadCar);
                break;
            case 6:
                train.displayTrain();
                break;
            case 7:
                exit = true;
                break;
            default:
                System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
}

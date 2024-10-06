public class Train {
    TrainCar engine;
    int carCount;

    public Train() {
        engine = new TrainCar(0, "ENGINE");
        carCount = 1;
    }

    public void addCar() {
        TrainCar newCar = new TrainCar(carCount, "EMPTY");
        TrainCar current = engine;

        while (current.next != null) {
            current = current.next;
        }
        current.next = newCar;
        carCount++;
    }

    public void removeCar(int carNumber) {
        if (carNumber == 0) {
            System.out.println("Cannot remove the engine.");
            return;
        }

        TrainCar current = engine;
        TrainCar prev = null;

        while (current != null && current.carNumber != carNumber) {
            prev = current;
            current = current.next;
        }

        if (current != null) {
            prev.next = current.next;
            renumberCars();
            carCount--;
        } else {
            System.out.println("Car number " + carNumber + " not found.");
        }
    }

    private void renumberCars() {
        TrainCar current = engine.next;
        int newNumber = 1;

        while (current != null) {
            current.carNumber = newNumber;
            newNumber++;
            current = current.next;
        }
    }

    public void switchCars(int car1, int car2) {
        if (car1 == 0 || car2 == 0) {
            System.out.println("Cannot switch the engine.");
            return;
        }

        TrainCar carA = null, carB = null;
        TrainCar current = engine;

        while (current != null) {
            if (current.carNumber == car1) carA = current;
            if (current.carNumber == car2) carB = current;
            current = current.next;
        }

        if (carA != null && carB != null) {
            int tempNumber = carA.carNumber;
            String tempCargo = carA.cargo;

            carA.carNumber = carB.carNumber;
            carA.cargo = carB.cargo;

            carB.carNumber = tempNumber;
            carB.cargo = tempCargo;
        } else {
            System.out.println("One or both cars not found.");
        }
    }

    public void loadCargo(int carNumber, String cargo) {
        TrainCar current = engine;

        while (current != null && current.carNumber != carNumber) {
            current = current.next;
        }

        if (current != null) {
            current.cargo = cargo;
        } else {
            System.out.println("Car number " + carNumber + " not found.");
        }
    }

    public void unloadCargo(int carNumber) {
        TrainCar current = engine;

        while (current != null && current.carNumber != carNumber) {
            current = current.next;
        }

        if (current != null) {
            current.cargo = "EMPTY";
        } else {
            System.out.println("Car number " + carNumber + " not found.");
        }
    }

    public void displayTrain() {
        TrainCar current = engine;

        while (current != null) {
            System.out.print(current.carNumber + "[" + current.cargo + "]");
            if (current.next != null) {
                System.out.print(" || ");
            }
            current = current.next;
        }
        System.out.println();
    }
}

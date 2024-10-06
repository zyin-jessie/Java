public class TrainCar {
    int carNumber;
    String cargo;
    TrainCar next;

    public TrainCar(int carNumber, String cargo) {
        this.carNumber = carNumber;
        this.cargo = cargo;
        this.next = null;
    }
}

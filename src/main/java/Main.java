import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        race.cars();
        System.out.println("Победитель гонки: " + race.winner());
    }
}

class Car {
    String name;
    int speed;
    Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }
}

class race {
    static ArrayList<Car> carList;
    static void cars() {
        carList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int num = 1;
        while (carList.size() < 3) {

            System.out.println("Введите название автомобиля №" + num + ": ");
            String name = scanner.next();

            while (true) {
                System.out.println("Введите скорость автомобиля №" + num + ": ");
                Scanner scannerSpeed = new Scanner(System.in);
                if (scannerSpeed.hasNextInt()) {
                    int speed = scannerSpeed.nextInt();
                    if (speed <= 250 && speed > 0) {
                        Car car = new Car(name, speed);
                        carList.add(car);
                        num += 1;
                        break;
                    } else {
                        System.out.println("Скорость должна быть от 0 до 250. Попробуйте ещё раз.");
                    }
                } else {
                    System.out.println("Введена некорректая скорость. Попробуйте ещё раз.");
                }
            }
        }

    }
    static String winner() {
        String raceWinner;

        ArrayList<Integer> distanceResults = new ArrayList<>();
        for (int i = 0; i <= 2; i++) {
            int distanceCar = carList.get(i).speed * 24;
            distanceResults.add(distanceCar);
        }
        int indexOfWinner = distanceResults.indexOf(Collections.max(distanceResults));

        raceWinner = carList.get(indexOfWinner).name;

        return raceWinner;
    }
}


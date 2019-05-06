import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Car car;
        Scanner in = new Scanner(System.in);
        char direction;
        char vehicleStatus;

        System.out.println("Wybierz rodzaj pojazdu c - samochód, t - czołg ");
        if(in.next().charAt(0) == 'c'){
            car = new Car();
        }
        else {
            car = new Tank();
        }

        do{
            car.getPrintBoard();
            System.out.println("Poziom paliwa " + car.getFuel());
            System.out.println("wybierz kierunek jazdy \n 'l' - lewo \n 'p' - prawo \n 'd' - dół \n 'g' - góra");
            direction = in.next().charAt(0);
            vehicleStatus = car.move(direction);

            if (vehicleStatus == 'b'){
                System.out.println("Krawędź planszy, wybierz inny kierunek");
                continue;
            }
            else if(vehicleStatus == 'p'){
                System.out.println("Osiągnąłeś cel, dodano 5 jednostek paliwa");
            }
        } while (car.getFuel() > 0);
        System.out.println("Skończyło się paliwo, koniec gry");
        }
    }


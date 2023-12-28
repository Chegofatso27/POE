import java.util.ArrayList;
import java.util.Scanner;

class Bus {
    private final String busNumber;
    private final String destination;
    private int availableSeats;

    public Bus(String busNumber, String destination, int availableSeats) {
        this.busNumber = busNumber;
        this.destination = destination;
        this.availableSeats = availableSeats;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public String getDestination() {
        return destination;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void bookSeats(int seats) {
        if (seats <= availableSeats) {
            availableSeats -= seats;
            System.out.println("Seats booked successfully!");
        } else {
            System.out.println("Not enough seats available.");
        }
    }
}

class BusRegistrationSystem {
    private final ArrayList<Bus> buses;

    public BusRegistrationSystem() {
        this.buses = new ArrayList<>();
    }

    public void registerBus(Bus bus) {
        buses.add(bus);
        System.out.println("Bus registered successfully!");
    }

    public void displayAvailableBuses() {
        System.out.println("Available Buses:");
        buses.forEach(bus -> {
            System.out.println("Bus Number: " + bus.getBusNumber() +
                    ", Destination: " + bus.getDestination() +
                    ", Available Seats: " + bus.getAvailableSeats());
        });
    }

    public Bus findBusByNumber(String busNumber) {
        for (Bus bus : buses) {
            if (bus.getBusNumber().equals(busNumber)) {
                return bus;
            }
        }
        return null;
    }
}

public class OnlineBusRegistrationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BusRegistrationSystem registrationSystem = new BusRegistrationSystem();

        // Sample data
        Bus bus1 = new Bus("B001", "City A", 20);
        Bus bus2 = new Bus("B002", "City B", 15);
        registrationSystem.registerBus(bus1);
        registrationSystem.registerBus(bus2);

        int choice;
        do {
            System.out.println("\n1. Display Available Buses");
            System.out.println("2. Book Seats");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    registrationSystem.displayAvailableBuses();
                    break;
                case 2:
                    System.out.print("Enter the bus number: ");
                    String busNumber = scanner.next();
                    Bus selectedBus = registrationSystem.findBusByNumber(busNumber);

                    if (selectedBus != null) {
                        System.out.print("Enter the number of seats to book: ");
                        int seatsToBook = scanner.nextInt();
                        selectedBus.bookSeats(seatsToBook);
                    } else {
                        System.out.println("Bus not found.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting the system. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }
}

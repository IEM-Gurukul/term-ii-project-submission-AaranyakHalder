public class Room {
    private int roomId;
    private boolean isBooked;

    public Room(int roomId) {
        this.roomId = roomId;
        this.isBooked = false;
    }

    public int getRoomId() {
        return roomId;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void bookRoom() {
        isBooked = true;
    }

    public void freeRoom() {
        isBooked = false;
    }
}

public class Customer {
    private int id;
    private String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }
}

public class Booking {
    private Customer customer;
    private Room room;

    public Booking(Customer customer, Room room) {
        this.customer = customer;
        this.room = room;
    }

    public void showBooking() {
        System.out.println("Customer: " + customer.getName() +
                " | Room: " + room.getRoomId());
    }
}

import java.util.*;

public class HotelManager {
    private List<Room> rooms = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }
}

public void showAvailableRooms() {
    System.out.println("Available Rooms:");
    for (Room r : rooms) {
        if (!r.isBooked()) {
            System.out.println("Room ID: " + r.getRoomId());
        }
    }
}

public void bookRoom(int roomId, Customer customer) {
    for (Room r : rooms) {
        if (r.getRoomId() == roomId && !r.isBooked()) {
            r.bookRoom();
            bookings.add(new Booking(customer, r));
            System.out.println("Room booked successfully!");
            return;
        }
    }
    System.out.println("Room not available!");
}

public void cancelBooking(int roomId) {
    for (Booking b : bookings) {
        if (b != null) {
            Room r = b.room;
            if (r.getRoomId() == roomId) {
                r.freeRoom();
                bookings.remove(b);
                System.out.println("Booking cancelled!");
                return;
            }
        }
    }
    System.out.println("Booking not found!");
}
public void showBookings() {
    if (bookings.isEmpty()) {
        System.out.println("No bookings found.");
        return;
    }

    for (Booking b : bookings) {
        b.showBooking();
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HotelManager hm = new HotelManager();
        Scanner sc = new Scanner(System.in);

        // Add sample rooms
        hm.addRoom(new Room(101));
        hm.addRoom(new Room(102));

        while (true) {
            System.out.println("\n1. Show Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Show Bookings");
            System.out.println("5. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    hm.showAvailableRooms();
                    break;

                case 2:
                    System.out.print("Enter Room ID: ");
                    int rId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Customer Name: ");
                    String name = sc.nextLine();

                    Customer c = new Customer(rId, name);
                    hm.bookRoom(rId, c);
                    break;

                case 3:
                    System.out.print("Enter Room ID: ");
                    hm.cancelBooking(sc.nextInt());
                    break;

                case 4:
                    hm.showBookings();
                    break;

                case 5:
                    System.exit(0);
            }
        }
    }
}

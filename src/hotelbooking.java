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
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
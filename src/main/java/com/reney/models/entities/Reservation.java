package com.reney.models.entities;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Reservation {
    private Integer roomNumber;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;

    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Reservation(){
    }

    public Reservation(Integer roomNumber, LocalDateTime checkIn, LocalDateTime checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public long duration(){
        Duration duration = Duration.between(checkIn, checkOut);
        return duration.toDays();
    }

    public void updateDates(LocalDateTime checkIn, LocalDateTime checkOut){
        if (checkIn.isBefore(checkOut)) {
            this.checkIn = checkIn;
            this.checkOut = checkOut;
        } else {
            System.out.println("Invalid date!");
        }
    }

    @Override
    public String toString() {
        return String.format("Reservation: Room %d, check-in: %s, check-out: %s, %d nights", roomNumber, dtf.format(checkIn), dtf.format(checkOut), duration());
    }
}

package com.reney.application;

import com.reney.models.entities.Reservation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        LocalDateTime checkIn = LocalDate.parse("20/03/2000", Reservation.dtf).atStartOfDay();
        LocalDateTime checkOut = LocalDate.parse("25/03/2000", Reservation.dtf).atStartOfDay();
        if (checkIn.isAfter(checkOut)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        } else {
            Reservation reservation = new Reservation(100, checkIn, checkOut);
            System.out.println(reservation);


            System.out.println("\nEnter new checkIn date:");
            checkIn = LocalDate.parse(sc.nextLine(), Reservation.dtf).atStartOfDay();
            System.out.println("\nEnter new checkOut date:");
            checkOut = LocalDate.parse(sc.nextLine(), Reservation.dtf).atStartOfDay();

            LocalDateTime dateNow = LocalDateTime.now();

            if (checkIn.isBefore(dateNow)) {
                System.out.println("Enter a valid date");
            } else {

                reservation.updateDates(checkIn, checkOut);

                System.out.println();
                System.out.println(reservation);

                sc.close();
            }
        }
    }
}
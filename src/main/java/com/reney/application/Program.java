package com.reney.application;

import com.reney.models.entities.Reservation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LocalDateTime now = LocalDateTime.now();

        System.out.print("Enter the check-In date: ");
        LocalDateTime checkIn = LocalDate.parse(sc.nextLine(), Reservation.dtf).atStartOfDay();
        System.out.print("Enter the check-Out date: ");
        LocalDateTime checkOut = LocalDate.parse(sc.nextLine(), Reservation.dtf).atStartOfDay();
        if (checkIn.isAfter(checkOut) || checkIn.isBefore(now)) {
            System.out.println("\nReservation error: The check-out date must be later than both the check-in date and today's date.");
        } else {
            Reservation reservation = new Reservation(100, checkIn, checkOut);
            System.out.println();
            System.out.println(reservation);


            System.out.print("\nEnter new checkIn date: ");
            checkIn = LocalDate.parse(sc.nextLine(), Reservation.dtf).atStartOfDay();
            System.out.print("Enter new checkOut date: ");
            checkOut = LocalDate.parse(sc.nextLine(), Reservation.dtf).atStartOfDay();

            String error = reservation.updateDates(checkIn, checkOut);
            if (error != null){
                System.out.println("\nError in reservation: " + error);
            }else {
                System.out.println();
                System.out.println(reservation);
            }

            sc.close();
        }
    }
}
package com.reney.application;

import com.reney.models.entities.Reservation;
import com.reney.models.exceptions.DomainException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter the check-In date: ");
            LocalDateTime checkIn = LocalDate.parse(sc.nextLine(), Reservation.dtf).atStartOfDay();
            System.out.print("Enter the check-Out date: ");
            LocalDateTime checkOut = LocalDate.parse(sc.nextLine(), Reservation.dtf).atStartOfDay();

            Reservation reservation = new Reservation(100, checkIn, checkOut);
            System.out.println();
            System.out.println(reservation);


            System.out.print("\nEnter new checkIn date: ");
            checkIn = LocalDate.parse(sc.nextLine(), Reservation.dtf).atStartOfDay();
            System.out.print("Enter new checkOut date: ");
            checkOut = LocalDate.parse(sc.nextLine(), Reservation.dtf).atStartOfDay();

            reservation.updateDates(checkIn, checkOut);
            System.out.println();
            System.out.println(reservation);
        }
        catch (DateTimeParseException e){
            System.out.println("\nInvalid date format");
        }
        catch (DomainException e){
            System.out.println("\nError in reservation: " + e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("\nUnexpected error");
        }


        sc.close();
    }
}
package exceptionExample.model.entities;

import exceptionExample.model.exceptions.DomainException;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Reservation {
    private Integer roomNumber;
    private LocalDate checkin;
    private LocalDate checkout;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public Reservation() {
    }

    public Reservation(Integer roomNumber, LocalDate checkin, LocalDate checkout) throws DomainException {
        if(checkout.isBefore(checkin)){
            throw new DomainException("Check-out date must be after check-in date");
        }

        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getCheckin() {
        return checkin.format(formatter);
    }

    public String getCheckout() {
        return checkout.format(formatter);
    }

    public Integer duration(){
        return Period.between(this.checkin,this.checkout).getDays();
    }

    public void updateDates(LocalDate chekin, LocalDate chekout) throws DomainException{
        if (chekout.isBefore(LocalDate.now()) || chekin.isBefore(LocalDate.now())){
            throw new DomainException("Reservation dates for update must be future dates");
        }
        this.checkin = chekin;
        this.checkout = chekout;
    }

    @Override
    public String toString() {
        return "Reservation: Room " + getRoomNumber()
                + ", chek-in: " + getCheckin()
                + ", chek-out: " + getCheckout()
                + ", " + duration() + " nights" ;
    }
}

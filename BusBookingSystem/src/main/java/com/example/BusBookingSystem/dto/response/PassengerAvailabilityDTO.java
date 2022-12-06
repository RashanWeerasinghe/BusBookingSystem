package com.example.BusBookingSystem.dto.response;

public class PassengerAvailabilityDTO {

    private int totalPrice;
    private String startHolt;
    private String endHolt;
    private int ticketCount;


    public PassengerAvailabilityDTO() {
    }

    public PassengerAvailabilityDTO(int totalPrice, String startHolt, String endHolt, int ticketCount) {
        this.totalPrice = totalPrice;
        this.startHolt = startHolt;
        this.endHolt = endHolt;
        this.ticketCount = ticketCount;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStartHolt() {
        return startHolt;
    }

    public void setStartHolt(String startHolt) {
        this.startHolt = startHolt;
    }

    public String getEndHolt() {
        return endHolt;
    }

    public void setEndHolt(String endHolt) {
        this.endHolt = endHolt;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    @Override
    public String toString() {
        return "PassengerAvailabilityDTO{" +
                "totalPrice=" + totalPrice +
                ", startHolt='" + startHolt + '\'' +
                ", endHolt='" + endHolt + '\'' +
                ", ticketCount=" + ticketCount +
                '}';
    }

}

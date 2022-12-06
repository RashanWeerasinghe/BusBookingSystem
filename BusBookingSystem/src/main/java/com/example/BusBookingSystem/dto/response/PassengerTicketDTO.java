package com.example.BusBookingSystem.dto.response;

import java.util.UUID;

public class PassengerTicketDTO {
    private  UUID ticketId;

    private String startHolt;
    private String endHolt;

    private int totalPrice;

    private int ticketCount;

    private String noOfSheets;


    public PassengerTicketDTO() {
    }

    public PassengerTicketDTO(String startHolt, String endHolt, int ticketCount) {

        this.startHolt = startHolt;
        this.endHolt = endHolt;
        this.ticketCount = ticketCount;
    }

    public UUID getTicketId() {
        return ticketId;
    }

    public void setTicketId(UUID ticketId) {
        this.ticketId = ticketId;
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

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
    public int getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    public String getNoOfSheets() {
        return noOfSheets;
    }

    public void setNoOfSheets(String noOfSheets) {
        this.noOfSheets = noOfSheets;
    }

    @Override
    public String toString() {
        return "PassengerTicketDTO{" +
                "ticketId=" + ticketId +
                ", startHolt='" + startHolt + '\'' +
                ", endHolt='" + endHolt + '\'' +
                ", totalPrice=" + totalPrice +
                ", ticketCount=" + ticketCount +
                ", noOfSheets='" + noOfSheets + '\'' +
                '}';
    }
}

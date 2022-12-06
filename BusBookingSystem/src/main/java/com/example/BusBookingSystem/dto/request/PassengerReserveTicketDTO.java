package com.example.BusBookingSystem.dto.request;

public class PassengerReserveTicketDTO {


    private String startHolt;
    private String endHolt;
    private int ticketCount;

    public PassengerReserveTicketDTO() {
    }

    public PassengerReserveTicketDTO(String startHolt, String endHolt, int ticketCount) {
        this.startHolt = startHolt;
        this.endHolt = endHolt;
        this.ticketCount = ticketCount;
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
        return "PassengerReserveTicketDTO{" +
                "startHolt='" + startHolt + '\'' +
                ", endHolt='" + endHolt + '\'' +
                ", ticketCount=" + ticketCount +
                '}';
    }
}

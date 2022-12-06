package com.example.BusBookingSystem.dto.request;

public class PassengerCheckAvailabilityDTO {
    private String startHolt;
    private String endHolt;
    private int numberOfPassengers;
    public PassengerCheckAvailabilityDTO() {
    }

    public PassengerCheckAvailabilityDTO(String startHolt, String endHolt, int numberOfPassengers) {
        this.startHolt = startHolt;
        this.endHolt = endHolt;
        this.numberOfPassengers = numberOfPassengers;
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

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    @Override
    public String toString() {
        return "PassengerCheckAvailabilityDTO{" +
                "startHolt='" + startHolt + '\'' +
                ", endHolt='" + endHolt + '\'' +
                ", numberOfPassengers=" + numberOfPassengers +
                '}';
    }
}

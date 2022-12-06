package com.example.BusBookingSystem.service;

import com.example.BusBookingSystem.dto.request.PassengerReserveTicketDTO;
import com.example.BusBookingSystem.dto.response.PassengerAvailabilityDTO;
import com.example.BusBookingSystem.dto.response.PassengerTicketDTO;
import com.example.BusBookingSystem.exception.NotFoundException;

public interface PassengerService {
    PassengerAvailabilityDTO checkAvailability(String start, String end, int x) throws NotFoundException;

    PassengerTicketDTO passengerReserveTicket(PassengerReserveTicketDTO passengerReserveTicketDTO) throws NotFoundException;
}

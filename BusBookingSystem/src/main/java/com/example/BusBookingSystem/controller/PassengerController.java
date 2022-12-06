package com.example.BusBookingSystem.controller;

import com.example.BusBookingSystem.dto.request.PassengerReserveTicketDTO;
import com.example.BusBookingSystem.dto.response.PassengerAvailabilityDTO;
import com.example.BusBookingSystem.dto.response.PassengerTicketDTO;
import com.example.BusBookingSystem.exception.NotFoundException;
import com.example.BusBookingSystem.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/passenger")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;
    @GetMapping(
            path={"/check-by-availability/{start}/{end}/{x}"}

    )
    public PassengerAvailabilityDTO checkAvailability(@PathVariable String start, @PathVariable String end, @PathVariable String x) throws NotFoundException{
        int X = 0;
        try{
            X=Integer.parseInt(x);
        }catch(NumberFormatException ex){
            ex.printStackTrace();
        }
        PassengerAvailabilityDTO passengerAvailabilityDTO= passengerService.checkAvailability(start,end,X);
        return passengerAvailabilityDTO;
    }

    @PostMapping(
            path = {"/reserve-ticket"}
    )
    public PassengerTicketDTO PassengerReserveTicket(@RequestBody PassengerReserveTicketDTO passengerReserveTicketDTO) throws NotFoundException {
        PassengerTicketDTO passengerTicketDTO=passengerService.passengerReserveTicket(passengerReserveTicketDTO);
        return  passengerTicketDTO;
    }

}

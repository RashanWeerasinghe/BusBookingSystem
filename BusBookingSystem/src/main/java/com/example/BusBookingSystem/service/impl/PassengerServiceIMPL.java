package com.example.BusBookingSystem.service.impl;

import com.example.BusBookingSystem.dto.request.PassengerReserveTicketDTO;
import com.example.BusBookingSystem.dto.response.PassengerAvailabilityDTO;
import com.example.BusBookingSystem.dto.response.PassengerTicketDTO;
import com.example.BusBookingSystem.exception.NotFoundException;
import com.example.BusBookingSystem.service.PassengerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

@Service
public class PassengerServiceIMPL implements PassengerService {
    private static  HashMap<String, String>GoBusMap = new HashMap<String, String>();
    private static  HashMap<String, String>ReturnBusMap = new HashMap<String, String>();
    @Override
    public PassengerAvailabilityDTO checkAvailability(String start, String end, int x) throws NotFoundException {
        PassengerAvailabilityDTO passengerAvailabilityDTO=new PassengerAvailabilityDTO();



        if(start.equals("A")||start.equals("B")||start.equals("C")||start.equals("D")&&
                end.equals("A")||end.equals("B")||end.equals("C")||end.equals("D")) {

            if (start.charAt(0) < end.charAt(0)) {
                checkBusMapEmpty(GoBusMap);
                String Holt = start + end;

                int count = 0;
                for (int i = 0; i <= 10; i++) {
                    for (int j = 1; j <= 4; j++) {
                        if (GoBusMap.get(String.valueOf(i) + "A") == "No")
                            count++;
                        else if (GoBusMap.get(String.valueOf(i) + "B") == "No")
                            count++;
                        else if (GoBusMap.get(String.valueOf(i) + "C") == "No")
                            count++;
                        else if (GoBusMap.get(String.valueOf(i) + "D") == "No")
                            count++;
                    }
                }


                if (count >= x) {

                    int totalPrice = getTotalPrice(x, Holt);

                    passengerAvailabilityDTO.setStartHolt(start);
                    passengerAvailabilityDTO.setEndHolt(end);
                    passengerAvailabilityDTO.setTicketCount(x);
                    passengerAvailabilityDTO.setTotalPrice(totalPrice);
                } else {
                    System.out.println("not available " + x + " sheets");
                }


                return passengerAvailabilityDTO;
            } else {
                checkBusMapEmpty(ReturnBusMap);
                String Holt = start + end;

                int count = 0;
                for (int i = 0; i <= 10; i++) {
                    for (int j = 1; j <= 4; j++) {
                        if (ReturnBusMap.get(String.valueOf(i) + "A") == "No")
                            count++;
                        else if (ReturnBusMap.get(String.valueOf(i) + "B") == "No")
                            count++;
                        else if (ReturnBusMap.get(String.valueOf(i) + "C") == "No")
                            count++;
                        else if (ReturnBusMap.get(String.valueOf(i) + "D") == "No")
                            count++;
                    }
                }

                if (count >= x) {

                    int totalPrice = getTotalPrice(x, Holt);

                    passengerAvailabilityDTO.setStartHolt(start);
                    passengerAvailabilityDTO.setEndHolt(end);
                    passengerAvailabilityDTO.setTicketCount(x);
                    passengerAvailabilityDTO.setTotalPrice(totalPrice);
                } else {
                    throw new NotFoundException("No "+x+" Ticket Available");
                }


                return passengerAvailabilityDTO;
            }


        }else{
            throw new NotFoundException("Not found location");
        }

    }

    @Override
    public PassengerTicketDTO passengerReserveTicket(PassengerReserveTicketDTO passengerReserveTicketDTO)  throws NotFoundException {

        PassengerTicketDTO passengerTicketDTO=new PassengerTicketDTO(
                passengerReserveTicketDTO.getStartHolt(),
                passengerReserveTicketDTO.getEndHolt(),
                passengerReserveTicketDTO.getTicketCount()
        );

        if(passengerTicketDTO.getStartHolt().equals("A")||passengerTicketDTO.getStartHolt().equals("B")
                ||passengerTicketDTO.getStartHolt().equals("C")
                ||passengerTicketDTO.getStartHolt().equals("D")&&
                passengerTicketDTO.getEndHolt().equals("A")
                ||passengerTicketDTO.getEndHolt().equals("B")
                ||passengerTicketDTO.getEndHolt().equals("C")
                ||passengerTicketDTO.getEndHolt().equals("D")) {

            if (passengerTicketDTO.getStartHolt().charAt(0) < passengerTicketDTO.getEndHolt().charAt(0)) {
                checkBusMapEmpty(GoBusMap);


                int count = 0;
                ArrayList<String> noOfSheets = new ArrayList<String>();

                int x = passengerTicketDTO.getTicketCount();
                String Holt = passengerTicketDTO.getStartHolt() + passengerTicketDTO.getEndHolt();
                int totalPrice;

                int countFree = 0;

                for (String i : GoBusMap.keySet()) {
                    if (GoBusMap.get(i) == "No")
                        countFree++;
                }

                if (countFree >= x) {

                    for (int i = 0; i <= 10; i++) {
                        if (count == passengerTicketDTO.getTicketCount())
                            break;
                        for (int j = 1; j <= 4; j++) {

                            if (count == passengerTicketDTO.getTicketCount())
                                break;


                            if (GoBusMap.get(String.valueOf(i) + "A") == "No") {
                                GoBusMap.put(String.valueOf(i) + "A", "Yes");
                                noOfSheets.add(String.valueOf(i) + "A");
                                //passengerTicketDTO.setNoOfSheets(noOfSheets);
                                count++;
                                System.out.println("one1");
                            } else if (GoBusMap.get(String.valueOf(i) + "B") == "No") {
                                GoBusMap.put(String.valueOf(i) + "B", "Yes");
                                noOfSheets.add(String.valueOf(i) + "B");
                                //passengerTicketDTO.setNoOfSheets(noOfSheets);
                                count++;
                                System.out.println("one2");
                            } else if (GoBusMap.get(String.valueOf(i) + "C") == "No") {
                                GoBusMap.put(String.valueOf(i) + "C", "Yes");
                                noOfSheets.add(String.valueOf(i) + "C");
                                //passengerTicketDTO.setNoOfSheets(noOfSheets);
                                count++;
                                System.out.println("one2");
                            } else if (GoBusMap.get(String.valueOf(i) + "D") == "No") {
                                GoBusMap.put(String.valueOf(i) + "D", "Yes");
                                noOfSheets.add(String.valueOf(i) + "D");
                                //passengerTicketDTO.setNoOfSheets(noOfSheets);
                                count++;
                                System.out.println("one3");
                            }

                        }
                    }

                    return getPassengerTicketDTO(passengerTicketDTO, noOfSheets, x, Holt);
                } else {
                    throw new NotFoundException("No "+x+" Ticket Available");
                }


            } else {
                checkBusMapEmpty(ReturnBusMap);


                int count = 0;
                ArrayList<String> noOfSheets = new ArrayList<String>();

                int x = passengerTicketDTO.getTicketCount();
                String Holt = passengerTicketDTO.getStartHolt() + passengerTicketDTO.getEndHolt();
                int totalPrice;

                int countFree = 0;

                for (String i : ReturnBusMap.keySet()) {
                    if (ReturnBusMap.get(i) == "No")
                        countFree++;
                }


                System.out.println("count freee:" + countFree);


                if (countFree >= x) {

                    for (int i = 0; i <= 10; i++) {
                        if (count == passengerTicketDTO.getTicketCount())
                            break;
                        for (int j = 1; j <= 4; j++) {

                            if (count == passengerTicketDTO.getTicketCount())
                                break;


                            if (ReturnBusMap.get(String.valueOf(i) + "A") == "No") {
                                ReturnBusMap.put(String.valueOf(i) + "A", "Yes");
                                noOfSheets.add(String.valueOf(i) + "A");
                                //passengerTicketDTO.setNoOfSheets(noOfSheets);
                                count++;
                                System.out.println("one1");
                            } else if (ReturnBusMap.get(String.valueOf(i) + "B") == "No") {
                                ReturnBusMap.put(String.valueOf(i) + "B", "Yes");
                                noOfSheets.add(String.valueOf(i) + "B");
                                //passengerTicketDTO.setNoOfSheets(noOfSheets);
                                count++;
                                System.out.println("one2");
                            } else if (ReturnBusMap.get(String.valueOf(i) + "C") == "No") {
                                ReturnBusMap.put(String.valueOf(i) + "C", "Yes");
                                noOfSheets.add(String.valueOf(i) + "C");
                                //passengerTicketDTO.setNoOfSheets(noOfSheets);
                                count++;
                                System.out.println("one2");
                            } else if (ReturnBusMap.get(String.valueOf(i) + "D") == "No") {
                                ReturnBusMap.put(String.valueOf(i) + "D", "Yes");
                                noOfSheets.add(String.valueOf(i) + "D");
                                //passengerTicketDTO.setNoOfSheets(noOfSheets);
                                count++;
                                System.out.println("one3");
                            }

                        }
                    }

                    return getPassengerTicketDTO(passengerTicketDTO, noOfSheets, x, Holt);
                } else {
                    throw new NotFoundException("No "+x+" Ticket Available");
                }


            }
        }else{
            throw new NotFoundException("No found location");
        }

    }

    private PassengerTicketDTO getPassengerTicketDTO(PassengerTicketDTO passengerTicketDTO, ArrayList<String> noOfSheets, int x, String holt) {
        int totalPrice;
        String y = "";
        for (String i : noOfSheets) {
            y = y + i + "  ";
        }
        passengerTicketDTO.setNoOfSheets(y);

        totalPrice = getTotalPrice(x, holt);

        passengerTicketDTO.setTotalPrice(totalPrice);
        passengerTicketDTO.setTicketId(UUID.randomUUID());
        return passengerTicketDTO;
    }

    private int getTotalPrice(int x, String holt) {
        int totalPrice;
        if(holt.equals("AB")|| holt.equals("BC")|| holt.equals("CB")|| holt.equals("DC")|| holt.equals("GD")|| holt.equals("BA") )
            totalPrice=50*x;
        else if (holt.equals("AC")|| holt.equals("BD")|| holt.equals("DB")|| holt.equals("CA"))
            totalPrice=100*x;
        else if (holt.equals("AD")|| holt.equals("DA"))
            totalPrice=150*x;
        else {
            totalPrice=0;
        }
        return totalPrice;
    }

    private void checkBusMapEmpty(HashMap<String, String>BusMap){
        if(BusMap.isEmpty()){
            for(int i=1;i<=10;i++){
                for(int j=1;j<=4;j++){
                    switch(j){
                        case 1: String x1=String.valueOf(i)+"A";BusMap.put(x1,"No");break;
                        case 2:String  x2=String.valueOf(i)+"B";BusMap.put(x2,"No");break;
                        case 3:String  x3=String.valueOf(i)+"C";BusMap.put(x3,"No");break;
                        case 4:String  x4=String.valueOf(i)+"D";BusMap.put(x4,"No");break;
                        default:break;
                    }

                }

            }
        }
    }


}

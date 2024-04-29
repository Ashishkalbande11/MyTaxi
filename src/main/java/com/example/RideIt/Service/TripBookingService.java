package com.example.RideIt.Service;

import com.example.RideIt.DTO.Request.TripBookingRequest;
import com.example.RideIt.DTO.Response.TripBookingResponse;
import com.example.RideIt.Exception.CabNotAvailableException;
import com.example.RideIt.Exception.CustomerNotFoundException;
import com.example.RideIt.Model.Cab;
import com.example.RideIt.Model.Customer;
import com.example.RideIt.Model.TripBooking;
import com.example.RideIt.Repository.CabRepository;
import com.example.RideIt.Repository.CustomerRepository;
import com.example.RideIt.Repository.DriverRepository;
import com.example.RideIt.Repository.TripBookingRepository;
import com.example.RideIt.Transformer.BookingTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TripBookingService {

    private  final TripBookingRepository tripBookingRepository;
    private  final CustomerRepository customerRepository;
    private final DriverRepository driverRepository;
    private final CabRepository cabRepository;

    @Autowired
    JavaMailSender javaMailSender;


    public TripBookingResponse bookCab(boolean applyCoupon, TripBookingRequest tripBookingRequest) {
        Customer customer = customerRepository.findByEmailId(tripBookingRequest.getCustomerEmailId());
        if(customer == null){
            throw new CustomerNotFoundException("Invalid email Id");
        }
        Cab cab = cabRepository.getRandomAvailableCab();
        if(cab == null){
            throw new CabNotAvailableException("sorry! All drivers are busy right now !!");
        }
        //prepare booking entity
        TripBooking tripBooking = BookingTransformer.bookingRequestToBooking(tripBookingRequest);
        tripBooking.setTotalFare(cab.getFarePerKM() * tripBookingRequest.getTripDistanceInKm());
        tripBooking.setCustomer(customer);
        tripBooking.setDriver(cab.getDriver());

        //save booking
        TripBooking savesTripBooking = tripBookingRepository.save(tripBooking);

        customer.getBookings().add(savesTripBooking);
        cab.setAvailable(false);
        cab.getDriver().getBookings().add(savesTripBooking);

        //customer and bookings
        customerRepository.save(customer);
        driverRepository.save(cab.getDriver());

        sendEmail(savesTripBooking);

        return BookingTransformer.tripBookingToTripBookingResponse(savesTripBooking);

    }

    private void sendEmail(TripBooking savesTripBooking) {

        String text = "Congrats !! " + savesTripBooking.getCustomer().getName()+" your ride is booked with " +
                savesTripBooking.getDriver().getName();
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("ashishkalbande027@gmail.com");
        simpleMailMessage.setTo(savesTripBooking.getCustomer().getEmailId());
        simpleMailMessage.setSubject("cab Booked !!");
        simpleMailMessage.setText(text);

        javaMailSender.send(simpleMailMessage);
    }
}

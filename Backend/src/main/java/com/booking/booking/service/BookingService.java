package com.booking.booking.service;

import com.booking.booking.model.Booking;
import com.booking.booking.repository.BookingRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private BookingRep bookingRep;
    @Autowired
    public BookingService(BookingRep bookingRep){
        this.bookingRep=bookingRep;
    }
    private int bookinNum=1;
    public Booking addBooking(Booking booking){
        List<Booking> bookings= (List<Booking>) bookingRep.findAll();
        for(Booking existingBooking:bookings){
            if(existingBooking.getDate().equals(booking.getDate())){
                    bookinNum++;
                    booking.setSameBookingNum(bookinNum);
        }
        }
        bookinNum=1;
        return bookingRep.save(booking);
    }

    public List<Booking> findAllBooking(){
        return (List<Booking>) bookingRep.findAll();
    }

    public Optional<Booking> findBooking(Integer id){
        return bookingRep.findById(id);
    }

    public void deleteBooking(Integer id){
        if(bookingRep.existsById(id)){
         bookingRep.deleteById(id);}
    }
}

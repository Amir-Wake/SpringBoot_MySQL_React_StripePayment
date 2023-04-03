package com.booking.booking.controller;

import com.booking.booking.model.Booking;
import com.booking.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/booking")
public class BookingController {
    private BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService){
        this.bookingService=bookingService;
    }

    @GetMapping("/")
    public List<Booking> getAllBooking(){
        return bookingService.findAllBooking();
    }

    @GetMapping("/{id}")
    public Optional<Booking> getBooking(@PathVariable("id") Integer id){
        return bookingService.findBooking(id);
    }

    @PostMapping
    public Booking saveBooking(@RequestBody Booking booking){
        return bookingService.addBooking(booking);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBooking(@PathVariable("id") Integer id){
        bookingService.deleteBooking(id);
    }
}

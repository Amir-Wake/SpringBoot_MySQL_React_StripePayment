package com.booking.booking.repository;

import com.booking.booking.model.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRep extends CrudRepository<Booking,Integer> {

}

package com.booking.booking.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
@Entity
@Data
@Table(name="Booking_List")
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String name;
    private String email;
    private String phone_num;
    private int people_num;

    private String date;

    private int sameBookingNum;
    private String createdDate;

    private String bookingRefrence;


    @PrePersist
    public void createdData(){
        //Created date
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String formattedDate = dateFormat.format(currentDate);
        this.createdDate=formattedDate;

        //cerated reference
        long timestamp = System.currentTimeMillis();
        int randomNumber = new Random().nextInt(90000000) + 10000000; // generates a random number between 10000000 and 99999999
        String refNumber = String.format("%d%d", timestamp, randomNumber);
        refNumber = refNumber.substring(refNumber.length() - 8);
        this.bookingRefrence = refNumber;
    }

    public Booking(String name,String email,String phone_num,int people_num,String date){
        this.name=name;
        this.phone_num=phone_num;
        this.email=email;
        this.people_num=people_num;
        this.date=date;
    }


}

package com.booking.booking;

import com.booking.booking.model.Booking;
import com.booking.booking.repository.BookingRep;
import com.stripe.Stripe;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class BookingApplication {

	@PostConstruct
	public void setup(){
		// This is your test secret API key.
		Stripe.apiKey = "sk_test_51MsmYTL264xZefcKSCE1DspGMYMeskf3igj8wVENLDWYkG2VFXVm3aE6Vd2JZ2sH1UxFHgFuFzxyRwqEn60PfY7L002CYgPEMH";

	}
	public static void main(String[] args) {
		SpringApplication.run(BookingApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(BookingRep bookingRep){
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				bookingRep.save(new Booking("Hawkar","test@test.com","01234",7,"1/3/2022 8:30 PM"));
			}
		};
	}


}
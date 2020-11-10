package com.mail.taskone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mail.taskone.Repository.AddressRepository;
import com.mail.taskone.bean.Address;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MyController {

	@Autowired(required = false)
	Address ad;
	
	@Autowired
	AddressRepository ar;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@PostMapping("/addmail")
	public String  insertMail ( @RequestBody  Address address) {
		ar.save(address);
		return  ("registersuccessfully");
		
	}
	
	@PostMapping("/sendmail")
	public String sendmail(@RequestBody  Address address) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom("andrewsjeffrin@gmail.com");
		simpleMailMessage.setTo(address.getEmailaddress());
		simpleMailMessage.setSubject("Test Mail");
		simpleMailMessage.setText("hi there,  \n This is a sample mail");
		javaMailSender.send(simpleMailMessage);
		return "mail send successfully";
	}
	
	@GetMapping("/getmail")
	public List<Address> viewcustomer() {	
		List<Address> list = ar.findAll();	
		return  list;
	}
}


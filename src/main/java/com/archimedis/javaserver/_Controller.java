package com.archimedis.javaserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin
@RestController
public class _Controller {

	@Autowired
	EntryService service;

	@GetMapping("/redirect/{id}/{accountID}")
	public void method(@PathVariable String id, @PathVariable String accountID,
			HttpServletResponse httpServletResponse) {
		service.initialPostToDB(id, accountID);
		httpServletResponse.setHeader("Location", "http://localhost:3000/" + id + "");
		httpServletResponse.setStatus(302);
	}

	@GetMapping("/getstatus/{id}")
	public String getStatus(@PathVariable String id) {
		return service.getEmailID(id);
	}

	@GetMapping("/putstatus/{id}/{emailID}/{time}")
	public void putStatus(@PathVariable String id, @PathVariable String emailID, @PathVariable String time) {
		System.out.println(id + " " + emailID + " " + time);
		service.setEmailID(id, emailID, time);
	}
}

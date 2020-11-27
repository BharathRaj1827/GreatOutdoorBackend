package com.capgemini.gos.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.gos.service.AdminInterface;
import com.capgemini.gos.exceptions.UserNotFoundException;
import com.capgemini.gos.entity.Admins;
import com.capgemini.gos.entity.GrowthReport;
import com.capgemini.gos.entity.RevenueTable;
import com.capgemini.gos.service.AdminService;

@RestController
@RequestMapping("/Reports")
@CrossOrigin("http://localhost:4200")
public class AdminController {
	@Autowired
	AdminService serviceobj;
	@Autowired
	AdminInterface adminobj;

	// Get GrowthReports
	@GetMapping("/GrowthReport/{date1}/{date2}/{category}")
	public ResponseEntity<List<GrowthReport>> viewDetailedSalesReportByProduct(@PathVariable("date1") Date entry,
			@PathVariable("date2") Date exit, @PathVariable("category") String category) {

		System.out.println(entry + " " + exit + category);
		List<GrowthReport> revenueList = serviceobj.viewDetailedSalesReportByProduct(entry, exit, category);
		System.out.println("Tse" + revenueList);
		return new ResponseEntity<>(revenueList, HttpStatus.OK);
	}

	@GetMapping("/valid/{adminname}/{adminpassword}")
	public ResponseEntity<Admins> validate(@PathVariable("adminname") String aname,
			@PathVariable("adminpassword") String apwd) throws UserNotFoundException {
		Admins a = adminobj.validate(aname, apwd);
		if (a == null) {
			throw new UserNotFoundException("Not an admin");
		}
		return new ResponseEntity<Admins>(a, HttpStatus.OK);
	}

	// Get SalesReports
	@GetMapping("/SalesReport/{date1}/{date2}/{userid}/{category}")
	public ResponseEntity<List<RevenueTable>> viewSalesReportByUserAndCategory(@PathVariable("date1") Date entry,
			@PathVariable("date2") Date exit, @PathVariable("userid") String targetUserId,
			@PathVariable("category") String category) {
		List<RevenueTable> salesList = serviceobj.viewSalesReportByUserAndCategory(entry, exit, targetUserId, category);
		System.out.println(salesList);
		return new ResponseEntity<>(salesList, HttpStatus.OK);
	}

}
package com.example.DataSource2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.DataSource2.DbOneModels.TableUserProfile;
import com.example.DataSource2.DbTwoModels.TableUserProfile2;
import com.example.DataSource2.DbOneRepository.TableLoginRepository;
import com.example.DataSource2.DbOneRepository.TableUserProfileRepository;
import com.example.DataSource2.DbTwoRepository.TableLoginRepository2;
import com.example.DataSource2.DbTwoRepository.TableUserProfileRepository2;


@RestController
public class MultiDatabaseController {

	@Autowired
	TableUserProfileRepository tableUserProfileRepository;
	@Autowired
	TableLoginRepository tableLoginRepositoryRepository;
	
	@Autowired
	TableUserProfileRepository2 tableUserProfileRepository2;
	@Autowired
	TableLoginRepository2 tableLoginRepositoryRepository2;
	
	@GetMapping("/userProfile/All/{dbType}")
	public List<?> getAllUsers(@PathVariable("dbType") String Source) {
		List<?> userDetails = null;
		if(Source.equalsIgnoreCase("oracle")) {
			userDetails =tableUserProfileRepository.findAll();
		}
		else {
			userDetails =tableUserProfileRepository2.findAll();
		}
		return userDetails;
	}
	
	@PostMapping("/save/{dbType}")
	public void saveUserDetails(@RequestBody Object userProfile,@PathVariable("dbType") String Source) {

		if(Source.equalsIgnoreCase("Oracle")) {
			tableUserProfileRepository.save((TableUserProfile)userProfile);
		}else {
			tableUserProfileRepository2.save((TableUserProfile2)userProfile);
		}
		
	}
}

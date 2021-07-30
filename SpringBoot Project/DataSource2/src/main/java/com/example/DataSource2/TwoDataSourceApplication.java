package com.example.DataSource2;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.DataSource2.DbOneModels.TableLogin;
import com.example.DataSource2.DbOneModels.TableUserProfile;
import com.example.DataSource2.DbOneRepository.TableLoginRepository;
import com.example.DataSource2.DbOneRepository.TableUserProfileRepository;
import com.example.DataSource2.DbTwoModels.TableLogin2;
import com.example.DataSource2.DbTwoModels.TableUserProfile2;
import com.example.DataSource2.DbTwoRepository.TableLoginRepository2;
import com.example.DataSource2.DbTwoRepository.TableUserProfileRepository2;


@SpringBootApplication
public class TwoDataSourceApplication implements CommandLineRunner{

	@Autowired
	TableUserProfileRepository tableUserProfileRepository;
	@Autowired
	TableLoginRepository tableLoginRepositoryRepository;
	
	@Autowired
	TableUserProfileRepository2 tableUserProfileRepository2;
	@Autowired
	TableLoginRepository2 tableLoginRepositoryRepository2;
	
	public static void main(String[] args) {
		SpringApplication.run(TwoDataSourceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		tableUserProfileRepository.saveAll(
				Arrays.asList(
						new TableUserProfile(Integer.valueOf(101),"user1",Integer.valueOf(25)),
						new TableUserProfile(Integer.valueOf(102),"user1",Integer.valueOf(40)),
						new TableUserProfile(Integer.valueOf(103),"user1",Integer.valueOf(30))
						)
				);
		tableLoginRepositoryRepository.saveAll(
				Arrays.asList(
						new TableLogin(Integer.valueOf(101),"userName1","Welcome1"),
						new TableLogin(Integer.valueOf(102),"userName2","Welcome2"),
						new TableLogin(Integer.valueOf(103),"userName3","Welcome3")
						)
				);
		tableUserProfileRepository2.saveAll(
				Arrays.asList(
						new TableUserProfile2(Integer.valueOf(104),"user4",Integer.valueOf(30)),
						new TableUserProfile2(Integer.valueOf(105),"user5",Integer.valueOf(45)),
						new TableUserProfile2(Integer.valueOf(106),"user6",Integer.valueOf(23))
						)
				);
		tableLoginRepositoryRepository2.saveAll(
				Arrays.asList(
						new TableLogin2(Integer.valueOf(104),"userName4","Welcome1"),
						new TableLogin2(Integer.valueOf(105),"userName5","Welcome2"),
						new TableLogin2(Integer.valueOf(106),"userName6","Welcome3")
						)
				);
		
	}

}

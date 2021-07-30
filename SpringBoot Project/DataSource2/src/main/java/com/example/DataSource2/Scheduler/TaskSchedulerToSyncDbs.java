package com.example.DataSource2.Scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.DataSource2.DbOneModels.TableUserProfile;
import com.example.DataSource2.DbOneRepository.TableLoginRepository;
import com.example.DataSource2.DbOneRepository.TableUserProfileRepository;
import com.example.DataSource2.DbTwoRepository.TableLoginRepository2;
import com.example.DataSource2.DbTwoRepository.TableUserProfileRepository2;

@Component
@EnableScheduling
public class TaskSchedulerToSyncDbs {
	
	@Autowired
	TableUserProfileRepository tableUserProfileRepository;
	@Autowired
	TableLoginRepository tableLoginRepositoryRepository;
	
	@Autowired
	TableUserProfileRepository2 tableUserProfileRepository2;
	@Autowired
	TableLoginRepository2 tableLoginRepositoryRepository2;

	@Scheduled(cron = "0 0/10 * * * ?")
	public void SyncDbData() 
	{
		
	}
}

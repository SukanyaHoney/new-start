package com.example.DataSource2.DbOneRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.DataSource2.DbOneModels.TableUserProfile;


public interface TableUserProfileRepository extends JpaRepository<TableUserProfile, Integer>{


}

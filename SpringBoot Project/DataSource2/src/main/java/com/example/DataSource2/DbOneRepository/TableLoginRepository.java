package com.example.DataSource2.DbOneRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DataSource2.DbOneModels.TableLogin;

public interface TableLoginRepository extends JpaRepository<TableLogin, Integer>{

}

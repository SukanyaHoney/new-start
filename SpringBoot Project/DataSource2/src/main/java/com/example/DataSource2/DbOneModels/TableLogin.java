package com.example.DataSource2.DbOneModels;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="tbl_login")
@NoArgsConstructor

public class TableLogin implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="uid")
	private Integer uid;

	@Column(name="username")
	private String username; 
	
	@Column(name="password")
	private String password;

	public TableLogin(Integer uid, String username, String password) {
		this.uid = uid;
		this.username=username;
		this.password=password;
	}

}

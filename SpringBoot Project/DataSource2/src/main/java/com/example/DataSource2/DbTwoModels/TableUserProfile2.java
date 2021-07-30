package com.example.DataSource2.DbTwoModels;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="tbl_user_profile")
@NoArgsConstructor
public class TableUserProfile2 implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="uid")
	private Integer uid;

	@Column(name="name")
	private String name; 
	
	@Column(name="age")
	private Integer age;
	
	public TableUserProfile2(Integer uid, String name, Integer age) {
		this.uid = uid;
		this.name=name;
		this.age=age;
	}

}

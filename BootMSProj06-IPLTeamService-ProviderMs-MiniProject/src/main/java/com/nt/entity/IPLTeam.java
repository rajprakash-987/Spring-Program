package com.nt.entity;


import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Table(name="MSMP_IPL_TEAM_INFO1")
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class IPLTeam implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer teamId;
	@Column(length = 20)
	@NonNull
	private String teamName;
	@Column(length = 20)
	@NonNull
	private String owner;
	@Column(length = 20)
	@NonNull
	private String area;
	
	public IPLTeam() {
		System.out.println("ipl team ::0 arg constuctor");
	}

}

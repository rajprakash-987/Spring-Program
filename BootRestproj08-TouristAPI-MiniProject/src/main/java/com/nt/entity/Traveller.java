package com.nt.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="TRAVER_INFO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Traveller {
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "TIDSQL",initialValue = 1000,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer tid;
	@Column(length=30)
	private String tname;
	@Column(length=100)
	private String taddrs;
	private LocalDate dob;
	private Long mobileno;

}

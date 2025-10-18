package com.nt.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="BANK_ACCOUNT")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class BankAccount {
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "acno_seq",initialValue = 30000,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private long acno;
	@NonNull
	@Column(length = 30)
	private String holderName;
	@NonNull
	private Double balance;
	
	@Version
	private int modificationCount;
	@CreationTimestamp
	@Column(insertable = true,updatable = false)
	private LocalDateTime openingdate;
	@UpdateTimestamp
	@Column(insertable = false,updatable = true)
	private LocalDateTime lastlyoperatedon;

}

package com.nt.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="JPA_MTOM_FACULTY")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Faculty {
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "FID_SEQ",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer fid;
	@NonNull
	@Column(length = 30)
	private String fname;
	@NonNull
	@Column(length = 30)
	private String faddrs;
	
	@ManyToMany(targetEntity = Student.class,cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="JPA_MTOM_FACULTIES_STUDENTS", //THIRD TABLE
				joinColumns = @JoinColumn(name="faculty_id",referencedColumnName = "fid"), //owning side FK column
				inverseJoinColumns =@JoinColumn(name="student_id",referencedColumnName="sid")) //non ownimg side FK column
	private Set<Student> studentInfo=new HashSet();

	@Override
	public String toString() {
		return "Faculty [fid=" + fid + ", fname=" + fname + ", faddrs=" + faddrs + "]";
	}
	
	

}

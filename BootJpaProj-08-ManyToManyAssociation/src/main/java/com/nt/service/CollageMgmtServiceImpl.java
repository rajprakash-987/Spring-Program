package com.nt.service;

import java.util.Optional;
import java.util.Set;
import com.nt.runners.ManyToManyAssociationMappingTestRound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Faculty;
import com.nt.entity.Student;
import com.nt.repository.IFacultyRepository;
import com.nt.repository.IStudentRepository;

@Service
public class CollageMgmtServiceImpl implements ICollageMgmtService {

    
	@Autowired
	private IFacultyRepository facultyRepo;
	@Autowired
	private IStudentRepository studentRepo;
	@Override
	public void saveDataUsingParent() {
		//prepare parent obj
		Faculty faculty1=new Faculty("raja","hyd");
		Faculty faculty2=new Faculty("raja","hyd");
		//prepare child obj
		Student student1=new Student("anil","hyd","CBIET");
		Student student2=new Student("suresh","bbsr","guru");
		Student student3=new Student("ramesh","blr","gift");
		//assign student to faculty
		faculty1.getStudentInfo().add(student1);
		faculty1.getStudentInfo().add(student2);
		faculty1.getStudentInfo().add(student3);
		faculty2.getStudentInfo().add(student1);
		faculty2.getStudentInfo().add(student2);
		//assign faculty to student
		student1.getFacultyInfo().add(faculty1);
		student1.getFacultyInfo().add(faculty2);
		student2.getFacultyInfo().add(faculty1);
		student2.getFacultyInfo().add(faculty2);
		student3.getFacultyInfo().add(faculty1);
		
		//save data using parent
		
			facultyRepo.save(faculty1);
			facultyRepo.save(faculty2);
			System.out.println("faculty and and assocviate students atre saved");
	
		

	}
	
	@Override
	public void loadDataUsingParent() {
		Iterable<Faculty> ifaculty=facultyRepo.findAll();
		ifaculty.forEach(faculty->{
			System.out.println("parent::"+faculty);
			Set<Student> childs=faculty.getStudentInfo();
			childs.forEach(stud->{
				System.out.println("childs::"+stud);
			});
		});
		
	}
	@Override
	public void deleteDataUsingParent() {
		//load parent
		Optional<Faculty> opt=facultyRepo.findById(1);
		if(opt.isPresent()) {
			Faculty faculty=opt.get();
			Set<Student> childs=faculty.getStudentInfo();
			faculty.setStudentInfo(null);
			childs.forEach(ch->{
				ch.setFacultyInfo(null);
			});
			facultyRepo.save(faculty);
			System.out.println("faculty is removed from certain Stuents");
		}
		
	}

}

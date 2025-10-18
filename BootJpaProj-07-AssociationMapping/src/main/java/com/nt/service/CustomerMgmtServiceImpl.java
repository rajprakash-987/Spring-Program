package com.nt.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Customer;
import com.nt.entity.PhoneNumber;
import com.nt.repository.ICustomerRepository;
import com.nt.repository.IPhonesRepository;

@Service("custService")
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {
	@Autowired
	private ICustomerRepository custRepo;
	@Autowired
	private IPhonesRepository phonesRepo;
	
	@Override
	public String saveDataUsingParent() {
		//create parent obj...
		Customer cutomer=new Customer("raja","hyd");
		//create child obj...
		PhoneNumber ph1=new PhoneNumber(9999999999L,"airtel","residence");
		PhoneNumber ph2=new PhoneNumber(8888888888L,"jio","office");
		//set parent to child..
		ph1.setCust(cutomer);ph2.setCust(cutomer);
		//set child to parent
		Set<PhoneNumber> childs=Set.of(ph1,ph2);
		cutomer.setPhonesinfo(childs);
		//save parent to child..
		int idVal=custRepo.save(cutomer).getCno();
		
		
		return "Parent to child objs are saved with the id value"+idVal;
	}
	
	@Override
	public String saveDataUsingChilds() {
		//create parent obj...
		Customer cutomer=new Customer("mahesh","delhi");
		//create child obj...
		PhoneNumber ph1=new PhoneNumber(7777777777L,"airtel","residence");
		PhoneNumber ph2=new PhoneNumber(6666666666L,"jio","office");
		//set parent to child...
		ph1.setCust(cutomer);ph2.setCust(cutomer);
		//set child to parent
		
		Set<PhoneNumber> childs=new HashSet<>();
		childs.add(ph1);childs.add(ph2);
		cutomer.setPhonesinfo(childs);
		//save obj using child
		phonesRepo.saveAll(childs);
		
		return"childs to parent obj are saved";
	}
	
	@Override
	public void loadDataUsingParent() {
		Iterable<Customer> it=custRepo.findAll();
		it.forEach(cust->{
			System.out.println("parent::"+cust);
			//Associated child obj
			Set<PhoneNumber> childs=cust.getPhonesinfo();
			childs.forEach(ph->{
				System.out.println("childs::"+ph);
			});
		});
	}
	
	@Override
	public void loadDataUsingChilds() {
		Iterable<PhoneNumber> it=phonesRepo.findAll();
		it.forEach(ph->{
			System.out.println("child:: "+ph);
			//get the associated parent
			Customer cust=ph.getCust();
			System.out.println("parent:: "+cust);
		});
		
	}
	
	@Override
	public void deleteDataUsingParent() {
		//load parent obj
		Optional<Customer> opt=custRepo.findById(102);
		if(opt.isPresent()) {
			//get customer obj
			Customer cust=opt.get();
			//delete customer 
			custRepo.delete(cust);
			System.out.println("Customer and his phone no is deleted");
		}
		else {
			System.out.println("customer is not found");
		}
		
	}
	
	@Override
	public void deleteAllChildsOfAParent() {
		//load parent obj
		Optional<Customer> opt=custRepo.findById(103);
		if(opt.isPresent()) {
			//get the parent obj
			Customer cust=opt.get();
			//get child of parent
			Set<PhoneNumber> childs=cust.getPhonesinfo();
			//nullifying parent from the child
			childs.forEach(ph->{
				ph.setCust(null);
			});
			//delete all the childs
			phonesRepo.deleteAllInBatch(childs);
			System.out.println("all child of a parent are deleted");
		}
		else {
			System.out.println("parent not found");
		}
		
	}
	
	@Override
	public void addNewChildToExistingChilds() {
		//load parent obj
		Optional<Customer> opt=custRepo.findById(103);
		if(opt.isPresent()) {
			//get the parent obj
			Customer cust=opt.get();
			//get existing child of a parent
			Set<PhoneNumber> childs=cust.getPhonesinfo();
			//create new phoneNumber
			PhoneNumber ph=new PhoneNumber(8989898989L,"airtel","home");
			//set new child to parent
			ph.setCust(cust);
			//add new child to existing childs and update the child
			childs.add(ph);
			custRepo.save(cust);
			System.out.println("new child is added to existing childs of a parent");
		}
		else {
			System.out.println("parent not found");
		}
	}
	
	@Override
	public void deleteDataUsingChilds() {
		//load parent obj
		Optional<Customer> opt=custRepo.findById(103);
		  if(opt.isPresent()) {
		  //get the parent obj
		  Customer cust=opt.get();
		  //get all child of a parent
		  Set<PhoneNumber> childs=cust.getPhonesinfo();
		  //delete all childs
		  childs.forEach(ph->{
			  phonesRepo.delete(ph);
		  });
		  System.out.println("all child and its associated parents are deleted");
		
	     }
	     else {
			System.out.println("parent not found");
		}
	}
	
	@Override
	public List<Object[]> showParentsToChildsDataUsingJoins() {
		//use repo
		
		return custRepo.fetchParentsToChildsDataUsingJoins();
	}
	
		  

}


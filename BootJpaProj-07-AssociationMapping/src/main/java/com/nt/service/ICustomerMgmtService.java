package com.nt.service;

import java.util.List;

public interface ICustomerMgmtService {
	public String saveDataUsingParent();  //insert using parent
	public String saveDataUsingChilds();  //insert using child
	
	public void loadDataUsingParent();    //select using parent
	public void loadDataUsingChilds();    //select using child
	
	public void deleteDataUsingParent();     //delete using parent
	public void deleteAllChildsOfAParent();   //delete all child of one parent
	
	
    public void addNewChildToExistingChilds();
    public void deleteDataUsingChilds();
    
    public List<Object[]> showParentsToChildsDataUsingJoins();

}

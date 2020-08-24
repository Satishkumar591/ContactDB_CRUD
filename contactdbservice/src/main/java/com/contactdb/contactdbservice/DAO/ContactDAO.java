package com.contactdb.contactdbservice.DAO;

import java.util.List;

import com.contactdb.contactdbservice.model.ContactDB;

public interface ContactDAO {
	
	public void save(ContactDB contactdb);
	
	public ContactDB getById(int id);
	
	public void deleteById(int id);
	
	public List<ContactDB> list();

}


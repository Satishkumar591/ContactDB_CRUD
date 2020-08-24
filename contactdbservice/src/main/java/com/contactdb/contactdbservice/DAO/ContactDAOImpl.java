package com.contactdb.contactdbservice.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contactdb.contactdbservice.model.ContactDB;
import com.contactdb.contactdbservice.repository.ContactRepository;

@Service
public class ContactDAOImpl implements ContactDAO {
	
	@Autowired
	private ContactRepository contactRepo;

	@Override
	public void save(ContactDB contactdb) {
		this.contactRepo.save(contactdb);
	}

	@Override
	public List<ContactDB> list() {
		
		return contactRepo.findAll();
	}

	@Override
	public ContactDB getById(int id) {
	   Optional<ContactDB>	contactdb = contactRepo.findById(id);
	   
	   ContactDB newContactdb = null;
	   if(contactdb.isPresent()) {
		   newContactdb = contactdb.get();
	   }else {
		   throw new RuntimeException("Contact is not foung in this Id: " +id);
	   }
	   
	   return newContactdb;
	
	}

	@Override
	public void deleteById(int id) {
		this.contactRepo.deleteById(id);
		
	}

}

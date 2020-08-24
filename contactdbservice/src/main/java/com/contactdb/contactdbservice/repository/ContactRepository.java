package com.contactdb.contactdbservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contactdb.contactdbservice.model.ContactDB;

@Repository
public interface ContactRepository extends JpaRepository<ContactDB, Integer>{

}

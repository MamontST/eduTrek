package telran.java53.edutrek.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import telran.java53.edutrek.enums.StatusContact;
import telran.java53.edutrek.model.Contact;

public interface ContactRepository extends MongoRepository<Contact, String> {

	List<Contact> findByName(String name);

	List<Contact> findByStatus(StatusContact status);
}

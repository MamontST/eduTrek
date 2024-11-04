package telran.java53.edutrek.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import telran.java53.edutrek.model.Contact;

public interface GroupRepository extends MongoRepository<Contact, String> {

}

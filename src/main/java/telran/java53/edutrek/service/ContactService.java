package telran.java53.edutrek.service;

import java.util.List;

import telran.java53.edutrek.dto.ContactCreateDto;
import telran.java53.edutrek.dto.ContactDto;
import telran.java53.edutrek.dto.ReminderDto;
import telran.java53.edutrek.enums.StatusContact;

public interface ContactService {
	ContactDto addContact(ContactCreateDto contactCreateDto);

	List<ContactDto> getAllContacts();

	ContactDto getContactById(String id);

	List<ContactDto> getContactByName(String name);

	List<ContactDto> getContactByStatus(StatusContact status);

	ContactDto updateContact(String id, ContactDto contactDto);

	ContactDto addComment(String contactId, String comment);

	ContactDto addReminder(String contactId, ReminderDto reminderDto);

	void archiveContact(String id);
}

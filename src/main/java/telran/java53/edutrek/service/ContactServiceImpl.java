package telran.java53.edutrek.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import telran.java53.edutrek.dao.ContactRepository;
import telran.java53.edutrek.dto.ContactDto;
import telran.java53.edutrek.dto.ReminderDto;
import telran.java53.edutrek.enums.StatusContact;
import telran.java53.edutrek.exception.ContactAlreadyExistsException;
import telran.java53.edutrek.exception.ContactNotFoundException;
import telran.java53.edutrek.model.Contact;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

	private final ContactRepository contactRepository;
	private final ModelMapper modelMapper;

	@Override
	public ContactDto addContact(ContactDto contactDto) {
	    if (contactRepository.findById(contactDto.getId()).isPresent()) {
	        throw new ContactAlreadyExistsException();
	    }
		Contact contact = modelMapper.map(contactDto, Contact.class);
		contactRepository.save(contact);
		return modelMapper.map(contact, ContactDto.class);
	}

	@Override
	public List<ContactDto> getAllContacts() {
		return contactRepository.findAll().stream().map(contact -> modelMapper.map(contact, ContactDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public ContactDto getContactById(String id) {
		Contact contact = contactRepository.findById(id)
				.orElseThrow(() -> new ContactNotFoundException("Contact " + id + " not found"));
		return modelMapper.map(contact, ContactDto.class);
	}

	@Override
	public List<ContactDto> getContactByName(String name) {
		return contactRepository.findByName(name).stream().map(contact -> modelMapper.map(contact, ContactDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<ContactDto> getContactByStatus(String status) {
		StatusContact statusContact;
        try {
            statusContact = StatusContact.valueOf(status.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid status: " + status);
        }
		return contactRepository.findByStatus(statusContact).stream()
				.map(contact -> modelMapper.map(contact, ContactDto.class)).collect(Collectors.toList());
	}

	@Override
	public ContactDto updateContact(String id, ContactDto contactDto) {
		Contact contact = contactRepository.findById(id)
				.orElseThrow(() -> new ContactNotFoundException("Contact " + id + " not found"));
		modelMapper.map(contactDto, contact);
		contactRepository.save(contact);
		return modelMapper.map(contact, ContactDto.class);
	}

	@Override
	public ContactDto addComment(String contactId, String comment) {
		Contact contact = contactRepository.findById(contactId)
				.orElseThrow(() -> new ContactNotFoundException("Contact " + contactId + " not found"));

		contact.getComments().add(comment);
		contactRepository.save(contact);
		return modelMapper.map(contact, ContactDto.class);
	}

	@Override
	public ContactDto addReminder(String contactId, ReminderDto reminderDto) {
		Contact contact = contactRepository.findById(contactId)
				.orElseThrow(() -> new ContactNotFoundException("Контакт с ID " + contactId + " не найден"));
		contact.getReminders().add(reminderDto);
		contactRepository.save(contact);
		return modelMapper.map(contact, ContactDto.class);
	}

	@Override
	public void archiveContact(String id) {
		Contact contact = contactRepository.findById(id)
				.orElseThrow(() -> new ContactNotFoundException("Contact " + id + " not found"));
		contact.setStatus(StatusContact.ARCHIVE);
		contactRepository.save(contact);

	}

}

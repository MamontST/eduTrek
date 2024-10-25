package telran.java53.edutrek.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import telran.java53.edutrek.dto.ContactDto;
import telran.java53.edutrek.dto.ReminderDto;
import telran.java53.edutrek.service.ContactService;

@RestController
@RequestMapping("/contact")
@RequiredArgsConstructor
public class ContactController {

	private final ContactService contactService;

	@PostMapping("")
	public ContactDto addContact(@RequestBody ContactDto contactDto) {
		return contactService.addContact(contactDto);
	}

	@GetMapping("/all")
	public List<ContactDto> getAllContacts() {
		return contactService.getAllContacts();
	}

	@GetMapping("/{id}")
	public ContactDto getContactById(@PathVariable String id ) {
		return contactService.getContactById(id);
	}

	@GetMapping("/name/{name}")
	public List<ContactDto> getContactByName(@PathVariable String name) {
		return contactService.getContactByName(name);
	}

	@GetMapping("/status/{status}")
	public List<ContactDto> getContactByStatus(@PathVariable String status) {
		return contactService.getContactByStatus(status);
	}

	@PutMapping("/{id}")
	public ContactDto updateContact(@PathVariable String id, @RequestBody ContactDto contactDto) {
		return contactService.updateContact(id, contactDto);
	}

	@PutMapping("/{id}/comment")
	public ContactDto addComment(@PathVariable("{id}") String contactId, @RequestBody String comment) {
		return contactService.addComment(contactId, comment);
	}

	@PutMapping("/{id}/reminder")
	public ContactDto addReminder(@PathVariable("{id}") String contactId, @RequestBody ReminderDto reminderDto) {
		return contactService.addReminder(contactId, reminderDto);
	}

	@DeleteMapping("/{id}")
	public void archiveContact(@PathVariable String id) {
		contactService.archiveContact(id);

	}

}

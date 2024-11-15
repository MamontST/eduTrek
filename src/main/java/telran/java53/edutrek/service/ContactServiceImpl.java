package telran.java53.edutrek.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import telran.java53.edutrek.dao.ContactRepository;
import telran.java53.edutrek.dto.ContactDto;

import telran.java53.edutrek.dto.ReminderDto;
import telran.java53.edutrek.enums.CoursesEnum;
import telran.java53.edutrek.enums.PaymentType;
import telran.java53.edutrek.enums.Source;
import telran.java53.edutrek.enums.StatusContact;
import telran.java53.edutrek.exception.ContactAlreadyExistsException;
import telran.java53.edutrek.exception.ContactNotFoundException;
import telran.java53.edutrek.model.Contact;
import telran.java53.edutrek.model.PaymentLog;
import telran.java53.edutrek.model.Student;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService, CommandLineRunner {

	final ContactRepository contactRepository;
	final ModelMapper modelMapper;
	final ContactModelDtoMapper mapper;
	

	@Transactional
	@Override
	public ContactDto addContact(ContactDto contactDto) {
	    if (contactRepository.findById(contactDto.getId()).isPresent()) {
	        throw new ContactAlreadyExistsException("Contact " + contactDto.getId() + " already exists");
	    }
	//	Contact contact = modelMapper.map(contactDto, Contact.class);
	    Contact contact = mapper.mapToModel(contactDto);
		contactRepository.save(contact);
		return mapper.mapToDto(contact);
	}

	@Override
	public List<ContactDto> getAllContacts() {
		return contactRepository.findAll().stream().map(contact -> mapper.mapToDto(contact))
				.collect(Collectors.toList());
	}

	@Override
	public ContactDto getContactById(String id) {
		Contact contact = contactRepository.findById(id)
				.orElseThrow(() -> new ContactNotFoundException("Contact " + id + " not found"));
		return mapper.mapToDto(contact);
	}

	@Override
	public List<ContactDto> getContactByName(String name) {
		return contactRepository.findByName(name).stream().map(contact -> mapper.mapToDto(contact))
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
				.map(contact -> mapper.mapToDto(contact)).collect(Collectors.toList());
	}

	@Override
	public ContactDto updateContact(String id, ContactDto contactDto) {
		Contact contact = contactRepository.findById(id)
				.orElseThrow(() -> new ContactNotFoundException("Contact " + id + " not found"));
		mapper.mapToModel(contactDto);
		contactRepository.save(contact);
		return mapper.mapToDto(contact);
	}

	@Override
	public ContactDto addComment(String contactId, String comment) {
		Contact contact = contactRepository.findById(contactId)
				.orElseThrow(() -> new ContactNotFoundException("Contact " + contactId + " not found"));

		contact.getComments().add(comment);
		contactRepository.save(contact);
		return mapper.mapToDto(contact);
	}

	@Override
	public ContactDto addReminder(String contactId, ReminderDto reminderDto) {
		Contact contact = contactRepository.findById(contactId)
				.orElseThrow(() -> new ContactNotFoundException("РљРѕРЅС‚Р°РєС‚ СЃ ID " + contactId + " РЅРµ РЅР°Р№РґРµРЅ"));
		contact.getReminders().add(reminderDto);
		contactRepository.save(contact);
		return mapper.mapToDto(contact);
	}

	@Override
	public void archiveContact(String id) {
		Contact contact = contactRepository.findById(id)
				.orElseThrow(() -> new ContactNotFoundException("Contact " + id + " not found"));
		contact.setStatus(StatusContact.ARCHIVE);
		contactRepository.save(contact);

	}

	@Transactional
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Repository " + contactRepository.count());
		if (contactRepository.count() == 0) {
			System.out.println("Creating and populating collection...");			
		} else {
			contactRepository.deleteAll();
			System.out.println("Erase and creat collection.");
			
		}
		
		List<String> commentsLogList = new ArrayList<String>();
		commentsLogList.add("Good connect");
		List<ReminderDto> reminders = new ArrayList<ReminderDto>();
		reminders.add(new ReminderDto(LocalDateTime.now(), "recall"));
		
		List<Contact> contacts = Arrays.asList(
			
			    new Contact("10", "Igor", "Petrov", "053-000-00-01", "igor.petrov@gmail.com", "Rehovot", StatusContact.LEAD, CoursesEnum.FSD, commentsLogList, reminders, Source.INTERNET),
			    new Contact("11", "Ivan", "Sidorov", "053-000-00-02", "ivan.sidorov@gmail.com", "Tel Aviv", StatusContact.LEAD, CoursesEnum.FSD, commentsLogList, reminders, Source.INTERNET),
			    new Contact("12", "Anna", "Ivanova", "053-000-00-03", "anna.ivanova@gmail.com", "Jerusalem", StatusContact.LEAD, CoursesEnum.WD, commentsLogList, reminders, Source.INTERNET),
			    new Contact("13", "Maria", "Smirnova", "053-000-00-04", "maria.smirnova@gmail.com", "Haifa", StatusContact.LEAD, CoursesEnum.FSD, commentsLogList, reminders, Source.INTERNET),
			    new Contact("14", "Dmitry", "Kozlov", "053-000-00-05", "dmitry.kozlov@gmail.com", "Beersheba", StatusContact.LEAD, CoursesEnum.QAT, commentsLogList, reminders, Source.INTERNET)		    
			    
			);
			
			contactRepository.saveAll(contacts);
			List<String> group = new ArrayList<String>();
			group.add("QA-53");
			List<String> activityLog = new ArrayList<String>();
			activityLog.add("Add to group");
			List<PaymentLog> paymentLog = new ArrayList<PaymentLog>();
			paymentLog.add(new PaymentLog(LocalDateTime.now(),PaymentType.CASH,15000.0,3,5000.0));
		
			
			Student student = new Student("15", "Jon", "kolov", "053-000-00-05", "jon.kolov@gmail.com", "Beersheba", StatusContact.STUDENT, 
					CoursesEnum.QAT, commentsLogList, reminders, Source.INTERNET, group, activityLog, paymentLog);
			contactRepository.save(student);
		
	}


}

package telran.java53.edutrek.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import telran.java53.edutrek.dto.ContactDto;
import telran.java53.edutrek.dto.StudentDto;
import telran.java53.edutrek.model.Contact;
import telran.java53.edutrek.model.Student;

@Component
@RequiredArgsConstructor

public class ContactModelDtoMapper {
	final ModelMapper modelMapper;

	public Contact mapToModel(ContactDto contactDto) {
		if (contactDto instanceof StudentDto) {
			return modelMapper.map(contactDto, Student.class);
		}
		return modelMapper.map(contactDto, Contact.class);
	}

	public ContactDto mapToDto(Contact contact) {
		if (contact instanceof Student) {
			return modelMapper.map(contact, StudentDto.class);
		}
		return modelMapper.map(contact, ContactDto.class);
	}

}

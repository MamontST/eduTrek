package telran.java53.edutrek.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import telran.java53.edutrek.enums.CoursesEnum;
import telran.java53.edutrek.enums.Source;
import telran.java53.edutrek.enums.StatusContact;
import lombok.Getter;
import lombok.Singular;

@Getter
@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(name = "student", value = StudentDto.class), @Type(name = "contact", value = ContactDto.class) })
public class ContactDto {

	String id;
	String name;
	String surname;
	String phoneNumber;
	String email;
	String place;
	StatusContact status;
	CoursesEnum course;
	// это поле у студентов и статус архив
	// List<String> groups;
	@Singular
	List<String> comments;
	
	@Singular
	List<ReminderDto> reminders;
	// такого поля нет в контактах
	// List<String> activityLog;
	Source source;
}

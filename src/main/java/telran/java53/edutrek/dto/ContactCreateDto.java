package telran.java53.edutrek.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import telran.java53.edutrek.enums.CoursesEnum;
import telran.java53.edutrek.enums.StatusContact;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContactCreateDto {
	String name;
	String surname;
	String phoneNumber;
	String email;
	String place;
	StatusContact status;
	CoursesEnum course;
	List<String> comments;
	List<ReminderDto> reminders;
}

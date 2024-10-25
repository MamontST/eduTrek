package telran.java53.edutrek.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import telran.java53.edutrek.dto.ReminderDto;
import telran.java53.edutrek.enums.CoursesEnum;
import telran.java53.edutrek.enums.StatusContact;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "contacts")

public class Contact {

	private String id;
	private String name;
	private String surname;
	private String phoneNumber;
	private String email;
	private String place;
	private StatusContact status;
	private CoursesEnum course;
	private List<String> comments;
	private List<ReminderDto> reminders;
}

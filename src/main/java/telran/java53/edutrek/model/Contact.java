 package telran.java53.edutrek.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import telran.java53.edutrek.dto.ReminderDto;
import telran.java53.edutrek.enums.CoursesEnum;
import telran.java53.edutrek.enums.Source;
import telran.java53.edutrek.enums.StatusContact;



@NoArgsConstructor
@AllArgsConstructor
@Getter

@EqualsAndHashCode(of = "id")
@Data 
@Document(collection = "contacts")

public class Contact implements Serializable {	
	private static final long serialVersionUID = 2902263536516757687L;
	
	
	private String id;
	private String name;
	private String surname;
	private String phoneNumber;
	private String email;
	private String place;
	@Setter
	private StatusContact status;
	@Setter
	private CoursesEnum course;
	private List<String> comments;
	private List<ReminderDto> reminders;
	private Source source;
}

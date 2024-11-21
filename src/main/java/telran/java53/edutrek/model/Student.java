package telran.java53.edutrek.model;


import java.util.List;


import lombok.Getter;
import lombok.NoArgsConstructor;

import telran.java53.edutrek.dto.ReminderDto;
import telran.java53.edutrek.enums.CoursesEnum;
import telran.java53.edutrek.enums.Source;
import telran.java53.edutrek.enums.StatusContact;

@NoArgsConstructor
@Getter

//@Document(collection = "contacts")
public class Student extends Contact {
	
	private static final long serialVersionUID = -3134139557966101650L;
	List<String> groups;
	List<PaymentLog> paymentLog;
	List<String> activityLog;
	
	public Student(String id, String name, String surname, String phoneNumber, String email, String place,
			StatusContact status, CoursesEnum course, List<String> comments, List<ReminderDto> reminders,
			Source source, List<String> groups, List<String> activityLog, List<PaymentLog> paymentLog) {
		super(id, name, surname, phoneNumber, email, place, status, course, comments, reminders, source);
		this.activityLog = activityLog;
		this.groups = groups;
		this.paymentLog = paymentLog;
	}	
	
	
}

package telran.java53.edutrek.dto;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import telran.java53.edutrek.enums.StatusContact;
import telran.java53.edutrek.enums.CoursesEnum;

@Entity
@Getter
public class StudentDto {
	@Id
	Integer studentId;
	String name;
	String surname;
	String phoneNumber;
	String email;
	String place;
	StatusContact status;
	CoursesEnum course;
	List<String> groups;
	List<String> comments;
	List<PaymentLog> paymentLog;
	List<String> reminders;
	List<String> activityLog;		
}

package telran.java53.edutrek.dto;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Id;
import java.time.DayOfWeek;

public class Group {
	@Id
	String id;
	String whatsApp;
	String skype;
	String slack;
	LocalDate startDate;
	LocalDate expectedFinishDate;
	List<DayOfWeek> lessonsDays;
	List<DayOfWeek> webinarsDays;
	List<StudentDto> studentsID;
    
}

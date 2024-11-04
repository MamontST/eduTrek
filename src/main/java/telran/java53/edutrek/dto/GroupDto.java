package telran.java53.edutrek.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupDto {

	private String id; 
	private String whatsApp; 
	private String skype; 
	private String slack; 
	private LocalDate startDate;
	private LocalDate expectedFinishDate; 
	private List<String> lessonsDays; 
	private List<String> webinarsDays; 
	private List<String> studentsID; 
	private List<ReminderDto> reminders; 
	private Boolean active;

}

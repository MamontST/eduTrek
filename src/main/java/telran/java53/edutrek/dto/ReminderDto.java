package telran.java53.edutrek.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReminderDto {

	LocalDateTime reminderTime;
    String reminderText;
}

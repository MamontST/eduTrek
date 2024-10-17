package telran.java53.edutrek.dto;

import java.util.List;
import lombok.Getter;

@Getter
public class StudentDto extends ContactDto {
	List<String> groups;
	List<PaymentLogDto> paymentLog;
	List<String> activityLog;	
}

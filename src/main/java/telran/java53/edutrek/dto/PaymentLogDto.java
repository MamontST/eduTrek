package telran.java53.edutrek.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import telran.java53.edutrek.enums.PaymentType;

@AllArgsConstructor
@NoArgsConstructor
public class PaymentLogDto {
	
	LocalDateTime  datePayment;
	PaymentType type;
	Double amount;
	Integer installments;
	Double each;

}

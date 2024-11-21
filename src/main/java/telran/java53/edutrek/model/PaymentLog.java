package telran.java53.edutrek.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import telran.java53.edutrek.enums.PaymentType;
import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode

public class PaymentLog implements Serializable {

	private static final long serialVersionUID = 1L;
	
	LocalDateTime  datePayment;
	PaymentType type;
	Double amount;
	Integer installments;
	Double each;

}

package telran.java53.edutrek.dto;

import telran.java53.edutrek.enums.PaymentType;

public class PaymentLog {
	Integer id;
	PaymentType type;
	Double amount;
	Integer installments;
	Double each;
}

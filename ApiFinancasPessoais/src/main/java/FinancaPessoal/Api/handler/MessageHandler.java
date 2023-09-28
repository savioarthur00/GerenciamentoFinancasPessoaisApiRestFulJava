package FinancaPessoal.Api.handler;

public abstract class  MessageHandler {
	

	public static String userNameRole() {
		return "O campo Username é obrigátorio";
	}
	public static String passwordRole() {
		return "O campo password é obrigátorio";
	}
}

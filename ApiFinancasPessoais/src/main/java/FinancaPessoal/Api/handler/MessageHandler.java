package FinancaPessoal.Api.handler;

public abstract class  MessageHandler {
	

	public static String mensagemObrigatoria(String campo) {
		return "O campo " + campo + " é obrigátorio.";
	}
	
}

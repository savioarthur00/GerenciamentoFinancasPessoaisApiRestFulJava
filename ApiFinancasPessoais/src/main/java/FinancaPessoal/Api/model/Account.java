package FinancaPessoal.Api.model;

import static FinancaPessoal.Api.handler.MessageHandler.saldoInsuficiente;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import FinancaPessoal.Api.handler.BusinessException;


@Entity(name="tb_account")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String accountname;
	
	private double balance;
	
	@OneToMany
	private List<Transaction> transactions;

	
	
	
	public void deposit(double valor) {
		this.balance += valor;
		Transaction transaction = new Transaction("Depósito na conta", valor);
		transactions.add(transaction);
	}
	
	public void withdraw(double valor) {
		if (valor <= balance) {
	        
	        this.balance -= valor;
	        
	        Transaction transaction = new Transaction("Saque da conta",valor);
	        transactions.add(transaction);
	    }else {
	    	throw new BusinessException(saldoInsuficiente());
	    }
	}
	
	
	
	public String getAccountname() {
		return accountname;
	}

	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Long getId() {
		return id;
	}
	
	
	
	
	
	
	
	

	
}

package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Informe os dados da conta:");
		System.out.print("N�mero: ");
		int number = sc.nextInt();
		System.out.println("Titular: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.print("Saldo inicial: ");
		double balance = sc.nextDouble();
		System.out.println("Limte de saque: ");
		double withdrawLimit = sc.nextDouble();
		
		Account acc = new Account(number, holder, balance, withdrawLimit);
		
		System.out.println();
		System.out.print("Informe a quantia de saque: ");
		double amount = sc.nextDouble();
		
		if(amount > acc.getWithdrawLimit()) {
			System.out.println("Erro de saque: a quantia excede o limite de saque");
		}
		else if(amount > acc.getBalance()) {
			System.out.println("Erro de saque: saldo insuficiente");
		}
		else {
		
			acc.withdraw(amount);
			System.out.printf("Novo saldo: %.2f%n", acc.getBalance());
		
		}
		
	
		
		sc.close();

	}

}

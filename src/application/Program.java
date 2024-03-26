package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainExceptions;

public class Program {

	public static void main(String[] args) {

		//Maneira correta de tratar as exceções, tendo as responsabilidades dentro de suas classes e não no programa principal.
	
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try { //Iniciando o comando para tratamento de exceções || try (tente)
			System.out.print("Número do quarto: ");
			Integer nQuarto = sc.nextInt();
			System.out.print("Data de check-in (Dia/Mês/Ano): ");
			Date dataCheckIn = sdf.parse(sc.next());
			System.out.print("Data de check-out (Dia/Mês/Ano): ");
			Date dataCheckOut = sdf.parse(sc.next());

			Reservation reserva = new Reservation(nQuarto, dataCheckIn, dataCheckOut);
			System.out.println(reserva);
			System.out.println();

			System.out.println("Deseja atualizar a sua data de reserva ? (s/n) ");
			char resposta = sc.next().charAt(0);

			if (resposta == 's') {
				System.out.println("Insira a nova data de reserva: ");
				System.out.print("Data de check-in (Dia/Mês/Ano): ");
				dataCheckIn = sdf.parse(sc.next());
				System.out.print("Data de check-out (Dia/Mês/Ano): ");
				dataCheckOut = sdf.parse(sc.next());

				reserva.atualizarDatas(dataCheckIn, dataCheckOut);

				System.out.println("Reserva: " + reserva);
			}
			else {
				System.out.println(reserva);
			}
		} 
		catch (ParseException e) { //catch (pegar), repassando dentro do () o que será tratado no programa, no caso desse catch será o ParseException para datas.
			System.out.println("Formato de data inválido.");
		}
		catch (DomainExceptions e) { //Tratou a Exceção do método (atualizarDatas), repassando uma mensagem que está escrita na classe Reservation
			System.out.println(e.getMessage());
		}
		catch (RuntimeException e) { //Versão generica, fazendo um uppcasting para minha Exceção. Caso aconteça qualquer tipo de exceção RunTimeException será apresentado a mensagem de erro.
			System.out.println("Dado escrito de forma incorreta || Erro inesperado. ");
		}
		sc.close();

	}
}

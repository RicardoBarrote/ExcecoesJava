package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		// Método ruim, pós a lógica para efetuar a reserva encontra-se na classe
		// principal do programa, coisa que não deve acontecer, a lógica tem que ser
		// feita na classe de RESERVA (Reservation).
		//
		//
		//
		//

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Número do quarto: ");
		Integer nQuarto = sc.nextInt();
		System.out.print("Data de check-in (Dia/Mês/Ano): ");
		Date dataCheckIn = sdf.parse(sc.next());
		System.out.print("Data de check-out (Dia/Mês/Ano): ");
		Date dataCheckOut = sdf.parse(sc.next());

		if (!dataCheckOut.after(dataCheckIn)) {
			System.out.println("Erro: Data de check-out tem que ser futura a data de check-in. ");
		} else {
			Reservation reserva = new Reservation(nQuarto, dataCheckIn, dataCheckOut);
			System.out.println(reserva);

			System.out.println();

			System.out.print("Deseja atualizar os dados da reserva ? (s/n)");
			char resposta = sc.next().charAt(0);

			Date now = new Date();

			if (resposta == 's') {
				System.out.println();
				System.out.println("Insira a nova data de reserva: ");
				System.out.print("Data de check-in (Dia/Mês/Ano): ");
				dataCheckIn = sdf.parse(sc.next());
				System.out.print("Data de check-out (Dia/Mês/Ano): ");
				dataCheckOut = sdf.parse(sc.next());

				if (dataCheckIn.before(now) || dataCheckOut.before(now)) {
					System.out.println("Erro na reserva: Data de reserva para atualização deve ser futura");
				} else if (!dataCheckOut.after(dataCheckIn)) {
					System.out.println("Erro: Data de check-out tem que ser futura a data de check-in. ");
				} else {
					reserva.atualizarDatas(dataCheckIn, dataCheckOut);
					System.out.println("Reserva atualizada: " + reserva);
				}
			} else {
				System.out.println("Reserva mantida");
				System.out.println(reserva);
			}
		}

		sc.close();
	}

}

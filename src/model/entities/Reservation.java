package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;

	public Reservation() {

	}

	public Reservation(Integer numeroQuarto, Date checkIn, Date checkOut) {
		this.numeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}
	
	public long duracao () {
		long diferenca = checkOut.getTime() - checkIn.getTime(); //Comando vai pegar a diferença entre as datas em milisegundos || "(Comando .getTime())"
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS); //Classe TimeUnit é um tipo enumerado complexo com operações 
																		// comando está convertendo o valor de diferenca que está em milissegundos para DIAS
																		// Classe -> TimeUnit || .DAYS -> tipo que será convertido || .convert -> informando que será uma conversão do valor que estará dentro do () para DAYS.			
	}
	
	public void atualizarDatas (Date checkIn, Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString () {
		return "Reserva: Quarto "
				+ numeroQuarto
				+ ", check-In: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkOut)
				+ ", "
				+ duracao()
				+" noites";	}
}

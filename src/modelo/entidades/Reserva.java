package modelo.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {
	}
	public Reserva(Integer numeroQuarto, Date checkIn, Date checkOut) {
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
		public Date getCheckOut() {
		return checkOut;
	}
		
		
	public long duracaoDias() {
		long diferenca = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	}
	
	public String atualizaDatas(Date checkIn, Date checkOut) {
		if (checkIn.getTime() >= checkOut.getTime()) {
			return "Data de check-out tem de ser posterior ao check-in";
		} 
		Date hoje = new Date();
		if (checkIn.getTime() < hoje.getTime() ) {
			return "Datas tem que ser futuras";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}

	//boa pratica, colocar o @Override sempre no método toString que existe nativamente
	@Override
	public String toString() {
		return "Reserva: Quarto "
			 + numeroQuarto
			 + ", Check-in: "
			 + sdf.format(checkIn)
			 + ", check-Out: "
			 + sdf.format(checkOut)
			 + ", duracao "
			 + duracaoDias()
			 + " noites";
	}
	
	
}

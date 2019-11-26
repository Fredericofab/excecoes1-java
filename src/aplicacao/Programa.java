package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelo.entidades.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Numero do Quarto ");
		int numQuarto = sc.nextInt();

		System.out.print("Data Check-in (dd/mm/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data Check-out (dd/mm/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

		if (checkIn.getTime() >= checkOut.getTime()) {
			System.out.println("Data de check-out tem de ser posterior ao check-in");
		} 
		else {
			Reserva reserva = new Reserva(numQuarto, checkIn, checkOut);
			System.out.println(reserva.toString());

			System.out.println("Atualizacao da Reserva:");

			System.out.print("Data Check-in (dd/mm/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data Check-out (dd/mm/yyyy): ");
			checkOut = sdf.parse(sc.next());

			if (checkIn.getTime() >= checkOut.getTime()) {
				System.out.println("Data de check-out tem de ser posterior ao check-in");
			} 
			else {
				Date hoje = new Date();
				if (checkIn.getTime() > hoje.getTime() ) {
					reserva.atualizaDatas(checkIn, checkOut);
					System.out.println(reserva.toString());
				}
				else {
					System.out.println("Datas tem que ser futuras");
				}
			}
		}
		sc.close();
	}

}

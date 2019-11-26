package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelo.entidades.Reserva;
import modelo.excecoes.MinhaException;

public class Programa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Numero do Quarto ");

			int numQuarto = sc.nextInt();

			System.out.print("Data Check-in (dd/mm/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Data Check-out (dd/mm/yyyy): ");
			Date checkOut = sdf.parse(sc.next());

			Reserva reserva = new Reserva(numQuarto, checkIn, checkOut);
			System.out.println(reserva.toString());

			System.out.println("Atualizacao da Reserva:");

			System.out.print("Data Check-in (dd/mm/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data Check-out (dd/mm/yyyy): ");
			checkOut = sdf.parse(sc.next());

			reserva.atualizaDatas(checkIn, checkOut);
			System.out.println(reserva.toString());
		} 
		catch (ParseException x) {
			System.out.println("erro de conversao de data");
		}
//		catch (IllegalArgumentException x) {
//			System.out.println("erro na reserva: " + x.getMessage());
//		}
		catch (MinhaException x) {
			System.out.println("erro na reserva: " + x.getMessage());
		}
		catch (RuntimeException x) {
			System.out.println("erro nao esperado");
		}
		sc.close();
	}

}

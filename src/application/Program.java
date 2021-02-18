package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import mode.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {//main pode lançar exceção desse tipo, se acontecer, vai ser propagada
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next()); //pega a string que o usuário digitu e troca (parse) para data
											//ou trata a exceção com try catch ou propaga com o thows
		
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		//checkOut posterior a checkIn
		
		if(!checkOut.after(checkIn)) { //a data tem o metodo after que testa se uma data é posterior a outra
			
			System.out.println("Error in reservation: checkOut date must be after checkIn date");
		}
		else {
			
			Reservation reserv = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reserv);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next()); 
			
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date();
			
			if(checkIn.before(now) || checkOut.before(now)) {
				
				System.out.println("Error in reservation: Reservation dates for update must be future dates.");
			}
			else if (!checkOut.after(checkIn)) { //repete igual de cima, a data tem o metodo after que testa se uma data é posterior a outra
					
					System.out.println("Error in reservation: checkOut date must be after checkIn date");
			}
			else {
			reserv.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reserv);
			}
		}
		
		
		
		sc.close();
		
	}

}

package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	public Reservation() {}


	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
		//boa pratica, tratar a exceção no começo dos metodos
		//já no construtor
		//PROGRAMAÇÃO DEFENSIVA
		if (!checkOut.after(checkIn)) { //repete igual de cima, a data tem o metodo after que testa se uma data é posterior a outra
			//Exceção personalizada
			//throw new IllegalArgumentException ("CheckOut date must be after checkIn date");
			throw new DomainException("CheckOut date must be after checkIn date");
		}	
		
		
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}


	public Integer getRoomNumber() {
		return roomNumber;
	}


	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}


	public Date getCheckIn() {
		return checkIn;
	}



	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		
		long diff = checkOut.getTime() - checkIn.getTime(); // pega a diferença entre as datas em milisegundos
	   //converter milisegundos para dias
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkIn, Date checkOut) throws DomainException {
		
		Date now = new Date();		
		if(checkIn.before(now) || checkOut.before(now)) {
			
			//lançar exceção
			//quem trata é o programa principal pelo TRY CATCH
			//IllegalArgumentException --> quando os argumentos que vc passa para um metodo, são invalidos
			//throw new IllegalArgumentException ("Reservation dates for update must be future dates.");
			
			//Exceção personalizada
			throw new DomainException("Reservation dates for update must be future dates.");
		}
		
		if (!checkOut.after(checkIn)) { //repete igual de cima, a data tem o metodo after que testa se uma data é posterior a outra
				
			//Exceção personalizada
			//throw new IllegalArgumentException ("CheckOut date must be after checkIn date");
			throw new DomainException("CheckOut date must be after checkIn date");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Room " +
				+ roomNumber
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkOut)
				+ ", "
				+ duration()
				+ " nights";
		
		
		
		
	}

}

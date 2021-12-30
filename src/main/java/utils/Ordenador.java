package utils;

import java.util.Comparator;

import models.Libro;

//este seria nuestro ordenador
public class Ordenador implements Comparator<Libro> {

	@Override 
	public int compare(Libro o1, Libro o2) {
		return -Integer.compare(o1.getPaginas(), o2.getPaginas());
	}
}

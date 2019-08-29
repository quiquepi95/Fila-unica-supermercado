package fila;

public class Metodos {

	public void inicializarArrayCajasVacias() {
		
		for(int i = 0; i < Inicializacion.nCajas; i++) {
			Inicializacion.cajaVacia[i] = true;
		}
	}

	public void inicializarArrayNumClientesEnCaja() {
		
		for(int i = 0; i < Inicializacion.nCajas; i++) {
			Inicializacion.personasEnCaja[i] = 0;
		}
	}
	
public void inicializarArraySalidaCajas() {
		
		for(int i = 0; i < Inicializacion.nCajas; i++) {
			Inicializacion.salidaCaja[i] = false;
		}
	}
}

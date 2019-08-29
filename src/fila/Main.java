package fila;


public class Main {

	
	private static Personas personas[];
	
	private static Cajas caja[];
	
	public static void main(String[] args) {
		Metodos m = new Metodos();

		caja = new Cajas[Inicializacion.nCajas];
		
		for(int i = 0; i < Inicializacion.nCajas; i++) {
			caja[i] = new Cajas(i);
			//caja[i].start();
		}
		
		m.inicializarArrayCajasVacias();
		m.inicializarArrayNumClientesEnCaja();
		m.inicializarArraySalidaCajas();
		
		
		personas = new Personas[Inicializacion.nPersonas];
		
		for(int i = 0; i < Inicializacion.nPersonas; i++) {
			personas[i] = new Personas(i,caja);
			personas[i].start();
			try {
				Thread.sleep(Inicializacion.aleatorio.nextInt(500)+100); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
	}

}

package fila;

class Cajas extends Thread{
	
	int cajas;
	Personas personas[];
	
	Cajas(int i){
		cajas = i;
		this.setName("Caja " + (i+1));
	}
	
	/*public void run() {
		
		System.out.println("Abriendo " + this.getName());
		
		while(!Inicializacion.cerrarCajas) {
			
			if(Inicializacion.personasEnCaja[cajas] == 0) {
				Inicializacion.cajaVacia[cajas] = true;
			} else {
				Inicializacion.cajaVacia[cajas] = false;
			}
		}
		
		
		System.out.println("Cerrando " + this.getName());
	}*/
	
	
	/*synchronized public void pasarACaja(int caja, int cliente) {
		// Indicar que la caja no está vacía
		Inicializacion.cajaVacia[cajas] = false;
		
		// Contador de personas en caja
		Inicializacion.personasEnCaja[caja]++;
		
		// Mostrar que el cliente pasa y muestra el nº de clientes de esa caja
		System.out.println("\tEl cliente " + (cliente + 1) + " pasa a la caja " + getName() + "\n");
		System.out.println("\tNúmero de clientes en "+ getName() + ": " + Inicializacion.personasEnCaja[caja] + "");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("Error en la atención al cliente.");
		}
		
		// Decimos que el cliente ha salido, así podemos acabar el bucle de la persona
		Inicializacion.salidaCaja[cliente] = true;
		
		// Mostramos que acaba de salir
		System.out.println("\tEl cliente " + (cliente + 1) + " acaba de salir de la " + getName() + "\n");
		
		// Indicamos que se vacía la caja
		Inicializacion.cajaVacia[cajas] = true;
		
		// Bajamos el contador de las personas en caja y lo mostramos
		Inicializacion.personasEnCaja[caja]--;
		System.out.println("\tNúmero de clientes en "+ getName() + ": " + Inicializacion.personasEnCaja[caja] + "");
		
		// Comprobar si hay gente en la cola o no
		
		Inicializacion.comprobarSiEsperan = true;
		//while (Inicializacion.comprobarSiEsperan) {
			if(Inicializacion.clienteEsperando > 0) {
				notify();
				System.out.println("Saliendo un esperando.");
			}
		//}
		
	}*/

}

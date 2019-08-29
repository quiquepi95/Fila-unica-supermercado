package fila;

class Personas extends Thread {
	
	Cajas c[];
	int cliente;
	boolean yaHeEsperadoCola = false;
	
	Personas(int i, Cajas[] caja) {
		cliente = i;
		this.c = caja;
		this.setName("Cliente " + (i+1));
	}
	
	synchronized void esperarEnCola() {
		System.out.println(this.getName() + " esperando en la cola.");
		Inicializacion.clienteEsperando++;
		try {
			wait();
		} catch (InterruptedException e) {
			System.out.println("Error en la espera.");
		}
		Inicializacion.comprobarSiEsperan = false;
		yaHeEsperadoCola = true;
		Inicializacion.clienteEsperando--;
		System.out.println("Ha acabado de esperar el " + getName());
	}
	
	synchronized void comprobarEsperando() {
		if(Inicializacion.clienteEsperando > 0) {
			notify();
			System.out.println("Saliendo un esperando.");
		}
	}
	
	
	synchronized void pasarACaja(int caja, int cliente) {
		// Indicar que la caja no está vacía
		Inicializacion.cajaVacia[c[caja].cajas] = false; 
		
		// Contador de personas en caja
		Inicializacion.personasEnCaja[caja]++; 
		
		// Mostrar que el cliente pasa y muestra el nº de clientes de esa caja
		System.out.println("\tEl " + getName() + " pasa a la caja " + c[caja].getName() + "\n");
		System.out.println("\tNúmero de clientes en "+ c[caja].getName() + ": " + Inicializacion.personasEnCaja[caja] + "");
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("Error en la atención al cliente.");
		}
		
		// Decimos que el cliente ha salido, así podemos acabar el bucle de la persona
		Inicializacion.salidaCaja[cliente] = true;
		
		// Mostramos que acaba de salir
		System.out.println("\tEl " + getName() + " acaba de salir de la " + c[caja].getName() + "\n");
		
		// Indicamos que se vacía la caja
		Inicializacion.cajaVacia[caja] = true;
		
		// Bajamos el contador de las personas en caja y lo mostramos
		Inicializacion.personasEnCaja[caja]--;
		System.out.println("\tNúmero de clientes en "+ c[caja].getName() + ": " + Inicializacion.personasEnCaja[caja] + "");
		
		
//		comprobarEsperando();
		
	}
	
	
	

	public void run() {
		System.out.println("Ha llegado el "+ this.getName() + "\n");
		
		// Hacemos un bucle hasta que el cliente salga de la caja
		while(!Inicializacion.salidaCaja[cliente]) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println("Error en la espera para que no pasen los clientes tan rápido.");
			}
			
			int j = 0;
			boolean comprobarCajaVacia = false;
		
			// Hacemos un bucle para comprobar que caja está vacía o tienen que esperar
			while(!comprobarCajaVacia && j < Inicializacion.nCajas) {
				if(Inicializacion.clienteEsperando > 0 && !yaHeEsperadoCola) {
					//Si hay clientes esperando, entra en espera
					System.out.println("Hay otros clientes esperando.");
					esperarEnCola();
				} else {
					// Sino comprobamos que esté vacía la caja o no.
					if(Inicializacion.cajaVacia[j]) {
						c[j] = new Cajas(j);
						pasarACaja(j,cliente);
//						c[j].pasarACaja(j,cliente);
						comprobarCajaVacia = true;
					} else {
						// Si está ocupada, indicamos que lo está
						System.out.println("Soy el " + this.getName() + " y la caja " + (j+1) + " está ocupada.");
					}
				}
				j++;
			} // fin for nCajas
			
			if(!comprobarCajaVacia) esperarEnCola();
		} // fin while salidaCaja
		
		comprobarEsperando();
		
		System.out.println("Soy " + this.getName() + " Ya he comprado. Me voy del super.");
		
		
	}

	

	

	

}

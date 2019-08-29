package fila;

import java.util.Random;

class Inicializacion {
	
	public final static int nPersonas = 10;
	public final static int nCajas = 4;
	
	public static int clienteEsperando = 0;
	
	public static boolean cerrarCajas = false;
	
	public static boolean[] cajaVacia = new boolean[nCajas];
	
	public static int[] personasEnCaja = new int[nCajas];
	
	public static boolean[] salidaCaja = new boolean[nPersonas];
	
	public static Random aleatorio = new Random();
	
	public static boolean comprobarSiEsperan = true;

}

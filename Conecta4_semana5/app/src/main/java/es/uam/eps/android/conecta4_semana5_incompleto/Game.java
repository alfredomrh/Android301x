package es.uam.eps.android.conecta4_semana5_incompleto;

import java.util.Random;

public class Game {
	static final int NFILAS = 6;
	static final int NCOLUMNAS = 7;
	static final int VACIO = 0;
	static final int MAQUINA = 1;
	private final String MAQUINASTR = "1111";
	static final int JUGADOR = 2;
	private final String JUGADORSTR = "2222";
	private int tablero[][];
	private boolean juego_activo = true;
	//Constructor de la clase inicializa el tablero a vacio
	public Game() {
		tablero = new int[NFILAS][NCOLUMNAS];
		for (int i = 0; i < NFILAS; i++)
			for (int j = 0; j < NCOLUMNAS; j++)
				tablero[i][j] = VACIO;
	}
	//metodo que retorna el valor de una posicion del tablero
	public int getTablero(int i, int j) {
		return tablero[i][j];
	}

    /*************************************************************************
    Completa este metodo.
    Parametros: indices i y j del tablero.
    Retorno: cierto si la posicion tablero[i][j] esta vacia (su valor
    es VACIO) y falso en caso contrario
    *************************************************************************/
    public boolean estaVacio(int i, int j) {
        // Aqui debes incluir tu codigo
		if(tablero[i][j] == VACIO)

			return true;

		return false;
    }

	public boolean estaMaquina(int i, int j) {
		return tablero[i][j] == MAQUINA;
	}

    /*************************************************************************
    Completa este metodo.
    Parametros: indices i y j del tablero.
    Retorno: cierto si la posicion tablero[i][j] esta ocupada por el
    jugador (su valor es JUGADOR) y falso en caso contrario
    *************************************************************************/
    public boolean estaJugador(int i, int j) {
   	
    	// Aqui debes incluir tu codigo
		if(tablero[i][j] == JUGADOR)

			return true;

		return false;
    }

	public void setJugador(int i, int j) {
		tablero[i][j] = JUGADOR;
	}

	public boolean tableroLleno() {

		for (int i = 0; i < NFILAS; i++)
			for (int j = 0; j < NCOLUMNAS; j++)
				if (tablero[i][j] == VACIO)
					return false;

		return true;
	}
	//si el tablero esta lleno o el juego inactivo retorna true
	public boolean finalJuego() {
		if (tableroLleno() || !juego_activo)
			return true;

		return false;
	}

    /*************************************************************************
    Completa este metodo.
    Parametros: indices i y j del tablero.
    Retorno: cierto si se puede colocar ficha en la posicion (i,j) del
    tablero. Debes comprobar que esa posicion del tablero esta vacia
    (su valor es VACIO) y que es la posicion vacia mas baja del tablero.
    En caso contrario, la funcion debe devolver false.
    *************************************************************************/
    public boolean sePuedeColocarFicha(int i, int j) {
        // Aqui debes incluir tu codigo
		if(estaVacio(i,j)) {//primero comprueba que la posicion esta vacia

			for (int pf = 0; pf < i; pf++) //recorre desde la fila cero de esa columna viendo si las fichas estan ocupadas hasta la posicion deseada

				if (tablero[pf][j] == VACIO) return false;

		}

		else return false;

		return true;
    }

	public void juegaMaquina() {
		int i;
		int fila = -1, columna = 0;
		Random r = new Random();

		do {
			columna = r.nextInt(NCOLUMNAS);
			for (i = 0; i < NFILAS; i++)
				if (tablero[i][columna] == VACIO) {
					fila = i;
					break;
				}
		} while (fila < 0);

		tablero[fila][columna] = MAQUINA;
	}

	boolean comprobarCuatro(int turno) {
		if (comprobarFilas(turno) || comprobarColumnas(turno) || comprobarDiagonales(turno)) {
			juego_activo = false;
			return true;
		}
		return false;
	}

	boolean comprobarFilas(int turno) {
		String cadena = turno == MAQUINA ? MAQUINASTR : JUGADORSTR;

		for (int i = 0; i < NFILAS; i++) {
			String str = "";
			for (int j = 0; j < NCOLUMNAS; j++)
				str += Integer.toString(tablero[i][j]);
			if (str.contains(cadena))
				return true;
		}

		return false;
	}

    /*************************************************************************
    Completa este metodo.
    Parametro: turno que puede ser MAQUINA o JUGADOR.
    Retorno: true si se el jugador correspondiente al turno tiene cuatro fichas
    contiguas verticalmente, o false en caso contrario.
    *************************************************************************/
	boolean comprobarColumnas(int turno) {
		// Coloca aqui tu codigo
		String cadena = turno == MAQUINA ? MAQUINASTR : JUGADORSTR;

		for (int j = 0; j < NCOLUMNAS; j++) {
			String str = "";
			for (int i = 0; i < NFILAS; i++)
				str += Integer.toString(tablero[i][j]);
			if (str.contains(cadena))
				return true;
		}
		
		return false;
	}

	boolean comprobarDiagonales(int turno) {
		String cadena = turno == MAQUINA ? MAQUINASTR : JUGADORSTR;

		for (int i = 0; i < 3; i++) {
			String str = "";
			for (int k = 0; k < 6 - i; k++)
				str += Integer.toString(tablero[i + k][k]);
			if (str.contains(cadena))
				return true;
		}

		for (int j = 1; j < 4; j++) {
			String str = "";
			for (int k = 0; k < 7 - j; k++)
				str += Integer.toString(tablero[k][j + k]);
			if (str.contains(cadena))
				return true;
		}

		return false;
	}
	
    /*************************************************************************
    Completa este metodo.
    El metodo debe eliminar las fichas de todas las posiciones del tablero y
    ajustar el estado del juego como activo.
    *************************************************************************/
	public void restart() {
		// Coloca aqui tu codigo
		for (int i = 0; i < NFILAS; i++)
			for (int j = 0; j < NCOLUMNAS; j++)
				tablero[i][j] = VACIO;

		juego_activo = true;

	}
}

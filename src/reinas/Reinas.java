/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reinas;

import javax.swing.JOptionPane;

/**
 *
 * @author nesto
 */
public class Reinas {
        public static void main(String[] args) {
		String[][] tablero =new String [8][8];
		
		tablero = llenarTablero(8);
		ubicarReina(tablero, 0);
	}

	public static void ubicarReina(String[][] tablero, int etapa) {

		for (int i = 0; i < tablero.length; i++) {
			if (Valido(tablero, i, etapa)) {
				tablero[i][etapa] = "♕";

				if (etapa < tablero.length - 1) {
					ubicarReina(tablero, etapa + 1);
				} else {
					imprimir(tablero);
                                        System.exit(0);
				}

				tablero[i][etapa] = " ";
			}

		}
	}
       
	public static boolean Valido(String[][] tablero, int i, int etapa) {

		for (int x = 0; x < etapa; x++) {
			if (tablero[i][x].equals("♕")) {
				return false;
			}
		}

		for (int j = 0; j < tablero.length && (i - j) >= 0 && (etapa - j) >= 0; j++) {

			if (tablero[i - j][etapa - j].equals("♕")) {
				return false;
			}

		}

		for (int j = 0; j < tablero.length && (i + j) < tablero.length && etapa - j >= 0; j++) {

			if (tablero[i + j][etapa - j].equals("♕")) {
				return false;
			}
		}

		return true;

	}

	public static String[][] llenarTablero(int length) {
		String[][] res = new String[length][length];
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res.length; j++) {
				res[i][j] = " ";
			}
		}
		return res;
	}

	public static void imprimir(String[][] tablero) {
                String M="";
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
                                M+="("+ tablero[i][j] + ")";
			}
                        M+="\n";
		}
                JOptionPane.showMessageDialog(null, M);
	}
}

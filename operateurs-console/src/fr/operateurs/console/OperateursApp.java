package fr.operateurs.console;

import java.util.Scanner;

public class OperateursApp {

	public static void main(String[] args) {
		System.out.println("Operateur :");
		Scanner sc = new Scanner(System.in);
		double nb = sc.nextDouble();
		System.out.println("NB = " + nb + "\n ");
		double nb2 = sc.nextDouble();
		System.out.println("NB2 = " + nb + "\n ");

		System.out.println("NB + NB2 = " + (nb + nb2) + 
				"\nNB - NB2 = " + (nb - nb2) + 
				"\nNB * NB2 = " + (nb * nb2) + 
				"\nNB / NB2 = " + (nb / nb2) + 
				"\nNB % NB2 = " + (nb % nb2));

		sc.close();
	}

}

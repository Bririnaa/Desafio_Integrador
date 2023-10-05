package desafio;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Desafio {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		// clase random para generar numeros aleatorios
		Random random = new Random();

		int numeroSecreto = random.nextInt(100) + 1;
		// Para limitar el "random.nextInt()" debemos proporcionarle un argumento dentro
		// del parentesis.

		int num;
		int intentos = 0;

		do {
			try {
				System.out.println("\nIngrese un numero entre 1-100: ");
				num = entrada.nextInt();

				if (num < 1 || num > 100) {
					throw new ArithmeticException();
				}

				while (num != numeroSecreto && intentos != 10) {
					intentos++;

					System.out.println("");
					System.out.println("Intentos:" + intentos);

					if (num > numeroSecreto) {
						System.out.println("El numero ingresado es mayor al secreto.");
					}

					if (num < numeroSecreto) {
						System.out.println("El numero ingresado es menor al secreto.");
					}

					System.out.println("\nIngrese un numero entre 1-100: ");
					num = entrada.nextInt();

					if (num < 1 || num > 100) {
						throw new ArithmeticException();
					}

				}

				if (num == numeroSecreto) {
					System.out.println("Adivinaste!");
					System.out.println("Cant. de intentos: " + intentos);
				}
				if (intentos == 10) {
					System.out.println("Agotaste tus 10 intentos. El número secreto era: " + numeroSecreto);
				}
			} catch (InputMismatchException e) {
				System.out.println("Error: Dato invalido.");
				entrada.nextLine(); // Consume la entrada incorrecta.
			} catch (ArithmeticException e) {
				System.out.println("Error: Ingreso un numero menor a 1 o mayor a 100.");
				entrada.nextLine();
			}

		} while (true);
		// el do-while sirve para que se repita el código si se cumple cualquiera de las
		// excepciones

	}
}

package com.nmetivier;

import java.util.Scanner;

/**
 * Première classe du programme. 
 * TP qui reprend : 
 * 		L'initialisation des variables (tout type) 
 * 		L'utilisation de tableaux 
 * 		La déclaration de méthodes (fonctions) (avec arguments) 
 * 		L'extraction de code pour avoir des méthodes. (Selection de code + Refactor/Extract Method) 
 * 		L'utilisation du clavier 
 * 		Les conditions 
 * 		Les boucles
 * 
 * Pour générer le programme en exécutable : 
 * 		File/Export
 * 		Runnable JAR File
 * 		Launch Application = Classe contenant le point d'entrée (public stativ void main(String[] args) {)
 * 		Export Destination = Dossier ou va etre créé l'exécutable + nom de l'éxécutable.
 *
 * Pour éxécuter le fichier généré :
 * 		Sous MICROSOFT Windows:
 * 			Ouvrir l'invite de commande. ([Win]+[R])
 * 			Ecrire "cmd"
 * 			Appuyer sur Entrée
 * 			Ecrire "java -jar "
 * 			Sélectionner 
 * 
 * @author METIVIER Nocolas
 * @version 0.0.1
 *
 */
public class Program {

	public static void main(String[] args) {

		// Tableau en 2D qui représente mes utilisateurs.
		Object[][] informationsUtilisateur = new Object[2][4];

		// Je créé mon mon claver.
		Scanner clavier = new Scanner(System.in);

		// Je déclarre sans initialiser 3 variables du même type.
		String nom, prenom, dateDeNaissance;

		// Je fais une boucle pour créer les 2 utilisateurs.
		// On connait les bornes de la boucle. [0;2[
		for (int utilisateursCrees = 0; utilisateursCrees < 2; utilisateursCrees++) {
			prenom = recupererPrenom(clavier);
			nom = recupererNom(clavier);
			dateDeNaissance = recupererDateDeNaissance(clavier);

			String dateAujourdHui = "15/03/2018";

			// On calcule l'age.
			byte age = calculerAge(dateAujourdHui, dateDeNaissance);

			// On affiche la majorité de la personne.
			verifierMajorite(age, nom, prenom);

			// On initialise le tableau en fonction de l'utilisateur.
			informationsUtilisateur[utilisateursCrees][0] = nom;
			informationsUtilisateur[utilisateursCrees][1] = prenom;
			informationsUtilisateur[utilisateursCrees][2] = dateDeNaissance;
			informationsUtilisateur[utilisateursCrees][3] = age;

		}

		// On affiche le tableau en 2 dimensions.
		afficherTableau2D(informationsUtilisateur);

	}

	/**
	 * Affiche un tableau en 2 dimensions.
	 * 
	 * @param informationsUtilisateur
	 *            Tableau en 2 dimensions.
	 */
	private static void afficherTableau2D(Object[][] informationsUtilisateur) {
		// Pour chaque ligne de mon tableau...
		for (int index = 0; index < informationsUtilisateur.length; index++) {
			// Pour chaque colonne de mon tableau...
			for (Object information : informationsUtilisateur[index]) {
				// J'affiche le contenu de la cellule.
				System.out.println(information);
			}
		}
	}

	/**
	 * Vérifie la majorité d'une personne.
	 * 
	 * @param age
	 *            Age de la persone.
	 * @param nom
	 *            Nom de la personne.
	 * @param prenom
	 *            Prénom de la personne.
	 */
	private static void verifierMajorite(byte age, String nom, String prenom) {
		// Si l'age est inférieur à 18...
		if (age < 18) {
			System.out.println(nom + " " + prenom + " n'est pas majeur.");
		} else { // Sinon....
			System.out.println(nom + " " + prenom + " est majeur.");
		}
	}

	/**
	 * Calcule la difference d'années entre deux date.
	 * 
	 * @param dateAujourdHuiCopie
	 *            Date d'aujourd'hui.
	 * @param dateDeNaissanceCopie
	 *            Date d'anniversaire.
	 * @return Age calculé.
	 */
	private static byte calculerAge(String dateAujourdHuiCopie, String dateDeNaissanceCopie) {
		// On découpe la date de naissance dans un tableau...
		// ... puis on récupère l'année grace à l'index dans le tableau...
		// ... enfin on convertis le resultat en Short.
		short anneeDeNaissance = Short.parseShort(dateDeNaissanceCopie.split("/")[2]);
		short anneeDAujourdHui = Short.parseShort(dateAujourdHuiCopie.split("/")[2]);

		// On renvoie le calcul convertit en byte pour que le type retourné
		// correspondent au type de la fonction.
		return (byte) (anneeDAujourdHui - anneeDeNaissance);
	}

	/**
	 * 
	 * @param clavierCopie
	 * @return
	 */
	private static String recupererDateDeNaissance(Scanner clavierCopie) {
		String date;
		System.out.println("Entrer votre date de naissance (XX/XX/XXXX) : ");
		date = clavierCopie.nextLine();
		return date;
	}

	/**
	 * Premet de récupérer un nom.
	 * 
	 * @param clavierCopie
	 *            Objet de type Scanner.
	 * @return Nom
	 */
	private static String recupererNom(Scanner clavierCopie) {
		// Vérifier qu'un prénom est au bon format.
		boolean verificateur = false;
		String lastName;

		// On doit au moins rentrer une fois dans la boucle.
		// On boucle tant que le vérificateur est faux.
		do {
			System.out.print("Entrez votre nom : ");

			// Je demande à l'utilisateur de saisir son prénom.
			lastName = clavierCopie.nextLine();

			// Si le prénom est composé d'au moins 3 lettres...
			if (lastName.length() >= 3) {
				// On vérifie que le prénom ne contient que des lettres.
				verificateur = lastName.chars().allMatch(Character::isLetter);
			}

		} while (verificateur != true);

		return lastName;
	}

	/**
	 * Récupérer le prénom d'une personne.
	 * 
	 * @param clavierCopie
	 *            Object de type Scanner.
	 * @return Prénom de l'utilisateur.
	 */
	static String recupererPrenom(Scanner clavierCopie) {
		// Vérifier qu'un prénom est au bon format.
		boolean verificateur = false;
		String firstName;

		// On doit au moins rentrer une fois dans la boucle.
		// On boucle tant que le vérificateur est faux.
		do {
			System.out.print("Entrez votre prénom : ");

			// Je demande à l'utilisateur de saisir son prénom.
			firstName = clavierCopie.nextLine();

			// Si le prénom est composé d'au moins 3 lettres...
			if (firstName.length() >= 3) {
				// On vérifie que le prénom ne contient que des lettres.
				verificateur = firstName.chars().allMatch(Character::isLetter);
			}

		} while (verificateur != true);

		return firstName;
	}

}

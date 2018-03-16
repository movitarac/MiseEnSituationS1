package andriani.com;

import java.util.Scanner;

/**
 * Premi�re classe du programme. 
 * TP qui reprend : 
 * 		L'initialisation des variables (tout type) 
 * 		L'utilisation de tableaux 
 * 		La d�claration de m�thodes (fonctions) (avec arguments) 
 * 		L'extraction de code pour avoir des m�thodes. (Selection de code + Refactor/Extract Method) 
 * 		L'utilisation du clavier 
 * 		Les conditions 
 * 		Les boucles
 * 
 * Pour g�n�rer le programme en ex�cutable : 
 * 		File/Export
 * 		Runnable JAR File
 * 		Launch Application = Classe contenant le point d'entr�e (public stativ void main(String[] args) {)
 * 		Export Destination = Dossier ou va etre cr�� l'ex�cutable + nom de l'�x�cutable.
 *
 * Pour �x�cuter le fichier g�n�r� :
 * 		Sous MICROSOFT Windows:
 * 			Ouvrir l'invite de commande. ([Win]+[R])
 * 			Ecrire "cmd"
 * 			Appuyer sur Entr�e
 * 			Ecrire "java -jar "
 * 			S�lectionner 
 * 
 * @author METIVIER Nocolas
 * @version 0.0.1
 *
 */
public class Program {

	public static void main(String[] args) {

		// Tableau en 2D qui repr�sente mes utilisateurs.
		Object[][] informationsUtilisateur = new Object[2][4];

		// Je cr�� mon mon claver.
		Scanner clavier = new Scanner(System.in);

		// Je d�clarre sans initialiser 3 variables du m�me type.
		String nom, prenom, dateDeNaissance;

		// Je fais une boucle pour cr�er les 2 utilisateurs.
		// On connait les bornes de la boucle. [0;2[
		for (int utilisateursCrees = 0; utilisateursCrees < 2; utilisateursCrees++) {
			prenom = recupererPrenom(clavier);
			nom = recupererNom(clavier);
			dateDeNaissance = recupererDateDeNaissance(clavier);

			String dateAujourdHui = "15/03/2018";

			// On calcule l'age.
			byte age = calculerAge(dateAujourdHui, dateDeNaissance);

			// On affiche la majorit� de la personne.
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
	 * V�rifie la majorit� d'une personne.
	 * 
	 * @param age
	 *            Age de la persone.
	 * @param nom
	 *            Nom de la personne.
	 * @param prenom
	 *            Pr�nom de la personne.
	 */
	private static void verifierMajorite(byte age, String nom, String prenom) {
		// Si l'age est inf�rieur � 18...
		if (age < 18) {
			System.out.println(nom + " " + prenom + " n'est pas majeur.");
		} else { // Sinon....
			System.out.println(nom + " " + prenom + " est majeur.");
		}
	}

	/**
	 * Calcule la difference d'ann�es entre deux date.
	 * 
	 * @param dateAujourdHuiCopie
	 *            Date d'aujourd'hui.
	 * @param dateDeNaissanceCopie
	 *            Date d'anniversaire.
	 * @return Age calcul�.
	 */
	private static byte calculerAge(String dateAujourdHuiCopie, String dateDeNaissanceCopie) {
		// On d�coupe la date de naissance dans un tableau...
		// ... puis on r�cup�re l'ann�e grace � l'index dans le tableau...
		// ... enfin on convertis le resultat en Short.
		short anneeDeNaissance = Short.parseShort(dateDeNaissanceCopie.split("/")[2]);
		short anneeDAujourdHui = Short.parseShort(dateAujourdHuiCopie.split("/")[2]);

		// On renvoie le calcul convertit en byte pour que le type retourn�
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
	 * Premet de r�cup�rer un nom.
	 * 
	 * @param clavierCopie
	 *            Objet de type Scanner.
	 * @return Nom
	 */
	private static String recupererNom(Scanner clavierCopie) {
		// V�rifier qu'un pr�nom est au bon format.
		boolean verificateur = false;
		String lastName;

		// On doit au moins rentrer une fois dans la boucle.
		// On boucle tant que le v�rificateur est faux.
		do {
			System.out.print("Entrez votre nom : ");

			// Je demande � l'utilisateur de saisir son pr�nom.
			lastName = clavierCopie.nextLine();

			// Si le pr�nom est compos� d'au moins 3 lettres...
			if (lastName.length() >= 3) {
				// On v�rifie que le pr�nom ne contient que des lettres.
				verificateur = lastName.chars().allMatch(Character::isLetter);
			}

		} while (verificateur != true);

		return lastName;
	}

	/**
	 * R�cup�rer le pr�nom d'une personne.
	 * 
	 * @param clavierCopie
	 *            Object de type Scanner.
	 * @return Pr�nom de l'utilisateur.
	 */
	static String recupererPrenom(Scanner clavierCopie) {
		// V�rifier qu'un pr�nom est au bon format.
		boolean verificateur = false;
		String firstName;

		// On doit au moins rentrer une fois dans la boucle.
		// On boucle tant que le v�rificateur est faux.
		do {
			System.out.print("Entrez votre pr�nom : ");

			// Je demande � l'utilisateur de saisir son pr�nom.
			firstName = clavierCopie.nextLine();

			// Si le pr�nom est compos� d'au moins 3 lettres...
			if (firstName.length() >= 3) {
				// On v�rifie que le pr�nom ne contient que des lettres.
				verificateur = firstName.chars().allMatch(Character::isLetter);
			}

		} while (verificateur != true);

		return firstName;
	}

}

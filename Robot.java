/**
 * Robot
 * @author Pierre Cauvin
 * @version du 01/10/23
 */

import iut.algo.ControleGraphique;
import iut.algo.Couleur;

public class Robot
{

	public static void direction(ControleGraphique ct, int centerX, int centerY, int taille, char dir, Couleur couleur)
	{
		/*-----------------*/
		/* Constantes      */
		/*-----------------*/
		final int TAILLE_TABLEAU = 3;
		
		/*-----------------*/
		/* Variables       */
		/*-----------------*/
		double angle;
		double angleRad;

		int[] x;
		int[] y;


		/*-----------------*/
		/* Initialisation  */
		/*-----------------*/
		angle    = 0;
		angleRad = 0;
		
		x = new int[TAILLE_TABLEAU];
		y = new int[TAILLE_TABLEAU];
		

		/*-----------------*/
		/* Instructions    */
		/*-----------------*/

		// effacer le calque M et dessiner dessus

		ct.effacer('M');
		ct.setTypeAction('M');

		// On calcule les coordonnées des sommets du triangle grâce au angles
		switch (dir)
		{
		case 'S':
			angle = 90;
			break;
		case 'O':
			angle = 180;
			break;
		case 'N':
			angle = 270;
			break;
		case 'E':
		default:
			angle = 0;
			break;
		}

		angleRad = Math.toRadians(angle);

		for (int i = 0; i < 3; i++)
		{
			
			x[i] = (int) (centerX + taille * Math.cos(angleRad));
			y[i] = (int) (centerY + taille * Math.sin(angleRad));
			
			angleRad += 2 * Math.PI / TAILLE_TABLEAU; // Équidistance entre les sommets

		}

		// cercle du robot
		ct.prendreStylo(couleur);
		ct.cercle(centerX, centerY, taille);

		// Lignes qui definisse la direction du robot
		ct.ligne(x[0], y[0], x[1], y[1]);
		ct.ligne(x[2], y[2], x[0], y[0]);
		// ct.ligne(x[1], y[1], x[2], y[2]); // Pas besoin de cette ligne, elle ferme le triangle

		// Retour au calque F
		ct.setTypeAction('F');
	}

}
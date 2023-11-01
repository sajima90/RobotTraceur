/**
 * RobotTraceurGUI
 * @author Pierre Cauvin
 * @version du 01/10/23
 */

import iut.algo.Clavier;
import iut.algo.ControleGraphique;
import iut.algo.Couleur;

public class RobotTraceur
{

	public static void main(String[] args)
	{

		final int TAILLE_CERCLE = 10;

		int poX = 100, poY = 100;
		char dir = 'N';
		boolean trace = true;

		int dist = 0;
		int xDepart = 0;
		int yDepart = 0;
		int xArrive = 0;
		int yArrive = 0;

		int rotations = 0;
		ControleGraphique ct = new ControleGraphique();
		ct.setTaille(600, 500);
		Couleur couleur = Couleur.VERT;

		Robot.direction(ct, poX, poY, TAILLE_CERCLE, dir, couleur);
		ct.majDessin();

		while (true)
		{
			System.out.print("[" + dir + "   " + poX + ":" + poY + "] \t action : ");
			String action = Clavier.lireString().toUpperCase();

			if (action.equals("FIN"))
			{
				System.out.println("Fermez la fenêtre graphique pour terminer le programme.");
				break;
			}

			if (Outil.estUnEntier(action))
			{
				dist = Integer.parseInt(action);
				if (dist >= 0)
				{
					xDepart = poX;
					yDepart = poY;
					switch (dir)
					{
					case 'N':
						poY -= dist;
						break;
					case 'O':
						poX -= dist;
						break;
					case 'S':
						poY += dist;
						break;
					case 'E':
						poX += dist;
						break;
					}
					xArrive = poX;
					yArrive = poY;

					if (trace){
						ct.ligne(xDepart, yDepart, xArrive, yArrive);
						ct.prendreStylo(Couleur.VIOLET);
					}

					Robot.direction(ct, xArrive, yArrive, TAILLE_CERCLE, dir, couleur);
					ct.majDessin();
				}
			}
			else if (action.equals("G") || action.equals("D"))
			{
				// 3 rotations à gauche, 1 rotation à droite
				rotations = action.equals("G") ? 3 : 1;
				for (int i = 0; i < rotations; i++)
				{
					dir = tourner('D', dir);
				}
				Robot.direction(ct, poX, poY, TAILLE_CERCLE, dir, couleur);
				ct.majDessin();
			}
			else if (action.equals("T"))
			{
				couleur = (trace) ? Couleur.ROUGE : Couleur.VERT;
				trace = !trace;
				Robot.direction(ct, poX, poY, TAILLE_CERCLE, dir, couleur);
				ct.majDessin();
			}

		}
	}

	public static char tourner(char dir, char orient)
	{
		if (dir == 'D')
		{
			switch (orient)
			{
			case 'N':
				orient = 'E';
				break;
			case 'O':
				orient = 'N';
				break;
			case 'E':
				orient = 'S';
				break;
			case 'S':
				orient = 'O';
				break;
			default:
				orient = 'N';
				break;
			}
		}
		return orient;
	}

}

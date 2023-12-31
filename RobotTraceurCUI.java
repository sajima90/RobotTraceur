/**
 * RobotTraceurCUI
 * @author Pierre Cauvin
 * @version du 01/10/23
 */

import iut.algo.Clavier;

public class RobotTraceurCUI
{

	public static void main(String[] args)
	{

		/*-----------------*/
		/* Variables       */
		/*-----------------*/

		int poX;
		int poY;
		int dist;
		int rotations;
		char dir;
		

		/*-----------------*/
		/* Initialisation  */
		/*-----------------*/

		poX       = 100;
		poY       = 100;
		dist      = 0;
		rotations = 0;
		dir       = 'N';


		/*-----------------*/
		/* Instructions    */
		/*-----------------*/

		while (true)
		{
			System.out.print("[" + dir + "   " + poX + ":" + poY + "] \t action : ");
			//lire la saisie de l'utilisateur en majuscule ou en minuscule
			String action = Clavier.lireString().toUpperCase();

			if (action.equals("FIN"))
			{
				System.out.println("Fermeture du programme.");
				break;
			}

			if (Outil.estUnEntier(action))
			{
				dist = Integer.parseInt(action);
				if (dist >= 0)
				{
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

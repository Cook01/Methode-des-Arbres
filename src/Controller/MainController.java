package Controller;

import java.util.Scanner;

import Model.*;

class MainController 
{

	public static void main(String[] args)
	{

		Scanner sc 	= new Scanner(System.in);
		
		Lettre a 	= new Lettre("a", false);
		Lettre b 	= new Lettre("b", false);
		Lettre d 	= new Lettre("d", false);
		Lettre cNeg = new Lettre("c", true);


		SousFormule formule1 		= new SousFormule(a, Symbole.IMPLIQUE, b, false);//(a -> b)
		SousFormule formule2 		= new SousFormule(formule1, Symbole.ET, cNeg, false);//((a -> b) && -(c))
		SousFormule formule3 		= new SousFormule(d, Symbole.OU, formule2, true);//-(d || ((a -> b) && -(c)))
		SousFormule formule  		= new SousFormule(formule2, Symbole.ET, formule3, false);//(((a -> b) && -(c)) && -(d || ((a -> b) && -(c))))

		Formule formuleDeBase 		= formule;


	}
}
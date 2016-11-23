package Controller;

import java.util.Scanner;
import java.util.ArrayList;

import Model.*;

class MainController 
{

	static Scanner sc 	= new Scanner(System.in);

	private static Formule choiceAFormule(ArrayList<Formule> formulesDeBases)
	{

		int choice = -1;

		
		do {
			System.out.print( "Choisissez une formule : ");
			choice = sc.nextInt();
			System.out.println();
		} while( choice <= 0 || choice > formulesDeBases.size() );

		
		System.out.println("Vous avez choisi la formule : " + formulesDeBases.get(choice-1));
	
		return formulesDeBases.get(choice-1);
	}

	private static void game(SousFormule formuleToDevelop)
	{

		ArrayList<Formule> root = new ArrayList<Formule>();
		root.add(formuleToDevelop);

		Tree<ArrayList<Formule>> myTree = new Tree<ArrayList<Formule>>(root);

		Decomposition decompose 		= new Decomposition(formuleToDevelop);

		Formule a = formuleToDevelop.getFormuleA();
		Formule b = formuleToDevelop.getFormuleB();

		if (decompose.getAisNeg()) {
			a.setIsNeg();
		}

		if (decompose.getBisNeg()) {
			b.setIsNeg();
		}

		if (decompose.getAonB()) {

			ArrayList<Formule> node = new ArrayList<Formule>();

			node.add(a);
			node.add(b);

			Tree<ArrayList<Formule>> newTree = new Tree<ArrayList<Formule>>(node);
		}



	}

	public static void main(String[] args)
	{

		System.out.println("");
		System.out.println("==================== MAIN ====================");

		
		ArrayList<Formule> formuleDeBase = new ArrayList<Formule>();
		
		Lettre a 	= new Lettre("a", false);
		Lettre b 	= new Lettre("b", false);
		Lettre d 	= new Lettre("d", false);
		Lettre cNeg = new Lettre("c", true);


		SousFormule formule1 		= new SousFormule(a, Symbole.IMPLIQUE, b, false);//(a -> b)
		SousFormule formule2 		= new SousFormule(formule1, Symbole.ET, cNeg, false);//((a -> b) && -(c))
		SousFormule formule3 		= new SousFormule(d, Symbole.OU, formule2, true);//-(d || ((a -> b) && -(c)))	
		SousFormule formule4 		= new SousFormule(formule2, Symbole.ET, formule3, false);//(((a -> b) && -(c)) && -(d || ((a -> b) && -(c))))
		

		formuleDeBase.add(formule1);
		formuleDeBase.add(formule2);
		formuleDeBase.add(formule3);
		formuleDeBase.add(formule4);

		for (int i = 0; i < formuleDeBase.size(); i++) {
			System.out.println( (i+1) + " : 	" + formuleDeBase.get(i).toString());
		}

		
		Formule pickFormule = choiceAFormule(formuleDeBase);

		game((SousFormule)pickFormule);

	}
}
package Controller;

import java.util.Scanner;
import java.util.ArrayList;

import Model.*;

class MainController 
{

	static Scanner sc 	= new Scanner(System.in);

	private static SousFormule choiceAFormule(ArrayList<Formule> formulesDeBases)
	{

		int choice = -1;

		
		do {
			System.out.print( "Choisissez une formule : ");
			choice = sc.nextInt();
			System.out.println();
		} while( choice <= 0 || choice > formulesDeBases.size() );

		
		System.out.println("Vous avez choisi la formule : " + formulesDeBases.get(choice-1));
	
		return (SousFormule)formulesDeBases.get(choice-1);
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


		SousFormule formule1 = new SousFormule(a, Symbole.IMPLIQUE, b, false);//(a -> b)
		SousFormule formule2 = new SousFormule(formule1, Symbole.ET, cNeg, false);//((a -> b) && -(c))
		SousFormule formule3 = new SousFormule(d, Symbole.OU, formule2, true);//-(d || ((a -> b) && -(c)))	
		SousFormule formule4 = new SousFormule(formule2, Symbole.OU, formule3, false);//(((a -> b) && -(c)) && -(d || ((a -> b) && -(c))))
		

		formuleDeBase.add(formule1);
		formuleDeBase.add(formule2);
		formuleDeBase.add(formule3);
		formuleDeBase.add(formule4);

		Tree decompTree = new Tree<ArrayList<Formule>>(formuleDeBase);

		//Debut du jeu (A FAIRE => Se deplacer uniquement dans les feuilles de l'arbre pour effectuer les operations)
		while(true){
			decompTree.print();

			//Selection de la formule a Developper (A FAIRE => Selection parmis TOUTES les formules, même des autres feuilles + Interdir selection de lettres)
			SousFormule pickFormule = choiceAFormule(formuleDeBase);

			//Developpement de la formule
			Decomposition decompose = new Decomposition(pickFormule);

			//DONE => copie au lieu de get() (la formule est modifiée dans toutes ses occurences sinon)
			Formule formA = pickFormule.getFormuleA().copy();
			Formule formB = pickFormule.getFormuleB().copy();

			//Interpretation du developpement
			//A est negatif ?
			if (decompose.getAisNeg()) {
				formA.setIsNeg();
			}

			//B est négatif ? 
			if (decompose.getBisNeg()) {
				formB.setIsNeg();
			}

			//A et B sont sur la même branche ?
			if (decompose.getAonB()) {

				ArrayList<Formule> node = new ArrayList<Formule>();

				node.add(formA);
				node.add(formB);

				for(int i = 0; i < formuleDeBase.size(); i++){
					if(formuleDeBase.get(i) != pickFormule){
						node.add(formuleDeBase.get(i));
					}
				}

				decompTree.addChildren(new Tree<ArrayList<Formule>>(node));

			} else { //A et B sont sur deux branches differentes
				ArrayList<Formule> nodeA = new ArrayList<Formule>();
				ArrayList<Formule> nodeB = new ArrayList<Formule>();

				nodeA.add(formA);
				nodeB.add(formB);

				for(int i = 0; i < formuleDeBase.size(); i++){
					if(formuleDeBase.get(i) != pickFormule){
						nodeA.add(formuleDeBase.get(i));
						nodeB.add(formuleDeBase.get(i));
					}
				}

				decompTree.addChildren(new Tree<ArrayList<Formule>>(nodeA));
				decompTree.addChildren(new Tree<ArrayList<Formule>>(nodeB));
			}
		}
	}
}
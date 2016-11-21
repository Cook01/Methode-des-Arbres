package Controller;

import Model.*;

class MainController 
{
	public static void main(String[] args)
	{

		Lettre a = new Lettre("a", false);
        Lettre b = new Lettre("b", false);

        SousFormule formule = new SousFormule(a, Symbole.IMPLIQUE, b, false);


        Decomposition decomposeFormule = new Decomposition(formule);

        if (decomposeFormule.getAisNeg()) {
        	formule.getFormuleA().setIsNeg();
        }

        if (decomposeFormule.getBisNeg()) {
        	formule.getFormuleB().setIsNeg();
        }

        if (decomposeFormule.getAonNeg()) {
        	
        }

	}
}
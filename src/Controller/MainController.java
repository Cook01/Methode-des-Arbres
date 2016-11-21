package Controller;

import Model.*;

class MainController 
{
	public static void main(String[] args)
	{

		Lettre a = new Lettre("a", false);
        Lettre b = new Lettre("b", false);

        SousFormule formule = new SousFormule(a, Symbole.IMPLIQUE, b, false);

        System.out.println(formule);


        Decomposition decomposeFormule = new Decomposition(formule);

        if (decomposeFormule.getAisNeg()) {
        	formule.getFormuleA().setIsNeg();
        }

        if (decomposeFormule.getBisNeg()) {
        	formule.getFormuleB().setIsNeg();
        }

        if (decomposeFormule.getAonNeg()) {
        	System.out.println(formule.getFormuleA());
        	System.out.println(formule.getFormuleB());
        } else {
        	System.out.println(formule.getFormuleA() + "    	    	" + formule.getFormuleB());
        }

	}
}
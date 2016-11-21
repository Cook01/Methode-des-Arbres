package Model;

/**
 * <h1>Decrit une décomposition d'une formule par la methode des arbres</h1>
 *
 * @author  Vincent THOMAS
 */
public class Decomposition 
{

    private boolean AisNeg;
    private boolean BisNeg;
    private boolean AonB;

    public Decomposition(SousFormule formule) {

        switch (formule.getSymbole()){

            case ET :

                if(!formule.getIsNeg()) {

                    AisNeg  = false;
                    BisNeg  = false;
                    AonB    = true;

                } else {

                    AisNeg  = true;
                    BisNeg  = true;
                    AonB    = false;
                }

                break;


            case OU :

                if(!formule.getIsNeg()) {

                    AisNeg  = false;
                    BisNeg  = false;
                    AonB    = false;

                } else {

                    AisNeg  = true;
                    BisNeg  = true;
                    AonB    = true;

                }

                break;


            case IMPLIQUE :

                if(!formule.getIsNeg()) {

                    AisNeg  = true;
                    BisNeg  = false;
                    AonB    = false;

                } else {

                    AisNeg  = false;
                    BisNeg  = true;
                    AonB    = true;

                }

                break;
        }
    }

    public boolean getAisNeg()
    {
        return this.AisNeg;
    }

    public boolean getBisNeg()
    {
        return this.BisNeg;
    }

    public boolean getAonNeg()
    {
        return this.AonB;
    }
}

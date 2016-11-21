package Model;

/**
 * <h1>Decrit une décomposition d'une formule par la methode des arbres</h1>
 *
 * @author  Vincent THOMAS
 */
public class Decomposition 
{

    private boolean aIsNeg;
    private boolean bIsNeg;
    private boolean aOnB;

    public Decomposition(SousFormule formule) {

        switch (formule.getSymbole()){

            case ET :

                if(!formule.getIsNeg()) {

                    aIsNeg  = false;
                    bIsNeg  = false;
                    aOnB    = true;

                } else {

                    aIsNeg  = true;
                    bIsNeg  = true;
                    aOnB    = false;
                }

                break;


            case OU :

                if(!formule.getIsNeg()) {

                    aIsNeg  = false;
                    bIsNeg  = false;
                    aOnB    = false;

                } else {

                    aIsNeg  = true;
                    bIsNeg  = true;
                    aOnB    = true;

                }

                break;


            case IMPLIQUE :

                if(!formule.getIsNeg()) {

                    aIsNeg  = true;
                    bIsNeg  = false;
                    aOnB    = false;

                } else {

                    aIsNeg  = false;
                    bIsNeg  = true;
                    aOnB    = true;

                }

                break;
        }
    }

    public boolean getAisNeg()
    {
        return this.aIsNeg;
    }

    public boolean getBisNeg()
    {
        return this.bIsNeg;
    }

    public boolean getAonNeg()
    {
        return this.aOnB;
    }
}

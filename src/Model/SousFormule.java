package Model;

/**
 * <h1>Decrit une sous-formule</h1>
 *
 * @author  gkueny
 */
public class SousFormule extends Formule
{

    private Symbole symbole;
    private Formule a;
    private Formule b;

    public SousFormule(Formule a, Symbole symbole, Formule b, Boolean isNeg) {
        this.isNeg = isNeg;
        this.symbole = symbole;
        this.a = a;
        this.b = b;
    }

    /**
     * @return Symbole symbole
     */
    public Symbole getSymbole() {
        return symbole;
    }

    /**
     * @return Formule a
     */
    public Formule getFormuleA() {
        return a;
    }

    /**
     * @return Formule b
     */
    public Formule getFormuleB() {
        return b;
    }


    public String toString() {

        if (isNeg)
            return "¬(" + a.toString() + " " + symbole.toString() + " " + b.toString() + ")";

        return "(" + a.toString() + " " + symbole.toString() + " " + b.toString() + ")";

    }


}

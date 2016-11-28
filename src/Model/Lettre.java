package Model;

/**
 * <h1>Decrit une Lettre</h1>
 *
 * @author  gkueny
 */
public class Lettre extends Formule
{

    private String l;

    public Lettre(String l, Boolean isNeg) {
        this.isNeg = isNeg;
        this.l = l;
    }

    /**
     * @return String l
     */
    public String getL() {
        return l;
    }

    public Formule copy(){
        return new Lettre(l, isNeg);
    }

    public String toString() {

        if (isNeg)
            return "¬" + l + "";

        return l;

    }
}

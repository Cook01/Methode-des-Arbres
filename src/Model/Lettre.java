package Model;

/**
 * <h1>Decrit une Lettre</h1>
 *
 * @author  gkueny
 */
class Lettre extends Formule
{

    private String l;

    Lettre(String l, Boolean isNeg) {
        this.isNeg = isNeg;
        this.l = l;
    }

    /**
     * @return String l
     */
    String getL() {
        return l;
    }

    public String toString() {

        if (isNeg)
            return "-(" + l + ")";

        return l;

    }
}

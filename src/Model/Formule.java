package Model;

/**
 * <h1>Decrit une Formule</h1>
 *
 * @author  gkueny
 */
abstract class Formule {

    boolean isNeg;

    /**
     * @return Boolean isNeg
     */

    boolean getIsNeg() {
        return isNeg;
    }

    public abstract String toString();
}

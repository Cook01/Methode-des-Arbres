package Model;

/**
 * <h1>Decrit une Formule</h1>
 *
 * @author  gkueny
 */
public abstract class Formule {

    boolean isNeg;

    /**
     * @return Boolean isNeg
     */

    public boolean getIsNeg() {
        return isNeg;
    }

    public void setIsNeg() {
        this.isNeg = !this.isNeg;
    }

    public abstract Formule copy();

    public abstract String toString();
}

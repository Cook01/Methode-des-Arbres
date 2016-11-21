package Model;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.lang.reflect.Field;

public class DecompositionTest extends TestCase {

    public static int totalAssertions = 0;
    public static int bilanAssertions = 0;


    public void test_Et() throws Exception {
        //given

        Formule a = new Lettre("a", false);
        Formule b = new Lettre("b", false);

        SousFormule formule = new SousFormule(a, Symbole.ET, b, false);

        Decomposition decomp = new Decomposition(formule);

        final Field aIsNeg = decomp.getClass().getDeclaredField("aIsNeg");
        aIsNeg.setAccessible(true);
        final Field bIsNeg = decomp.getClass().getDeclaredField("bIsNeg");
        bIsNeg.setAccessible(true);
        final Field aOnB = decomp.getClass().getDeclaredField("aOnB");
        aOnB.setAccessible(true);

        totalAssertions++ ;
        assertFalse((boolean)aIsNeg.get(decomp));
        bilanAssertions++ ;

        totalAssertions++ ;
        assertFalse((boolean)bIsNeg.get(decomp));
        bilanAssertions++ ;

        totalAssertions++ ;
        assertTrue((boolean)aOnB.get(decomp));
        bilanAssertions++ ;
    }

    public void test_Et_Negatif() throws Exception {
        //given

        Formule a = new Lettre("a", false);
        Formule b = new Lettre("b", false);

        SousFormule formule = new SousFormule(a, Symbole.ET, b, true);

        Decomposition decomp = new Decomposition(formule);

        final Field aIsNeg = decomp.getClass().getDeclaredField("aIsNeg");
        aIsNeg.setAccessible(true);
        final Field bIsNeg = decomp.getClass().getDeclaredField("bIsNeg");
        bIsNeg.setAccessible(true);
        final Field aOnB = decomp.getClass().getDeclaredField("aOnB");
        aOnB.setAccessible(true);

        totalAssertions++ ;
        assertTrue((boolean)aIsNeg.get(decomp));
        bilanAssertions++ ;

        totalAssertions++ ;
        assertTrue((boolean)bIsNeg.get(decomp));
        bilanAssertions++ ;

        totalAssertions++ ;
        assertFalse((boolean)aOnB.get(decomp));
        bilanAssertions++ ;
    }

    public void test_Ou() throws Exception {
        //given

        Formule a = new Lettre("a", false);
        Formule b = new Lettre("b", false);

        SousFormule formule = new SousFormule(a, Symbole.OU, b, false);

        Decomposition decomp = new Decomposition(formule);

        final Field aIsNeg = decomp.getClass().getDeclaredField("aIsNeg");
        aIsNeg.setAccessible(true);
        final Field bIsNeg = decomp.getClass().getDeclaredField("bIsNeg");
        bIsNeg.setAccessible(true);
        final Field aOnB = decomp.getClass().getDeclaredField("aOnB");
        aOnB.setAccessible(true);

        totalAssertions++ ;
        assertFalse((boolean)aIsNeg.get(decomp));
        bilanAssertions++ ;

        totalAssertions++ ;
        assertFalse((boolean)bIsNeg.get(decomp));
        bilanAssertions++ ;

        totalAssertions++ ;
        assertFalse((boolean)aOnB.get(decomp));
        bilanAssertions++ ;
    }

    public void test_Ou_Negatif() throws Exception {
        //given

        Formule a = new Lettre("a", false);
        Formule b = new Lettre("b", false);

        SousFormule formule = new SousFormule(a, Symbole.OU, b, true);

        Decomposition decomp = new Decomposition(formule);

        final Field aIsNeg = decomp.getClass().getDeclaredField("aIsNeg");
        aIsNeg.setAccessible(true);
        final Field bIsNeg = decomp.getClass().getDeclaredField("bIsNeg");
        bIsNeg.setAccessible(true);
        final Field aOnB = decomp.getClass().getDeclaredField("aOnB");
        aOnB.setAccessible(true);

        totalAssertions++ ;
        assertTrue((boolean)aIsNeg.get(decomp));
        bilanAssertions++ ;

        totalAssertions++ ;
        assertTrue((boolean)bIsNeg.get(decomp));
        bilanAssertions++ ;

        totalAssertions++ ;
        assertTrue((boolean)aOnB.get(decomp));
        bilanAssertions++ ;
    }

    public void test_Implication() throws Exception {
        //given

        Formule a = new Lettre("a", false);
        Formule b = new Lettre("b", false);

        SousFormule formule = new SousFormule(a, Symbole.IMPLIQUE, b, false);

        Decomposition decomp = new Decomposition(formule);

        final Field aIsNeg = decomp.getClass().getDeclaredField("aIsNeg");
        aIsNeg.setAccessible(true);
        final Field bIsNeg = decomp.getClass().getDeclaredField("bIsNeg");
        bIsNeg.setAccessible(true);
        final Field aOnB = decomp.getClass().getDeclaredField("aOnB");
        aOnB.setAccessible(true);

        totalAssertions++ ;
        assertTrue((boolean)aIsNeg.get(decomp));
        bilanAssertions++ ;

        totalAssertions++ ;
        assertFalse((boolean)bIsNeg.get(decomp));
        bilanAssertions++ ;

        totalAssertions++ ;
        assertFalse((boolean)aOnB.get(decomp));
        bilanAssertions++ ;
    }

    public void test_Implication_Negative() throws Exception {
        //given

        Formule a = new Lettre("a", false);
        Formule b = new Lettre("b", false);

        SousFormule formule = new SousFormule(a, Symbole.IMPLIQUE, b, true);

        Decomposition decomp = new Decomposition(formule);

        final Field aIsNeg = decomp.getClass().getDeclaredField("aIsNeg");
        aIsNeg.setAccessible(true);
        final Field bIsNeg = decomp.getClass().getDeclaredField("bIsNeg");
        bIsNeg.setAccessible(true);
        final Field aOnB = decomp.getClass().getDeclaredField("aOnB");
        aOnB.setAccessible(true);

        totalAssertions++ ;
        assertFalse((boolean)aIsNeg.get(decomp));
        bilanAssertions++ ;

        totalAssertions++ ;
        assertTrue((boolean)bIsNeg.get(decomp));
        bilanAssertions++ ;

        totalAssertions++ ;
        assertTrue((boolean)aOnB.get(decomp));
        bilanAssertions++ ;
    }

    /**
     * main de la classe Test
     *
     * @param args arguments
     *
     */
    public static void main(String[] args) {

        junit.textui.TestRunner.run(new TestSuite(DecompositionTest.class));

        if (bilanAssertions == totalAssertions) {
            System.out.print("Bravo ! ");
        }
        else  {
            System.out.print("OUPS ! ");
        }

        System.out.println(" "+bilanAssertions+"/"+totalAssertions+" assertions verifiees");

    } // fin main


}
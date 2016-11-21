package Model;

import junit.framework.TestCase;
import junit.framework.TestSuite;


public class DecompossitionTest extends TestCase {

    public static int totalAssertions = 0;
    public static int bilanAssertions = 0;


    public void test_Et() throws Exception {
        //given

        Formule a = new Lettre("a", false);
        Formule b = new Lettre("b", false);

        SousFormule formule = new SousFormule(a, Symbole.IMPLIQUE, b, false);

        Decompossition decomp = new Decompossition(formule);

        final Field aIsNeg = testCat.getClass().getDeclaredField("aIsNeg");
        field.setAccessible(true);
        final Field bIsNeg = testCat.getClass().getDeclaredField("bIsNeg");
        field.setAccessible(true);
        final Field aOnB = testCat.getClass().getDeclaredField("aOnB");
        field.setAccessible(true);

        totalAssertions++ ;
        assertFalse(aIsNeg.get(decomp));
        bilanAssertions++ ;

        totalAssertions++ ;
        assertFalse(bIsNeg.get(decomp));
        bilanAssertions++ ;

        totalAssertions++ ;
        assertTrue(aOnB.get(decomp));
        bilanAssertions++ ;
    }

    public void test_Et_Negatif() throws Exception {
        //given

        Formule a = new Lettre("a", false);
        Formule b = new Lettre("b", false);

        SousFormule formule = new SousFormule(a, Symbole.ET, b, true);

        Decompossition decomp = new Decompossition(formule);

        final Field aIsNeg = testCat.getClass().getDeclaredField("aIsNeg");
        field.setAccessible(true);
        final Field bIsNeg = testCat.getClass().getDeclaredField("bIsNeg");
        field.setAccessible(true);
        final Field aOnB = testCat.getClass().getDeclaredField("aOnB");
        field.setAccessible(true);

        totalAssertions++ ;
        assertTrue(aIsNeg.get(decomp));
        bilanAssertions++ ;

        totalAssertions++ ;
        assertTrue(bIsNeg.get(decomp));
        bilanAssertions++ ;

        totalAssertions++ ;
        assertFalse(aOnB.get(decomp));
        bilanAssertions++ ;
    }

    public void test_Ou() throws Exception {
        //given

        Formule a = new Lettre("a", false);
        Formule b = new Lettre("b", false);

        SousFormule formule = new SousFormule(a, Symbole.OU, b, false);

        Decompossition decomp = new Decompossition(formule);

        final Field aIsNeg = testCat.getClass().getDeclaredField("aIsNeg");
        field.setAccessible(true);
        final Field bIsNeg = testCat.getClass().getDeclaredField("bIsNeg");
        field.setAccessible(true);
        final Field aOnB = testCat.getClass().getDeclaredField("aOnB");
        field.setAccessible(true);

        totalAssertions++ ;
        assertFalse(aIsNeg.get(decomp));
        bilanAssertions++ ;

        totalAssertions++ ;
        assertFalse(bIsNeg.get(decomp));
        bilanAssertions++ ;

        totalAssertions++ ;
        assertFalse(aOnB.get(decomp));
        bilanAssertions++ ;
    }

    public void test_Ou_Negatif() throws Exception {
        //given

        Formule a = new Lettre("a", false);
        Formule b = new Lettre("b", false);

        SousFormule formule = new SousFormule(a, Symbole.OU, b, true);

        Decompossition decomp = new Decompossition(formule);

        final Field aIsNeg = testCat.getClass().getDeclaredField("aIsNeg");
        field.setAccessible(true);
        final Field bIsNeg = testCat.getClass().getDeclaredField("bIsNeg");
        field.setAccessible(true);
        final Field aOnB = testCat.getClass().getDeclaredField("aOnB");
        field.setAccessible(true);

        totalAssertions++ ;
        assertFalse(aIsNeg.get(decomp));
        bilanAssertions++ ;

        totalAssertions++ ;
        assertFalse(bIsNeg.get(decomp));
        bilanAssertions++ ;

        totalAssertions++ ;
        assertTrue(aOnB.get(decomp));
        bilanAssertions++ ;
    }

    public void test_Implication() throws Exception {
        //given

        Formule a = new Lettre("a", false);
        Formule b = new Lettre("b", false);

        SousFormule formule = new SousFormule(a, Symbole.IMPLIQUE, b, false);

        Decompossition decomp = new Decompossition(formule);

        final Field aIsNeg = testCat.getClass().getDeclaredField("aIsNeg");
        field.setAccessible(true);
        final Field bIsNeg = testCat.getClass().getDeclaredField("bIsNeg");
        field.setAccessible(true);
        final Field aOnB = testCat.getClass().getDeclaredField("aOnB");
        field.setAccessible(true);

        totalAssertions++ ;
        assertFalse(aIsNeg.get(decomp));
        bilanAssertions++ ;

        totalAssertions++ ;
        assertTrue(bIsNeg.get(decomp));
        bilanAssertions++ ;

        totalAssertions++ ;
        assertFalse(aOnB.get(decomp));
        bilanAssertions++ ;
    }

    public void test_Implication_Negative() throws Exception {
        //given

        Formule a = new Lettre("a", false);
        Formule b = new Lettre("b", false);

        SousFormule formule = new SousFormule(a, Symbole.IMPLIQUE, b, true);

        Decompossition decomp = new Decompossition(formule);

        final Field aIsNeg = testCat.getClass().getDeclaredField("aIsNeg");
        field.setAccessible(true);
        final Field bIsNeg = testCat.getClass().getDeclaredField("bIsNeg");
        field.setAccessible(true);
        final Field aOnB = testCat.getClass().getDeclaredField("aOnB");
        field.setAccessible(true);

        totalAssertions++ ;
        assertTrue(aIsNeg.get(decomp));
        bilanAssertions++ ;

        totalAssertions++ ;
        assertFalse(bIsNeg.get(decomp));
        bilanAssertions++ ;

        totalAssertions++ ;
        assertTrue(aOnB.get(decomp));
        bilanAssertions++ ;
    }

    /**
     * main de la classe Test
     *
     * @param args arguments
     *
     */
    public static void main(String[] args) {

        junit.textui.TestRunner.run(new TestSuite(FormuleTest.class));

        if (bilanAssertions == totalAssertions) {
            System.out.print("Bravo ! ");
        }
        else  {
            System.out.print("OUPS ! ");
        }

        System.out.println(" "+bilanAssertions+"/"+totalAssertions+" assertions verifiees");

    } // fin main


}
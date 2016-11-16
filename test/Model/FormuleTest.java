package Model;

import junit.framework.TestCase;
import junit.framework.TestSuite;


public class FormuleTest extends TestCase {

    public static int totalAssertions = 0;
    public static int bilanAssertions = 0;


    public void test_simpleFormule() throws Exception {
        //given

        Formule a = new Lettre("a", false);
        Formule b = new Lettre("b", false);

        Formule formule = new SousFormule(a, Symbole.IMPLIQUE, b, false);

        totalAssertions++ ;
        assertEquals("(a " + Symbole.IMPLIQUE.toString() + " b)", formule.toString());
        bilanAssertions++ ;
    }

    public void test_simpleFormuleNeg() throws Exception {
        //given

        Formule a = new Lettre("a", false);
        Formule b = new Lettre("b", true);

        Formule formule = new SousFormule(a, Symbole.IMPLIQUE, b, true);

        totalAssertions++ ;
        assertEquals("-(a " + Symbole.IMPLIQUE.toString() + " -(b))", formule.toString());
        bilanAssertions++ ;
    }

    public void test_complicatedFormule() throws Exception {
        //given

        Formule a = new Lettre("a", false);
        Formule b = new Lettre("b", false);
        Formule d = new Lettre("d", false);
        Formule cNeg = new Lettre("c", true);


        Formule formule1 = new SousFormule(a, Symbole.IMPLIQUE, b, false);//(a -> b)

        Formule formule2 = new SousFormule(formule1, Symbole.ET, cNeg, false);//((a -> b) && -(c))

        Formule formule3 = new SousFormule(d, Symbole.OU, formule2, true);//-(d || ((a -> b) && -(c)))

        Formule formule4 = new SousFormule(formule2, Symbole.ET, formule3, false);//(((a -> b) && -(c)) && -(d || ((a -> b) && -(c))))

        totalAssertions++ ;
        assertEquals("(((a " + Symbole.IMPLIQUE.toString() + " b) " + Symbole.ET.toString() + " -(c)) " + Symbole.ET.toString() + " -(d " + Symbole.OU.toString() + " ((a " + Symbole.IMPLIQUE.toString() + " b) " + Symbole.ET.toString() + " -(c))))", formule4.toString());
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
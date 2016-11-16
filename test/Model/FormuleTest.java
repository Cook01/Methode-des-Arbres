package Model;

import org.junit.Test;

import static org.junit.Assert.*;

public class FormuleTest {

    @Test
    public void simpleFormule() throws Exception {
        //given

        Formule a = new Lettre("a", false);
        Formule b = new Lettre("b", false);

        Formule formule = new SousFormule(a, Symbole.IMPLIQUE, b, false);

        assertEquals("(a " + Symbole.IMPLIQUE.toString() + " b)", formule.toString());
    }

    @Test
    public void simpleFormuleNeg() throws Exception {
        //given

        Formule a = new Lettre("a", false);
        Formule b = new Lettre("b", true);

        Formule formule = new SousFormule(a, Symbole.IMPLIQUE, b, true);

        assertEquals("-(a " + Symbole.IMPLIQUE.toString() + " -(b))", formule.toString());
    }

    @Test
    public void complicatedFormule() throws Exception {
        //given

        Formule a = new Lettre("a", false);
        Formule b = new Lettre("b", false);
        Formule d = new Lettre("d", false);
        Formule cNeg = new Lettre("c", true);


        Formule formule1 = new SousFormule(a, Symbole.IMPLIQUE, b, false);//(a -> b)

        Formule formule2 = new SousFormule(formule1, Symbole.ET, cNeg, false);//((a -> b) && -(c))

        Formule formule3 = new SousFormule(d, Symbole.OU, formule2, true);//-(d || ((a -> b) && -(c)))

        Formule formule4 = new SousFormule(formule2, Symbole.ET, formule3, false);//(((a -> b) && -(c)) && -(d || ((a -> b) && -(c))))

        assertEquals("(((a " + Symbole.IMPLIQUE.toString() + " b) " + Symbole.ET.toString() + " -(c)) " + Symbole.ET.toString() + " -(d " + Symbole.OU.toString() + " ((a " + Symbole.IMPLIQUE.toString() + " b) " + Symbole.ET.toString() + " -(c))))", formule4.toString());
    }


}
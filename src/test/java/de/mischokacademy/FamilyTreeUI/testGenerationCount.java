package de.mischokacademy.FamilyTreeUI;

import de.mischokacademy.FamilyTreeUI.Domain.Human;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class testGenerationCount {

    @Test
    void testOneGeneration() {
        Human genOneSon = new Human("Kevin", "Costner", 30);

        assertEquals(1, genOneSon.getGenerationCount());
    }

    @Test
    void testTwoGenerationsMother() {
        Human genOneSon = new Human("Kevin", "Costner", 30);
        Human genTwoMother = new Human("Calista", "Flockheart", 50);

        genOneSon.setMother(genTwoMother);

        assertEquals(2, genOneSon.getGenerationCount());
    }

    @Test
    void testTwoGenerationsParents() {
        Human genOneSon = new Human("Kevin", "Costner", 30);
        Human genTwoMother = new Human("Calista", "Costner", 50);
        Human genTwoFather = new Human("Michael", "Costner", 52);

        genOneSon.setMother(genTwoMother);
        genOneSon.setFather(genTwoFather);

        assertEquals(2, genOneSon.getGenerationCount());
    }

    @Test
    void testThreeGenerationsGrandParentsMother() {
        Human genOneSon = new Human("Kevin", "Costner", 30);
        Human genTwoMother = new Human("Calista", "Costner", 50);
        Human genTwoFather = new Human("Michael", "Costner", 52);
        Human genThreeMotherM = new Human("Silvia", "Scholl", 71);
        Human genThreeFatherM = new Human("Rudolf", "Scholl", 72);

        genOneSon.setMother(genTwoMother);
        genOneSon.setFather(genTwoFather);
        genTwoMother.setMother(genThreeMotherM);
        genTwoMother.setFather(genThreeFatherM);

        assertEquals(3, genOneSon.getGenerationCount());
    }

    @Test
    void testThreeGenerationsGrandParentBoth() {
        Human genOneSon = new Human("Kevin", "Costner", 30);
        Human genTwoMother = new Human("Calista", "Costner", 50);
        Human genTwoFather = new Human("Michael", "Costner", 52);
        Human genThreeMotherM = new Human("Silvia", "Scholl", 71);
        Human genThreeFatherM = new Human("Rudolf", "Scholl", 72);
        Human genThreeMotherF = new Human("Brunhilde", "Müller", 72);
        Human genThreeFatherF = new Human("Gernot", "Müller", 71);

        genOneSon.setMother(genTwoMother);
        genOneSon.setFather(genTwoFather);
        genTwoMother.setMother(genThreeMotherM);
        genTwoMother.setFather(genThreeFatherM);
        genTwoFather.setMother(genThreeMotherF);
        genTwoFather.setFather(genThreeFatherF);

        assertEquals(3, genOneSon.getGenerationCount());
    }

    @Test
    void testFiveGenerations() {
        Human genOneSon = new Human("Kevin", "Costner", 30);            // Generation 1
        Human genTwoMother = new Human("Calista", "Costner", 50);       // Generation 2 Mutter
        Human genTwoFather = new Human("Michael", "Costner", 52);       // Generation 2 Vater
        Human genThreeMotherM = new Human("Silvia", "Scholl", 71);      // Generation 3 Oma (Mutter)
        Human genThreeFatherM = new Human("Rudolf", "Scholl", 72);      // Generation 3 Opa (Mutter)
        Human genThreeMotherF = new Human("Brunhilde", "Müller", 72);   // Generation 3 Oma (Vater)
        Human genThreeFatherF = new Human("Gernot", "Müller", 71);      // Generation 3 Opa (Vater)
        Human genFourFatherF = new Human("Alf", "Tenner", 97);          // Generation 4 Ur-Opa (Vater)
        Human genFiveFatherF = new Human("Willi", "Müller", 119);       // Generation 5 Ur-Ur-Opa (Vater)

        genOneSon.setMother(genTwoMother);
        genOneSon.setFather(genTwoFather);
        genTwoMother.setMother(genThreeMotherM);
        genTwoMother.setFather(genThreeFatherM);
        genTwoFather.setMother(genThreeMotherF);
        genTwoFather.setFather(genThreeFatherF);
        genThreeFatherF.setFather(genFourFatherF);
        genFourFatherF.setFather(genFiveFatherF);

        assertEquals(5, genOneSon.getGenerationCount());
    }
}

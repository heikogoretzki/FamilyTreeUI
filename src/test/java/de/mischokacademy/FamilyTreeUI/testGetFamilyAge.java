package de.mischokacademy.FamilyTreeUI;

import de.mischokacademy.FamilyTreeUI.Domain.Human;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testGetFamilyAge {

    @Test
    void testOneGenerationAge() {
        Human genOneSon = new Human("Kevin", "Costner", 30);

        assertEquals(30, genOneSon.getFamilyAge());
    }

    @Test
    void testTwoGenerationsAge() {
        Human genOneSon = new Human("Kevin", "Costner", 30);
        Human genTwoMother = new Human("Calista", "Flockheart", 50);

        genOneSon.setMother(genTwoMother);

        assertEquals(30 + 50, genOneSon.getFamilyAge());
    }

    @Test
    void testTwoGenerationsParentsAge() {
        Human genOneSon = new Human("Kevin", "Costner", 30);
        Human genTwoMother = new Human("Calista", "Costner", 50);
        Human genTwoFather = new Human("Michael", "Costner", 52);

        genOneSon.setMother(genTwoMother);
        genOneSon.setFather(genTwoFather);

        assertEquals(30 + 50 + 52, genOneSon.getFamilyAge());
    }

    @Test
    void testThreeGenerationsGrandParentsMotherAge() {
        Human genOneSon = new Human("Kevin", "Costner", 30);
        Human genTwoMother = new Human("Calista", "Costner", 50);
        Human genTwoFather = new Human("Michael", "Costner", 52);
        Human genThreeMotherM = new Human("Silvia", "Scholl", 71);
        Human genThreeFatherM = new Human("Rudolf", "Scholl", 72);

        genOneSon.setMother(genTwoMother);
        genOneSon.setFather(genTwoFather);
        genTwoMother.setMother(genThreeMotherM);
        genTwoMother.setFather(genThreeFatherM);

        assertEquals(30 + 50 + 52 + 71 + 72, genOneSon.getFamilyAge());
    }

    @Test
    void testThreeGenerationsGrandParentBothAge() {
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

        assertEquals(30 + 50 + 52 + 71 + 72 + 72 + 71, genOneSon.getFamilyAge());
    }

    @Test
    void testFiveGenerationsAge() {
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

        assertEquals(30 + 50 + 52 + 71 + 72 + 72 + 71 + 97 + 119, genOneSon.getFamilyAge());
    }
}

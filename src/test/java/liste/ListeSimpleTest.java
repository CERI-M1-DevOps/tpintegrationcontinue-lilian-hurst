package liste;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ListeSimpleTest {

    ListeSimple listeATester;

    @BeforeEach
    public void init() {
        listeATester = new ListeSimple();
    }

    // Tests existants (copiés depuis ListeSimpleTest.java)
    @Test
    public void listeConstruiteVide() {
        assertNull(listeATester.tete);
        assertEquals(0, listeATester.getSize());
    }

    @Test
    public void ajoutAugmenteSize() {
        listeATester.ajout(1);
        assertEquals(1, listeATester.getSize());
    }

    @Test
    public void ajoutChangeTete() {
        listeATester.ajout(1);
        Noeud teteApresPremierAjout = listeATester.tete;
        listeATester.ajout(1);
        assertNotNull(teteApresPremierAjout);
        assertNotSame(teteApresPremierAjout, listeATester.tete);
    }

    @Test
    public void ajoutPlusieursFoisLeMeme() {
        listeATester.ajout(1);
        listeATester.ajout(1);
        listeATester.ajout(1);
        assertEquals(3, listeATester.getSize());
    }

    @Test
    public void toStringDonneTousLesNoeuds() {
        System.out.println(listeATester);
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        System.out.println(listeATester);
    }

    @Test
    public void modifiePremier() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.modifiePremier(2, 4);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(3), Noeud(4), Noeud(1))");
        assertEquals(4, listeATester.tete.getSuivant().getElement());
    }

    // NOUVEAUX TESTS pour améliorer la couverture

    @Test
    public void modifiePremierElementIntrouvable() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.modifiePremier(99, 4); // Élément qui n'existe pas
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(3), Noeud(2), Noeud(1))"); // Aucun changement
    }

    @Test
    public void modifiePremierListeVide() {
        listeATester.modifiePremier(1, 2); // Sur une liste vide
        assertNull(listeATester.tete);
        assertEquals(0, listeATester.getSize());
    }

    @Test
    public void modifieTous() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(1);
        listeATester.ajout(1);
        listeATester.modifieTous(1, 4);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(4), Noeud(4), Noeud(2), Noeud(4))");
        assertEquals(4, listeATester.tete.getSuivant().getElement());
    }

    @Test
    public void modifieTousElementIntrouvable() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.modifieTous(99, 4); // Élément qui n'existe pas
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(3), Noeud(2), Noeud(1))"); // Aucun changement
    }

    @Test
    public void modifieTousListeVide() {
        listeATester.modifieTous(1, 2); // Sur une liste vide
        assertNull(listeATester.tete);
        assertEquals(0, listeATester.getSize());
    }

    @Test
    public void supprimePremierListeVide() {
        listeATester.supprimePremier(1);
        assertNull(listeATester.tete);
        assertEquals(0, listeATester.getSize());
    }

    @Test
    public void supprimePremierEnPremierePosition() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.supprimePremier(3);
        assertEquals(listeATester.toString(),"ListeSimple(Noeud(2), Noeud(1))");
        assertEquals(2, listeATester.getSize());
    }

    @Test
    public void supprimePremierEnPositionQuelconque() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.ajout(4);
        listeATester.supprimePremier(2);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(4), Noeud(3), Noeud(1))");
        assertEquals(3, listeATester.getSize());
    }

    @Test
    public void supprimePremierEnDernierePosition() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.ajout(4);
        listeATester.supprimePremier(1);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(4), Noeud(3), Noeud(2))");
        assertEquals(3, listeATester.getSize());
    }

    @Test
    public void supprimePremierElementIntrouvable() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.supprimePremier(99); // Élément qui n'existe pas
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(3), Noeud(2), Noeud(1))");
        assertEquals(3, listeATester.getSize());
    }

    @Test
    public void supprimeTousListeVide() {
        listeATester.supprimeTous(1);
        assertNull(listeATester.tete);
        assertEquals(0, listeATester.getSize());
    }

    @Test
    public void supprimeTousUneSeuleFoisAuDebut() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.supprimeTous(3);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(2), Noeud(1))");
        assertEquals(2, listeATester.getSize());
    }

    @Test
    public void supprimeTousUneSeuleFoisPositionQuelconque() {
        listeATester.ajout(1);
        listeATester.ajout(3);
        listeATester.ajout(2);
        listeATester.supprimeTous(3);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(2), Noeud(1))");
        assertEquals(2, listeATester.getSize());
    }

    @Test
    public void supprimeTousPlusieursFois() {
        listeATester.ajout(2);
        listeATester.ajout(1);
        listeATester.ajout(1);
        listeATester.supprimeTous(1);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(2))");
        assertEquals(1, listeATester.getSize());
    }

    @Test
    public void supprimeTousPlusieursFoisPositionQuelconque() {
        listeATester.ajout(3);
        listeATester.ajout(1);
        listeATester.ajout(3);
        listeATester.ajout(2);
        listeATester.supprimeTous(3);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(2), Noeud(1))");
        assertEquals(2, listeATester.getSize());
    }

    @Test
    public void supprimeTousElementIntrouvable() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.supprimeTous(99); // Élément qui n'existe pas
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(3), Noeud(2), Noeud(1))");
        assertEquals(3, listeATester.getSize());
    }

    @Test
    public void supprimeTousTousLesElements() {
        listeATester.ajout(1);
        listeATester.ajout(1);
        listeATester.ajout(1);
        listeATester.supprimeTous(1);
        assertNull(listeATester.tete);
        assertEquals(0, listeATester.getSize());
    }

    @Test
    public void avantDernierListeVide() {
        assertNull(listeATester.getAvantDernier());
    }

    @Test
    public void avantDernierListeAUnElement() {
        listeATester.ajout(1);
        assertNull(listeATester.getAvantDernier());
    }

    @Test
    public void avantDernierListeADeuxElements() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        assertEquals(2, listeATester.getAvantDernier().getElement());
    }

    @Test
    public void avantDernierListeAPlusieursElements() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.ajout(4);
        assertEquals(2, listeATester.getAvantDernier().getElement());
    }

    @Test
    public void inverserListeVide() {
        listeATester.inverser();
        assertNull(listeATester.tete);
    }

    @Test
    public void inverserListeUnElement() {
        listeATester.ajout(1);
        listeATester.inverser();
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(1))");
    }

    @Test
    public void inverserListeNbPairDElements() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.ajout(4);
        listeATester.inverser();
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(1), Noeud(2), Noeud(3), Noeud(4))");
    }

    @Test
    public void inverserListeNbImPairDElements() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.inverser();
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(1), Noeud(2), Noeud(3))");
    }

    @Test
    public void getPrecedentNoeudExistant() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        Noeud noeud1 = listeATester.tete.getSuivant().getSuivant(); // Noeud(1)
        Noeud precedent = listeATester.getPrecedent(noeud1);
        assertEquals(2, precedent.getElement());
    }

    @Test
    public void getPrecedentPremierNoeud() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        Noeud premierNoeud = listeATester.tete.getSuivant(); // Noeud(2)
        Noeud precedent = listeATester.getPrecedent(premierNoeud);
        assertEquals(3, precedent.getElement()); // La tête
    }

    @Test
    public void echanger2NoeudsQuelconques() {
        listeATester.ajout(5);
        listeATester.ajout(4);
        Noeud r1 = listeATester.tete;
        listeATester.ajout(3);
        listeATester.ajout(2);
        Noeud r2 = listeATester.tete;
        listeATester.ajout(1);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(1), Noeud(2), Noeud(3), Noeud(4), Noeud(5))");
        listeATester.echanger(r1, r2);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(1), Noeud(4), Noeud(3), Noeud(2), Noeud(5))");
    }

    @Test
    public void echangerLePremierNoeudAvecUnAutre() {
        listeATester.ajout(5);
        listeATester.ajout(4);
        Noeud r2 = listeATester.tete;
        listeATester.ajout(3);
        listeATester.ajout(2);
        listeATester.ajout(1);
        Noeud r1 = listeATester.tete;
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(1), Noeud(2), Noeud(3), Noeud(4), Noeud(5))");
        listeATester.echanger(r1, r2);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(4), Noeud(2), Noeud(3), Noeud(1), Noeud(5))");
    }

    @Test
    public void echangerLePremierEnSecondArgumentNoeudAvecUnAutre() {
        listeATester.ajout(5);
        listeATester.ajout(4);
        Noeud r1 = listeATester.tete;
        listeATester.ajout(3);
        listeATester.ajout(2);
        listeATester.ajout(1);
        Noeud r2 = listeATester.tete;
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(1), Noeud(2), Noeud(3), Noeud(4), Noeud(5))");
        listeATester.echanger(r1, r2);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(4), Noeud(2), Noeud(3), Noeud(1), Noeud(5))");
    }

    @Test
    public void echangerMemeNoeud() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        Noeud noeud = listeATester.tete;
        String avantEchange = listeATester.toString();
        listeATester.echanger(noeud, noeud); // Échanger un nœud avec lui-même
        assertEquals(avantEchange, listeATester.toString()); // Aucun changement
    }

    @Test
    public void echangerNoeudsAdjacents() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        Noeud r1 = listeATester.tete; // Noeud(3)
        Noeud r2 = listeATester.tete.getSuivant(); // Noeud(2)
        listeATester.echanger(r1, r2);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(2), Noeud(3), Noeud(1))");
    }

    @Test
    public void toStringListeVide() {
        assertEquals("ListeSimple()", listeATester.toString());
    }

    @Test
    public void toStringListeUnElement() {
        listeATester.ajout(42);
        assertEquals("ListeSimple(Noeud(42))", listeATester.toString());
    }

    @Test
    public void echangerNoeudQuelconqueAvecTete() {
        // Test spécifique pour la branche else if (r2 == tete)
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.ajout(4);

        Noeud r1 = listeATester.tete.getSuivant().getSuivant(); // Noeud(2) - pas la tête
        Noeud r2 = listeATester.tete; // Noeud(4) - la tête

        assertEquals("ListeSimple(Noeud(4), Noeud(3), Noeud(2), Noeud(1))", listeATester.toString());
        listeATester.echanger(r1, r2);
        assertEquals("ListeSimple(Noeud(2), Noeud(3), Noeud(4), Noeud(1))", listeATester.toString());
    }

    @Test
    public void echangerTeteAvecDernierNoeud() {
        // Autre test pour s'assurer que tous les cas sont couverts
        listeATester.ajout(1); // dernier
        listeATester.ajout(2);
        listeATester.ajout(3); // tête

        Noeud teteOriginale = listeATester.tete; // Noeud(3)
        Noeud dernierNoeud = listeATester.tete.getSuivant().getSuivant(); // Noeud(1)

        assertEquals("ListeSimple(Noeud(3), Noeud(2), Noeud(1))", listeATester.toString());
        listeATester.echanger(dernierNoeud, teteOriginale); // r1=dernier, r2=tête
        assertEquals("ListeSimple(Noeud(1), Noeud(2), Noeud(3))", listeATester.toString());
    }

    @Test
    public void echangerDeuxNoeudsNonTete() {
        // Test pour s'assurer que le cas r1 != tete && r2 != tete est bien testé
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.ajout(4);
        listeATester.ajout(5);

        Noeud r1 = listeATester.tete.getSuivant(); // Noeud(4) - pas la tête
        Noeud r2 = listeATester.tete.getSuivant().getSuivant().getSuivant(); // Noeud(2) - pas la tête

        assertEquals("ListeSimple(Noeud(5), Noeud(4), Noeud(3), Noeud(2), Noeud(1))", listeATester.toString());
        listeATester.echanger(r1, r2);
        assertEquals("ListeSimple(Noeud(5), Noeud(2), Noeud(3), Noeud(4), Noeud(1))", listeATester.toString());
    }

    @Test
    public void echangerPourCouvrirLigne104TeteEgalR1() {
        // Test spécifiquement pour couvrir la ligne 104: tete = r1;
        // Cette ligne n'est exécutée QUE dans la branche else if (r2 == tete)

        // Créer une liste simple avec exactement 2 éléments
        listeATester.ajout(10); // devient le 2e élément
        listeATester.ajout(20); // devient la tête

        // État: ListeSimple(Noeud(20), Noeud(10))
        // tete pointe vers Noeud(20)

        Noeud noeudNonTete = listeATester.tete.getSuivant(); // Noeud(10) - PAS la tête
        Noeud noeudTete = listeATester.tete;                 // Noeud(20) - EST la tête

        // Vérifications avant échange
        assertNotNull(noeudNonTete);
        assertNotNull(noeudTete);
        assertEquals(20, listeATester.tete.getElement()); // tête = 20
        assertTrue(noeudNonTete != listeATester.tete);   // r1 != tete
        assertTrue(noeudTete == listeATester.tete);      // r2 == tete

        // Cet appel DOIT déclencher: else if (r2 == tete)
        // Conditions:
        // - r1 != r2 ✓ (10 != 20)
        // - r1 != tete && r2 != tete ✗ (car r2 == tete)
        // - r1 == tete ✗ (car r1 != tete)
        // - r2 == tete ✓ ← Cette branche sera prise
        listeATester.echanger(noeudNonTete, noeudTete);

        // Après l'échange, la ligne 104 "tete = r1;" doit avoir été exécutée
        // Donc tete doit maintenant pointer vers noeudNonTete (qui contenait 10)
        assertEquals(10, listeATester.tete.getElement()); // PREUVE que ligne 104 exécutée
        assertEquals("ListeSimple(Noeud(10), Noeud(20))", listeATester.toString());
    }:

    @Test
    public void echangerNoeudNonTeteAvecTeteSimple() {
        // Test très simple pour couvrir else if (r2 == tete)
        listeATester.ajout(1);  // dernier
        listeATester.ajout(2);  // tête

        Noeud r1 = listeATester.tete.getSuivant(); // Noeud(1) - PAS la tête
        Noeud r2 = listeATester.tete;              // Noeud(2) - EST la tête

        // État initial: ListeSimple(Noeud(2), Noeud(1))
        assertEquals("ListeSimple(Noeud(2), Noeud(1))", listeATester.toString());

        // Appel avec r1 (non-tête) et r2 (tête)
        // Ceci DOIT déclencher else if (r2 == tete)
        listeATester.echanger(r1, r2);

        // Résultat attendu: ListeSimple(Noeud(1), Noeud(2))
        assertEquals("ListeSimple(Noeud(1), Noeud(2))", listeATester.toString());
    }

    @Test
    public void echangerAutreTestPourR2EgaleTete() {
        // Autre test avec 3 éléments pour être sûr
        listeATester.ajout(5);  // dernier
        listeATester.ajout(10); // milieu
        listeATester.ajout(15); // tête

        Noeud dernierNoeud = listeATester.tete.getSuivant().getSuivant(); // Noeud(5)
        Noeud teteNoeud = listeATester.tete; // Noeud(15)

        assertEquals("ListeSimple(Noeud(15), Noeud(10), Noeud(5))", listeATester.toString());

        // echanger(noeud_qui_n_est_pas_tete, noeud_qui_est_tete)
        listeATester.echanger(dernierNoeud, teteNoeud);

        assertEquals("ListeSimple(Noeud(5), Noeud(10), Noeud(15))", listeATester.toString());
    }

    @Test
    public void supprimeTousRecursTestComplet() {
        // Test pour s'assurer que toutes les branches de supprimeTousRecurs sont couvertes
        // Cas où tous les éléments sont à supprimer sauf un au milieu
        listeATester.ajout(1);
        listeATester.ajout(2); // celui-ci ne sera pas supprimé
        listeATester.ajout(1);
        listeATester.ajout(1);
        listeATester.supprimeTous(1);
        assertEquals("ListeSimple(Noeud(2))", listeATester.toString());
        assertEquals(1, listeATester.getSize());
    }

    @Test
    public void supprimeTousRecursListeNullTest() {
        // Test pour le cas de base de la récursion (tete == null)
        listeATester.supprimeTous(1); // sur liste vide
        assertNull(listeATester.tete);
        assertEquals(0, listeATester.getSize());
    }
}
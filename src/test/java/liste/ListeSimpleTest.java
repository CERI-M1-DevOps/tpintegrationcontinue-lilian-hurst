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

    // --- Tests existants ---

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

    // ... (tous tes tests existants restent ici) ...

    // --- Tests supplémentaires pour couverture 100% ---

    @Test
    public void modifiePremierElementNonPresent() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.modifiePremier(99, 100); // élément absent
        assertEquals("ListeSimple(Noeud(2), Noeud(1))", listeATester.toString());
    }

    @Test
    public void modifieTousElementNonPresent() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.modifieTous(99, 100); // élément absent
        assertEquals("ListeSimple(Noeud(2), Noeud(1))", listeATester.toString());
    }

    @Test
    public void supprimeTousListeVide() {
        listeATester.supprimeTous(1); // aucun élément à supprimer
        assertNull(listeATester.tete);
        assertEquals(0, listeATester.getSize());
    }

    @Test
    public void supprimeTousAucunElement() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.supprimeTous(99); // élément absent
        assertEquals("ListeSimple(Noeud(2), Noeud(1))", listeATester.toString());
        assertEquals(2, listeATester.getSize());
    }

    @Test
    public void echangerMêmeNoeud() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        Noeud n = listeATester.tete;
        listeATester.echanger(n, n); // rien ne doit se passer
        assertEquals("ListeSimple(Noeud(2), Noeud(1))", listeATester.toString());
    }

    @Test
    public void getPrecedentDeuxiemeElement() {
        listeATester.ajout(1);
        listeATester.ajout(2); // 2 -> 1
        Noeud n = listeATester.tete.getSuivant(); // deuxième noeud
        assertEquals(listeATester.tete, listeATester.getPrecedent(n));
    }
}

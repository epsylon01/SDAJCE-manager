/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.controleurs;

import ch.ceff.ict3.sdajcemanager.event.*;
import ch.ceff.ict3.sdajcemanager.modele.Carte;
import ch.ceff.ict3.sdajcemanager.modele.Conteneur;
import ch.ceff.ict3.sdajcemanager.modele.Database;
import ch.ceff.ict3.sdajcemanager.modele.Deck;
import ch.ceff.ict3.sdajcemanager.modele.Partie;

/**
 *
 * @author cp-14luf
 */
public class Controleur {

    private Database db;

    public Controleur() {
        db = db.newDatabase();
    }

    public void addCarte(AddCarteEvent event) {
        Carte carte = new Carte(-1, event.getNom(), event.getType(), event.getSphere(), event.getNombre(), event.getConteneur());
        db.addCarte(carte);
    }

    public void delCarte(int index) {
        db.delCarte(index);
    }

    public void editCarte(EditCarteEvent event) {
        Carte carte = new Carte(event.getId(), event.getNom(), event.getType(), event.getSphere(), event.getNombre(), event.getConteneur());
        db.editCarte(carte);
    }

    public void addDeck(AddDeckEvent event) {
        Deck deck = new Deck(-1, event.getNom(), event.getCartes());
        db.addDeck(deck);
    }

    public void delDeck(int index) {
        db.delDeck(index);
    }

    public void AddPartie(AddPartieEvent event) {
        Partie partie = new Partie(-1, event.getDate(), event.isResultat(), event.getDecks());
        db.addPartie(partie);
    }

    public void DelPartie(int index) {
        db.delPartie(index);
    }

    public void AddConteneur(AddConteneurEvent event) {
        Conteneur conteneur = new Conteneur(-1, event.getNom(), event.getAbbr());
        db.addConteneur(conteneur);
    }

    public void DelConteneur(int index) {
        db.delConteneur(index);
    }

}

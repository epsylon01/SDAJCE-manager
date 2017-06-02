/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.composants;

import ch.ceff.ict3.sdajcemanager.listeners.AppListener;
import ch.ceff.ict3.sdajcemanager.modele.Carte;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author cp-13jru
 */
public class PageAjoutDeck extends JPanel {

    private TablePanelAjoutCarte tablePanel;
    private List<Carte> cartes;
    private AppListener listener;

    public PageAjoutDeck() {
        initComponents();
    }

    private void initComponents() {

        //toolBar = new ToolBar();
        tablePanel = new TablePanelAjoutCarte();

        tablePanel.refresh();
        this.add(tablePanel, BorderLayout.CENTER);

    }

    private void layoutComponents() {

    }
    
    public void setData(List<Carte> cartes) {
        this.cartes = cartes;
        tablePanel.setData(cartes);
        tablePanel.setAutoCreateRowSorter();
        tablePanel.setSorter();
    }
    
    public void setListener(AppListener listener) {
        this.listener = listener;
    }

}

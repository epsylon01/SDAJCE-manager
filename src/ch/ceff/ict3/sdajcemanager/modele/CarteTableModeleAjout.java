/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.modele;

import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cp-14luf
 */
public class CarteTableModeleAjout extends AbstractTableModel {

    private final String[] COLNAMES = {"Nombre", "Disponnible", "Nom", "Type", "Sphère", "Conteneur"};

    private List<Carte> cartes;
    private int[] nbr;
    
    
    @Override
    public int getRowCount() {
        return cartes.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Carte carte = cartes.get(rowIndex);
        
        
        switch (columnIndex) {
            case 0:
                return this.nbr[rowIndex];
            case 1:
                return carte.getNombre();
            case 2:
                return carte.getNom();
            case 3:
                return carte.getType();
            case 4:
                return carte.getSphere();
            case 5:
                return carte.getConteneur().getNom();
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return String.class;
            default:
                return String.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
//        Carte carte = cartes.get(row);
//        carte = value;
        System.out.println((int)value);
        this.nbr[row] = (int)value;
        
        fireTableCellUpdated(row, col);
    }

    public void setData(List<Carte> cartes) {
        this.cartes = cartes;
        this.nbr = new int[cartes.size()];
        
        for(int i = 0; i < cartes.size(); i++) {
            this.nbr[i] = cartes.get(i).getNombre();
        }
        
    }
    
    

    @Override
    public String getColumnName(int column) {
        return COLNAMES[column];
    }
}

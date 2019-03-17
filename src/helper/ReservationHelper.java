/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import bean.Reservation;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author YOUNES
 */
public class ReservationHelper extends AbstractHelper<Reservation>{
   private static AbstractHelperItem[] titres;

    static {
        titres = new AbstractHelperItem[]{
            new AbstractHelperItem("DATE RESERVATION ", "DateReservation"),
            new AbstractHelperItem("DATE DEBUT ", "DateArrive"),
            new AbstractHelperItem("DATE FIN ", "DateDepart"),
            new AbstractHelperItem("CHAMBRE", "Chambre")};

    }

    public ReservationHelper(JTable jTable, List<Reservation> list) {
        super(titres, jTable, list);
    }

    public ReservationHelper(AbstractHelperItem[] abstractHelperItem, JTable jTable) {
        super(titres, jTable);
    }

    public ReservationHelper(JTable jTable) {
        super(titres, jTable);
    }

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import bean.Hotel;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author YOUNES
 */
public class HotelHelper extends AbstractHelper<Hotel>{
   private static AbstractHelperItem[] titres;

    static {
        titres = new AbstractHelperItem[]{
            new AbstractHelperItem("NOM HOTEL ", "nom"),
            new AbstractHelperItem("PROPRIETAIRE ", "proprietaire"),
            new AbstractHelperItem("N°PHONE", "phone")};

    }

    public HotelHelper(JTable jTable, List<Hotel> list) {
        super(titres, jTable, list);
    }

    public HotelHelper(AbstractHelperItem[] abstractHelperItem, JTable jTable) {
        super(titres, jTable);
    }

    public HotelHelper(JTable jTable) {
        super(titres, jTable);
    }
}

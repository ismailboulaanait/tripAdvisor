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
public class HotelHelperEspace extends AbstractHelper<Hotel>{
   private static AbstractHelperItem[] titres;

    static {
        titres = new AbstractHelperItem[]{
            new AbstractHelperItem("NOM HOTEL ", "nom"),
            new AbstractHelperItem("ETAT ", "accepte")};

    }

    public HotelHelperEspace(JTable jTable, List<Hotel> list) {
        super(titres, jTable, list);
    }

    public HotelHelperEspace(AbstractHelperItem[] abstractHelperItem, JTable jTable) {
        super(titres, jTable);
    }

    public HotelHelperEspace(JTable jTable) {
        super(titres, jTable);
    }

    
}

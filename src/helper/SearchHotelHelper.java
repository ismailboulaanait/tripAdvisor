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
public class SearchHotelHelper extends AbstractHelper<Hotel>{
   private static AbstractHelperItem[] titres;

    static {
        titres = new AbstractHelperItem[]{
            new AbstractHelperItem("NOM HOTEL ", "nom"),
            new AbstractHelperItem("PHONE", "phone")};

    }

    public SearchHotelHelper(JTable jTable, List<Hotel> list) {
        super(titres, jTable, list);
    }

    public SearchHotelHelper(AbstractHelperItem[] abstractHelperItem, JTable jTable) {
        super(titres, jTable);
    }

    public SearchHotelHelper(JTable jTable) {
        super(titres, jTable);
    }

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import bean.Chambre;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author YOUNES
 */
public class ChambreHelper extends AbstractHelper<Chambre>{
   private static AbstractHelperItem[] titres;

    static {
        titres = new AbstractHelperItem[]{
            new AbstractHelperItem("NUMERO ", "numero"),
            new AbstractHelperItem("NOMBRE DE PLACE ", "nbrLit"),
            new AbstractHelperItem("PRIX", "prix")};

    }

    public ChambreHelper(JTable jTable, List<Chambre> list) {
        super(titres, jTable, list);
    }

    public ChambreHelper(AbstractHelperItem[] abstractHelperItem, JTable jTable) {
        super(titres, jTable);
    }

    public ChambreHelper(JTable jTable) {
        super(titres, jTable);
    }

    
}

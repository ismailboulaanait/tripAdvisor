/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import bean.Review;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author YOUNES
 */
public class ReviewHelper extends AbstractHelper<Review>{
   private static AbstractHelperItem[] titres;

    static {
        titres = new AbstractHelperItem[]{
            new AbstractHelperItem("NOTE", "note"),
            new AbstractHelperItem("COMMENTAIRE", "commentaire")};

    }

    public ReviewHelper(JTable jTable, List<Review> list) {
        super(titres, jTable, list);
    }

    public ReviewHelper(AbstractHelperItem[] abstractHelperItem, JTable jTable) {
        super(titres, jTable);
    }

    public ReviewHelper(JTable jTable) {
        super(titres, jTable);
    }

    
}

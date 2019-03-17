package helper;


import bean.User;
import java.util.List;

import javafx.scene.control.TableView;

public class CompteFxHelper extends AbstractFxHelper<User> {

    private static AbstractFxHelperItem[] titres;

    static {

        titres = new AbstractFxHelperItem[]{
            new AbstractFxHelperItem("RA9EM AL 7ISSAB", "id"),
            new AbstractFxHelperItem("A RASSID", "solde")};
    }

    public CompteFxHelper(TableView<User> table, List<User> list) {
        super(titres, table, list);
    }

    public CompteFxHelper(TableView<User> table) {
        super(titres, table);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Chambre;
import bean.Hotel;
import bean.HotelType;
import bean.Pays;
import bean.Ville;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import util.SearchUtil;

/**
 *
 * @author ismail boulaanait
 */
public class ChambreService extends AbstractFacade<Chambre>{
    
    public ChambreService() {
        super(Chambre.class);
    }
    
    public int addChambre(int numero , int nbrLit , int prix , Hotel hotel){
        List<Chambre> tst = getChambresHotel(hotel);
        for (Chambre chambre : tst) {
            if (chambre.getNumero()==numero) {
                return -1;
            }
        }
        Chambre chambre = new Chambre(numero, nbrLit, prix, hotel);
        create(chambre);
        return 1;
    }
    
    
    public List<Chambre> searchByCriteria(Pays pays ,Ville ville , HotelType type ,Integer nbrlit , Integer prixMin , Integer prixMax){
        String query = constractQuery(pays,ville, type, nbrlit, prixMin, prixMax);
        List<Chambre> res = new ArrayList();
        res = getEntityManager().createQuery(query).getResultList();
        return res ;
    }
    
//    public String constractQuery(Ville ville , HotelType type ,int nbrlit , int prixMin , int prixMax){
//        String query = "select   c from Chambre c where c.nbrLit='"+nbrlit+"'"
//                + "and c.prix>'"+prixMin+"'"
//                + "and c.prix<'"+prixMax+"'"
//                + "and c.hotel.type.id='"+type.getId()+"'"
//                + "and c.hotel.ville.id='"+ville.getId()+"'";
//        
//        return query;
//    }
    
    public String constractQuery(Pays pays ,Ville ville , HotelType type ,Integer nbrlit , Integer prixMin , Integer prixMax){
        String query = "select c from Chambre c where c.hotel.accepte='"+true+"'";
        if (pays != null ) {
            query += " and c.hotel.ville.pays.id='"+pays.getId()+"'";
        }
        if (ville != null ) {
            query += " and c.hotel.ville.id='"+ville.getId()+"'";
        }
        if (type != null ) {
            query += " and c.hotel.type.id='"+type.getId()+"'";
        }
        if (nbrlit != null && !nbrlit.equals("") ) {
            query += " and c.nbrLit='"+nbrlit+"'";
        }
        if (prixMin != null && !prixMin.equals("") ) {
            query += " and c.prix>='"+prixMin+"'";
        }
        if (prixMax != null && !prixMax.equals("") ) {
            query += " and c.prix<='"+prixMax+"'";
        }
        return query;
        
    }
    
    public List<Chambre> searchChambreReservation(Hotel hotel ,Date dateArr , Date dateDep ){
        java.sql.Date da = new java.sql.Date(dateArr.getTime());
        java.sql.Date dd = new java.sql.Date(dateDep.getTime());
        System.out.println(hotel.getId());
       String query = "select c from Chambre c where c.hotel.id='"+hotel.getId()+"'"
               + " and c not in (Select r.chambre from Reservation r where r.dateDepart<'"+da+"' "
               + " and r.dateArrive>'"+dd+"')";
       return getEntityManager().createQuery(query).getResultList();
//   String query="select c from Chambre c where c.hotel.id='"+hotel.getId()+"'"
//           + " and c not in(select r.chambre from Reservation r where 1=1 ";
//          query+=SearchUtil.addConstraintDate("r","dateDepart" , "<", dateArr);
//          query+=SearchUtil.addConstraintDate("r","dateArrive" , ">", dateDep);
//           
//         return getEntityManager().createQuery(query).getResultList();  

    }
    
    public List<Chambre> getChambresHotel(Hotel hotel){
        String query = "select c from Chambre c where c.hotel.id='"+hotel.getId()+"'";
        return getEntityManager().createQuery(query).getResultList();
    }
    
    public int modifierChambre(int numero , int nbrLit , int prix  , Chambre chambre){
        String query = "update Chambre c set c.numero='"+numero+"' , c.nbrLit='"+nbrLit+"', c.prix='"+prix+"' where c.id='"+chambre.getId()+"'";
        return execUpdate(query);
    }
    
    public int deleteChambre(Chambre chambre){
        String query = "delete from Chambre c where c.id='"+chambre.getId()+"'";
        return execUpdate(query);
    }
    
    public int deleteChambreByHotel(Hotel hotel){
        String query = "delete from Chambre c where c.hotel.id='"+hotel.getId()+"'";
        return execUpdate(query);
    }
    
}

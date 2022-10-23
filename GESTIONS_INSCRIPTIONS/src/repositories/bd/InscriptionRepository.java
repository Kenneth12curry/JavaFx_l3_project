package repositories.bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Etudiant;
import entities.Inscription;
import repositories.core.Mysqldb;

public class InscriptionRepository extends Mysqldb implements repositories.IInscriptionRepository{


    private final String INSERT="INSERT INTO `inscriptions` (`nom_etudiant`, `annee_inscription`, `etudiant_id`) VALUES (?, ?, ?);";
    private final String SQL_SELECT="SELECT * FROM inscriptions";
    private final String SELECT_BY_ID="SELECT * FROM `inscriptions` WHERE `id` = ?";


    @Override
    public List<Inscription> findAll() {
        List<Inscription> inscriptions=new ArrayList<>();
        this.ouvriConnexionBD();
        try {
            ps=conn.prepareStatement(SQL_SELECT);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                    Inscription inscription=new Inscription(
                        rs.getInt("id"),
                        rs.getString("nom_etudiant"),
                        rs.getString("annee_inscription "),
                        rs.getString("matricule_etudiant"));
                        
                                      
                 inscriptions.add(inscription);
                             
            }
 
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.closeConnexionBD();
         return inscriptions;
    }

    @Override
    public Inscription findById(int id) {
        Inscription inscription=null;
        this.ouvriConnexionBD();
        try {
            ps=conn.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                    inscription=new Inscription(
                        rs.getInt("id"),
                        rs.getString("nom_etudiant"),
                        rs.getString("annee_inscription "),
                        rs.getString("matricule_etudiant"));
                                      
                             
            }
 
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.closeConnexionBD();
        return inscription;

    }



    @Override
    public Inscription insert(Inscription inscription) {
        this.ouvriConnexionBD();
        try {
            ps=conn.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, inscription.getNomEtudiant());
            ps.setString(2, inscription.getAnneeInsc());
            ps.setInt(3, inscription.getEtudiant().getId());
            
            ps.executeUpdate();
            //retourner le dernier id insérer
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                inscription.setId(rs.getInt(1));
            }
            

    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
       this.closeConnexionBD();
        return inscription;
       
    }
    
}

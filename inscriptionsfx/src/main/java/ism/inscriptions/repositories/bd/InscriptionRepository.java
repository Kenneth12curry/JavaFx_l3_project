package ism.inscriptions.repositories.bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ism.inscriptions.entities.Etudiant;
import ism.inscriptions.entities.Inscription;
import ism.inscriptions.repositories.IInscriptionRepository;
import ism.inscriptions.core.Mysqldb;

public class InscriptionRepository extends Mysqldb implements IInscriptionRepository{

    private static final String INSERT="INSERT INTO `inscriptions` ( `annee_inscription`,`date_insc`,`filiere_etudiant`, `etudiant_id`) VALUES (?,?,?,?);";

    @Override
    public List<Inscription> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Inscription findById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Inscription insert(Inscription inscription) {
        this.ouvriConnexionBD();
        try {
            System.out.println(inscription.getEtudiant().getId());
            ps=conn.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, inscription.getAnneeInsc());
            ps.setString(2, inscription.getDateInsc());
            ps.setString(3, inscription.getFiliereEtudiant());
            ps.setInt(4, inscription.getEtudiant().getId());
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

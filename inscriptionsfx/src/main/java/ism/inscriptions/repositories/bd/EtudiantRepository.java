package ism.inscriptions.repositories.bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ism.inscriptions.entities.Etudiant;
import ism.inscriptions.entities.Role;
import ism.inscriptions.repositories.IEtudiantRepository;
import ism.inscriptions.core.Mysqldb;

public class EtudiantRepository  extends Mysqldb implements IEtudiantRepository {


    private final String SQL_SELECT="SELECT * FROM `user` WHERE `role` like 'ETUDIANT'";
    private final String SELECT_BY_MATRICULE="SELECT * FROM `user` WHERE `matricule` LIKE ?";
    private final String INSERT="INSERT INTO `user` (`login`, `password`, `nom_complet`, `role`, `nci`, `matricule`, `grade`, `tuteur`,classe_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?);";
    private final String SQL_SELECT_ANNEE="SELECT u.* FROM user u,inscriptions i WHERE  u.id=i.etudiant_id and role like 'ETUDIANT' and i.annee_inscription like ?";
    private final String SQL_SELECT_ETUDIANTS= "SELECT u.* FROM user u,classe c WHERE role like 'ETUDIANT' and u.classe_id=c.id and c.libelle like ?"; 
    private static final String  SQL_ETUDIANTS="Select u.* from user  u, classe c, inscriptions i WHERE c.id=u.classe_id  AND  u.id=i.etudiant_id AND u.role like 'ETUDIANT' AND i.annee_inscription like ?  AND c.libelle like ?";

    @Override
    public Etudiant finByMatricule(String matricule) {
        Etudiant etudiant=null;
        this.ouvriConnexionBD();
        try {
            ps=conn.prepareStatement(SELECT_BY_MATRICULE);
            ps.setString(1, matricule);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                    etudiant=new Etudiant(
                    rs.getInt("id"), 
                    rs.getString("login"), 
                    rs.getString("password"), 
                    rs.getString("nom_complet"), 
                    rs.getString("role").compareTo("ETUDIANT")==0? Role.ETUDIANT:Role.RP,
                    rs.getString("matricule"),
                    rs.getString("tuteur"));
                             
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.closeConnexionBD();
        return etudiant;
    }

    @Override
    public List<Etudiant> findAll() {
       List<Etudiant> etudiants=new ArrayList<>();
       this.ouvriConnexionBD();
       try {
           ps=conn.prepareStatement(SQL_SELECT);
           ResultSet rs=ps.executeQuery();
           while(rs.next()){
                   Etudiant etudiant=new Etudiant(
                   rs.getInt("id"), 
                   rs.getString("login"), 
                   rs.getString("password"), 
                   rs.getString("nom_complet"), 
                   rs.getString("role").compareTo("ETUDIANT")==0? Role.ETUDIANT:Role.RP,
                   rs.getString("matricule"),
                   rs.getString("tuteur"));

                etudiants.add(etudiant);
                            
           }

       } catch (SQLException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
       this.closeConnexionBD();
        return etudiants;
    }

    @Override
    public Etudiant insert(Etudiant etudiant) {
        this.ouvriConnexionBD();
        try {
            ps=conn.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, etudiant.getLogin());
            ps.setString(2, etudiant.getPassword());
            ps.setString(3, etudiant.getNomComplet());
            ps.setString(4, etudiant.getRole().name());
            if(etudiant.getRole().name().compareTo("ETUDIANT")==0){
                ps.setNull(5, java.sql.Types.FLOAT);
                ps.setNull(7, java.sql.Types.FLOAT);

               
            }
            ps.setString(6,etudiant.getMatricule());
            ps.setString(8,etudiant.getTuteur());
            ps.setInt(9, etudiant.getClasse().getId());
            ps.executeUpdate();
            //retourner le dernier id insérer
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){

                etudiant.setId(rs.getInt(1));
             
            }
            

    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
       this.closeConnexionBD();
        return etudiant;
    }

    @Override
    public List<Etudiant> findByEtudiants(String annee) {
        List<Etudiant> etudiants=new ArrayList<>();
        this.ouvriConnexionBD();
        try {
            ps=conn.prepareStatement(SQL_SELECT_ANNEE);
            ps.setString(1, annee);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                    Etudiant etudiant=new Etudiant(
                    rs.getInt("id"), 
                    rs.getString("login"), 
                    rs.getString("password"), 
                    rs.getString("nom_complet"), 
                    rs.getString("role").compareTo("ETUDIANT")==0? Role.ETUDIANT:Role.RP,
                    rs.getString("matricule"),
                    rs.getString("tuteur"));
 
                 etudiants.add(etudiant);
                             
            }
 
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.closeConnexionBD();
         return etudiants;
    }

    @Override
    public List<Etudiant> findByEtudiant(String annee,String libelle) {
        List<Etudiant> etudiants=new ArrayList<>();
        this.ouvriConnexionBD();
        try {
            ps=conn.prepareStatement(SQL_ETUDIANTS);
            ps.setString(1, annee);
            ps.setString(2, libelle);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                    Etudiant etudiant=new Etudiant(
                    rs.getInt("id"), 
                    rs.getString("login"), 
                    rs.getString("password"), 
                    rs.getString("nom_complet"), 
                    rs.getString("role").compareTo("ETUDIANT")==0? Role.ETUDIANT:Role.RP,
                    rs.getString("matricule"),
                    rs.getString("tuteur"));
 
                 etudiants.add(etudiant);
                             
            }
 
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.closeConnexionBD();
         return etudiants;
    }
    
}

package repositories.bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Classe;
import entities.Professeur;
import entities.ProfesseurClasse;
import entities.Role;
import repositories.IProfesseurRepository;
import repositories.core.Mysqldb;

public class ProfesseurRepository extends Mysqldb implements IProfesseurRepository{

    private final String SQL_SELECT="select * from user WHERE role like'PROFESSEUR'";
    private final String SQL_INSERT="INSERT INTO `user` (`login`, `password`, `nom_complet`, `role`, `nci`, `matricule`, `grade`, `tuteur`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    private final String SQL_SELECT_BY_NCI="SELECT * FROM `user` WHERE `nci` LIKE ?";
    private final String SQL_SELECT_BY_CLASSE2="SELECT c.* FROM `classe` c,professeur_classe pc ,user u WHERE c.id = pc.classe_id and u.id = pc.professeur_id and u.nci like ?";
   
    
    @Override
    public List<Professeur> findAll() {
        List<Professeur> professeurs=new ArrayList<>();
        this.ouvriConnexionBD();
        try {
            ps=conn.prepareStatement(SQL_SELECT);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Professeur professeur=new Professeur(
                    rs.getInt("id"), 
                    rs.getString("login"), 
                    rs.getString("password"), 
                    rs.getString("nom_complet"), 
                    rs.getString("role").compareTo("PROFESSEUR")==0? Role.PROFESSEUR:Role.RP,
                    rs.getString("nci"),
                    rs.getString("grade"));

                professeurs.add(professeur);
                     
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.closeConnexionBD();
        return professeurs;
    }

    @Override
    public List<Classe> findByClasseProfesseur(String nci) {
       
        List<Classe> classes=new ArrayList<>();
        this.ouvriConnexionBD();
        try {
            ps=conn.prepareStatement(SQL_SELECT_BY_CLASSE2);
            ps.setString(1, nci);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Classe classe=new Classe(
                    rs.getInt("id"), 
                    rs.getString("filiere"), 
                    rs.getString("libelle"));

                classes.add(classe);
               }  
             
               
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.closeConnexionBD();
        return classes;
    }

    @Override
    public Professeur findByNci(String nci) {
        Professeur professeur=null;
        this.ouvriConnexionBD();
        try {
            ps=conn.prepareStatement(SQL_SELECT_BY_NCI);
            ps.setString(1, nci);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                    professeur=new Professeur(
                    rs.getInt("id"), 
                    rs.getString("login"), 
                    rs.getString("password"), 
                    rs.getString("nom_complet"), 
                    rs.getString("role").compareTo("PROFESSEUR")==0? Role.PROFESSEUR:Role.RP,
                    rs.getString("nci"),
                    rs.getString("grade"));
                             
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.closeConnexionBD();
        return professeur;
        
    }

    @Override
    public Professeur insert(Professeur professeur) {
        this.ouvriConnexionBD();
        try {
            ps=conn.prepareStatement(SQL_INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, professeur.getLogin());
            ps.setString(2, professeur.getPassword());
            ps.setString(3, professeur.getNomComplet());
            ps.setString(4, professeur.getRole().name());
            ps.setString(5, professeur.getNci());
            if(professeur.getRole().name().compareTo("PROFESSEUR")==0){

                ps.setNull(6,java.sql.Types.FLOAT);
                ps.setNull(8,java.sql.Types.FLOAT);
            }
            ps.setString(7, professeur.getGrade());
            ps.executeUpdate();
            //retourner le dernier id insérer
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                professeur.setId(rs.getInt(1));
            }
            

    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
       this.closeConnexionBD();
        return professeur;
    }

   

   
    
}

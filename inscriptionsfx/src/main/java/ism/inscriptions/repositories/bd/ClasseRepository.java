package ism.inscriptions.repositories.bd;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ism.inscriptions.entities.Classe;
import ism.inscriptions.repositories.IClasseRepository;
import ism.inscriptions.core.Mysqldb;

public class ClasseRepository extends Mysqldb implements IClasseRepository{
    
    private final String SQL_SELECT="select * from classe";
    private final String SQL_INSERT="INSERT INTO `classe` (`libelle`, `filiere`) VALUES (?,?);";
    private final String SQL_SELECT_BY_ID="SELECT * FROM `classe` WHERE `id` = ?";
    private final String SQL_SELECT_BY_LIBELLE="SELECT * FROM `classe` WHERE `libelle` like ?";

    @Override
    public List<Classe> findAll() {
        List<Classe> classes =new ArrayList<>();
        this.ouvriConnexionBD();
        try {
            ps=conn.prepareStatement(SQL_SELECT);
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
    public Classe findById(int id) {
        Classe classe=null;
        this.ouvriConnexionBD();
        try {
            ps=conn.prepareStatement(SQL_SELECT_BY_ID);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                 classe=new Classe(
                    rs.getInt("id"), 
                    rs.getString("filiere"), 
                    rs.getString("libelle"));      
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.closeConnexionBD();
        return classe;
      
    }

    @Override
    public Classe insert(Classe classe) {
        this.ouvriConnexionBD();
        try {
            ps=conn.prepareStatement(SQL_INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, classe.getLibelle());
            ps.setString(2, classe.getFiliere());
            ps.executeUpdate();
            //retourner le dernier id insérer
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                classe.setId(rs.getInt(1));
            }
            

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.closeConnexionBD();
        return classe;
       
    }

    @Override
    public Classe findByLibelle(String libelle) {
        Classe classe=null;
        this.ouvriConnexionBD();
        try {
            ps=conn.prepareStatement(SQL_SELECT_BY_LIBELLE);
            ps.setString(1, libelle);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                 classe=new Classe(
                    rs.getInt("id"), 
                    rs.getString("filiere"), 
                    rs.getString("libelle"));      
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.closeConnexionBD();
        return classe;
    }
    
}

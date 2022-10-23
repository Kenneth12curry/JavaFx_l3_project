package repositories.bd;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import entities.ProfesseurClasse;
import repositories.IProfesseurClasseRepository;
import repositories.core.Mysqldb;


public class ProfesseurClasseRepository extends Mysqldb implements IProfesseurClasseRepository {

    private final String INSERT="INSERT INTO `professeur_classe` (`classe_id`, `professeur_id`) VALUES (?,?);";
    @Override
    public ProfesseurClasse insertClasseprof(ProfesseurClasse professeurclasse) {
        this.ouvriConnexionBD();
        try {
            ps=conn.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, professeurclasse.getClasse().getId());
            ps.setInt(2, professeurclasse.getProfesseur().getId());
            ps.executeUpdate();
            //retourner le dernier id insérer
            

    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
       this.closeConnexionBD();
       return professeurclasse;
    }
    
}

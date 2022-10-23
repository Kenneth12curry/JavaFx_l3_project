package ism.inscriptions.repositories.bd;

import java.sql.ResultSet;
import java.sql.SQLException;

import ism.inscriptions.core.Mysqldb;
import ism.inscriptions.entities.Role;
import ism.inscriptions.entities.User;
import ism.inscriptions.repositories.IUserRepository;

public class UserRepository extends Mysqldb implements IUserRepository {

    private final String  SQL_CONNECT="SELECT * FROM `user` WHERE `login` LIKE ? AND `password` LIKE ?";
    @Override
    public User findUserByLoginAndPassword(String login, String password) {

        User user=null;
        this.ouvriConnexionBD();
        try {
            ps=conn.prepareStatement(SQL_CONNECT);
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                    user=new User(
                    rs.getInt("id"), 
                    rs.getString("login"), 
                    rs.getString("password"), 
                    rs.getString("nom_complet"), 
                    rs.getString("role").compareTo("AC")==0? Role.AC:Role.RP);  
                             
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.closeConnexionBD();
        return user;
    }
    
}

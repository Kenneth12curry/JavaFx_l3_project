package ism.inscriptions.entities;

public class User {
    
    protected int id;
    protected String login;
    protected String password;
    protected String nomComplet;
    protected Role role;
    //protected static int nbre;
   
    
    //Constructeur

    public User() {
        /*nbre++;
        id=nbre;
        role=Role.RP*/

    }

    //Surchage du Constructeur
    
    public User(String login, String password, String nomComplet) {
        this.login = login;
        this.password = password;
        this.nomComplet = nomComplet;
        role=Role.RP;

    }

    public User(int id, String login, String password, String nomComplet, Role role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.nomComplet = nomComplet;
        this.role = role;
        role=Role.RP;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id=id;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getNomComplet() {
        return nomComplet;
    }
    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "[id=" + id + ", login=" + login + ", nomComplet=" + nomComplet + ", password=" + password
                + ", role=" + role + "";
    }


}

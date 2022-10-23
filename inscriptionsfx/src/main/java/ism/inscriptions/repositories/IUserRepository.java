package ism.inscriptions.repositories;

import ism.inscriptions.entities.User;

public interface IUserRepository {

    public User findUserByLoginAndPassword(String login,String password);
}

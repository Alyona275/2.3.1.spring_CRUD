package CRUDapplication.dao;

import CRUDapplication.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    void updateUser(User user);
    void removeById(long id);
    User getUserById(long id);
    List<User> getUsers();
}

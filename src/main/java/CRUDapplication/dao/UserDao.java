package CRUDapplication.dao;

import CRUDapplication.model.Role;
import CRUDapplication.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    void updateUser(User user);
    void removeById(long id);
    User getUserById(long id);
    Role getRoleById(long id);
    User findByUsername(String username);
    List<User> getUsers();
    List<Role> getRoles();
}

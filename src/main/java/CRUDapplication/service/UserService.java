package CRUDapplication.service;

import CRUDapplication.model.Role;
import CRUDapplication.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void updateUser(User user);
    void removeById(long id);
    User getUserById(long id);
    Role getRoleById(long id);
    List<User> getUsers();
    List<Role> getRoles();
}

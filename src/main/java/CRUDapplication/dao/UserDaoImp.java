package CRUDapplication.dao;

import CRUDapplication.model.Role;
import CRUDapplication.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addUser(User user) {
        em.merge(user);
    }

    @Override
    public void updateUser(User user) {
        em.merge(user);
    }

    @Override
    public void removeById(long id) {
        em.remove(getUserById(id));
    }

    @Override
    public User getUserById(long id) {
        return em.find(User.class, id);
    }

    @Override
    public Role getRoleById(long id) {
        return em.find(Role.class, id);
    }

    @Override
    public User findByUsername(String username) {
        User user = em.createQuery("select u from User u where u.username = :username", User.class)
                .setParameter("username", username).getSingleResult();
        return user;
    }

    @Override
    public List<User> getUsers() {
        TypedQuery<User> namedQuery = em.createNamedQuery("User.getAll", User.class);

        return namedQuery.getResultList();
    }

    @Override
    public List<Role> getRoles() {
        return em.createNamedQuery("Role.getAll", Role.class).getResultList();
    }
}

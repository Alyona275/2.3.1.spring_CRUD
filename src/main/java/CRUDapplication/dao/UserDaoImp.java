package CRUDapplication.dao;

import CRUDapplication.model.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
    public User findByUsername(String username) {
        List<User> userList = getUsers();
        User res = null;
        for (User user : userList) {
            if (username.equals(user.getUsername())) {
                res = getUserById(user.getId());
            } else {
                throw new UsernameNotFoundException("User not found");
            }
        }
        return res;
    }

    @Override
    public List<User> getUsers() {
        TypedQuery<User> namedQuery = em.createNamedQuery("User.getAll", User.class);

        return namedQuery.getResultList();
    }
}

package peaksoft.dao;

import peaksoft.model.User;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao{


    @Override
    public void createUsersTable() {

    }

    @Override
    public void dropUsersTable() {

    }

    @Override
    public void saveUser(long id, String name, String lastName, byte age) {

    }

    @Override
    public void removeUserById(long id) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void cleanUsersTable() {

    }

    @Override
    public boolean existsByFirstName(String firstName) {
        return false;
    }
}

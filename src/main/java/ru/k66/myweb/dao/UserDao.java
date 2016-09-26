package ru.k66.myweb.dao;

import ru.k66.myweb.model.User;

import java.util.List;

/**
 * Created by ikydp on 06.09.2016.
 */
public interface UserDao {
    public void add(User user);
    public void edit(User user);
    public void delete(int  userId);
    public User getUser(int userId);
    public List getAllUsers();
    List seatchUser(User User);
}

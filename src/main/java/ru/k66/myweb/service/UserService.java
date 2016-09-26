package ru.k66.myweb.service;

import ru.k66.myweb.model.User;

import java.util.List;

/**
 * Created by ikydp on 08.09.2016.
 */
public interface UserService {

    public void add(User user);
    public void edit(User user);
    public void delete(int  userId);
    public User getUser(int userId);
    public List getAllUsers();
    List seatchUser(User User);

}

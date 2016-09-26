package ru.k66.myweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.k66.myweb.dao.UserDao;
import ru.k66.myweb.model.User;
import ru.k66.myweb.service.UserService;

import java.util.List;

/**
 @Qualifier("humanFindDaoImlp")
 @Autowired
 private HumanDao humanFindDao;

 @Transactional
 public void add(Human human) {
 humanFindDao.add(human);
 }

 @Transactional
 public void edit(Human human) {
 humanFindDao.edit(human);
 }

 @Transactional
 public void delete(int humanId) {
 humanFindDao.delete(humanId);
 }

 @Transactional
 public Human getHuman(int humanId) {
 return humanFindDao.getHuman(humanId);
 }

 @Override
 public List searchHumans(Human human) {
 return humanFindDao.seatchHuman(human);
 }

 @Transactional
 public List getAllHumans() {
 return humanFindDao.getAllHumans();
 }
 }
 */
@Service
public class UserServiceImpl implements UserService {

 @Qualifier(value = "userDaoImpl")
    @Autowired
    private UserDao userDao;

    @Transactional
    public void add(User user) {
userDao.add(user);
    }

    @Transactional
    public void edit(User user) {
userDao.edit(user);
    }

    @Transactional
    public void delete(int userId) {
userDao.delete(userId);
    }

    @Transactional
    public User getUser(int userId) {
        return userDao.getUser(userId);
    }

    @Transactional
    public List getAllUsers() {
        return userDao.getAllUsers();
    }

    @Transactional
    public List seatchUser(User user) {
        return userDao.seatchUser(user);
    }
}

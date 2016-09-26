package ru.k66.myweb.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ru.k66.myweb.dao.UserDao;

import ru.k66.myweb.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ikydp on 06.09.2016.
 */
@Transactional
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory session;
    @Override
    public void add(User user) {


        session.getCurrentSession().save(user);
    }
    @Override
    public void edit(User user) {
        session.getCurrentSession().update(user);
    }


    @Override
    public void delete(int userId) {
        session.getCurrentSession().delete(getUser(userId));

    }
    @Override
    public User getUser(int UserId) {
        return (User) session.getCurrentSession().get(User.class,UserId);
    }
    @Override
    public List getAllUsers() {
        return session.getCurrentSession().createQuery("from User").list();
    }


    @Override
    public List seatchUser(User user) {


        List list = new ArrayList();


        if (user.getSendto()!= null){
            list =  getFindList(user.getSendto());
            if(list.size()>0){
                return list;
            }
        }
        /*
        if (User.getCity()!= null){

            list =  getFindList(User.getCity());
            if(list.size()>0){
                return list;
            }
        }
        if (User.getCar() != null){

            list =  getFindList(User.getCar());
            if(list.size()>0){
                return list;
            }
        }
*/
        User newUser = new User();

        newUser.setName("Не найдено");
        newUser.setSurname("записей");
        list.add(newUser);
        return list;
    }

    private List getFindList ( String nameof){
        //    return session.getCurrentSession(). createQuery("from User where  concat(userId,name,second,surname,sendto,email,subject,text) like '%" +
        return session.getCurrentSession(). createQuery("from User where  concat(sendto) like '%" +

                nameof+
                "%'" ).list();
    }

/*
  private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "second")
    private String second;
    @Column(name = "surname")
    private String surname;



    @Column(name = "sendto")
    private String sendto;

    @Column(name = "email")
    private String email;
    @Column(name = "subject")
    private String subject;

    @Column(name = "text")
    private String text;

 */


}

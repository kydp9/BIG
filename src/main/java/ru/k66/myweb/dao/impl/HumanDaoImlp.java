package ru.k66.myweb.dao.impl;




import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.k66.myweb.dao.HumanDao;
import ru.k66.myweb.model.Human;

import java.util.List;


@Repository
public class HumanDaoImlp implements HumanDao {
@Autowired
    private SessionFactory session;
@Override
    public void add(Human human) {
session.getCurrentSession().save(human);
    }
    @Override
    public void edit(Human human) {
session.getCurrentSession().update(human);
    }


    @Override
    public void delete(int humanId) {
session.getCurrentSession().delete(getHuman(humanId));

    }
    @Override
    public Human getHuman(int humanId) {
        return (Human) session.getCurrentSession().get(Human.class,humanId);
    }
    @Override
    public List getAllHumans() {
        return session.getCurrentSession().createQuery("from Human").list();
    }

    @Override
    public List seatchHuman(Human human) {
        return session.getCurrentSession().createQuery("from Human").list();
    }
}

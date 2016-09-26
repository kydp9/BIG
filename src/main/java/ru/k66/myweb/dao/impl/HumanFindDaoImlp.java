package ru.k66.myweb.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.k66.myweb.dao.HumanDao;
import ru.k66.myweb.model.Human;

import java.util.ArrayList;
import java.util.List;




@Transactional
@Repository
public class HumanFindDaoImlp implements HumanDao {
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


List list = new ArrayList();
        if (human.getSurname()!= null){

          list =  session.getCurrentSession(). createQuery("from Human where  concat(id,first,second,last,car,city) like '%" +
                  human.getSurname()+
                  "%'" ).list();
            if(list.size()>0){
                return list;
            }
        }

        if (human.getName()!= null){
            list =  getFindList(human.getName());
            if(list.size()>0){
                return list;
            }
        }
        if (human.getCity()!= null){

            list =  getFindList(human.getCity());
            if(list.size()>0){
                return list;
            }
        }
        if (human.getCar() != null){

            list =  getFindList(human.getCar());
            if(list.size()>0){
                return list;
            }
        }

        Human newHuman = new Human();
        newHuman.setCar("Результатов");
        newHuman.setCity("Повторите запрос");
        newHuman.setName("Поиск");
        newHuman.setSurname("Не дал");
       list.add(newHuman);
        return list;
    }

    private List getFindList ( String nameof){
       return session.getCurrentSession(). createQuery("from Human where  concat(id,first,second,last,car,city) like '%" +

               nameof+
                "%'" ).list();
    }
}


package ru.k66.myweb.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.k66.myweb.dao.HumanDao;
import ru.k66.myweb.model.Human;
import ru.k66.myweb.service.HumanService;


import javax.ejb.TransactionAttribute;
import java.util.List;

/**
 * Created by ikydp on 02.09.2016.
 */
@Service
public class HumanServiceimpl implements HumanService {


    @Qualifier("humanDaoImlp")
    @Autowired

     private HumanDao humanDao;

    @Transactional
    public void add(Human human) {
humanDao.add(human);
    }

    @Transactional
    public void edit(Human human) {
humanDao.edit(human);
    }

    @Transactional
    public void delete(int humanId) {
humanDao.delete(humanId);
    }

    @Transactional
    public Human getHuman(int humanId) {
        return humanDao.getHuman(humanId);
    }

    @Override
    public List searchHumans(Human human) {
        return null;
    }

    @Transactional
    public List getAllHumans() {
        return humanDao.getAllHumans();
    }
}

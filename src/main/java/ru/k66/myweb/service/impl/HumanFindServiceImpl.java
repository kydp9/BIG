package ru.k66.myweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.k66.myweb.dao.HumanDao;
import ru.k66.myweb.model.Human;
import ru.k66.myweb.service.HumanService;

import java.util.List;

/**
 * Created by ikydp on 04.09.2016.
 */
@Service
public class HumanFindServiceImpl implements HumanService {
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


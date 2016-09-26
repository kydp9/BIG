package ru.k66.myweb.service;

import ru.k66.myweb.model.Human;

import java.util.List;

/**
 * Created by ikydp on 02.09.2016.
 */
public interface HumanService {

    public void add(Human human);
    public void edit(Human human);
    public void delete(int  humanId);
    public  Human getHuman(int humanId);
    public  List searchHumans(Human human);
    public List getAllHumans();
}

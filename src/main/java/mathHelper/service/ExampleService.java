package mathHelper.service;

import mathHelper.Dao.ExampleDaoImpl;
import mathHelper.model.Examples;

import java.util.List;

public class ExampleService {
    private final ExampleDaoImpl exampleDao = new ExampleDaoImpl();

    public Object save(Examples examples){
        if (examples.getExample()!= null){
            return exampleDao.save(examples);
        } else {
            return null;
        }
    }

    public void getByEquals(Double equals){
            exampleDao.getByEquals(equals);
    }
    public void delete(Examples examples){
        exampleDao.delete(examples);
    }
}

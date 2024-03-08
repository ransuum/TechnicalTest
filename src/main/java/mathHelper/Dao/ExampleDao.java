package mathHelper.Dao;

import mathHelper.model.Examples;

import java.util.List;

public interface ExampleDao {
    Object save(Examples examples);
    void delete(Examples examples);
    void update(Examples examples);
    void getByEquals(Double equals);
}

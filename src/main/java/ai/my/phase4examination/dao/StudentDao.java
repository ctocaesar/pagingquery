package ai.my.phase4examination.dao;

import ai.my.phase4examination.domain.Student;

import java.util.List;
import java.util.Map;

/**
 * @ClassName StudentDao
 * @Description TODO
 * @Auther: 张伟
 * @Date 2019/8/24 14:25
 * @Version 1.0
 */
public interface StudentDao {
    int save(Student student);

    List<Student> pagingQuery(Map<String, Object> map);

    int getTotal(Map<String, Object> map);

}

package ai.my.phase4examination.service;

import ai.my.phase4examination.domain.Student;
import ai.my.phase4examination.vo.PaginationVo;

import java.util.Map;

/**
 * @ClassName StudentService
 * @Description TODO
 * @Auther: 张伟
 * @Date 2019/8/24 14:24
 * @Version 1.0
 */
public interface StudentService {
    int save(Student student);

    PaginationVo<Student> pagingQuery(Map<String, Object> map);
}

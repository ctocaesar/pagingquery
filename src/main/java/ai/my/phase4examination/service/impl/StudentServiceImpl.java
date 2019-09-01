package ai.my.phase4examination.service.impl;

import ai.my.phase4examination.dao.StudentDao;
import ai.my.phase4examination.domain.Student;
import ai.my.phase4examination.service.StudentService;
import ai.my.phase4examination.vo.PaginationVo;
import ai.my.utils.SqlSessionUtil;

import java.util.List;
import java.util.Map;

/**
 * @ClassName StudentServiceImpl
 * @Description TODO
 * @Auther: 张伟
 * @Date 2019/8/23 14:24
 * @Version 1.0
 */
public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = SqlSessionUtil.getSqlSession().getMapper(StudentDao.class);
    @Override
    public int save(Student student) {
        // StudentDao studentDao = SqlSessionUtil.getSqlSession().getMapper(StudentDao.class);
        int count = studentDao.save(student);
        return count;
    }

    @Override
    public PaginationVo<Student> pagingQuery(Map<String, Object> map) {
        List<Student> studentList = studentDao.pagingQuery(map);
        int total = studentDao.getTotal(map);
        PaginationVo<Student> vo = new PaginationVo<>();
        vo.setTotal(total);
        vo.setStudentList(studentList);

        return vo;
    }
}

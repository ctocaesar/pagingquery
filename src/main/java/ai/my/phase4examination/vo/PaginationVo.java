package ai.my.phase4examination.vo;
/**
 * Copyright (C), 2015-2019, XXX有限公司
 * Package : ai.my.phase4examination.vo
 * FileName: PaginationVo
 * Author:   张伟
 * Date:     2019/8/24 14:40
 * Description: 返回学生分页查询信息类VO
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈返回学生分页查询信息类VO〉
 *
 * @author 张伟
 * @create 2019/8/23
 * @since 1.0.0
 */
public class PaginationVo<T> {
    private int total;
    private List<T> studentList;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<T> studentList) {
        this.studentList = studentList;
    }
}

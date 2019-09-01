package ai.my.phase4examination.web.controller;

import ai.my.phase4examination.domain.Student;
import ai.my.phase4examination.service.StudentService;
import ai.my.phase4examination.service.impl.StudentServiceImpl;
import ai.my.phase4examination.vo.PaginationVo;
import ai.my.utils.PrintJson;
import ai.my.utils.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * @ClassName StudentController
 * @Description TODO
 * @Auther: 张伟
 * @Date 2019/8/24 14:21
 * @Version 1.0
 */
public class StudentController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入到学生控制器");
        String path = request.getServletPath();
        if("/student/pagingQuery.do".equals(path)){
            System.out.println("/student/pagingQuery.do");
            pagingQuery(request,response);
        }
    }

    private void pagingQuery(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("执行分页查询");
        String pageNoStr = request.getParameter("pageNo");
        String pageSizeStr = request.getParameter("pageSize");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        int pageNo = Integer.valueOf(pageNoStr);
        int pageSize = Integer.valueOf(pageSizeStr);
        // 略过条数
        int skipCount = (pageNo-1)*pageSize;
        Map<String,Object> map = new HashMap<>();
        map.put("name", name);
        map.put("gender",gender);
        map.put("address",address);
        map.put("phone",phone);
        map.put("skipCount",skipCount);
        map.put("pageSize",pageSize);

        StudentService ss = (StudentService) ServiceFactory.getService(new StudentServiceImpl());
        PaginationVo<Student> vo = ss.pagingQuery(map);
        PrintJson.printJsonObj(response,vo);

    }
}

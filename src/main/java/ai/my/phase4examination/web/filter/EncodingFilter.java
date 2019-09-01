package ai.my.phase4examination.web.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName EncodingFilter
 * @Description TODO
 * @Auther: 张伟
 * @Date 2019/8/24 14:55
 * @Version 1.0
 */
public class EncodingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        System.out.println("进入到过滤字符编码的过滤器");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        chain.doFilter(req, resp);
    }
}

package com.wkcto.springboot.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * ClassName:${NAME}
 * <p>
 * Package:${PACKAGE_NAME}
 * Description:
 *
 * @Date:2018/8/7 11:28
 * @Author:GanHoL
 */
public class HeFilter implements Filter {

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        //过滤业务处理（省略）

        System.out.println("进入了heFilter..........");

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}

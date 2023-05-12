package com.beeBank.beeBank.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// import org.apache.jasper.compiler.Node.UseBean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.beeBank.beeBank.models.User;

@Component
public class AppInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        System.out.println("In Pre Handle Interceptor Method");
        // CHECK REQUEST URI:
        if(request.getRequestURI().startsWith("/app")){
            //Get Session:
            HttpSession session = request.getSession();

            //Get Token Stored in Session:
            String token = (String) session.getAttribute("token");
            System.out.println(token);

            //Get User object stored in session 
            User user = (User)session.getAttribute("user");

            //check if authenticated
            // boolean isAuthenticated=(boolean)session.getAttribute("authenticated");

            //Validate session attributes/ objects:
            if(token == null || user == null){
                response.sendRedirect("/login");
                return false;
            }
            //End of Validate Session Attributes/ objects 
        }
        //End of Check Request URI
        return true;
    }
    //End of Pre Handle Mehtod  
  
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception{
        System.out.println("In Post Handle Interceptor Method");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception{
        System.out.println("In After Completion Handle Interceptor Method");
    }
}

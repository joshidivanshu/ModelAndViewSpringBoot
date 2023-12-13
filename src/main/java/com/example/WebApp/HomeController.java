package com.example.WebApp;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("home")
    @ResponseBody
    public String home(HttpServletRequest request) {
        /*
        * Can test this functionality by making a curl request
        *curl -X POST -d "key1=test" http://localhost:8080/home
        * */
        System.out.println(request.toString());
        System.out.println(request.getParameterNames());
        System.out.println(request.getParameter("key1"));
        System.out.println("Hi from homepage!!");
        return "Hello to homepage";
    }

    @RequestMapping("test")
    @ResponseBody
    public String testMethod() {
        return "Get request tester for dispatcher servlet";
    }

    @RequestMapping("sessionTest")
    @ResponseBody
    public String testMethod2(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String name = request.getParameter("name");
        System.out.println("Hi "+ name);
        session.setAttribute("name", name);
        return "Hi" + name;

    }

    @RequestMapping("home1")
    @ResponseBody
    public String home1(String name, HttpSession session) {
        System.out.println("Hi " + name);
        return "Hi " + name;
    }

    @RequestMapping("home2")
    @ResponseBody
    public String home2(@RequestParam("name") String myName, @RequestParam("test") String salutation) {
        System.out.println("Hi  " + salutation + " " +  myName);
        return "Hi " + myName;
    }

    @RequestMapping("home3")
    public String home3(Model model) {
        Mydata mydata = new Mydata();
        mydata.setName("Divanshu");
        mydata.setAge(10);

        model.addAttribute("myData", mydata);
        return "example";

    }

    @RequestMapping("home4")
    public ModelAndView home4() {
        ModelAndView mv = new ModelAndView();
        Mydata mydata = new Mydata();
        mydata.setName("Divanshu");
        mydata.setAge(10);
        mv.addObject("myData", mydata);
        mv.setViewName("example");

        return mv;
    }


}

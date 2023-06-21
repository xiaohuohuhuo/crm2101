package com.itheima.controller;


import com.itheima.domain.User;
import com.itheima.domain.Vo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @ResponseBody
    @RequestMapping(value="/quick23")
    public void save23(String username, MultipartFile[] uploadFile) throws IOException{
        System.out.println(username);
        for (MultipartFile multipartFile:uploadFile){
            String originalFilename = multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File("C:\\upload\\"+originalFilename));

        }
    }

    @ResponseBody
    @RequestMapping(value="/quick22")
    public void save22(String username, MultipartFile uploadFile,MultipartFile uploadFile2) throws IOException{
        System.out.println(username);
        String originalFilename = uploadFile.getOriginalFilename();
        uploadFile.transferTo(new File("C:\\upload\\"+originalFilename));
        String originalFilename2 = uploadFile2.getOriginalFilename();
        uploadFile2.transferTo(new File("C:\\upload\\"+originalFilename2));
    }

    @ResponseBody
    @RequestMapping(value="/quick21")
    public void save21(@CookieValue(value="JSESSIONID",required= false)String jsessionId) throws IOException{
        System.out.println(jsessionId);
    }

    @ResponseBody
    @RequestMapping(value="/quick20")
            public void save20(@RequestHeader(value="User-Agent",required= false)String user_agent) throws IOException{
            System.out.println(user_agent);
    }

    @ResponseBody
    @RequestMapping(value="/quick19")
    public void save19 (HttpServletRequest request, HttpServletResponse response, HttpSession session)throws IOException {
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
    }

    @ResponseBody
    @RequestMapping(value="/quick18")
    public void save18 (Date date)throws IOException {
        System.out.println(date);
    }

    @ResponseBody
    @RequestMapping(value="/quick17/{username}")
    public void save17(@PathVariable (value="username") String username) throws IOException {
        System.out.println(username);
    }

    @ResponseBody
    @RequestMapping(value="/quick16")
    public void save16(@RequestParam(value="name",required = false,defaultValue="itcast") String username) throws IOException {
        System.out.println(username);
    }

    @ResponseBody
    @RequestMapping(value="/quick15")
    public void save15(@RequestBody List<User> userList) throws IOException {
        System.out.println(userList);
    }


    @ResponseBody
    @RequestMapping(value="/quick14")
    public void save14(Vo vo) throws IOException {
        System.out.println(vo);
    }

    @ResponseBody
    @RequestMapping(value="/quick13")
    public void save13(String[] strs) throws IOException {
        System.out.println(Arrays.asList(strs));
    }

    @ResponseBody
    @RequestMapping(value="/quick12")
    public void save12(User user) throws IOException {
        System.out.println(user);
    }

    @ResponseBody
    @RequestMapping(value="/quick11")
    public void save11(String username,int age) throws IOException {
    System.out.println(username);
    System.out.println(age);
}

    @RequestMapping(value="/quick10")
    @ResponseBody
    public User save10() throws IOException {
    User user = new User();
    user.setUsername("lisi2");
    user.setAge(10);
    return user;
    }

    @RequestMapping(value="/quick7")
    @ResponseBody
    public String save7() throws IOException {
    return" hello cast";
    }

    @RequestMapping(value="/quick6")
    public void save6(HttpServletResponse response ) throws IOException {
response.getWriter().print("hello itcast");
    }

    @RequestMapping(value="/quick5")
    public String save5(HttpServletRequest request){
        request.setAttribute("username","额文部");
        return "success";
    }

    @RequestMapping(value="/quick4")
    public String save4(Model model){
        model.addAttribute("username","博学谷");
        return "success";
    }

    @RequestMapping(value="/quick3")
    public ModelAndView save3(ModelAndView modelAndView){
        modelAndView.addObject("username","itheima");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping(value="/quick2")
    public ModelAndView save2(){
        /*
        * moxin
        * shitu*/
       ModelAndView modelAndView = new ModelAndView();
       modelAndView.addObject("username","itcast");
       modelAndView.setViewName("success");
       return modelAndView;
    }

    // 请求地址  http://localhost:8080/user/quick
    @RequestMapping(value="/quick",method = RequestMethod.GET,params = {"username"})
    public String save(){
        System.out.println("Controller save running....");
        return "success";
    }

}

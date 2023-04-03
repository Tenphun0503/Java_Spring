/**
 * UserController.java
 * Author: Ten Phun
 */
package demo.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 1. @Controller Define Bean
@Controller
public class UserController {
    // 2. Set Request URL
    // 3. Set Response type
    @RequestMapping("/save")
    @ResponseBody
    public String save(String name){
        System.out.println("springmvc save name ==> " + name);
        return "{'module' : 'springmvc save'}";
    }
    @RequestMapping("/update")
    @ResponseBody
    public String update(String name){
        System.out.println("springmvc update name ==> " + name);
        return "{'module' : 'springmvc update'}";
    }
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(String name){
        System.out.println("springmvc delete name ==> " + name);
        return "{'module' : 'springmvc delete'}";
    }
    @RequestMapping("/select")
    @ResponseBody
    public String select(String name){
        System.out.println("springmvc select name ==> " + name);
        return "{'module' : 'springmvc select'}";
    }
}

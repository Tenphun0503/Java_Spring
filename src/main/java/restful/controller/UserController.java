/**
 * UserController.java
 * Created on Apr 04, 2023, 12:24 AM
 * Author: Ten Phun
 */
package restful.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import restful.domain.User;

@Controller
public class UserController {
    @RequestMapping("/save")
    @ResponseBody
    public String save(@RequestBody User user){
        return "module: user save";
    }
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Integer id){
        return "module: user delete";
    }
    @RequestMapping("/update")
    @ResponseBody
    public String update(@RequestBody User user){
        return "module: user update";
    }
    @RequestMapping("/getById")
    @ResponseBody
    public String getById(Integer id){
        return "module: user getById";
    }
    @RequestMapping("/getByAll")
    @ResponseBody
    public String getByAll(){
        return "module: user getByAll";
    }
}

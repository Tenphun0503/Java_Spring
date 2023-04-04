/**
 * UserController.java
 * Created on Apr 04, 2023, 12:24 AM
 * Author: Ten Phun
 */
package restful.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import restful.domain.User;

@Controller
public class UserController {
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseBody
    public String save(@RequestBody User user){
        return "module: user save";
    }
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@PathVariable Integer id){
        return "module: user delete";
    }
    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    @ResponseBody
    public String update(@RequestBody User user){
        return "module: user update";
    }
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getById(@PathVariable Integer id){
        return "module: user getById";
    }
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public String getByAll(){
        return "module: user getAll";
    }
}

package com.controller;

import com.entity.SysUser;
import com.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class controller {
    @Autowired
    ISysUserService sysUserService;
    @GetMapping("/list")
    public  String list(Model model){
        List<SysUser> list = sysUserService.findAll();
        model.addAttribute("list",list);
        return "list";
    }
    @GetMapping("/add")
    public  String add(){

        return "admin-add";
    }
    @PostMapping("/save")
    @ResponseBody
    public  String save(SysUser user){
        user.setLoginName(user.getUserName());
        user.setLoginDate(new Date());
        sysUserService.save(user);
        return "admin-add";
    }
    @GetMapping("/edit")
    public  String edit(Long id,Model model){

        model.addAttribute("user",sysUserService.findById(id));
        return "admin-edit";
    }
    @PostMapping("/update")
    @ResponseBody
    public  String update(SysUser user,Model model){
        SysUser oldUser = sysUserService.findById(user.getUserId());
        oldUser.setLoginName(user.getUserName());
        oldUser.setUserName(user.getUserName());
        oldUser.setEmail(user.getEmail());
        oldUser.setPhonenumber(user.getPhonenumber());
        System.out.println(oldUser);
        sysUserService.update(oldUser);
        return "admin-edit";
    }
    @PostMapping("/delete")
    @ResponseBody
    public  String delete(Long id){
        System.out.println(id+"===============");
        sysUserService.delete(id);
        return "admin-add";
    }

}

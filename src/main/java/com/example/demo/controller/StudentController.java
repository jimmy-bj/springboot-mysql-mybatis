package com.example.demo.controller;

import com.example.demo.pojo.Student;
import com.example.demo.mapper.StudentMapper;
import net.minidev.json.JSONArray;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class StudentController {
    @Resource
    private StudentMapper stuMapper;
    @GetMapping
    public @ResponseBody String  findUser(@RequestParam(value = "id") Long id){
        Student stu = stuMapper.findById(id);
        System.out.println(stu);
        if(stu==null){
            return "the object is not found!";
        }else{
            List list = new ArrayList<Student>();
            list.add(stu);
            return JSONArray.toJSONString(list);
        }
    }

    @RequestMapping("/findAll")
    public Iterable<Student> findAll(){
        return stuMapper.findAll();
    }

    @RequestMapping("/save")
    public @ResponseBody String saveUser(@RequestParam(value="name") String name, @RequestParam(value="idNum") String idNum){
        Student stu = new Student();
        stu.setIdNum(idNum);
        stu.setName(name);
        int result = stuMapper.insertObj(stu);
        System.out.println("result===:"+result);
        return "insert success!";
    }

    @RequestMapping("/del")
    public @ResponseBody String saveUser(@RequestParam(value="id") Long id){
        int result = stuMapper.deleteObj(id);
        System.out.println("delete result===:"+result);
        return "delete "+id+" success!";
    }

    @RequestMapping("/update")
    public @ResponseBody String updateUser
            (@RequestParam(value="id") Long id,@RequestParam(value="name") String name, @RequestParam(value="idNum") String idNum){
        Student stu = new Student();

        if(id!=null && id>0){
            stu.setId(id);
            if(name!=null && name.trim().length()>0){
                stu.setName(name);
                System.out.println("1name==="+name+"|||idNum==="+idNum);
            }if(idNum!=null && idNum.trim().length()>0){
                stu.setIdNum(idNum);
                System.out.println("2name==="+name+"|||idNum==="+idNum);
            }
        }else{
           return "param is wrong!";
        }
        int result = stuMapper.updateObj(stu);
        System.out.println("updateObj result===:"+result);
        return "updateObj "+id+" success!";
    }

    @RequestMapping("/edit")
    public @ResponseBody String saveUser
            (@RequestParam(value="id") Long id,@RequestParam(value="name") String name, @RequestParam(value="idNum") String idNum){
        Student stu = new Student();
        System.out.println("name==="+name+"|||idNum==="+idNum);
        if(id!=null && id>0){
            stu.setId(id);
            if(name!=null){
                stu.setName(name);
            }if(idNum!=null){
                stu.setIdNum(idNum);
            }
        }else{
            return "param is wrong!";
        }
        int result = stuMapper.edit(stu);
        System.out.println("updateObj result===:"+result);
        return "updateObj "+id+" success!";
    }


}


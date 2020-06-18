package com.laibin.mapper;

import com.laibin.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {
    //获取老师
    List<Teacher> getTeachers();

    //获取指定老师下的所有学生及老师的信息
    Teacher getTeacher(int id);

    Teacher getTeacher2(int id);
}

package com.itzixi.mapper;

import com.itzixi.pojo.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherMapperCustom {

    public List<Teacher> getTeacherById(String tid);

}
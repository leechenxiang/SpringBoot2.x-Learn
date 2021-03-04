package com.itzixi.service;

import com.itzixi.pojo.Teacher;

import java.util.List;

public interface TeacherService {

    /**
     * 新增teacher
     * @param teacher
     */
    public void saveTeacher(Teacher teacher);

    /**
     * 根据主键id查询对象
     * @param id
     */
    public Teacher queryTeacherById(String id);

    /**
     * 根据条件查询对象的list
     * @param name
     * @param sex
     * @return
     */
    public List<Teacher> queryTeacherByCondition(String name, Integer age, String sex);

    /**
     * 根据条件进行分页查询
     * @param name
     * @param page
     * @param pageSize
     * @return
     */
    public List<Teacher> queryTeacherPaged(String name, Integer page, Integer pageSize);

    /**
     * 修改对象
     * @param teacher
     */
    public void updateTeacher(Teacher teacher);

    /**
     * 删除对象
     * @param teacher
     */
    public void deleteTeacher(Teacher teacher);

    /**
     * 测试事务
     */
    public void testTrans();

    /**
     * 自定义mapper中实现sql查询
     * @param id
     * @return
     */
    public List<Teacher> getTeacherByIdCustomSQL(String id);

}

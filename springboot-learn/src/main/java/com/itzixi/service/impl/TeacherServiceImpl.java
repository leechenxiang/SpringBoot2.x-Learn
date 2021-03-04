package com.itzixi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itzixi.mapper.TeacherMapper;
import com.itzixi.mapper.TeacherMapperCustom;
import com.itzixi.pojo.Teacher;
import com.itzixi.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private TeacherMapperCustom teacherMapperCustom;

    @Override
    public void saveTeacher(Teacher teacher) {
//        try {
//            Thread.sleep(3500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        teacherMapper.insert(teacher);
    }

    @Override
    public Teacher queryTeacherById(String id) {
        return teacherMapper.selectByPrimaryKey(id);
    }

//    @Override
//    public List<Teacher> queryTeacherByCondition(String name, Integer age, String sex) {
//
//        Example example = new Example(Teacher.class);
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andEqualTo("name", name);
//        criteria.andGreaterThanOrEqualTo("age", age);
//        criteria.andEqualTo("sex", sex);
//
//        List<Teacher> teacherList = teacherMapper.selectByExample(example);
//        return teacherList;
//    }

    @Override
    public List<Teacher> queryTeacherByCondition(String name, Integer age, String sex) {

        Teacher teacher = new Teacher();
        teacher.setName(name);
        teacher.setAge(age);
        teacher.setSex(sex);

        List<Teacher> teacherList = teacherMapper.select(teacher);
        return teacherList;
    }

    @Override
    public List<Teacher> queryTeacherPaged(String name, Integer page, Integer pageSize) {

        // 开始执行分页
        PageHelper.startPage(page, pageSize);

        Teacher teacher = new Teacher();
        teacher.setName(name);
        List<Teacher> teacherList = teacherMapper.select(teacher);

        // 分页信息对象
        PageInfo pageInfo = new PageInfo<>(teacherList);
        log.info(pageInfo.toString());

        return teacherList;
    }

    @Override
    public void updateTeacher(Teacher teacher) {
//        teacherMapper.updateByExample()
        teacherMapper.updateByPrimaryKey(teacher);
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        // 删除的三种方式
        // 1. 根据主键删除
//        teacherMapper.deleteByPrimaryKey(teacher.getId());

        // 2. 根据对象中所现有存在的属性值匹配作为条件删除
//        teacherMapper.delete(teacher);

        // 3. 根据构建的Example条件去删除
        Example example = new Example(Teacher.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andGreaterThanOrEqualTo("age", teacher.getAge());
        teacherMapper.deleteByExample(example);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void testTrans() {
        // 1. 新增数据
        // 2. 修改数据
        // 3. 模拟发生异常
        // 4. 观察1和2所发生的数据变动，有没有影响数据库(实际：不应该映射，事务应该不成功)
        // 5. 处理事务，实现事务的回滚，不让先前的数据入库

        String tid = UUID.randomUUID().toString();

        Teacher teacher = new Teacher();
        teacher.setId(tid);
        teacher.setName("trans");
        teacher.setAge(12);
        teacher.setSex("boy");

        teacherMapper.insert(teacher);

        int a = 1 / 0;

        Teacher teacherForUpdate = new Teacher();
        teacherForUpdate.setId("6cb13c4b-8138-4942-a5fc-ba83e86f8279");
        teacherForUpdate.setName("update");
        teacherMapper.updateByPrimaryKeySelective(teacherForUpdate);

    }

    @Override
    public List<Teacher> getTeacherByIdCustomSQL(String id) {
        return teacherMapperCustom.getTeacherById(id);
    }
}

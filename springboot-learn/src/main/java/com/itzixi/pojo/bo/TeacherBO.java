package com.itzixi.pojo.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.util.List;

@Data
@ToString
@AllArgsConstructor
public class TeacherBO {
    private String id;

    @NotBlank
    private String name;

    @NotNull
    private Integer age;

    @NotEmpty
    private String sex;

    @Min(value = 1, message = "老师任职年级最小为1年级")
    @Max(value = 6, message = "老师任职年级最大为6年级")
    private Integer grade;

    @Range(min = 1, max = 18, message = "老师班级区间为1~18班")
    private Integer classroom;

    @Size(min = 2, max = 5, message = "每个老师需要有2~5个技能")
    private List<String> skill;

    @Length(min = 3, max = 12, message = "每个老师英文名字长度的区间在3~12位之间")
    private String englishName;

    @Email(message = "老师的邮箱格式不正确")
    private String email;

}
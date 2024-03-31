package entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
/**
 * @author ：admin
 * @date ：Created in 2023/2/23 11:46
 * @description：学生类
 * @modified By：
 * @version:
 */

@Component
@ConfigurationProperties(prefix = "student")
public class Student {

    /**
     * 创建一些属性
     */
    private int age;
    private String name;
    private String message;

    /**
     * 无参构造器
     */
    public Student() {
    }

    /**
     * 有参构造器
     */
    public Student(int age, String name, String message) {
        this.age = age;
        this.name = name;
        this.message = message;
    }

    /**
     * get和set方法
     */
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

package config;

import entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import service.StudentService;
/**
 * @author ：admin
 * @date ：Created in 2023/2/23 12:27
 * @description：第一个自动配置类
 * @modified By：
 * @version:
 */
@org.springframework.context.annotation.Configuration
//如果满足条件，包含类StudentService
@ConditionalOnClass({StudentService.class})
//自动配置属性，实体类属性
@EnableConfigurationProperties(Student.class)
public class EricStartAutoConfig {
    @Autowired
    Student student;

    /**
     * @param
     * @return service.StudentService
     * @create by: admin
     * @description:  实例化StudentService的Bean
     * @create time: 2023/2/23 12:32
     */
    @Bean
    public StudentService studentService(){
        StudentService ss = new StudentService();
        ss.setStudent(student);
        return ss;
    }
}

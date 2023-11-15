package hello.core.beenfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBeen(){
        String[] beanDifinitionNames = ac.getBeanDefinitionNames();
        for (String beanDifinitionName : beanDifinitionNames) {
            Object been = ac.getBean(beanDifinitionName);
            System.out.println("name = " + beanDifinitionName + "Object = " + been);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBeen(){
        String[] beanDifinitionNames = ac.getBeanDefinitionNames();
        for (String beanDifinitionName : beanDifinitionNames) {
            BeanDefinition beanDefinition =  ac.getBeanDefinition(beanDifinitionName);

            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object been = ac.getBean(beanDifinitionName);
                System.out.println("name = " + beanDifinitionName + " Object = " + been);
            }

        }
    }
}

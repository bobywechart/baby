package com.wechat.baby;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement //开启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@SpringBootApplication
@MapperScan("com.wechat.baby.dao")
public class Application {

	/**
	 * 查看当前事务管理器
	 * HibernateTransactionManager
	 * DataSourceTransactionManager
	 * JtaTransactionManager
	 * JpaTransactionManager
	 * @author john
	 * @date 2017年7月10日
	 * @param platformTransactionManager
	 * @return
	 */
	/*@Bean
    public Object showTransactionManager(PlatformTransactionManager platformTransactionManager){
        System.out.println(">>>>>>>>>>" + platformTransactionManager.getClass().getName() + "<<<<<<<<<<");
        return new Object();
    }*/
	 
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

}

package adobe.com.prj;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration

@EnableTransactionManagement
public class AppConfig {
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource(); // pool of db connection commonpooldata srouce is more configurable
			ds.setDriverClassName("com.mysql.jdbc.Driver");
			ds.setUrl("jdbc:mysql://localhost:3306/adobe_trg_2019?createDatabaseIfNotExist=true");
			ds.setUsername("root");
			ds.setPassword("root"); //password set while installing mysql
		return ds;
	}
	//here i am creating a pool of db
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds) {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(ds);
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter()); //this line tells jpa that i am using hibernate and this needs to be updated in case of frmwrk chane
		emf.setPackagesToScan("adobe.com.prj.entity"); // all entities marked as @entity in this folder
		
		Properties props = new Properties();
		props.setProperty("hibernate.hbm2ddl.auto", "update"); //testing : create // production : update
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect"); // generate sql matching sql dialect
		emf.setJpaProperties(props);
		return emf;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager();
	}
}
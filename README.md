# jkwdm
spring boot接口项目

### 遇到的问题
* 打包部署到tomcat7，报错。原因org.springframework.boot版本选了2.0不匹配，改到1.4版本
* 扫描不到mapper，在启动类里加@MapperScan({"com.jmwdm.*.dao"})注解
* pagehepler插件不分页,网上查了好多，原因是spring boot中使用pagehepler, pom中引入jar包后。需要注入，见类MyBatisConfiguration
```java
@Configuration
public class MyBatisConfiguration {

	/**
     * 给mybatis注入分页插件
     * 防止mybatis分页插件不生效
     **/
    @Bean
    public Interceptor[] plugins() {
        return new Interceptor[]{new PageInterceptor()};
    }
}
```


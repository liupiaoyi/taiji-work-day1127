# taiji-work-day1127

day 11.27

提交：有.getignore readme文件，不要有bin
	  一个项目只有一个main函数就行。 不要用 new Application();

spring-start-web	  
@ConditionalOnClass(ObjectMapper.class) 如果有这个class存在，此装配才起作用

(web 应用中的类 Jackson2ObjectMapperBuilder.class)实体转json转http

项目OL(json)
	bean定义objectmapper
	定义pojo
 	main-> pojo转json json转pojo


	自动装配不支持静态属性。


mvn -Pnexus dependency:resolve
						source
						
@EnableConfigurationProperties(DataSourceProperties.class)
spring boot.pdf---->29.1配置数据库； page-->306

mvn -Pnexus dependency:tree         查看jar包以来关系  -Pdireck
mvn -Pnexus package -DskipTests     打包jar （跳过测试）


	CMD
			E:\Demo\workspace\cmd>java -jar target\cmd-0.0.1-SNAPSHOT.jar --abc=xyz --acb=123 -debug
			太极
			1.5.8.RELEASE

			Application Runner:
			acb->[123]
			abc->[xyz]

			CommandLine Runner:
			--abc=xyz
			--acb=123

						
查找bean的实现类			
		ApplicationContext context = SpringApplication.run(.class, args);
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
               System.out.print(name); System.out.print("->");
               Object bean = context.getBean(name);
               System.out.println(bean.getClass().getName());
        }
			
			

lambda --> interface的一个方法


读 14-21 章，72章
一个类如果不被包含在 package 的声明中，则它一般被认为是在“默认包”中。
因此最好不要用默认包，因为spring application启动时，@ComponentScan，@EntityScan或@SpringBootApplication注解的多个class，jar都要被读取，回产生矛盾。
通常将main application类放在根目录下，用@EnableAutoConfiguration注解主类。（它会默认搜索包）

可用@ComponentScan注释跟package，不需要指定basePackage属性。也可以用 @SpringBootApplication注解根包 下的主类。
		@Configuration
		@EnableAutoConfiguration
		@ComponentScan


建议配置文件 使用@Configuration class，并在其中定义main()
Enable*
@Import ： 不必将所有配置放在一个类上，可以使用@Import导入其他配置类；
		   或者用 @ComponentScan 自动扫描 spring 组件（包括配置类@Configuration）
			（@ImportResource 可以加载XML配置文件）

自动配置
	Spring Boot会根据添加的jar依赖 自动配置
	添加 @EnableAutoConfiguration或 @SpringBootApplication到配置类中(@Configuration)
		只能添加一个@EnableAutoConfiguration注释,建议添加到 主 配置类。
	可以添加自定义配置，来 替换 自动配置的默认的属性值
	(debug)控制台显示当前配置记录报告
	
	@EnableAutoConfiguration（exclude = {DataSourceAutoConfiguration.class}）禁用不需要的自动配置的类
	
@ComponentScan 查找bean， 常与@Autowired一起用。
	在跟包下的application使用后， (@Component，@Service，@Repository,@Controller等)自动生成bean
  如果bean 是一个构造函数，可以直接使用，不需要添加	@Autowired

@SpringBootApplication ： 
			相当于使用@Configuration， @EnableAutoConfiguration并@ComponentScan与他们的默认属性
			@SpringBootApplication根据@EnableAutoConfiguration and @ComponentScan 提供别名

HTTP服务器的最大优点之一： 将应用打包，容易去调试程序。不需要任何特殊的IDE插件或扩展
			导入mvn项目：Import...→Existing Maven Projects   from the File
	运行：①java -jar： For example: $ java -jar target/myproject-0.0.1-SNAPSHOT.jar
		  ②$ mvn spring-boot：run
		  ③$ gradle bootRun

Developer tools：spring-boot-devtools

PDF---->23.5-8  52
	一些时间发生在 ApplicationContext 产生之前，因此无法在@Bean 中注册listener。
	但是可以在SpringApplication.addListeners(...) or SpringApplicationBuilder.listeners(...)方法中注册
	
	如果想自动生成listener，可以在项目中添加 META-INF/spring.factories 文件。
	用org.springframework.context.ApplicationListener KEY影响listener
	org.springframework.context.ApplicationListener=com.example.project.MyListener

在工程中整合struts2.3.31和spring3.2.18的步骤

1、新建web工程

2、导入相关jar包
	>spring3.2.18的相关包(commons-logging.jar,spring-struts.jar)
	>struts2.3.31的相关包
	>struts2-spring-plugin-2.3.31.jar

3、 修改web.xml
	> ContextLoaderListener
	> contextConfigLocation
	> classpath:applicationContext.xml
	
	> StrutsPrepareAndExecuteFilter
	> /*
	
	> 中文乱码的过滤器

4、 创建Spring的主配置文件applicationContext.xml
	> 头文件从官方帮助文档
	创建struts2的主配置文件struts.xml
	> 从apps把主配置拷贝过来

5、 创建实体类(数据库表，前台页面)

6、 DAO层
	> 创建接口
	> 创建实现类
		~ 导入成员变量 private TxQueryRunner qr; getter/setter;
		~ 实现接口中所有方法
		~ 在主配置文件添加Bean,TxQueryRunner,StudentDaoImpl. bean id要唯一，class需要全限定名，property name用对应类的成员变量名，ref用对应的引用
		
7、 BIZ层
	> 编制接口
	> 编制实现类
		~ 导入成员变量 private IStudentDao sdao;getter/setter;
		~ 实现接口中所有方法
		~ 在主配置文件添加Bean,StudentBizImpl. bean id要唯一，class需要全限定名，property name用对应类的成员变量名，ref用对应的引用

8、 Action层
	> 创建一个Action类，继承自ActionSupport
	> 导入成员变量 private IStudentBiz sbiz; getter/setter;
	> 完成Action指定方法 
	
	> 在struts2主配置配置Action package name namespace extends action name class method result name type 
	> 在Spring主配置文件配置Bean  bean id class property 

9、 在JSP中展示



在工程中使用spring注解的步骤：

1、导入相关的jar包

2、修改主配置文件applicationContext.xml里面命名空间
	>添加叫context的命名空间（没加之前，alt+/是不能弹出<context:xxxx>）
	>跟context相关的5个内容：
		xmlns:context="http://www.springframework.org/schema/context"
		http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd
     >添加组件扫描：
     	<context:component-scan base-package="com"/>
     >添加bean
     	TxQueryRunner
     	
3、修改DAO的实现类
	>在类上添加注解@Repository
	>在类成员上添加注解@Resource(属性装配的问题：一般是先匹配变量名，再匹配变量类型)
	
4、修改BIZ的实现类
	>在类上添加注解@Service
	>在类成员上添加注解@Resource(属性装配的问题：一般是先匹配变量名，再匹配变量类型)
	
4、修改ACTION
	>在类上添加注解@Controller@Scope("prototype")，写在一行或者多行都可以
	>在类成员上添加注解@Resource(属性装配的问题：一般是先匹配变量名，再匹配变量类型)
	
	
	
在Spring框架中配置Druid数据库连接池并且Spring和DbUtils进行整合

1、在applicationContext.xml中配置数据源
	> <bean id="ds" class="xxxxx.DruidDataSource"> 驱动，url,用户名,密码	</bean>
	
2、自定义模板类QueryRunnerTemplate.java
	> 需要注入ds属性
	> 还要封装以前的DbUtils工具
	> query的两个方法，update的两个方法
	
3、在DAO层实现类中使用
	> StudentDaoImpl有一个成员变量 private QueryRunnerTemplate qr;
	> getter/setter方法
	> 在方法中使用即可	
	
	
	
	
	

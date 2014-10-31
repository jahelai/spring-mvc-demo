spring-mvc-demo
===============

###介绍
spring-verion更新到是4.1.2.REALEASE
此示例主要是围绕springmvc的特性,实现的多视图解析,不同视图,定位不同视图器解析,返回不同的数据格式.详细运行demo慢慢品祥.
也可参考 http://yidwo.iteye.com/blog/1884061

###部署
demo采用gradle做为jar包依赖管理. 为了您的运行不出错,建议你下载并配置gradle.这里是简单入门介绍 http://yidwo.iteye.com/blog/1848990

进入目录(spring-mvc-demo)下,如果您用eclipse开发,执行命令: gradle eclipe

用idea执行命令:gradle idea  都会自动下载jar包和生成eclipse的配置文件.

###运行
运行demo,执行命令:gradle jettyRun; 然后在地址栏上访问即可。
您也可以用命令:gradle war 生成war包,扔到tomcat等容器.

### ifarm 后台管理系统（持续更新中。。。。。。）
##### 简介
1. 工作之余整理了SpringBoot整个常用框架的模板库[framework](https://github.com/lhrimperial/framework)，
运用这个模板开发了一个基于粗粒度权限设计的管理后台[caiwei](https://github.com/lhrimperial/caiwei)，前端使用的是ExtJs。 
ExtJs属于比较重的前端框架，基于当下流行的几种前端框架，选择了Vue + ElementUI重新实现了一个后台管理系统前端[ifarm-console](https://github.com/lhrimperial/ifarm-console)。
权限管理选用了Shiro 权限管理框架，并且对权限进行了细粒度的设计，控制到按钮。 时间比较紧还有很多不完善和考虑不周全的地方，希望看到这份代码发现问题的可以给我留言，谢谢！

2. 测试地址（云服务器已到期。。。）
    - http://www.ifarmshop.com
        - admin/123
    - ~~http://www.ifarmshop.com/caiwei/index~~
        - 275688/123

3. 后端技术栈
    - SpringBoot
    - SpringMVC
    - MyBatis + MySQL
    - Redis
    - Shiro
    
4. 启动步骤
    1. 后端
        1. clone 源码
            - git clone https://github.com/lhrimperial/ifarm.git
            - git clone https://github.com/lhrimperial/framework.git
        2. mvn install -Dmaven.test.skip=true(framework先install)
        3. 新建MySQL数据库 ifarm-console, 执行脚本（ifarm-console.sql）
        4. 配置MySQL和Redis，application-dev.properties
        5. 启动 java -jar ifarm-console-exec.jar
        
    2. 前端
        1. git clone https://github.com/lhrimperial/ifarm-console.git
        2. npm install([搭建环境](https://github.com/lhrimperial/farm-console))
        3. npm run dev
   
5. 效果图
    - 用户管理
    ![Alt text](doc/用户管理.png)
    - 菜单管理
    ![Alt text](doc/菜单管理.png)
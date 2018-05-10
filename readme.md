### ifarm 后台管理系统（持续更新中。。。。。。）
##### 简介
1. ifarm 后台管理系统，采用前后端分离设计与开发，本工程为后端Java代码，前端[ifarm-console](https://github.com/lhrimperial/farm-console)采用Vue+ElementUI开发,

2. 后端技术栈
    - SpringBoot
    - SpringMVC
    - MyBatis + MySQL
    - Redis
    - Shiro
3. 项目中SpringBoot整合常用的后端框架的[framework](https://github.com/lhrimperial/framework), 采用Shiro作用权限管理框架，设计了细粒度的权限控制
4. 启动步骤（成本原因，暂时没有可供大家访问的资源。）
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
        2. npm install(搭建环境看前端的readme)
        3. npm run dev
5. 用户/密码：admin/123     
6. 效果图
    - 用户管理
    ![Alt text](doc/用户管理.png)
    - 菜单管理
    ![Alt text](doc/菜单管理.png)
#### docker-compose搭建springboot运行环境
1. 安装[docker-compose](https://yeasy.gitbook.io/docker_practice/compose/install)
2. 准备各个server的目录
    - /home/docker-compose/
        docker-compose.yml (详细配置见附录)
      /home/javaApp/
        Dockerfile
    - /data/mysql/
        /conf/my.cnf
        /data/
        /init/ifarm-console.sql
    - /data/nginx/
        /etc/nginx/nginx.conf
        /usr/share/nginx/html/dist/
    - /data/redis
        /conf/redis.conf
        /data

3. 附录
 - docker-compose.yml
 ```
    version: '3'
    
    services:
      ###################redis###########################
      redis:
        #镜像名称
        image: redis:latest
        #项目名称
        container_name: myredis
        ports:
          - 6379:6379
        command: redis-server /etc/redis/redis.conf
        volumes:
          - /etc/localtime:/etc/localtime:ro
          - /etc/hosts:/etc/hosts:ro
          - /data/redis/data:/data
          - /data/redis/conf/redis.conf:/etc/redis/redis.conf
    
      ###################nginx###########################
      nginx:
        image: nginx:latest
        container_name: nginx
        ports:
          - 80:80
          - 443:443
        volumes:
          - /etc/localtime:/etc/localtime:ro
          - /etc/hosts:/etc/hosts:ro
          - /data/nginx/etc/nginx//nginx.conf:/etc/nginx/nginx.conf
          - /data/nginx/usr/share/nginx/html:/usr/share/nginx/html
    
      ###################zookeeper###########################
      zoo1:
          image: zookeeper:latest
          container_name: myzoo1
          ports:
              - "2181:2181"
    
      ###################mysql###########################
      mysql:
        hostname: mysql
        image: mysql/mysql-server:5.7
        container_name: mysql-server # 指定容器名称，如果不设置此参数，则由系统自动生成
        environment:
          - TZ=Asia/Shanghai # 设置容器时区与宿主机保持一致
          - MYSQL_ROOT_PASSWORD=root # 设置root密码
        volumes:
           - /etc/localtime:/etc/localtime:ro # 设置容器时区与宿主机保持一致
           - "/data/mysql/data/:/var/lib/mysql"
           - "/data/mysql/conf/my.cnf:/etc/my.cnf"
           - "/data/mysql/init:/docker-entrypoint-initdb.d/"
        ports:
            - "3306:3306"
        healthcheck:
          test: ["CMD", "mysqladmin", "-uroot", "-p$MYSQL_ROOT_PASSWORD",  "ping", "-h", "localhost"]
          timeout: 5s
          retries: 10
    
    
      java:
          build: ./javaApp
          image: ifarm:test
          container_name: ifram
          ports:
              - "8080:8080"
          depends_on:
            - redis
            - zoo1
            - mysql
 ```
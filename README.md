# springboot-mysql-mybatis
springboot-demo-mysql-mybatis
这是一个springboot+mybatis+mysql的框架，包含对单表的增删改查:  
 
1.StudentMapper.java文件
在类名第一行要加@Mapper，否则此类无法注入到controller中。  
2.application.properties文件  
高版本mysql需要配置这个参数serverTimezone=GMT  
3.项目启动后的访问地址  
查看单条  
http://localhost:8080/user?id=${id}  
查看列表  
http://localhost:8080/user/findAll  
新增单条  
http://localhost:8080/user/save?name=特朗普&idNum=250  
修改单条  
http://localhost:8080/user/update?id=${id}&name=小特&idNum=  
删除单条  
http://localhost:8080/user/del?id=${id}  
【Powered by 硅谷课堂】
https://my.oschina.net/guiguketang   

# SpringBoot对jsp的支持

# 操作注意事项

如果出现下面的信息：

    “Whitelabel Error Page
    This application has no explicit mapping for /error, so you are seeing this as a fallback.
    
    Sat Sep 29 09:11:19 CST 2018
    There was an unexpected error (type=Not Found, status=404).
    /WEB-INF/jsp/index.jsp”
    
此时不是配置依赖的问题了，是IDEA的内置tomcat问题，这个时候需要使用IDEA插件的方式运行程序：
1.打开Maven Project,找到maven的依赖菜单
2.在Lifecycle,Plugins,Dependencies中选择Plugins
3.在Plugins中找到springboot
4.spring-boot:run双击运行或者右键(run maven build)
    

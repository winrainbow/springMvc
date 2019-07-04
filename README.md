# springMvc
springMvc 相关的demo
## 传统的文件上传方式
使用 commons-fileupload 库，按传统的方式上付文件时，需要注器在 xml文件中，不要配置文件解析器视图，否则下面代码中获取到的 filteItems 的size为0 ，因为文件解析器已经做过一次处理，执行fileUpload.parseRequest时，解析不出来了
DiskFileItemFactory factory = new DiskFileItemFactory();
ServletFileUpload fileUpload = new ServletFileUpload(factory);
List<FileItem> fileItems = fileUpload.parseRequest(request);
System.out.println("fileItems:"+fileItems.size());
  
  注释掉文件解析器：
  <!-- 文件解析器的名字必须是 multipartResolver-->
    <!--<bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
        <property name="maxUploadSize" value="20000000000"/>
    </bean>-->
## myBatis 调试
连接mysql数据库时，在xml中配置mysql数据库的Url时，需要注意加在 useSSL=false,以及时区相关的信息，并且注意 & 符号需要使用转义字符

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
        dd {
            font-size: 18px;
        }
    </style>
</head>
<body>
    <h2>Hello World!</h2>

    <a href="helloPage">open hello page</a><br>
    <a href="aboutUsPage">About Us</a><br>

    <hr><hr>
    <p style="font-size: 20px;">
    <b> Steps how to create Spring First WEB-MVC Program :- </b><br>
    <dl>
        <dd>1. Create MAVEN project (D:\Happy_Coding\Videos_lecture\Java create_servlet_project_with_maven.mp4 see this video for more details)</dd>
        <dd>2. Provide <i>"spring-webmvc"</i> dependency in pom.xml file</dd>
        <br>
        <dd>3. Configure <i>"DispatcherServlet"</i> class in web.xml file (present in src/main/webapp/WEB-INF/ folder) OR in java class file (create in src/main/java folder)
            <dl>
                <dd>-- in this program i add `servlet` and `servlet-mapping` tag in web.xml file</dd>
            </dl>
        </dd>
        <dd>4. Create <i>"Spring Configuration File"</i> (create myds-servlet.xml in WEB-INF folder and 'the context schema')</dd>
        <br>
        <dd>5. Configure the handler mapping class in spring configuration file
            <dl>
                <dd>-- HandlerMapping 'interface'</dd>
                <dd>-- BeanNameUrlHandlerMapping 'class'</dd>
                <dd>-- RequestHandlerMapping 'default class'</dd>
            </dl>
        </dd>
        <br>
        <dd>6. Create Controller in src/main/java folder
            <dl>
                <dd>-- Create Controller using @Controller annotation in MyController class</dd>
            </dl>
        </dd>
        <dd>7. Create handler methods in the Controller class </dd>
        <dd>8. Configure ViewResolver in spring configuration file
            <dl>
                <dd>-- ViewResolver 'interface'</dd>
                <dd>-- InternalResourceViewResolver 'default class'</dd>
            </dl>
        </dd>
        <dd>9. Create view page to be returned (/WEB-INF/views/----.jsp)</dd>
        <br>
        <dd>10. Scan the package (in which controller are created) in spring configuration file</dd>
    <dl>
    </p>
    <img style="width: 100%;border:3px solid red;"
                    src="spring_web-mvc_structure_img.png"
                    alt="Spring WEB-MVC Structure Image" />
</body>
</html>
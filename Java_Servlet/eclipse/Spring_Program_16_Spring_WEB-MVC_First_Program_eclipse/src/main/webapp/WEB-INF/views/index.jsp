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

body {
	font-family: Arial, sans-serif;
}

h1, h2, h3 {
	color: #333;
}

code {
	background-color: #f4f4f4;
	border-radius: 3px;
	padding: 0.2em 0.4em;
	font-size: 1.1em;
}

pre {
	background-color: #f4f4f4;
	padding: 1em;
	border-radius: 3px;
	overflow: auto;
}

a {
	color: #007bff;
	text-decoration: none;
}

a:hover {
	text-decoration: underline;
}

.columns {
	display: flex;
	flex-wrap: wrap;
	gap: 20px;
}

.column {
	flex: 1;
	min-width: 200px;
	box-shadow: 0 0 5px rgba(0, 0, 0, 0.6);
	padding: 10px;
	border-radius: 5px;
	overflow-wrap: break-word;
}
</style>
</head>
<body>
	<h2>Hello World!</h2>

	<a href="helloPage">open hello page</a>
	<br>
	<a href="aboutUsPage">About Us</a>
	<br>



	<h2 style="text-align: center;">Spring MVC Flow Explanation</h2>
	<div class="columns">
		<div class="column">
			<h3>1. Request Interception by DispatcherServlet:</h3>
			<ul>
				<li><strong>Web.xml:</strong>
					<ul>
						<li>જ્યારે તમે project run કરો છો અને URL <a
							href="http://localhost:8080/Spring_Program_16_Spring_WEB-MVC_First_Program_eclipse/">http://localhost:8080/Spring_Program_16_Spring_WEB-MVC_First_Program_eclipse/</a>
							ઍક્સેસ કરો છો, ત્યારે request <code>web.xml</code> માં configured
							DispatcherServlet (<code>myds</code>) intercept કરે છે.
						</li>
						<li><code>&lt;url-pattern&gt;/&lt;/url-pattern&gt;</code>
							means that this servlet will handle all incoming requests to the
							application.</li>
					</ul></li>
				<li><strong>Request Mapping:</strong>
					<ul>
						<li>DispatcherServlet request intercept કરે છે અને તેને
							Spring MVC framework માં process કરવા માટે dispatch કરે છે.</li>
					</ul></li>
			</ul>
		</div>
		<div class="column">
			<h3>2. Request Handling by Controller:</h3>
			<ul>
				<li><strong>MyController.java:</strong>
					<ul>
						<li>DispatcherServlet request URL ને match કરવા માટે
							controllers ને શોધે છે.</li>
						<li><code>@RequestMapping("/")</code> method <code>home()</code>
							execute થાય છે, જે <code>"index"</code> string return કરે છે.</li>
						<li>આ string view resolver માટે view name તરીકે serve થાય છે.</li>
					</ul></li>
			</ul>
		</div>
		<div class="column">
			<h3>3. View Resolution by InternalResourceViewResolver:</h3>
			<ul>
				<li><strong>myds-servlet.xml:</strong>
					<ul>
						<li>DispatcherServlet એ view resolver ને <code>"index"</code>
							string pass કરે છે, જે myds-servlet.xml માં defined
							InternalResourceViewResolver bean માં resolve થાય છે.
						</li>
						<li><strong>InternalResourceViewResolver:</strong> <pre>
&lt;bean class="org.springframework.web.servlet.view.InternalResourceViewResolver"&gt;
    &lt;property name="prefix" value="/WEB-INF/views/" /&gt;
    &lt;property name="suffix" value=".jsp" /&gt;
&lt;/bean&gt;
                    </pre></li>
						<li><strong>View Resolution:</strong>
							<ul>
								<li><code>"index"</code> string ને resolve કરવા માટે <code>prefix</code>
									અને <code>suffix</code> values ની મદદથી path generate થાય છે: <code>/WEB-INF/views/index.jsp</code>.</li>
							</ul></li>
					</ul></li>
			</ul>
		</div>
		<div class="column">
			<h3>4. Rendering the JSP:</h3>
			<ul>
				<li><strong>JSP File Rendering:</strong>
					<ul>
						<li>Spring framework resolved view (JSP file) <code>/WEB-INF/views/index.jsp</code>
							ને render કરે છે.
						</li>
						<li>Rendered JSP file નો response client (browser) ને serve
							થાય છે, જેથી તમે webpage (view) ને visualize કરી શકો.</li>
					</ul></li>
			</ul>
		</div>
	</div>



	<h2>તેવીજ રીતે Get method showing this "/helloPage" ત્યારે અથવા આ
		ફાઈલે માં આપેલી (નીચે છે તે) lick પર ક્લિક થાય ત્યારની પ્રોસેસ</h2>
	<pre>&lt;a href="helloPage"&gt;open hello page&lt;/a&gt;&lt;br&gt;</pre>
	<div class="columns">
		<div class="column">

			<h3>1. URL and Request Handling:</h3>
			<p>When you click on the link, it will direct you to the URL:</p>
			<code>http://localhost:8080/Spring_Program_16_Spring_WEB-MVC_First_Program_eclipse/helloPage</code>
		</div>
		<div class="column">
			<h3>2. DispatcherServlet:</h3>
			<p>
				The request to this URL will be intercepted by
				<code>DispatcherServlet</code>
				configured in
				<code>web.xml</code>
				:
			</p>
			<pre>
&lt;servlet&gt;
    &lt;servlet-name&gt;myds&lt;/servlet-name&gt;
    &lt;servlet-class&gt;org.springframework.web.servlet.DispatcherServlet&lt;/servlet-class&gt;
    &lt;load-on-startup&gt;1&lt;/load-on-startup&gt;
&lt;/servlet&gt;

&lt;servlet-mapping&gt;
    &lt;servlet-name&gt;myds&lt;/servlet-name&gt;
    &lt;url-pattern&gt;/&lt;/url-pattern&gt;
&lt;/servlet-mapping&gt;
    </pre>
		</div>
		<div class="column">
			<h3>3. Controller Method:</h3>
			<p>
				The request will be mapped to the following method in
				<code>MyController.java</code>
				:
			</p>
			<pre>
@RequestMapping(value = "/helloPage", method = RequestMethod.GET)
public ModelAndView openHelloPage() {
    System.out.println("openHelloPage() method executed. It means Opened Hello page...");
    ModelAndView mav = new ModelAndView();
    mav.setViewName("hello"); // This should match a JSP file like `hello.jsp`
    return mav; // Corresponds to hello.jsp
}
    </pre>
		</div>
		<div class="column">
			<h3>4. View Resolution:</h3>
			<p>
				The view name
				<code>"hello"</code>
				will be resolved to the JSP file:
			</p>
			<pre>/WEB-INF/views/hello.jsp</pre>

			<h3>5. Rendering the JSP:</h3>
			<p>
				The content of
				<code>hello.jsp</code>
				will be rendered and displayed in the browser.
			</p>
		</div>
	</div>



	<h2>તેવીજ રીતે Get method showing this "/index" ત્યારે અથવા આ
		ફાઈલે માં આપેલી (નીચે છે તે) lick પર ક્લિક થાય ત્યારની પ્રોસેસ</h2>
	<p>
		In your
		<code>hello.jsp</code>
		file, you might have a link like this: <span
			style="display: inline; font-family: monospace; background-color: #f4f4f4; border-radius: 3px; padding: 0.2em 0.4em; font-size: 1.1em;">
			&lt;a href="index"&gt;Back to Index Page&lt;/a&gt; </span>
	</p>
	<div class="columns">
		<div class="column">
			<h3>1. URL and Request Handling:</h3>
			<p>When you click on the link, it will direct you to the URL:</p>
			<code>http://localhost:8080/Spring_Program_16_Spring_WEB-MVC_First_Program_eclipse/index</code>
		</div>
		<div class="column">
			<h3>2. DispatcherServlet:</h3>
			<p>
				The request to this URL will be intercepted by the
				<code>DispatcherServlet</code>
				configured in
				<code>web.xml</code>
				:
			</p>
			<pre>
&lt;servlet&gt;
    &lt;servlet-name&gt;myds&lt;/servlet-name&gt;
    &lt;servlet-class&gt;org.springframework.web.servlet.DispatcherServlet&lt;/servlet-class&gt;
    &lt;load-on-startup&gt;1&lt;/load-on-startup&gt;
&lt;/servlet&gt;

&lt;servlet-mapping&gt;
    &lt;servlet-name&gt;myds&lt;/servlet-name&gt;
    &lt;url-pattern&gt;/&lt;/url-pattern&gt;
&lt;/servlet-mapping&gt;
    </pre>
		</div>
		<div class="column">
			<h3>3. Controller Method:</h3>
			<p>
				The request will be mapped to the following method in
				<code>MyController.java</code>
				:
			</p>
			<pre>
@RequestMapping("/")
public String home() {
    return "index"; // This should match a JSP file like `index.jsp`
}
    </pre>
		</div>
		<div class="column">
			<h3>4. View Resolution:</h3>
			<p>
				The view name
				<code>"index"</code>
				will be resolved to the JSP file:
			</p>
			<pre>/WEB-INF/views/index.jsp</pre>

			<h3>5. Rendering the JSP:</h3>
			<p>
				The content of
				<code>index.jsp</code>
				will be rendered and displayed in the browser when you click the
				link.
			</p>
		</div>
	</div>






	<p style="font-size: 20px;">
		<b> Steps how to create Spring First WEB-MVC Program :- </b><br>
	<dl>
		<dd>1. Create MAVEN project (D:\Happy_Coding\Videos_lecture\Java
			create_servlet_project_with_maven.mp4 see this video for more
			details)</dd>
		<dd>
			2. Provide <i>"spring-webmvc"</i> dependency in pom.xml file
		</dd>
		<br>
		<dd>
			3. Configure <i>"DispatcherServlet"</i> class in web.xml file
			(present in src/main/webapp/WEB-INF/ folder) OR in java class file
			(create in src/main/java folder)
			<dl>
				<dd>-- in this program i add `servlet` and `servlet-mapping`
					tag in web.xml file</dd>
			</dl>
		</dd>
		<dd>
			4. Create <i>"Spring Configuration File"</i> (create myds-servlet.xml
			in WEB-INF folder and 'the context schema')
		</dd>
		<br>
		<dd>
			5. Configure the handler mapping class in spring configuration file
			<dl>
				<dd>-- HandlerMapping 'interface'</dd>
				<dd>-- BeanNameUrlHandlerMapping 'class'</dd>
				<dd>-- RequestHandlerMapping 'default class'</dd>
			</dl>
		</dd>
		<br>
		<dd>
			6. Create Controller in src/main/java folder
			<dl>
				<dd>-- Create Controller using @Controller annotation in
					MyController class</dd>
			</dl>
		</dd>
		<dd>7. Create handler methods in the Controller class</dd>
		<dd>
			8. Configure ViewResolver in spring configuration file
			<dl>
				<dd>-- ViewResolver 'interface'</dd>
				<dd>-- InternalResourceViewResolver 'default class'</dd>
			</dl>
		</dd>
		<dd>9. Create view page to be returned (/WEB-INF/views/----.jsp)</dd>
		<br>
		<dd>10. Scan the package (in which controller are created) in
			spring configuration file</dd>
		<dl>
			</p>
			<img style="width: 100%; border: 3px solid red;"
				src="spring_web-mvc_structure_img.png"
				alt="Spring WEB-MVC Structure Image" />
</body>
</html>
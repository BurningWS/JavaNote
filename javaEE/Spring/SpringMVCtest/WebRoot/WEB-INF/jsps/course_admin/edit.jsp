<%@ page language="java" 
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>鎴戜笉鏄湡姝ｇ殑鎱曡缃?/title>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/main.css"
	type="text/css" />
</head>
<body>
	<div id="main">
		<div class="newcontainer" id="course_intro">
		  <form name="mainForm" action="<%= request.getContextPath()%>/courses/save" method="post">
		    <div>
		       <span>璇剧▼鍚岖О:</span><input type="text" id="title" name="title">
		    </div>
		    <div>
		       <span>璇剧▼镞堕昵:</span><input type="text" id="duration" name="duration"> 绉?
		    </div> 
		    <div>
		       <span>璇剧▼闅惧害:</span>
		       <select id="level" name="level">
                  <option value="0">鍒濈骇</option>
                  <option value="1" selected="selected">涓骇</option>
                  <option value="2">楂樼骇</option>
                </select>
		    </div> 
		    <div>
		       <span>璇剧▼浠嬬粛:</span>
		       <textarea id="descr" name="descr" rows="5" style="width:480px"></textarea>
		    </div> 
		    <div>
		       <input type="submit" id="btnPass" value="鎻愪氦" />
		    </div> 
		  </form>
		</div>
	</div>
</body>
</html>
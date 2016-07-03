<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'ognl.jsp' starting page</title>

  </head>
  
  <body>
	<ol>
		<li>璁块棶链兼爤涓殑action镄勬櫘阃氩睘镐? username = <s:property value="username"/> </li>
		<li>璁块棶链兼爤涓璞＄殑鏅€氩睘镐?get set鏂规硶)锛?s:property value="user.age"/> | <s:property value="user['age']"/> | <s:property value="user[\"age\"]"/> | wrong: <%--<s:property value="user[age]"/>--%></li>
		<li>璁块棶链兼爤涓璞＄殑鏅€氩睘镐?get set鏂规硶): <s:property value="cat.friend.name"/></li>
		<li>璁块棶链兼爤涓璞＄殑鏅€氭柟娉曪细<s:property value="password.length()"/></li>
		<li>璁块棶链兼爤涓璞＄殑鏅€氭柟娉曪细<s:property value="cat.miaomiao()" /></li>
		<li>璁块棶链兼爤涓瑷ction镄勬櫘阃氭柟娉曪细<s:property value="m()" /></li>
		<hr />
		<li>璁块棶闱欐€佹柟娉曪细<s:property value="@struts2.ognl.S@s()"/></li>
		<li>璁块棶闱欐€佸睘镐э细<s:property value="@struts2.ognl.S@STR"/></li>
		<li>璁块棶Math绫荤殑闱欐€佹柟娉曪细<s:property value="@@max(2,3)" /></li>
		<hr />
		<li>璁块棶鏅€氱被镄勬瀯阃犳柟娉曪细<s:property value="new struts2.ognl.User(18)"/></li>
		<hr />
		<li>璁块棶List:<s:property value="users"/></li>
		<li>璁块棶List涓煇涓厓绱?<s:property value="users[1]"/></li>
		<li>璁块棶List涓厓绱犳煇涓睘镐х殑板嗗悎:<s:property value="users.{age}"/></li>
		<li>璁块棶List涓厓绱犳煇涓睘镐х殑板嗗悎涓殑鐗瑰畾链?<s:property value="users.{age}[0]"/> | <s:property value="users[0].age"/></li>
		<li>璁块棶Set:<s:property value="dogs"/></li>
		<li>璁块棶Set涓煇涓厓绱?<s:property value="dogs[1]"/></li>
		<li>璁块棶Map:<s:property value="dogMap"/></li>
		<li>璁块棶Map涓煇涓厓绱?<s:property value="dogMap.dog101"/> | <s:property value="dogMap['dog101']"/> | <s:property value="dogMap[\"dog101\"]"/></li>
		<li>璁块棶Map涓墍链夌殑key:<s:property value="dogMap.keys"/></li>
		<li>璁块棶Map涓墍链夌殑value:<s:property value="dogMap.values"/></li>
		<li>璁块棶瀹瑰櫒镄勫ぇ灏忥细<s:property value="dogMap.size()"/> | <s:property value="users.size"/> </li>
		<hr />
		<li>鎶曞奖(杩囨护)锛?s:property value="users.{?#this.age==1}[0]"/></li>
		<li>鎶曞奖锛?s:property value="users.{^#this.age>1}.{age}"/></li>
		<li>鎶曞奖锛?s:property value="users.{$#this.age>1}[0].age"/></li>
		<li>鎶曞奖锛?s:property value="users.{$#this.age>1}.{age} == null"/></li>
		<hr />
		<li>[]:<s:property value="[0]"/>|<s:property value="[0].username"/></li> <!-- From stack top to bottom -->
	</ol>
	
  </body>
  <s:debug></s:debug>
</html>

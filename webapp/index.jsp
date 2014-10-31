<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring MVC多种视图解析实例 </title>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	function ajaxJson() {
		$.ajax({
		    url: 'do/sample.json',
		    type: 'GET',
		    dataType: 'json',
		    data: {
		    	status: true,
		    	info: encodeURI($("#idText").text())
		    },
		    timeout: 1000,
		    error: function(xmlReq, errInfo, errors){
		        alert(errors + "    " + xmlReq.responseText);
		    },
		    success: function(jd){
		    	$("#jsonData").text("json data status: " + jd.testModel.status 
		    			+ "  info: " + decodeURI(jd.testModel.info));
		    }
		});
	}
	function ajaxXml() {
		$.ajax({
		    url: 'do/sample.xml',
		    type: 'GET',
		    dataType: 'xml',
		    timeout: 1000,
		    error: function(xmlReq, errInfo, errors){
		        alert(errInfo + "    " + errors);
		    },
		    success: function(xd){
		    	$("#xmlData").text("xml data :" + xd.getElementsByTagName("info")[0].firstChild.nodeValue);
		    }
		});
	}
</script>
</head>
<body>
    <div>
    	<h3>JSON</h3>
		<a href="do/sample">请求josn数据 do/sample</a> <br/><br/>
		<a href="do/mapJson">请求Map结构的josn数据 do/mapJson</a> <br/><br/>
		<a href="javascript:ajaxJson();">ajax请求josn数据 do/sample.json</a>&nbsp;&nbsp;&nbsp;
			<span id="jsonData"></span><br/><br/>
		<h3>JSP Freemarker</h3>
		<a href="do/sample.html">前往jsp页面 do/sample.html</a><br/><br/>
		<a href="do/getftl.html">前往ftl页面 do/getftl.html</a><br/><br/>
		<a href="do/nofoundPage.html">前往不存在页面</a><br/><br/>
		<h3>XML</h3>
		<a href="do/sample.xml">请求xml数据 do/sample.xml</a><br/><br/>
		<a href="javascript:ajaxXml();">ajax请求xml数据 do/sample.xml</a>&nbsp;&nbsp;&nbsp;
			<span id="xmlData"></span><br/><br/>
    </div>
    <div style="display:none">
    <span id="idText">我从客户端来，跑了趟服务端，现在回来了.</span>
    <input id="idTP" value="这是中文，传到服务器后返回。"/>
    </div>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 静态包含 base标签、css样式、jQuery文件 --%>
<%@ include file="/pages/common/header.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
</style>

		<div id="header">
				<img class="logo_img" alt="" src="static/img/logo.gif" >
				<span class="wel_word"></span>
				<div>
					<span>欢迎<span class="um_span">韩总</span>光临</span>
					<a href="../order/order.jsp">我的订单</a>
					<a href="../../index.jsp">注销</a>&nbsp;&nbsp;
					<a href="../../index.jsp">返回</a>
				</div>
		</div>
		
		<div id="main">
		
			<h1>注册成功! <a href="./index.jsp">转到主页</a></h1>
	
		</div>
		
		<div id="bottom">
			<span>
				ABC.Copyright &copy;2015
			</span>
		</div>
<%@ include file="/pages/common/footer.jsp"%>
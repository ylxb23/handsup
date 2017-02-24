<%@ page language="java" pageEncoding="UTF-8" %>

<!-- js lib -->
<script type="text/javascript" src="<%=request.getContextPath() %>/libs/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/libs/underscore.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/libs/angular/angular.min.js"></script>

<!-- css lib --> 
<link href="<%=request.getContextPath() %>/libs/semanticui/semantic.min.css" rel="stylesheet"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/libs/semanticui/semantic.min.js"></script>

<%-- 
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/common/vipui.min.css" />
--%>

<!-- 项目css样式, 置于所有 css 样式库下面 -->
<link href="<%=request.getContextPath() %>/css/main.css" rel="stylesheet"/>


<!-- 置于最下面 -->
<script type="text/javascript" src="<%=request.getContextPath() %>/libs/require-2.3.2.min.js" data-main="<%=request.getContextPath() %>/js/require.config.js"></script>
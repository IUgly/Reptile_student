<%@ page language="java" import="java.util.*,beans.Profit"
         contentType="text/html; charset=utf-8"%>
<%@ page import="servlet.ShowReport" %>
<%@ page import="jdbc.Jdbc" %>
<%@ page import="service.Service" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://"
          + request.getServerName() + ":" + request.getServerPort()
          + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <base href="<%=basePath%>">

  <title>Java环境生成报表</title>
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">

  <style type="text/css">
    table.hovertable {
      font-family: 黑体;
      font-size: 13px;
      color: #333333;
      border-width: 1px;
      border-color: #999999;
      border-collapse: collapse;
    }

    table.hovertable th {
      background-color: #c3dde0;
      border-width: 1px;
      padding: 8px;
      border-style: solid;
      border-color: #a9c6c9;
    }

    table.hovertable tr {
      background-color: #d4e3e5;
    }

    table.hovertable td {
      border-width: 1px;
      padding: 8px;
      border-style: solid;
      border-color: #a9c6c9;
    }
  </style>
</head>

<body>
<form action="ShowReport" method="post">
  <input type="submit" value="生成表单">
</form>
<table class="hovertable">
  <tr>
    <th colspan="5">手机信息表</th>
  </tr>
  <tr>
    <th>序号</th>
    <th>品牌</th>
    <th>成本价</th>
    <th>销售价</th>
    <th>厂商</th>
  </tr>
  <%
    ArrayList list = null;
    //session为JSP内置对象
    if (session.getAttribute("phone") != null) {
      list = (ArrayList) session.getAttribute("phone");
      if (list.size() > 0) {
          int temp=0;
          int temp1=0;
          int temp2=0;
          int temp3=0;
        Profit pf;
        for (int i = 0; i < list.size(); i++) {
          pf = new Profit();
          pf = (Profit) list.get(i);
  %>
  <tr onmouseover="this.style.backgroundColor='#ffff66'"
      onmouseout="this.style.backgroundColor='#d4e3e5'">
    <td><%=pf.getId()%></td>
    <td><%=pf.getName()%></td>
    <td><%=pf.getCostPrice()%></td>
    <td><%=pf.getSellPrice()%></td>
    <td><%=pf.getManufacturer()%></td>
  </tr>

  <%
        }
      }
    }
  %>
</table>
</body>
</html>
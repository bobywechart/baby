<%@ page contentType="text/html; charset=utf-8" %>
<%@ page language="java" pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%	  
	  request.setCharacterEncoding("GBK");
	  StringBuffer sbXml = new StringBuffer();
	  sbXml.append("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n");
	  sbXml.append("<love>\n");
	  sbXml.append("\t<header>\n");
	  sbXml.append("\t\t<request_type>CgYeepayCashReceiveReq</request_type>\n");
	  sbXml.append("\t</header>\n");
	  sbXml.append("\t<body>\n");
	  Enumeration e = request.getParameterNames();
	  while (e.hasMoreElements()) {
		//得到参数名
		String name = (String) e.nextElement();
		//得到这个参数的所有值
		String value = request.getParameter(name);
		//输出参数名
		sbXml.append("\t\t<" + name + ">" + value + "</" + name+ ">\n");
	  }
	  sbXml.append("\t</body>\n");
	  sbXml.append("</love>\n");
	  System.out.println("callback.jsp.........................\n"+sbXml.toString());
 %>

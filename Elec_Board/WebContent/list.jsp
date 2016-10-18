<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="css/style.css">

<table align="center" border="0" cellpadding="5" cellspacing="2" width="100%" bordercolordark="white" bordercolorlight="black">
<caption>상품 LIST</caption>
	<colgroup>
		<col width="15%"/>
		<col width="30%"/>
		<col width="16%"/>
		<col width="16%"/>
		<col width="7%"/>
		<col width="7%"/>
		<col width="7%"/>
	</colgroup>
	<tr>
        <td bgcolor="#00cc00">
            <p align="center">
            <font color="white"><b><span style="font-size:9pt;">모델번호</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">모델이름</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">가격</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">날짜</span></b></font></p>
        </td>
        
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">첨부파일</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">파일용량</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">조 회 수</span></b></font></p>
        </td>
    </tr>
    
    <c:forEach items="${list}" var="elec" varStatus="state">
	<tr>
		<td>${elec.modelNum}</td>
  		<td><a href="elec?command=detail&modelNum=${elec.modelNum}">${elec.modelName}</a></td>
  		<td>${elec.price}</td>
  		<td>${elec.writeday}</td>
  		<td>${elec.fName}</td>
  		<td>${elec.fSize}</td>
  		<td>${elec.readnum}</td>
    </tr>
 </c:forEach> 
    
</table>
<hr>
<div align=right>
<span style="font-size:9pt;">&lt;<a href="write.html">글쓰기</a>&gt;</span></div>


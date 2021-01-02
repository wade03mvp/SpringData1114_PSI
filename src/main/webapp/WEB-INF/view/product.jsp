<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html>
    <head>
        <!-- Head -->
        <%@include file="include/header.jspf"  %>
    </head>
    <body style="padding: 10px">

        <div id="layout">
            <!-- Toggle -->
            <%@include file="include/toggle.jspf"  %>

            <!-- Menu -->
            <%@include file="include/menu.jspf"  %>

            <div id="main">
                
                <div class="header">
                    <h1>Product</h1>
                    <h2>CRUD</h2>
                </div>
                
                <table class="pure-table" style="border: none">
                    <td valign="top">
                        <!-- 表單 -->
                        <form:form class="pure-form"
                                   modelAttribute="product"
                                   method="post"
                                   action="${pageContext.request.contextPath}/mvc/psi/product">
                            <fieldset>
                                <legend>Product Form</legend>
                                <form:input path="id" readonly="true" /><p />
                                商品名稱 : <br />
                                <form:input path="name" /><p />
                                商品圖片 : <br />
                                <form:input path="image" readonly="true" /><p />
                                <input type="file" id="myfile" name="myfile" /><p />
                                <button type="submit" class="pure-button pure-button-primary">Submit</button>
                            </fieldset>
                            
                        </form:form>
                    </td>
                    <td valign="top">
                        <!-- 資料列表 -->
                    </td>
                </table>
                
                
                
            </div>
        </div>
        <!-- Foot -->
        <%@include file="include/footer.jspf"  %>
    </body>
</html>
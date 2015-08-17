<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="pageTitle" scope="request" value="漂流阅读－用户"/>
<%@ include file="../header.jsp" %>

<div class="container">
    <div class="page_header">
        <h3>图书列表</h3>
        <h3><a href='/awesome-spring/users/${userid}/books/new'>添加</a></h3>
    </div>
    <table class="table table-striped">
        <thead>
            <tr>
                <th>title</th>
                <th>summary</th>
                <th>image</th>
                <th>author</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.title}</td>
                <td>${book.summary}</td>
                <td>${book.image}</td>
                <td>${book.author}</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<%@ include file="../footer.jsp" %>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="pageTitle" scope="request" value="漂流阅读－用户"/>
<%@ include file="../header.jsp" %>

<div class="container">
    <div class="page_header">
        <h3>添加图书</h3>
    </div>
    <form method="post" action="/awesome-spring/users/${book.userId}/books">
      <div class="form-group">
        <label for="title">title</label>
        <input type="text" class="form-control" id="title" placeholder="title" name="title">
      </div>
      <div class="form-group">
        <label for="summary">summary</label>
        <input type="text" class="form-control" id="summary" placeholder="summary" name="summary">
      </div>
      <div class="form-group">
        <label for="image">image</label>
        <input type="text" class="form-control" id="image" placeholder="image" name="image">
      </div>
      <div class="form-group">
        <label for="author">author</label>
        <input type="text" class="form-control" id="author" placeholder="author" name="author">
      </div>

      <button type="submit" class="btn btn-default">Submit</button>
    </form>
</div>

<%@ include file="../footer.jsp" %>
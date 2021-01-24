<%@ page language="java" contentType="text/html; ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Berat Badan Form</title>
    <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
    <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
<div class="container">
    <spring:url value="/beratBadan" var="addURL"/>
    <h2>Tambah Data Berat Badan</h2>
    <form:form modelAttribute="beratBadanForm" method="post" action="${addURL}" cssClass="form">
        <form:hidden path="id"/>
        <div class="form-group">
            <label>Tanggal</label>
            <form:input path="tanggal" cssClass="date-picker" id="tanggal"/>
        </div>
        <div class="form-group">
            <label>Max</label>
            <form:input path="max" cssClass="form-control" id="max"/>
        </div>
        <div>
            <label>Min</label>
            <form:input path="min" cssClass="form-control" id="min"/>
        </div>
        <div>
            <label>Perbedaan</label>
            <form:input path="perbedaan" cssClass="form-control" id="perbedaan"/>
        </div>
        <button type="submit" class="btn btn-success">Tambahkan</button>
    </form:form>
</div>
</body>
</html>
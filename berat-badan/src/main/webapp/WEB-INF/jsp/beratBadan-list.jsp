<%@ page language="java" contentType="text/html; ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Berat Badan List</title>
    <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
    <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
<div class="container">
    <spring:url value="/beratBadan/add" var="addURL"/>
    <a class="fas fa-plus-square" href="${addURL}" role="button"></a>
    <table class="table table-striped">
        <thead class="thead-green">
        <th scope="row">Tanggal</th>
        <th scope="row">Max</th>
        <th scope="row">Min</th>
        <th scope="row">Perbedaan</th>
        </thead>
        <tbody>
        <c:forEach items="${beratBadanList}" var="beratBadan">
            <tr>
                <td>${beratBadan.tanggal}</td>
                <td>${beratBadan.max}</td>
                <td>${beratBadan.min}</td>
                <td>${beratBadan.perbedaan}</td>
                <td>
                    <spring:url value"/beratBadan/detail/${beratBadan.id}" var="detailURL"/>
                    <a class="far fa-eye" href="${detailURL}" role="button"></a>
                </td>
            </tr>
        </c:forEach>
            <tr>
                <td>Rata-rata</td>
                <td>${averageMax}</td>
                <td>${averageMin}</td>
                <td>${averagePerbedaan}</td>
            </tr>
        </tbody>
    </table>
</div>
</body>
</html>
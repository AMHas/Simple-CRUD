<%@ page language="java" contentType="text/html; ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Berat Badan Detail</title>
    <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
    <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
<div class="container">
    <h2>Berat Badan Detail</h2>
    <table class="table table-striped">
        <thead class="thead-green">
        <th scope="row">Tanggal</th>
        <th scope="row">${beratBadanDetail.tanggal}</th>
        </thead>
        <tbody>
        <tr>
            <td>Max</td>
            <td>${beratBadanDetail.max}</td>
        </tr>
        <tr>
            <td>Min</td>
            <td>${beratBadanDetail.min}</td>
        </tr>
        <tr>
            <td>Perbedaan</td>
            <td>${beratBedanDetail.perbedaan}</td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
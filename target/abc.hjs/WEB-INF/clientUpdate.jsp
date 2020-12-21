<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="data-entry.css"></link>
</head>
<body>

<jsp:include page="../menu.jsp"/>
<h2>Client Form</h2>
<p>Resize the browser window to see the effect. When the screen is less than 600px wide,
   make the two columns stack on top of each other instead of next to each other.</p>


<div class="container">
  <form action="client.update">
  
   <div class="row">
    <div class="col-25">
      <label for="clientId">Client Id</label>
    </div>
    <div class="col-75">
   	 <input readonly="readonly" type="text" id="clientId" 
   	 name="clientId" 
   	 value="${client.clientId}">
    </div>
  </div>
  
  <div class="row">
    <div class="col-25">
      <label for="fname">First Name</label>
    </div>
    <div class="col-75">
      <input readonly="readonly" type="text" id="fname" 
      name="firstname" 
      value="${client.firstName}">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="lname">Last Name</label>
    </div>
    <div class="col-75">
      <input readonly="readonly" type="text" id="lname" 
      name="lastname" 
      value="${client.lastName}">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="salary">Salary</label>
    </div>
    <div class="col-75">
      <input type="text" id="salary" 
      name="salary" 
      value="${client.currentSalary}">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="country">Status</label>
    </div>
    <div class="col-75">
      <select id="status" name="status" value="${client.status}">
      	<option value="N/A">Not Available</option>
        <option value="MFJ">Married Filing Jointly</option>
        <option value="S">Single</option>
        <option value="HH">Head of House Hold</option>
        <option value="MFS">Married Filing Single</option>
      </select>
    </div>
  </div>
  <div class="row">
    <div class="col-75">
      <textarea id="subject" name="subject" placeholder="Write something.." style="height:200px"></textarea>
    </div>
  </div>
  <div class="row">
    <input readonly="readonly" type="submit" value="delete">
    <input readonly="readonly" type="submit" value="update">
  </div>
  </form>
</div>
<script type="text/javascript">document.getElementById("status").value="${client.status}"</script>
</body>
</html>

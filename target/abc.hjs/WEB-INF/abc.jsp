
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>    
    <title>ABC-Counter [Dynamic]</title>
    <link rel="stylesheet" href="format.css"></link>
</head>
<body> 
  <jsp:include page="../menu.jsp"/>
  <div class="divBody">
    <h1>ABC Counter [Dynamic]</h1>    
    
    <form action="abc">
    	<label>Display Mode: </label>
    	<select name="displaymode" id="displaymode">
    		<option value ="abc" selected>all</option>
    		<option value ="vow">vowels</option>
    		<option value ="con">consonant</option>
    	</select>
    	
    	<input type="submit" value="build abc"/>
    </form>
    <hr />    
   
    	<c:forEach items="${abc}" var="row" >
    		<div class='divScenario ${row.highlight}'>
	             <span class="uletter">${row.upperCase}</span>
	             <span class="number">${row.number}</span>
	             <span class="lletter">${row.lowerCase}</span>
	       </div>
    	</c:forEach> 
    	<br/>
    	Author is: ${author}
  </div>
  <script type="text/javascript">
  		document.getElementById("displaymode").value = "${displaymode}"
  </script>       
</body>
</html>
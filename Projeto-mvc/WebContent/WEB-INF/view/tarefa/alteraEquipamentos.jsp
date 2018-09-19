<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum"%>
		
	<link href="resources/css/jquery-ui.css" rel="stylesheet">
	<script src="resources/js/jquery.js"></script>
	<script src="resources/js/jquery-ui.js"></script>
  </head>
  <body>
      <h3>Alterar Equipamento - ${equipamento.id}</h3>
      <form action="alterarEquipamento" method="post">
        <input type="hidden" name="id" value="${equipamento.id}" />
		Nome:            <input type="text" name="name"  value="${equipamento.name}"  /><br /> 
		Local:           <input type="text" name="local" value="${equipamento.local}" /><br />
		Data Adquirido:  <input type="text" id="adquirido" name="adquirido" value="<fmt:formatDate value="${equipamento.adquirido.time}" pattern="dd/MM/yyyy" />"/><br />               
	  <script>
	  $( function() {
	    $( "#adquirido" ).datepicker({dateFormat:'dd/mm/yy'});
	  } );
	  </script>
          <input type="submit" value="Alterar"/>
      </form>
  </body>
</html>
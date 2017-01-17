<!DOCTYPE html>
 <%@page import="java.util.ArrayList"%> 
 <%@page import="java.util.List"%> 
<%@page import="entidades.Ambiente"%>
  
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Criar Contrato</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <link rel="stylesheet" href="b3/bootstrap3.css" media="screen">
    <link rel="stylesheet" href="b3/custom.min.css">
    <link rel="stylesheet" href="b3/dropdownTemplate.css">
    
    <script src="b3/sweetalert2/sweetalert2.min.js"></script>
	<link rel="stylesheet" href="b3/sweetalert2/sweetalert2.min.css">

    <script>

     var _gaq = _gaq || [];
      _gaq.push(['_setAccount', 'UA-23019901-1']);
      _gaq.push(['_setDomainName', "bootswatch.com"]);
        _gaq.push(['_setAllowLinker', true]);
      _gaq.push(['_trackPageview']);

     (function() {
       var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
       ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
       var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
     })();

    </script>
  </head>


  <body>
    <div class="navbar navbar-default navbar-fixed-top">
      <%@ include file = "cabecalho.jsp" %>
    </div>
 
    <div class="container" >
        <div class="row">
          <div class="">    
            <div class="well">
             
                <fieldset>
                  <center><legend>Contrato</legend></center>
             
                   <%
					float valor = (Float)request.getAttribute("valorC");
					int prazo = (Integer)request.getAttribute("prazoC");
					List<Ambiente> listaA = (List)request.getAttribute("listaAmbiente");
                   
                   
					out.println("<div class='row'><div class=\"col-lg-12\"><fieldset><legend>Valor: </legend>"+valor+"</fieldset></div></div><br>");					
					out.println("<div class='row'><div class=\"col-lg-12\"><fieldset><legend>Prazo: </legend>"+prazo+"</fieldset></div></div><br>");	
					out.println("<div class='row'><div class=\"col-lg-12\"><fieldset><legend>Ambientes</legend><table class=\"table table-striped table-hover\">");
					out.println("<thead><tr><td><b>#</b></td><td><b>paredes</b></td> <td><b>portas</b></td><td><b>metragem</b></td><td><b>custo</b></td><td><b>Entrega (semanas)</b></td></tr>");
					out.println(" </thead><tbody>");
					int contador =1;
					for(Ambiente a : listaA){
						out.println("<tr>");
						out.print("<td>"+contador+"</td>");
						out.print("<td>"+a.getNumParedes()+"</td>");
						out.print("<td>"+a.getNumPortas()+"</td>");
						out.print("<td>"+a.getMetragem()+"</td>");
						out.print("<td>"+a.getCustoTotal()+"</td>");
						out.print("<td>"+a.getTempoTotalPorAmbiente()+"</td>");
						out.println("</tr>");
						contador += 1 ;
					}
					
					out.println(" </tbody></table></fieldset></div></div> ");
                   %>
              
                  
                  <center><a href="formPrincipal.jsp" class="btn btn-primary">In�cio</a></center>
                </fieldset>
       
            </div>
          </div>
         
        </div>
    <!--   </div> -->

    </div>
	
	 
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="b3/bootstrap.min.js"></script>
    <script src="b3/custom.js"></script>
    <script src="b3/carousel.js"></script>
</html>

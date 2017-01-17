<!DOCTYPE html>
<%@page import="enums.TipoComodo"%>
<%@page import="entidades.Comodo"%>
  <%@page import="java.util.ArrayList"%> 
 <%@page import="java.util.List"%> 
<%@page import="entidades.Cozinha"%>

<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Listar Cozinha</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <link rel="stylesheet" href="b3/bootstrap3.css" media="screen">
    <link rel="stylesheet" href="b3/custom.min.css">
    <link rel="stylesheet" href="b3/dropdownTemplate.css">
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
 	<br>
    <div class="container">

        <div class="row">
          <div class="col-lg-12">
            <fieldset>
                  <legend>Listar Cozinha</legend>
              <table class="table table-striped table-hover ">
                <thead>
                  <tr>
                    <td><b>Descrição</b></td>
                  </tr>
                </thead>
                <tbody>
			    
			    	<%
			    	
			    	List<Comodo>cozinhas = (List)request.getAttribute("cozinhas");
			    	for(Comodo c : cozinhas){
			    		out.println("<tr><td>");
			    		out.print(c.getDescricao());
			    		//System.out.println(c.getDescricao());
			    		out.print("<td><ul class = 'breadcrumb'><li><a href='EditarCozinha?id="+c.getIdComodo()+"&&descricao="+c.getDescricao()+"'>Editar</a></li><li><a href='DeletarCozinha?id="+c.getIdComodo()+"'>Deletar</a></li></ul></td>");
			    		out.println("</td></tr>");
			    	}
			    	%>
                </tbody>
              </table> 
               <div class="form-group">
                    <div class="col-lg-10 col-lg-offset-2">
                      <button class="btn btn-primary" onclick="history.back();" value="Back">Voltar</button>
                    </div>
              </fieldset>
            </div>
          </div>
      </div>
   


    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="b3/bootstrap.min.js"></script>
    <script src="b3/custom.js"></script>
    <script src="b3/carousel.js"></script>
</html>

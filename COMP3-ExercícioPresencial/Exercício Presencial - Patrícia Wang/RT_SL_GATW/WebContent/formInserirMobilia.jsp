<!DOCTYPE html>
 
 <%@page import="dao.ComodoDAO"%>
<%@page import="entidades.Comodo"%>
<%@page import="java.util.ArrayList"%> 
 <%@page import="java.util.List"%> 
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Inserir Mobília</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <link rel="stylesheet" href="b3/bootstrap3.css" media="screen">
    <link rel="stylesheet" href="b3/custom.min.css">
    <link rel="stylesheet" href="b3/dropdownTemplate.css">
    
    <script src="b3/sweetalert2/sweetalert2.min.js"></script>
	<link rel="stylesheet" href="b3/sweetalert2/sweetalert2.min.css">
 	<!-- Owl Carousel Assets -->
    <!-- <link href="b3/carousel/owl-carousel/owl.carousel.css" rel="stylesheet">
    <link href="b3/carousel/owl-carousel/owl.theme.css" rel="stylesheet">
    <script src="b3/carousel/owl-carousel/owl.carousel.js"></script> -->
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
 
    <div class="container">
        <div class="row">
          <div class="col-md-6 col-md-offset-3">    
            <div class="well">
              <form class="form-signin" method='get' action='CriarMobilia'>
                <fieldset>
                  <legend>Inserir Mobília</legend>
                  <div class="form-group">
                    	<label for="inputDescricao" class="col-lg-2 control-label">Descrição</label>
                    	<div class="col-lg-10">
                      		<input type="text" name="descricao" class="form-control" id="inputDescricao" placeholder="Descrição">
                    	</div>
                  </div>
                    <div class="form-group">
                    	<label for="inputCusto" class="col-lg-2 control-label">Custo</label>
                    	<div class="col-lg-10">
                      		<input type="text" name="custo" class="form-control" id="inputCusto" placeholder="$$">
                    	</div>
                  	</div> 
                    <div class="form-group">
                    	<label for="inputTempoEntrega" class="col-lg-2 control-label">Tempo de entrega</label>
                   	 	<div class="col-lg-10">
                      		<input type="text" name="tempoEntrega" class="form-control" id="inputTempo" placeholder="semanas">
                    	</div>
                  	</div>
					<div class="form-group">
	      				<label for="select" class="col-lg-2 control-label">Cômodos:</label>
					      <div class="col-lg-10">
					        <select multiple="" class="form-control" name = "comodoSelect">
					          
					         <%
					          ComodoDAO dao = new ComodoDAO();
					          List<Comodo>listaComodo = dao.listarComodoTotal();
					          for(Comodo c : listaComodo){
					        	  out.println("<option value = "+c.getIdComodo()+" >");
					        	  out.print(c.getDescricao());
					        	  out.println("</option>");
					          }
					          %>
					          
					        </select>
					      </div>
	    			</div> 
                  <div class="form-group">
                    <div class="col-lg-10 col-lg-offset-2">
                      <button type="submit" class="btn btn-primary">Enviar</button>
                    </div>
                  </div>
                </fieldset>
              </form>
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

<!DOCTYPE html>



<%@page import="data.mapper.ComodoMapper"%>
<%@page import="entidades.Comodo"%>
<%@page import="entidades.Mobilia"%>
<%@page import="java.util.ArrayList"%> 
<%@page import="java.util.List"%> 
<%@page import="java.util.Arrays"%>
<%@page import="entidades.ComodoComposto"%>


 
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Inserir Ambiente</title>
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


  <body onload="myFunction()">
    <div class="navbar navbar-default navbar-fixed-top">
      <%@ include file = "cabecalho.jsp" %>
    </div>

    <div class="container" >
        <div class="row">
          <div class="col-sm-9">    
            <div class="well">
              <form id = "formAmbiente" class="form-signin" method='get' action='CriarAmbiente'>
                <fieldset>
                  <legend>Inserir Ambiente</legend>
                
	                <div class="form-group">
                    	<label for="inputParede" class="col-lg-2 control-label">Número de Paredes</label>
                    	<div class="col-lg-10">
	       				 	<input type="text" name="parede" class="form-control" id="inputParede" placeholder="Numero de Paredes">
	       				</div>
	       			</div>
	       			
	        		<div class="form-group">
                    	<label for="inputPorta" class="col-lg-2 control-label">Número de Portas</label>
                    	<div class="col-lg-10">
	       				 	<input type="text" name="porta" class="form-control" id="inputPorta" placeholder="Numero de Portas">
	       				</div>
	       			</div>
	       			
	       			<div class="form-group">
                    	<label for="inputMetragem" class="col-lg-2 control-label">Metragem</label>
                    	<div class="col-lg-10">
	       				 	<input type="text" name="metragem" class="form-control" id="inputMetragem" placeholder="Metragem">
	       				 </div>
	      			</div>
	      			
					<br>
					<div class="form-group">
                    	
          
			         
			              <label for="inputMetragem" class="col-lg-2 control-label">Mobilias disponíveis:</label>
			              <br>
			                <fieldset class="group"> 
			                
						    <% ComodoMapper mapperComodo = new ComodoMapper();
			            	
			                	List<Comodo>listaComodo = mapperComodo.listarComodoTotal();
			                	int i = 0;
			                	for(Comodo c : listaComodo){
			                		
			                			List<Mobilia> mobilias = ComodoComposto.listarMobilias(c.getIdComodo());
			                			if(!mobilias.isEmpty())
			                			{
			                				out.println("<label class='col-lg-2 control-label'><i>"+c.getDescricao()+"</i></label>");
			                				
				                			for(Mobilia m : mobilias){
				                				out.println("<ul class='checkbox'> ");
				                				out.println("<li><input type='checkbox' name ='mobiliaSelect' value="+m.getIdMobilia()+" onclick=\"document.getElementById('categoria"+i+"').disabled = !this.checked;\" /><label>"+m.getDescricao()+"</label> ");
				                				out.print("<input type='text' name='categoria' id='categoria"+i+"' size='5' disabled='disabled'></li>");
				                				out.println("</ul>");
				                				i++;
				                			}
			                			}else{
			                				System.out.println("comodo nao associado a mobilia");
			                			}
			                	}
			                	
			             
						    %>
						    </fieldset>

	      			</div>

    				<br>
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

    </div>

    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="b3/bootstrap.min.js"></script>
    <script src="b3/custom.js"></script>
    <script src="b3/carousel.js"></script>
</html>

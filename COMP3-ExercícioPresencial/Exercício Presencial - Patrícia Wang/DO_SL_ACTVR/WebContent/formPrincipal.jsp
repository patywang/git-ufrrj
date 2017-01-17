<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Proj CompIII</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <link rel="stylesheet" href="b3/bootstrap3.css" media="screen">
    <link rel="stylesheet" href="b3/custom.min.css">
    <link rel="stylesheet" href="b3/dropdownTemplate.css">
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
 <!--    <ul class="dropdown-menu">
                        <li class="menu-item dropdown dropdown-submenu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Level 1</a>
                            <ul class="dropdown-menu">
                                <li class="menu-item ">
                                    <a href="#">Link 1</a>
                                </li>
                                <li class="menu-item dropdown dropdown-submenu">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Level 2</a>
                                    <ul class="dropdown-menu">
                                        <li>
                                            <a href="#">Link 3</a>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                    </ul> -->

<!-- <div class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">  
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav">
                <li class="menu-item dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Drop Down<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li class="menu-item dropdown dropdown-submenu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Level 1</a>
                            <ul class="dropdown-menu">
                                <li class="menu-item ">
                                    <a href="#">Link 1</a>
                                </li>
                                <li class="menu-item dropdown dropdown-submenu">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Level 2</a>
                                    <ul class="dropdown-menu">
                                        <li>
                                            <a href="#">Link 3</a>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</div> -->
    <div class="container">

   <center>
      <!-- Carousel -->
     <div id="myCarousel" class="carousel slide" data-ride="carousel">
	  <!-- Indicators -->
	  <ol class="carousel-indicators">
	    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
	    <li data-target="#myCarousel" data-slide-to="1"></li>
	    <li data-target="#myCarousel" data-slide-to="2"></li>
	    <li data-target="#myCarousel" data-slide-to="3"></li>
	  </ol>
	
	  <!-- Wrapper for slides -->
	  <div class="carousel-inner" role="listbox">
	    <div class="item active">
	      <img src="b3/imagensCarousel/img1.jpg" alt="">
	      <div class="carousel-caption">
        	<h3 style="color:#e72510;">CompIII</h3>
        	<p>by: Patrícia Wang</p>
      	  </div>
	    </div>
	
	    <div class="item">
	      <img src="b3/imagensCarousel/img2.jpg" alt="">
	      <div class="carousel-caption">
        	<h3 style="color:white;">CompIII</h3>
        	<p>by: Patrícia Wang</p>
      	  </div>
	    </div>
	
	    <div class="item">
	      <img src="b3/imagensCarousel/img3.jpg" alt="">
	      <div class="carousel-caption">
        	<h3 style="color:#e72510;">CompIII</h3>
        	<p>by: Patrícia Wang</p>
      	  </div>
	    </div>
	    
	    <div class="item">
	      <img src="b3/imagensCarousel/img6.jpg" alt="">
	      <div class="carousel-caption">
        	<h3 style="color:white;">CompIII</h3>
        	<p >by: Patrícia Wang</p>
      	  </div>
	    </div>
	  </div>

	</div>
	</center>
    </div>


    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="b3/bootstrap.min.js"></script>
    <script src="b3/custom.js"></script>
    <script src="b3/carousel.js"></script>
</html>

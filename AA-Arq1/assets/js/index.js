
var comando;
var saida = '\0';

$("#comando-btn").click(function(){

	console.log("haha");

	comando = $("#comando-txt").val();
	comando = comando.split("\n");
        var binario =  document.getElementById("saida-txt");
        binario.innerHTML = "";
	for(var i = 0; i < comando.length; i++){
		
		var c = comando[i].split(/[ ,()]+/);  

		if(c[0] == ""){
			c.shift();                     
		}
 		if(c.length == 0 || c[0] == ""){
			continue;
		}

                var tipo_intrucao = jsonData.instru[c[0]].tipo;
                switch(tipo_intrucao){

                  	case "r":
				saida = jsonData.instru[c[0]].inicio; //op
				if(c[0] == "jr"){
					saida += jsonData.registradores[c[1]]; // rs
					saida += "00000"; //rt
					saida += "00000"; //rd
					saida += "00000"; //shamt					
 				}else{ // se não for o jr
					saida += jsonData.registradores[c[2]]; //rs
					saida += jsonData.registradores[c[3]]; // rt
					saida += jsonData.registradores[c[1]]; // rd 
				        saida += "00000"; //shamt
                                }
				saida += jsonData.instru[c[0]].fim; //funct
                 	break;

			case "r2":			
				saida = jsonData.instru[c[0]].inicio; //op
				saida += "00000"; //rs
				saida += jsonData.registradores[c[2]]; //rt
				saida += jsonData.registradores[c[1]]; //rd 
				var decimal = parseInt( c[3], 10 ).toString( 2 ); //shamt
				for(var j = 0; j< 5 - decimal.length; j++){
						saida += "0";
				}
				saida +=  decimal;
				saida += jsonData.instru[c[0]].fim; //funct
			break;

			case "i":
				saida = jsonData.instru[c[0]].inicio;
				saida += jsonData.registradores[c[2]];  //rs
				saida += jsonData.registradores[c[1]];  //rt
				var decimal = parseInt( c[3], 10 ).toString( 2 );

				for(var j = 0; j< 16 - decimal.length; j++){
					saida += "0";
		                }
				saida +=  decimal;
			break;	
		
			case "i2":
				saida = jsonData.instru[c[0]].inicio;
				saida += jsonData.registradores[c[3]];  //rs
				saida += jsonData.registradores[c[1]];  //rt
				var decimal = parseInt( c[2], 10 ).toString( 2 );

				for(var j = 0; j< 16 - decimal.length; j++){
					saida += "0";
		                }
				saida +=  decimal;
			break;	
		
                    /* case "j":

				saida = jsonData.instru[c[0]].inicio;
				var str = c[1];
				for(var j = 0; j< 16 - c[1].length; j++){
					saida += "0";
		                }

				for(var r = 0, p =str.length;r<p;r++){
                               // var arr = [];
                                var hex = Number(str.charCodeAt(r));
                               
                                 }
                                 saida += hex; 
				
                	break;     */     

               	} // fim do case

		console.log(saida);
	  	binario.innerHTML += saida + "</br>";
		
	}
});


	



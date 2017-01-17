
var comando;
var saida = '\0';
var posicao ;
var c ;
var reg_= new Array(32); //registradores
var memoria = [];
var rs, rt, rd; //registradores de cada instrução
var hi, lo; //registradores especiais hi e lo
var posicao_final;
var erros = []; 
var alertas_erro;//mensagens de erro 
var contador; //contador step-by-step
var label = {};
var pilha = new Array();
 var last_execute = 3996;

//variaveis que liberam o uso dos outros botoes
var montador_btn = false;
var play_btn = false;
var next_btn = false;
var previous_btn = false;
var stop_btn = false; 

var posicoes_label =[];

var str = [];
$("#comando-btn").click(function(){
		str = [];

		var bin = [];
		var func_ ;//function
		    
		//"zera" a memoria
		memoria.length = 0;

		//zerando os registradores
			
		for (var i = 0; i < 32; i++) {
				
			reg_[i] = 0;
		}

		//zerando posicao

		posicao = 3996; 
		contador = 3996;

		alertas_erro = "";
		    
		montador_btn = true; 
		play_btn = false;
		next_btn = false;
		previous_btn = false;

		comando = $("#comando-txt").val();
		comando = comando.split("\n");
		
		//pilha de registradores
			
		for (var i = 0; i < 32; i++) {
			pilha[i] = 0;
		};

		    
		// find_label();

		for (var i = 0; i < comando.length; i++) {
			
			var x = comando[i].split(/[ :,()]+/);
			if(jsonData.instru[x[0]] == undefined){

           		label[x[0]] = posicao;
           				           
            }else{
            	posicao +=4;
            }
		};
		    
		var binario =  document.getElementById("saida-txt");
		posicao = 3996;
		       
		for(var i = 0; i < comando.length; i++){
	
			c = comando[i].split(/[ :,()]+/); 


			if(c[0] == ""){
				c.shift();                     
			}
		 	if(c.length == 0 || c[0] == ""){
				continue;
			}
		            
		    if(jsonData.instru[c[0]] == undefined){

           		//label[c[0]] = posicao;
           		//posicao -=4;
           		
           		posicao+=4;
           		continue;
		           
            } else{
            		//muda pc        
				    posicao = posicao + 4;
		            console.log("position" + posicao);
		   
				    var tipoInst = jsonData.instru[c[0]].tipo;
				        
					

				    //verificar se quer mudar o valor de $zero e $sp
				     if(c[1] == "$zero"){
						erros[posicao] = 1;
					} else if(c[1] == "$sp"){
						erros[posicao] = 2;
					}

				    switch(tipoInst){
				        
				        case "r":
				          		

					        if(jsonData.registradores[c[1]]=== undefined || jsonData.registradores[c[2]] === undefined || jsonData.registradores[c[3]] === undefined)
							{
								erros[posicao] = 3;

							}else{
								saida = jsonData.instru[c[0]].inicio; //op

								if(c[0] == "jr"){
									saida += jsonData.registradores[c[1]].valor; // rs
									saida += "00000"; //rt
									saida += "00000"; //rd
									saida += "00000"; //shamt					
						 		}else{ // se não for o jr

									saida += jsonData.registradores[c[2]].valor; //rs
									saida += jsonData.registradores[c[3]].valor; // rt
									saida += jsonData.registradores[c[1]].valor; // rd 
									saida += "00000"; //shamt
							    }
								saida += jsonData.instru[c[0]].fim; //funct 
								bin.push(saida ); // push: cololoca no final
					            memoria[posicao] = saida;
					        }    

			         		break;

						case "r2":	

							if(jsonData.registradores[c[1]] === undefined || jsonData.registradores[c[2]] === undefined || jsonData.registradores[c[3]] === undefined)
							{
								erros[posicao] = 7;

							}else{
									saida = jsonData.instru[c[0]].inicio; //op
									saida += jsonData.registradores[c[2]].valor; //rt
									saida += jsonData.registradores[c[1]].valor; //rd 
									saida += "00000"; //rs


									var decimal = parseInt( c[3], 10 ).toString( 2 ); //shamt
									for(var j = 0; j< 5 - decimal.length; j++){
											saida += "0";
									}
									saida +=  decimal;
									saida += jsonData.instru[c[0]].fim; //funct
									bin.push(saida );

							  		memoria[posicao] = saida; 
								}

							break;
					
						case "r3":		


							if(jsonData.registradores[c[1]] === undefined || jsonData.registradores[c[2]] === undefined)
							{
								erros[posicao] = 7;

							}else{

								saida = jsonData.instru[c[0]].inicio; //op
								saida += jsonData.registradores[c[1]].valor; // rs
								saida += jsonData.registradores[c[2]].valor; //rt
								saida += "00000"; //rd
								saida += "00000"; //shamt
								saida += jsonData.instru[c[0]].fim; //funct
								bin.push(saida );

						        memoria[posicao] = saida; 
						    }
				
							break;	

						case "i":

							if(jsonData.registradores[c[1]] === undefined || jsonData.registradores[c[2]] === undefined)
							{
								erros[posicao] = 7;
							} else{

								saida = jsonData.instru[c[0]].inicio;
								saida += jsonData.registradores[c[2]].valor;  //rs
								saida += jsonData.registradores[c[1]].valor;  //rd
								var decimal;

								if(c[3]<0){
									decimal = negative_number(c[3]);
								}
								else if(c[3]>=0){
									decimal = parseInt( c[3], 10 ).toString( 2 );
									for(var j = 0; j< 16 - decimal.length; j++){
										saida += "0";
								        }
								} else {
									erros[posicao] = 4;
									
								}
								saida +=  decimal;
								bin.push(saida );

								memoria[posicao] = saida; 
							}	

							break;	
				
						case "i2":
							saida = jsonData.instru[c[0]].inicio;
							saida += jsonData.registradores[c[3]].valor;  //rs 
							saida += jsonData.registradores[c[1]].valor;  //rt
							var decimal;
		                        
		                        
		                      
							if(c[2]<0 ||(c[2] % 4) !== 0){
								
								erros[posicao] = 9;
							}else{
								decimal = parseInt( c[2], 10 ).toString( 2 );
		                       
								for(var j = 0; j< 16 - decimal.length; j++){
									saida += "0";
							    }
							}
		                        
							saida +=  decimal;
							bin.push(saida );
		                        

							memoria[posicao] = saida; 

								 
							break;
			 
			 			//instruções que tem label
						case "i3":
							saida = jsonData.instru[c[0]].inicio;
							saida += jsonData.registradores[c[2]].valor;  //rs
							saida += jsonData.registradores[c[1]].valor;  //rt
		         
							//bin.push(saida);  
				            //bin.push(c[3]);
	                      
	                        var decimal = "";
	                        var label_address = parseInt(label[c[3]],10).toString(2);
	                       
	                        var tamanho = 16 - label_address.length;
	                        for(var p=0; p<tamanho; p++){
	                            decimal+="0";
	                            
	                        }
	                        
	                        decimal = decimal + label_address;
	                        memoria[posicao] = saida + decimal;

		//		           memoria[posicao] = saida; 
		                       
							break;	
						
						case "j":
		                        saida = jsonData.instru[c[0]].inicio;
		                        bin.push(saida);  
		                        bin.push(c[1]);

		                        var decimal = parseInt( label[c[1]], 10 ).toString( 2 );

		                        while(saida.length + decimal.length < 32){
		                            saida+="0";
		                        }

		                        saida+=decimal;
		                       memoria[posicao] = saida; 

		                        break;     

						case "especial":
		                                saida = jsonData.instru[c[0]].inicio;
		                                saida += jsonData.registradores[c[1]].valor;  //rd
		                                var decimal;

		                                decimal = parseInt( c[2], 10 ).toString( 2 );
		                                    console.log(decimal);
		                                for(var j = 0; j< 21 - decimal.length; j++){
		                                    saida += "0";
		                                }

		                                saida +=  decimal;
		                                bin.push(saida );
		                                memoria[posicao] = saida;

		                                break;       
		     

				       	} // fim do case
				       	str.push(saida);
				}
			}
		          

	        posicao_final = posicao; 

	        for (var i = 0; i < memoria.length; i+=4) {
	        	console.log(memoria[i] + " " + i);
	        };
	      
	        console.log("posicao_final ::" + posicao_final);
	        show_messages();
		       	   		console.log(str+'saidacacal');
		       	   		


});


//--------------------------------------------------------------
//--------------------------------------------------------------
//--------------------------------------------------------------

//------------------------------tipo especial

//------------------------------LI----------------------
function li(rd,immediate){

	var d;
	d = parseInt(rd,2);
	//console.log("imed::",immediate);
	reg_[d] = immediate;
	console.log("li::" + reg_[d]);

}

//------------------------------tipo r

//-------------------------------ADD---------------------

function add(rt, rs, rd){

	var d, s, t;
	d = parseInt( rd, 2 );
	s = parseInt( rs, 2 );
	t = parseInt( rt, 2 );

	reg_[d] = reg_[s] +  reg_[t];

	console.log("add::" + reg_[d]);
	
}


//------------------------------SUB---------------------

function sub(rt, rs, rd){
	var d, s, t;

	d = parseInt( rd, 2 );
	s = parseInt( rs, 2 );
	t = parseInt( rt, 2 );
	reg_[d] = reg_[s] -  reg_[t]; //subtrai

	reg_[d] = parseInt( reg_[d], 10 ); //volta pra binario

	console.log("sub::" + reg_[d]);

}

//------------------------------OR


function or(rt, rs, rd){
	var d, s, t;

	d = parseInt( rd, 2 );
	s = parseInt( rs, 2 );
	t = parseInt( rt, 2 );

	reg_[d] = reg_[s] | reg_[t];

	console.log("or::" + reg_[d]);
	
}


//------------------------------AND


function and(rt, rs, rd){

	var d, s, t;

	d = parseInt( rd, 2 );
	s = parseInt( rs, 2 );
	t = parseInt( rt, 2 );

	reg_[d] = reg_[s] & reg_[t];

	console.log("and::" + reg_[d]);

}

//------------------------------NOR


function nor(rt, rs, rd){
	var d, s, t;

	d = parseInt( rd, 2 );
	s = parseInt( rs, 2 );
	t = parseInt( rt, 2 );

	reg_[d] = ~(reg_[s] | reg_[t]);
	console.log("nor::" + reg_[d]);

}

//-------------------------SLT 

function slt(rt, rs, rd){
	
	var d, s, t;

	d = parseInt( rd, 2 );
	s = parseInt( rs, 2 );
	t = parseInt( rt, 2 );

	if(reg_[s]<reg_[t]){
		reg_[d] = 1;

	}else{
		reg_[d] = 0;
	}

	console.log("slt::" + reg_[d]);

}


//--------------------------------------------------------------
//--------------------------------------------------------------
//--------------------------------------------------------------
//------------------------------tipo r2


//---------------------------------SLL
function sll(rt, rd, sh){
	var shift;

	t = parseInt( rt, 2 );
	d = parseInt( rd, 2 );

	t = parseInt(reg_[t], 10);
	shift = parseInt(sh,2);

	reg_[d] = t << shift;

	
	console.log("sll ");

}


//---------------------------------SRL
function srl(rt, rd, sh){
	var shift;

	t = parseInt( rt, 2 );
	d = parseInt( rd, 2 );

	t = parseInt(reg_[t], 10);
	shift = parseInt(sh,2);

	reg_[d] = t >> shift;

	console.log("srl ");
	
}


//--------------------------------------------------------------
//--------------------------------------------------------------
//--------------------------------------------------------------
//------------------------------tipo r3


//-----------------------MULT 

function mult(rs, rt){
	var s, t, resultado, binario_;

	t = parseInt( rt, 2 );
	s = parseInt( rs, 2 );

	console.log("mult" + reg_[t] + " " + reg_[s]);

	resultado = reg_[t] * reg_[s];

	
	binario_ = parseInt(resultado, 10).toString(2);
	
	var antes = "";
	for (var i = 0; binario_.length + antes.length < 64; i++) {
		antes += "0";
	};

	var resultado_final = antes + binario_;

	hi = resultado_final.substring(0,32);
	lo = resultado_final.substring(32,64);


	console.log("mult::" + resultado_final);

}


//-------------------------DIV

function div(rs, rt){
	var s, t;
	t = parseInt( rt, 2 );
	s = parseInt( rs, 2 );

	hi = reg_[s] % reg_[t];
	lo = reg_[s] / reg_[t];

	hi =  parseInt(hi, 10).toString( 2 );
	lo =  parseInt(lo, 10).toString( 2 );

}

//--------------------------------------------------------------
//--------------------------------------------------------------
//--------------------------------------------------------------
//------------------------------tipo i



//-------------------------------ADDI---------------------


function addi(rs, rd, immediate){

	
	var d, i, s;

	d = parseInt( rd, 2 );
	s = parseInt( rs, 2 );
	reg_[d] = reg_[s] + immediate;

    console.log("addi::  depois "+ reg_[d]);
	
}

//------------------------------ANDI

function andi(rs, rd, immediate){

	var d, s, t;

	d = parseInt( rd, 2 );
	s = parseInt( rs, 2 );
	t = parseInt( immediate, 2 ); //immediate

	reg_[d] = reg_[s] & t;
	console.log("andi::" + reg_[d]);
	
}

//------------------------------ORI

function ori(rs, rd, immediate){

	
	var d, s, t;

	d = parseInt( rd, 2 );
	s = parseInt( rs, 2 );
	t = parseInt( immediate, 2 ); //immediate

	reg_[d] = reg_[s] | t;
	console.log("ori::" + reg_[d]);

}

//-------------------------SLTI

function slti(rs, rd, immediate){
	
	var d, s, i;

	d = parseInt( rd, 2 );
	s = parseInt( rs, 2 );
	i = parseInt( immediate, 2 );

	if(reg_[s]< i){
		reg_[d] = 1;

	}else{
		reg_[d] = 0;
	}

	console.log("slti::" + reg_[d]);
	
}

//--------------------------------------------------------------
//--------------------------------------------------------------
//--------------------------------------------------------------
//------------------------------tipo i2


//-------------------------LW

function lw(rs, rt, offset){
	var d, s, off;

	d = parseInt( rt, 2 ); //destino
	s = parseInt( rs, 2 ); //origem
	off = offset;
    
    
    var deslocamento = s + off;
  
    reg_[d] = memoria[deslocamento];
 
    console.log(reg_[d]);
	console.log("lw ");
	
}


//-------------------------SW

function sw(rs, rt, offset){
	var d, s, off;

	d = parseInt( rt, 2 ); //destino
	s = parseInt( rs, 2 ); //origem
	off = offset;
    
    console.log("s " + s);
    console.log("d " + d);
    console.log("off " + off);
    console.log("reg " + reg_[d]);
    
   
    var deslocamento = s + off;
  
    memoria[deslocamento]= reg_[d];
    
    console.log(memoria[deslocamento]);
	console.log("sw ");
	
}

//-------------------------LB


//-------------------------SW





//--------------------------------------------------------------
//--------------------------------------------------------------
//--------------------------------------------------------------
//------------------------------tipo i3


//-------------------------------BEQ

function beq(rs, rt, label, pc){

	var t, s, l;

	t = parseInt( rt, 2 );
	s = parseInt( rs, 2 );
	
    console.log("beq");
  
   
	if(reg_[s] == reg_[t]){
		return label;
        
	}else{
		return pc;
	}
}



//-------------------------------BNE

function bne(rs, rt, label, pc){

	var t, s, l;

	t = parseInt( rt, 2 );
	s = parseInt( rs, 2 );
	
	console.log("bne");

	if(reg_[s] != reg_[t]){
		return label;
	}else{
		return pc;
	}
}

//--------------------------------------------------------------
//--------------------------------------------------------------
//--------------------------------------------------------------
//------------------------------tipo j

//--------------------------------J

function j(label){

	var l = parseInt(label, 2);

	console.log("j" + l);
	return l;
}


//--------------------------------JAL

function jal(label, pc){

	var l = parseInt(label, 2);
    var x = pc.toString(2);
    var saida="";
    
    var tamanho = 32 - x.length;
    for(var i=0; i<tamanho; i++){
        saida+="0";
    }
    
    reg_[31] = saida + x;
    
	console.log("jal    " + l);

	return l;
}





//--------------------------EXECUTA

function executa(instrucao, pc){

	var rt = "", rs = "", rd= "", sh= "", op= "", func= "", immediate = "", address= "", tipo = "", offset=""; 

	if(instrucao === undefined){
		return pc+4;
	}
	//opcode

       
	op = instrucao.substring(0, 6);
		
	if(op == "000011" || op == "000010" ){
		console.log("tipo j");
		tipo = "j";

	} else if( op == "000000"){
		
		func = instrucao.substring(26, 32);

		tipo = "r";
	}else if ( op == "111111"){
		tipo = "especial";

	} else{
		
		tipo = "i";

	}

	switch(tipo){
			
		case "especial":
			rd =instrucao.substring(6,11 );
	                        immediate = instrucao.substring(11, 32);
			immediate = parseInt( immediate, 2 );
			li(rd,immediate);
			break;
			

		case "r":

			rs = instrucao.substring(6, 11);
			rt = instrucao.substring(11, 16);
			rd = instrucao.substring(16, 21);
			sh = instrucao.substring(21, 26);

			switch(func){
				case "100000": //add
								add(rt, rs, rd);
                                pc = pc;
								break;

				case "100010": //sub
								 sub(rt, rs, rd);
                                pc = pc;
								 break;

				case "100100": //and
								and(rt, rs, rd);
                                pc = pc;
								break;

				case "100101": //or
								or(rt, rs, rd);
                                pc = pc;
								break;

				case "100111": //nor
								nor(rt, rs, rd);
                                pc = pc;
								break;

				case "101010": //slt
								slt(rt, rs, rd);
                                pc = pc;
								break;

				case "001000": //jr

				case "000000": //sll
								sll(rt, rd, sh);
                                pc = pc;
								break;

				case "000010": //srl
								srl(rt, rd, sh);
                                pc = pc;
								break;

				case "011000": //mult
								mult(rs, rt);
                                pc = pc;
								break;

				case "011010": //div
								div(rs, rt);
                                pc = pc;
								break;

			}

			break;

	case "i":
			rs = instrucao.substring(6, 11);
			rd =instrucao.substring(11, 16);
            immediate = instrucao.substring(16, 32);
         
        
            if(immediate[0]=== "1"){
                immediate = immediate.substring(1, 16);
              
                immediate = (parseInt( immediate, 2 )) * (-1);
                 
               
            }else{
        
                immediate = parseInt( immediate, 2 );
               
            }
         
			switch(op){
				case "010000"://addi
								

								addi(rs, rd, immediate);
                                pc = pc;
								break;

				case "001100"://andi
								//immediate = memoria[pc].substring(16, 32);

								andi(rs, rd, immediate);
                                pc = pc;
								break;

				case "001101"://ori
							//	immediate = memoria[pc].substring(16, 32);

								ori(rs, rd, immediate);
                                pc = pc;
								break;

				case "001010"://slti
							//	immediate = memoria[pc].substring(16, 32);

								slti(rs, rd, immediate);
                                pc = pc;
								break;

				case "100011"://lw
							//	offset = memoria[pc].substring(16, 32);
                    
								lw(rs, rd, immediate);
                                pc = pc;
								break;

				case "101011"://sw
                                sw(rs, rd, immediate);
                                pc = pc;
                                break;

				case "100000"://lb

				case "101000"://sb

				case "000100": //beq
							//	address= memoria[pc].substring(16, 32);
                              
								pc = beq(rs, rd, immediate, pc);
                               // pc = executa(memoria[pc], pc);

								break;

				case "000101": //bne
                                pc = bne(rs, rt, immediate, pc);
                               //pc =  executa(memoria[pc], pc);
                                break;
			}

			break;

		case "j":

			address= instrucao.substring(6, 32);
			
			switch(op){
				case "000010": //j
                                pc = j(address);
                        
								break;

				case "000011": //jal
								
								pc = jal(address, pc);
                               	break;
			}

			break;

}
 return pc;

}

//-----------------------------------------------------NUMEROS NEGATIVOS

function negative_number(n){
	

	var binario = parseInt( n, 10 ).toString( 2 ); //volta pra binario
	
	binario = binario.substring(1, binario.length);
	
	var final = "1"; //bit da magnitude

	for(var i = 0; final.length + binario.length<16; i++){
		final += "0"; //preenche com 0s
	}
    
	final += binario; //recebe o binario
   
	return final;

}



//--------------------------------------------------MOSTRA MENSAGENS DE ERRO

function show_messages(){


	if(erros.length === 0){
	
		alertas_erro = "Operation complete sucefully!" + "<br>";


	}else{


			for (var i = 0; i < erros.length; i+=4) {
				switch(erros[i]){
					case 1: //modificar $0
							alertas_erro += "Not register value can be modified" +  "<br>"
							//console.log("erro 1");
							break;

					case 2: //modificar $sp

							alertas_erro += "Not register value can be modified" +  "<br>"
							//console.log("erro 2");
							break;

					case 3: //passar imadiato no lugar de $

							alertas_erro += "Constant not allowed at instruction" +  "<br>"
							//console.log("erro 3");
							break;

					case 4: //passar $ no lugar de imediato

							alertas_erro += "Register not allowed at instruction" +  "<br>"
							//console.log("erro 4");
							break;

					case 5: //label indefinida

							alertas_erro += "Undefined label" +  "<br>"
							//console.log("erro 5");
							break;			

					case 6: //numeros negativos pra lw, sw...

							alertas_erro += "Not allowed negative number" +  "<br>"
							//console.log("erro 6");
							break;

					case 7: //$ indefinidos

							alertas_erro += "Undefined registers" +  "<br>"
							//console.log("erro 7");
							break;
                        
                    case 8:
                            break;
                        
                    case 9: //offset nao acc
                            
                            alertas_erro += "Offset not accepted" +  "<br>"
							//console.log("erro 9");
							break;


					

				}
		}		

		
	};
	document.getElementById("mensagens").innerHTML = alertas_erro; 
	

	erros.length = 0; //zera o vetor de erros



}


//-----------------------------------------------------ATUALIZA registradores

function change_registradores(){
    var atualizado = 0;
    var negativo;
    
     
	for (var i = 2; i < reg_.length; i++) {
        
        atualizado = "";
        
        negativo = false;
     
		if(i==26 || i==27){
			continue;
		}else{
            
                if(reg_[i][0] == "1"){
                        
                     atualizado = "0" + reg_[i].substring(1, 32);
                    negativo = true;
                    
                }else{
                    atualizado = reg_[i].substring(0, 32);
                    
                }
            
				atualizado = parseInt(atualizado, 2);
                if(negativo){
                    atualizado = atualizado *(-1);
                  
                }else{
                    atualizado = atualizado;
                 }
            
				document.getElementById(i).innerHTML= atualizado;

		}
        
        reg_[i] = atualizado;
        
	};
}

//----------------------------------------32 bits dos registradores

function preenche_registradores(){

	var valor_binario = "";
    


	for (var k = 0; k < reg_.length; k++) {
        
        valor_binario = "0";
        
        if(reg_[k] < 0){
            valor_binario = "1";
            reg_[k] = reg_[k] * (-1);
        }

		reg_[k] =  parseInt(reg_[k], 10).toString( 2 );
       
		for (var i = 1; valor_binario.length + reg_[k].length < 32; i++) {
			valor_binario += "0";

		};

		reg_[k] = valor_binario + reg_[k];
    
	}	

}
//----------------------------------------------------  PLAY

function play_button(){
    
    var tabela="";
        
    if (erros.length === 0 && montador_btn === true) {
        
        
        for(var i=4000; i<=posicao_final; i+=4){
        
           i = executa(memoria[i], i);
            
           if(memoria[i+4] === undefined){
           
            	break;
       		 }


            
        }
       
        preenche_registradores();
   
        change_registradores();
    
        alertas_erro = "Program is finished!" + "<br>";
        document.getElementById("mensagens").innerHTML = alertas_erro; 
        play_btn = true;
        
        var instrucao = 4000;
        var instru_label = "";
        var data_seg = "";

        for(var i=0; i<comando.length; i++){
        	var x = comando[i].split(/[ :,()]+/);
			/*if(jsonData.instru[x[0]] === undefined){

				instrucao = instru_label;
			}else{*/
				instrucao = (i*4)+4000;
				console.log("instrucao" + instrucao);
			//}

            
   			tabela += "<tr id="+ instrucao +"><td><font" + ">"  + instrucao + "</font></td><td><font" + ">"+ comando[i] + "</font></td></tr>"; 
            
            if(instrucao < posicao_final){
                instrucao +=4;
            }
        
    	}

    	data_seg = "<table border=1px border=1px style=height:0px><tr class='dts_title'><td >Adress</td><td >Value(+0)</td><td >Value(+4)</td><td >Value(+8)</td><td >Value(+c)</td><td >Value(+10)</td><td >Value(+14)</td><td >Value(+18)</td><td >Value(+1c)</td></tr><tr class='dts_title' style='border:1px solid;'><td id='adress0'></td><td id='adress1'></td><td id='adress2'></td><td id='adress3'></td><td id='adress4'></td><td id='adress5'></td><td id='adress6'></td><td id='adress7'</td><td id='adress8'</td></tr></table>";
        
   		 document.getElementById("adresses").innerHTML = tabela;
   		 document.getElementById("memoryContent").innerHTML = data_seg;
   		 updateAdress();
   		 
         
        
    }else{
        alertas_erro = "Not assemble yet!" + "<br>";
        document.getElementById("mensagens").innerHTML = alertas_erro; 
    
    }
    
    //passa pra memoria
    
    for(var i=2; i<reg_.length; i++){
     
        memoria[i*4] = reg_[i];
    }
    
 	console.log(memoria);
}


//-----------------------------------------------------STEP BY STEP


function step_by_step(contador, botao){

if(contador<posicao_final){
	last_execute+=4;
 }

 if(contador === 4000){
     
        for (var i = 0; i < 32; i++) {
		
			reg_[i] = 0;
		}
        preenche_registradores();
        change_registradores();
        last_execute = 4000; 
        console.log("------------------");
        
}

var k = ((contador-4000)/4);
console.log(contador + " " + k);


last_execute = executa(memoria[last_execute], contador);
console.log("last" + last_execute);


if(botao === "n"){
	if(contador !== posicao_final){
		pilha = pilha.concat(reg_);
		

    	}
    
    }else{
	    var vetor = pilha.slice(pilha.length -32, pilha.length);
	   

	    for (var i = 0; i <32 ; i++) {
	    	   reg_[i] = vetor[i];
	    	  
	    	    };
	   	pilha.length = pilha.length -32;
	   

    }


   for(var w=2; w<32; w++){
    
        reg_[w] = parseInt(reg_[w], 10); //transforma os resultados em inteiros

    }

	preenche_registradores();
	change_registradores();
    

    for(var i=4000; i<=posicao_final; i+=4){
   
        k = ((i-4000)/4);
        contador = last_execute;
                
        if(i === contador){
        	 k = ((last_execute-4000)/4);
            document.getElementById(contador).innerHTML = "<tr id="+ contador +"><td><font color=" + "green>"  + contador + "</font></td><td><font color=" + "green>"+ comando[k] + "</font></td></tr>"; 
    
        }else{
         
            document.getElementById(i).innerHTML = "<tr id="+ i +"><td><font" + ">"  + i + "</font></td><td><font" + ">"+ comando[k] + "</font></td></tr>"; 
            
        }
    }

    
}

//----------------------------------------------------------UPDATE ADDRESS

function updateAdress(){
    for (var i = 0; i < 9; i++) {
        $("#adress"+i).replaceWith('<td id="adress'+i+'"></td>');
    }

    for (var i = 0; i < 9; i++) {
        i%2==0 ? paridade = 'divpar' :  paridade = 'divimpar';  
        var res = binaryToHex(((i*(32*9))+4000).toString(2)).result;
        $("#adress0").append("<div  class=\'"+ paridade+"\'>0x"+ res +"</div>");
    }

	var count = 0;
    var paridade;
    for (var i = 0; i < 9; i++) {
        for (var j = 1; j < 9; j++) {
            i%2==0 ? paridade = 'divpar' :  paridade = 'divimpar';  
            var aux;
            str[count] == undefined ? aux = '00000000000000000000000000000000' : aux = str[count];
            count++;
            $("#adress"+j).append("<div  class=\'"+ paridade+"\'>0x"+ binaryToHex(aux).result+"</div>");
            console.log(str[count]+'--'+count+'---'+i+'----'+j);
        }   
    }
}

function binaryToHex(s) {
    var i, k, part, accum, ret = '';
    for (i = s.length-1; i >= 3; i -= 4) {
        // extract out in substrings of 4 and convert to hex
        part = s.substr(i+1-4, 4);
        accum = 0;
        for (k = 0; k < 4; k += 1) {
            if (part[k] !== '0' && part[k] !== '1') {
                // invalid character
                return { valid: false };
            }
            // compute the length 4 substring
            accum = accum * 2 + parseInt(part[k], 10);
        }
        if (accum >= 10) {
            // 'A' to 'F'
            ret = String.fromCharCode(accum - 10 + 'A'.charCodeAt(0)) + ret;
        } else {
            // '0' to '9'
            ret = String(accum) + ret;
        }
    }
    // remaining characters, i = 0, 1, or 2
    if (i >= 0) {
        accum = 0;
        // convert from front
        for (k = 0; k <= i; k += 1) {
            if (s[k] !== '0' && s[k] !== '1') {
                return { valid: false };
            }
            accum = accum * 2 + parseInt(s[k], 10);
        }
        // 3 bits, value cannot exceed 2^3 - 1 = 7, just convert
        ret = String(accum) + ret;
    }
    return { valid: true, result: ret };
}

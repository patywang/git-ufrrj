  
  function atualiza_pagina(){
 		

 		
			  //var script = document.createElement('script');
			  //script.type = 'text/javascript';
			  //script.src = 'js/index.js';
			  
			  //document.getElementsByTagName('head')[0].appendChild(script);

			  //document.write(unescape("%3Cscript src='index.js' type='text/javascript'%3E%3C/script%3E"));

			play_button();
			//show_messages();
      
      //vai pra pagina de execução
        selectionTab('1');
     

      
        

     }

   function next_button(){
       //next_button();
     //contador +=4;
     var botao = "n";
       if(play_btn){
            next_btn = true;
      
           if(contador !== posicao_final){
                    contador+=4;
               }

           if(contador<=posicao_final){
               step_by_step(contador, botao);


           }

       }
   }

function previous_button(){
    //previous_button();
     var botao = "p";
    
    if(next_btn){
    
        if(contador !== 4000){
                    contador-=4;
               }

        if(contador >= 4000 && contador<= posicao_final){
            step_by_step(contador, botao);

       }
    
   

    }
    
}
 



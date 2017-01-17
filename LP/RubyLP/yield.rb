def chama_bloco
   puts 'Inicio do método'
   # você pode chamar o método com a palavra-chave yield
   yield
   yield
   puts 'Fim do metodo'
 end
 # Os blocos de código podem aparecer apenas no código adjacente a uma chamada de método
 chama_bloco {puts 'Dentro do bloco'}

 #Inicio do método
 #Dentro do bloco
 #Dentro do bloco
 #Fim do método
PERIODO = 2015.1   #CONSTANTE

class Aluno
	@@contador_aluno = 0  #VARIÁVEL DE CLASSE
	$media = 5.0          #VARIÁVEL GLOBAL

	def initialize (nome, nota1, nota2)
		@nome = nome      #VARIÁVEL DE INSTÂNCIA
		@nota1 = nota1	  #VARIÁVEL DE INSTÂNCIA
		@nota2 = nota2    #VARIÁVEL DE INSTÂNCIA
		@@contador_aluno += 1
	end

	def numero_de_instancias
		return @@contador_aluno
	end

	def mediaFinalAluno
		nota = (@nota1 + @nota2) / 2
=begin
		bloco condicional mais simples em ruby: if está implícito!!
		condicao1 > condicao2 ? "se sim faça isso" : "senao faça esse no lugar"
=end
		return puts nota >= $media ? "Aluno #{@nome} foi aprovado em #{PERIODO}!!" :
		 							"Aluno #{@nome} foi reprovado em #{PERIODO}"
	end
end 

fulano = Aluno.new("aluno1", 6.0, 10)
fulaninho = Aluno.new("aluno2", 3.0, 2.5)

puts "Número de instâncias: #{fulaninho.numero_de_instancias}"
#Número de instâncias: 2

fulano.mediaFinalAluno
#Aluno fulano foi aprovado em 2015.1!!

fulaninho.mediaFinalAluno
#Aluno fulaninho foi reprovado em 2015.1

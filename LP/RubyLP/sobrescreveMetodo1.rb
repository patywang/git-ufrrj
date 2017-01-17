class Produto
	attr_reader :nome, :qtd

	def initialize (nome, qtd)
		@nome = nome
		@qtd = qtd

	end

	def +(outro_produto)
		puts "sobrescrevendo operador +"
		return @qtd + outro_produto.qtd

	end


	def ==(outro_produto)
		puts "sobrescrevendo operador =="
		return @nome == outro_produto.nome
	end


	def /(outro_produto)
		puts "sobrescrevendo operador /"
		return @qtd > outro_produto.qtd
	end
end
	p Produto.new("café", 3) + Produto.new("açúcar", 2)
	p Produto.new("café", 3) == Produto.new("açúcar", 2)
	p Produto.new("café", 3) / Produto.new("açúcar", 2)

	#sobrescrevendo operador +
	#5
	#sobrescrevendo operador ==
	#false
	#sobrescrevendo operador /
	#true



	
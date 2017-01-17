module Music   #MÓDULO

	def play
		puts "i'm playing #{self.genre}"
	end
end

class Musician   #CLASSE PAI

	def getMusician
		puts "Hey, i'm a musician!"
	end

end


class DJ < Musician    #CLASSE FILHA
	include Music

	#attr_reader :genre
    #atrr_writer :genre
    attr_accessor :genre
    
	def initialize(genre)
		@genre = genre
	end
end

dj = DJ.new("Rock")
dj.play
#i'm playing Rock

dj.genre = "Eletrônica"  #attr_accessor :leitura e alteração de uma variável
dj.play
#i'm playing Eletrônica

dj.getMusician
#Hey, i'm a musician!



require 'matrix'
p matriz_1 = Matrix[ [25, 93], [-1, 66] ]  
#Matrix[[25, 93], [-1, 66]] 

p matriz_2 = Matrix.build(3) { |row, col| col - row }   
#Matrix[[0, 1, 2], [-1, 0, 1], [-2, -1, 0]] 

p matriz_3 = Matrix.build(2) { |row, col| col + row }
#Matrix[[0, 1], [1, 2]]

p matrix_i = Matrix.identity(2)  
#Matrix[[1, 0], [0, 1]]

p Matrix.vstack(matriz_1, matrix_i) 
#Matrix[[25, 93], [-1, 66], [1, 0], [0, 1]]

p matriz_1 * matriz_3 
#Matrix[[93, 211], [66, 131]]

p matriz_2.transpose	
#Matrix[[0, -1, -2], [1, 0, -1], [2, 1, 0]]





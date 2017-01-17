var jsonData = { 
	"instru": 
	{ 
 			//TIPO R
			"add":  {"tipo":"r", "inicio":"000000", "fim":"100000"}, 
			"sub":  {"tipo":"r", "inicio":"000000", "fim":"100010"},
			"and":  {"tipo":"r", "inicio":"000000", "fim":"100100"},
			"or":   {"tipo":"r", "inicio":"000000", "fim":"100101"},
			"nor":  {"tipo":"r", "inicio":"000000", "fim":"100111"},
			"slt":  {"tipo":"r", "inicio":"000000", "fim":"101010"},
			"jr":   {"tipo":"r", "inicio":"000000", "fim":"001000"},
                        
                     


			//TIPO I
			"addi": {"tipo":"i", "inicio":"010000"},
			"andi": {"tipo":"i", "inicio":"001100"},
			"ori":  {"tipo":"i", "inicio":"001101"},
            "slti": {"tipo":"i", "inicio":"001010"},
                     
			
			
			//TIPO J	
            "j":   {"tipo":"j", "inicio":"000010"},
			"jal": {"tipo":"j", "inicio":"000011"}, 
                


//---------------------------ESPECIAIS:  pois há condição especifica p eles----------------------//

			//TIPO R  r2

			"sll": {"tipo":"r2", "inicio":"000000", "fim":"000000"},
			"srl": {"tipo":"r2", "inicio":"000000", "fim":"000010"}, 

			
			//TIPO I  i2
			"lw": {"tipo":"i2", "inicio":"100011"},
			"sw": {"tipo":"i2", "inicio":"101011"},
			"lb": {"tipo":"i2", "inicio":"100000"},
			"sb": {"tipo":"i2", "inicio":"101000"},
			
			

//-----------------------------------------------------------------------------------------


            //Tipo R   r3
            "mult": {"tipo":"r3", "inicio":"000000", "fim":"011000"}, 
			"div":  {"tipo":"r3", "inicio":"000000", "fim":"011010"},
                        

            //TIPO i3
            "beq": {"tipo":"i3", "inicio":"000100"},
			"bne": {"tipo":"i3", "inicio":"000101"},
 
//----------------------------------------------------------------------------------------------

			//tipo especial
			"li":  {"tipo":"especial","inicio":"111111"},
    	},
	
    	"registradores":
    	{	
			"$zero": 	{"nome": "zero", "valor": "00000"},
			"$v0":	 	{"nome": "v0", "valor": "00010"},
			"$v1":		{"nome": "v1", "valor":"00011"},
			"$a0":		{"nome": "a0", "valor": "00100"},
			"$a1":		{"nome": "a1", "valor": "00101"},
			"$a2":		{"nome": "a2", "valor": "00110"},
			"$a3":		{"nome": "a3", "valor":"00111"},
			"$t0": 		{"nome":"t0", "valor":"01000"},
        	"$t1": 		{"nome":"t1", "valor":"01001"},
 			"$t2": 		{"nome":"t2", "valor":"01010"},
			"$t3": 		{"nome":"t3", "valor":"01011"},
        	"$t4": 		{"nome":"t4", "valor":"01100"},
 			"$t5": 		{"nome":"t5", "valor":"01101"},
			"$t6": 		{"nome":"t6", "valor":"01110"},
			"$t7": 		{"nome":"t7", "valor":"01111"},
			"$s0": 		{"nome":"s0", "valor":"10000"},
        	"$s1": 		{"nome":"s1", "valor":"10001"},
 			"$s2": 		{"nome":"s2", "valor":"10010"},
			"$s3": 		{"nome":"s3", "valor":"10011"},
        	"$s4": 		{"nome":"s4", "valor":"10100"},
 			"$s5": 		{"nome":"s5", "valor":"10101"},
			"$s6": 		{"nome":"s6", "valor":"10110"},
			"$s7": 		{"nome":"s7", "valor":"10111"},
			"$t8": 		{"nome":"t8", "valor":"11000"},
			"$t9": 		{"nome":"t9", "valor":"11001"},
			"$k0":		{"nome":"k0", "valor":"11010"},
			"$k1":		{"nome":"k1", "valor":"11011"},
			"$gp":		{"nome":"gp", "valor":"11100"},
			"$sp":		{"nome":"sp", "valor":"11101"},
			"$fp":		{"nome":"fp", "valor":"11110"},
        	"$ra":		{"nome":"ra", "valor":"11111"}
    	} 
};

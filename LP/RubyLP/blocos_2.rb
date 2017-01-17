def proc_return
  p = Proc.new { return "Proc.new"}
  p.call
  return "Fim do método proc_return"
end

def lambda_return
  l = lambda { return "lambda" }
  l.call
  return "Fim do método lambda_return"
end

puts proc_return         #Proc.new
puts lambda_return		 #Fim do método lambda_return

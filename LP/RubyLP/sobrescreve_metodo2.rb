class MagicString < String
  def +@
    [self.upcase]
  end

  def -@
    downcase
  end

  def ~@
    [self.reverse]
    end

  def !@
    swapcase
  end
end

str = MagicString.new("This is my string!")
p +str                 #"THIS IS MY STRING!"  
p ~str                 #["!gnirts ym si sihT"]
p !str                 #tHIS IS MY STRING
p (not str)            #tHIS IS MY STRING
  

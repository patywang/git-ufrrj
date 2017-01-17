class NewDog  
  def initialize(breed)  
    @breed = breed  
  end  
  attr_reader :breed, :name   # create reader only  
  # setter method  
  def set_name=(nm)  
    @name = nm  
  end  
end  
nd = NewDog.new('Doberman')  
nd.set_name ='Benzy'
puts nd.name 
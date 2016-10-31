class List
	def initialize()
	@lists = Hash.new
	end
	
	def insert(val)
		@lists.store(@lists.length+1,val)
	end
	
	def prints()
		print @lists
		puts
	end
	
	def traverse()
		counter=1
		begin
			print @lists[counter].to_s + " "
			counter+=1
		end while counter <= @lists.length+1
	end
	
	def delete(val)
		counter=1
		myVal = @lists[counter]
		begin
			if(myVal == val) then
			@lists.delete(counter)
			@lists.rehash
			end
		counter+=1
		myVal = @lists[counter]
		end while counter <= @lists.length+1
	end
end

myList = List.new()

myList.insert("Bacon")
myList.insert("Sasage")
myList.insert("Ham")
myList.prints()
myList.traverse()
myList.delete("Bacon")
myList.prints()
myList.insert("Pork")
myList.prints()

#!/usr/bin/env ruby
#Assignmnet #5 Part 5
#CS417 OOP
#By John Knowles
#Due November 1, 2016

class List
	def initialize()
	@lists = Hash.new
	@size = 0
	end
	
	def insert(value)
		@lists.store(@size+1,value)
		@size+=1
	end
	
#	def prints()
#		print @lists
#		puts
#	end
	
	def traverse()
		counter=1
		begin
			print @lists[counter].to_s + " "
			counter+=1
		end while counter <= @lists.length+1
		puts
	end
	
	def delete(value)
		counter=1
		myValue = @lists[counter]
		begin
			if(myValue == value) then
			@lists.delete(counter)
			@lists.rehash
			end
		counter+=1
		myValue = @lists[counter]
		end while counter <= @lists.length+1
	end
end

myList = List.new()

myList.insert("Bacon")
myList.insert("Sasage")
myList.insert("Ham")
myList.traverse()
myList.delete("Bacon")
myList.insert("Pork")
myList.insert("Sausage")
myList.insert("Pig")
myList.traverse()

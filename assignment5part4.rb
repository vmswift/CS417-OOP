#!/usr/bin/env ruby
#Assignmnet #5 Part 4
#CS417 OOP
#By John Knowles
#Due November 1, 2016

def ssort(list)  
	list.size.times do |start|  
		min = start  
		start.upto(list.size-1) do |i|  
			min = i if list[i].to_i < list[min].to_i
		end  
		list[start], list[min] = list[min], list[start]  
	end  
	return list  
end  

def ssort!(list) 
	mutList = list.clone
	mutList.size.times do |start|  
		min = start  
		start.upto(mutList.size-1) do |i|  
			min = i if mutList[i].to_i < mutList[min].to_i  
		end  
		mutList[start], mutList[min] = mutList[min], mutList[start]  
	end  
	return mutList 
end  


print "Enter the elements followed by spaces: "
input = gets
puts

myList = input.split(" ")
mutedList = ssort!(myList)
print mutedList
puts
print myList
puts
ssort(myList)
print myList
puts

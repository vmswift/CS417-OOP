#!/usr/bin/env ruby
#Assignmnet #5 Part 3
#CS417 OOP
#By John Knowles
#Due November 1, 2016

def secondSmallest(list)
	if (list.size > 2) then
		newList = list.sort{|a,b| a.to_i<=>b.to_i}
		#sort list least to greatest
		secondSmall = newList[1]
		return list.index(secondSmall)
	else
		return 0
	end
end

print "Enter the elements followed by spaces: "
input = gets
puts

myList = input.split(" ")

print "Second smallest value location is: " + secondSmallest(myList).to_s
puts

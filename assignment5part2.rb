#!/usr/bin/env ruby
#Assignmnet #5 Part 2
#CS417 OOP
#By John Knowles
#Due November 1, 2016

def numSmaller(list,item)
	if(list.count > 0) then
		return list.count{|val| val.to_i<item.to_i}
	else
		return 0
	end
end

print "Enter the elements followed by spaces: "
input = gets
puts

myList = input.split(" ")

print "Enter search less than value for array: "
input2 = gets.chomp
puts

print "Number of values less than " + input2.to_s + " is " + numSmaller(myList,input2).to_s
puts

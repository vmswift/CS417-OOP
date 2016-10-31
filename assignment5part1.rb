#!/usr/bin/env ruby
def occurrences(list,key)
	return list.count(key)
end

print "Enter the elements followed by spaces: "
input = gets
puts

myList = input.split(" ")
#myList = ["Bacon","MoreBacon","EnoughBacon","Toomuchbacon", "MoreBacon","MoreBacon"]

print "Enter search value for array: "
input2 = gets.chomp
puts

print "Number of times " + input2.to_s + " occurs is " + occurrences(myList,input2).to_s + " times"
puts
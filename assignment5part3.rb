def secondSmallest(list)
	if (list.size > 2) then
		newList = list.sort
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

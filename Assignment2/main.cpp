/*
Class: CS417 OOP
Instructr: Dr. Lewis
File: main.cpp
Description: Main file for calling on code contained in airline.cpp. 
This code is used in an effort to resolve the problem statement listed
under Assignment 2 in CS417 OOP.
*/
#include <iostream>
#include "airline.cpp"

using namespace std;

int main()
{
	int myVal = 0;
	cout << "Enter number of time periods: ";
	cin >> myVal;
	cout << endl;
	airline<int> myAir(myVal);
	myAir.manage_queue();
	myAir.calc_queue();
	return 0;
}


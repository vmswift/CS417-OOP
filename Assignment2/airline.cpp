/*
Class: CS417 OOP
Instructr: Dr. Lewis
File: airline.cpp
Description: Cpp file that outlines code used in the header and main file etc.
This code is used in an effort to resolve the problem statement listed
under Assignment 2 in CS417 OOP.
*/
#include "airline.h"
template <class type>
void airline<type>::manage_queue() //manage airline queue
{
	int count = 0;
	std::cout << "Eco      " << "Freq     " << "First" << endl;
	std::cout << "-------------------------" << endl;
	while (count <= time)
	{
		inc_agent_time();
		if (eco_count == 1)
		{
			push_eco();
			increment_eco();
			eco_count = 0;
		}
		if (freq_count == 5)
		{
			push_freq();
			increment_freq();
			freq_count = 0;
		}
		if (first_count == 20)
		{
			push_first();
			increment_first();
			first_count = 0;
		}
		eco_counter.push(size_eco());
		freq_counter.push(size_freq());
		first_counter.push(size_first());
		std::cout << setw(2) << size_eco() << setw(10) << size_freq() << setw(8) << size_first() << endl;
		if (first_agent || freq_agent || eco_agent)
		{
			eco_load();
			freq_load();
			first_load();
		}

		count++;
	}
	return;
}

template <class type>
void airline<type>::eco_load() //manage airline eco queue
{
	if (eco_agent&&eco_time == 0 && eco_size>0)
	{
		eco_agent = false;
		eco_time = service_time();
		pop_eco();
	}
	else if (eco_time>0)
	{
		eco_time--;
		if (eco_time == 0)
		{
			eco_agent = true;
		}
	}
	return;
}

template <class type>
void airline<type>::freq_load() //manage airline freq queue
{
	if (freq_agent&&freq_time == 0 && size_freq() > 0)
	{
		freq_agent = false;
		freq_time = service_time();
		pop_freq();
	}
	else if (freq_agent&&first_agent == false && freq_time == 0 && size_first() > 0)
	{
		freq_agent = false;
		freq_time = service_time();
		pop_first();
	}
	else if (freq_agent&&eco_agent == false && freq_time == 0 && size_eco() > 0)
	{
		freq_agent = false;
		freq_time = service_time();
		pop_eco();
	}
	else if (freq_time>0)
	{
		freq_time--;
		if (freq_time == 0)
		{
			freq_agent = true;
		}
	}
	return;
}

template <class type>
void airline<type>::first_load() //manage airline freq queue
{
	if (first_agent&&first_time == 0 && size_first() > 0)
	{
		first_agent = false;
		first_time = service_time();
		pop_first();
	}
	else if (first_agent&&freq_agent == false && first_time == 0 && size_freq() > 0)
	{
		first_agent = false;
		first_time = service_time();
		pop_freq();
	}
	else if (first_agent&&eco_agent == false && first_time == 0 && size_eco() > 0)
	{
		first_agent = false;
		first_time = service_time();
		pop_eco();
	}
	else if (first_time>0)
	{
		first_time--;
		if (first_time == 0)
		{
			first_agent = true;
		}
	}
	return;
}

template <class type>
void airline<type>::calc_queue()
{
	type one = 0, two = 0, three = 0, onesize = 0, twosize = 0, threesize = 0;
	onesize = eco_counter.size();
	twosize = freq_counter.size();
	threesize = first_counter.size();
	while (eco_counter.size() != 0)
	{
		one = one + eco_counter.front();
		eco_counter.pop();
	}
	while (freq_counter.size() != 0)
	{
		two = two + freq_counter.front();
		freq_counter.pop();
	}
	while (first_counter.size() != 0)
	{
		three = three + first_counter.front();
		first_counter.pop();
	}
	std::cout << "Largest size of Economy Line: " << size_eco() << endl;
	std::cout << "Economy Avg Line Length: " << (one / onesize) << endl;
	std::cout << "Largest size of Frequent Flyer Line: " << size_freq() << endl;
	std::cout << "Frequent Flyer Avg Line Length: " << (two / twosize) << endl;
	std::cout << "Largest size of First Class Line: " << size_first() << endl;
	std::cout << "First Class Avg Line Length: " << (three / threesize) << endl;
	std::cout << endl;
	return;
}
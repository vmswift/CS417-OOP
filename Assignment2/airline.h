/*
Class: CS417 OOP
Instructr: Dr. Lewis
File: airline.h
Description: Header file code used to outline code in the implementation file etc.
This code is used in an effort to resolve the problem statement listed
under Assignment 2 in CS417 OOP.
*/
#pragma once
#include <queue>
#include <iomanip>
//#include "airline.cpp"
template <class type> class airline
{
private:
	type time;
	bool first_agent, freq_agent, eco_agent;
	int  first_size, freq_size, eco_size;
	int  first_count, freq_count, eco_count;
	int  first_time, freq_time, eco_time;
	std::queue<type> first, freq, eco;
	std::queue<type> first_counter, freq_counter, eco_counter;
	void push(std::queue<type>& myQ) { myQ.push(1); };
	void pop(std::queue<type>& myQ) { myQ.pop(); };
	type front(std::queue<type>& myQ) { if (myQ.size()>0) { return myQ.front(); } else { return 0; } };
	type size(std::queue<type>& myQ) { return myQ.size(); };
	int service_time() { return (rand() % 10 + 2); };
	void inc_agent_time() { first_count++; eco_count++; freq_count++; };
	void eco_load();
	void freq_load();
	void first_load();
public:
	airline(type value) { time = value; first_agent = true; freq_agent = true; eco_agent = true; first_size = 0; freq_size = 0; eco_size = 0; first_count = 0; freq_count = 0; eco_count = 0; eco_time = 0; freq_time = 0; first_time = 0; };
	//~airline() {};
	void push_first() { push(first); };
	void push_freq() { push(freq); };
	void push_eco() { push(eco); };
	void pop_first() { pop(first); };
	void pop_freq() { pop(freq); };
	void pop_eco() { pop(eco); };
	type front_first()  { return front(first); };
	type front_freq() { return front(freq); };
	type front_eco() { return front(eco); };
	type size_first() { return size(first); };
	type size_freq() { return size(freq); };
	type size_eco() { return size(eco); };
	bool first_available() { return first_agent; };
	bool freq_available() { return freq_agent; };
	bool eco_available() { return eco_agent; };
	void set_first_agent(bool myAgent) { first_agent = myAgent; };
	void set_freq_agent(bool myAgent) { freq_agent = myAgent; };
	void set_eco_agent(bool myAgent) { eco_agent = myAgent; };
	void increment_first() { first_size++; };
	void increment_freq() { freq_size++; };
	void increment_eco() { eco_size++; };
	type get_max_first() { return first_size; };
	type get_max_freq() { return freq_size; };
	type get_max_eco() { return eco_size; };
	type get_total_size() { return (get_max_eco() + get_max_freq() + get_max_first()); }
	void manage_queue();
	void calc_queue();
};
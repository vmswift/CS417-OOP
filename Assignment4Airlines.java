//Assignment 04 CS417
//Painful Airlines Ticketing Terminal
//Fall 2016
//Description: Remake of Assignment 02
//in using Java and not C++
import java.util.*;

public class Airlines {
	Integer time = 0;
	Boolean first_agent = true, freq_agent =true, eco_agent = true;
	Integer first_size = 0, freq_size = 0, eco_size = 0,
			first_count = 0, freq_count = 0, eco_count = 0,
			first_time = 0, freq_time = 0, eco_time = 0;
	Queue<Integer>   first = new LinkedList<Integer>(),
			freq  = new LinkedList<Integer>(),
			eco   = new LinkedList<Integer>(),
			first_counter = new LinkedList<Integer>(),
			freq_counter = new LinkedList<Integer>(),
			eco_counter = new LinkedList<Integer>();
	
	public Airlines(){
		time = readTime();
	}
	
	void push(Queue<Integer> myQueue){
		myQueue.add(1);
	}
	
	void pop(Queue<Integer> myQueue){
		myQueue.remove();
	}
	
	int size(Queue<Integer> myQueue){
		return myQueue.size();
	}
	
	
	int service_time(){
		return (2 + (int)(Math.random() * 10));
	}
	
	void inc_agent_time(){
		first_count++;
		freq_count++;
		eco_count++;
	}
	
	void push_first(){
		push(first);
	}
	
	void push_freq(){
		push(freq);
	}
	
	void push_eco(){
		push(eco);
	}
	
	void pop_first(){
		pop(first);
	}
	
	void pop_freq(){
		pop(freq);
	}
	
	void pop_eco(){
		pop(eco);
	}
	
	int size_first(){
		return size(first);
	}
	
	int size_freq(){
		return size(freq);
	}
	
	int size_eco(){
		return size(eco);
	}
	
	void increment_first(){
		first_size++;
	}
	
	void increment_freq(){
		freq_size++;
	}
	
	void increment_eco(){
		eco_size++;
	}
	
	int get_max_first(){
		return first_size;
	}
	
	int get_max_freq(){
		return freq_size;
	}
	
	int get_max_eco(){
		return eco_size;
	}
	
	public int readTime(){
		Integer temp = 0;
		System.out.print("Enter number of time ticks: ");
		Scanner console = new Scanner(System.in);
		temp = console.nextInt();
		console.close();
		return temp;
	}
	
	void eco_load(){
		if(eco_agent&&eco_time==0&&eco_size>0){
			eco_agent = false;
			eco_time = service_time();
			pop_eco();
		}
		else if(eco_time>0){
			eco_time--;
			if(eco_time==0){
				eco_agent = true;
			}
		}
	}
	
	void freq_load(){
		if(freq_agent&&freq_time==0&&size_freq()>0){
			freq_agent = false;
			freq_time = service_time();
			pop_freq();
		}
		else if(freq_agent&&first_agent==false&&freq_time==0&&size_first()>0){
			freq_agent = false;
			freq_time = service_time();
			pop_first();
		}
		else if(freq_agent&&eco_agent==false&&freq_time==0&&size_eco()>0){
			freq_agent = false;
			freq_time = service_time();
			pop_eco();
		}
		else if(freq_time>0){
			freq_time--;
			if(freq_time==0){
				freq_agent = true;
			}
		}
	}
	
	void first_load(){
		if(first_agent&&first_time==0&&size_first()>0){
			first_agent = false;
			first_time = service_time();
			pop_first();
		}
		else if(first_agent&&freq_agent==false&&first_time==0&&size_freq()>0){
			first_agent = false;
			first_time = service_time();
			pop_freq();
		}
		else if(first_agent&&eco_agent==false&&first_time==0&&size_eco()>0){
			first_agent = false;
			first_time = service_time();
			pop_eco();
		}
		else if(first_time>0){
			first_time--;
			if(first_time==0){
				first_agent=true;
			}
		}
	}
	
	
	//manages queue and calls eco_load(), freq_load(), first_load()
	public void manage_queue(){
		Integer count = 0;
		System.out.println("Eco      Freq       First");
		System.out.println("--------------------------");
		while(count<time){
			inc_agent_time();
			if(eco_count==1){
				push_eco();
				increment_eco();
				eco_count = 0;
			}
			if(freq_count==5){
				push_freq();
				increment_freq();
				freq_count = 0;
			}
			if(first_count==20){
				push_first();
				increment_first();
				first_count = 0;
			}
			eco_counter.add(size_eco());
			freq_counter.add(size_freq());
			first_counter.add(size_first());
			System.out.println(size_eco() + "         " + size_freq() + "           " + size_first());
			if(first_agent||freq_agent||eco_agent){
				eco_load();
				freq_load();
				first_load();
			}
			count++;
		}
		
	}
	
	
	//calculates and prints avg and max of each line
    public void calc_queue(){
    	int one = 0, two = 0, three = 0,
    	    onesize = 0, twosize = 0, threesize = 0;
    	onesize = eco_counter.size();
    	twosize = freq_counter.size();
    	threesize = first_counter.size();
    	while(eco_counter.size()!=0){
    		one = one + eco_counter.element();
    		eco_counter.remove();
    	}
    	while(freq_counter.size()!=0){
    		two = two + freq_counter.element();
    		freq_counter.remove();
    	}
    	while(first_counter.size()!=0){
    		three = three + first_counter.element();
    		first_counter.remove();
    	}
    	System.out.println("Largest size of Economy Line: " + size_eco());
    	System.out.println("Economy Avg Line Length: " + (one/onesize));
    	System.out.println("Largest size of Frequent Flyer Line: " + size_freq());
    	System.out.println("Frequent Flyer Avg Line Length: " + (two/twosize));
    	System.out.println("Largest size of First Class Line: " + size_first());
    	System.out.println("First Class Avg Line Length: " + (three/threesize));
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Airlines myAir = new Airlines();
		myAir.manage_queue();
		myAir.calc_queue();
		
	}

}

package misc;

/**
 * Toy interface.
 */
interface Toy {
	void talk();
}

/**
 * Dog class.
 */
class Dog implements Toy {
	public void talk() {
		System.out.println("Wow");
	}
}

/**
 * Cat class.
 */
class Cat implements Toy {
	public void talk() {
		System.out.println("Meow");
	}
}

public class ToyFactory_I496E {
	public Toy getToy(String type) {
		if ("Dog".equals(type)) {
			return new Dog();
		} else if ("Cat".equals(type)) {
			return new Cat();
		} else {
			return null;
		}
	}
	
	public static void main(String[] args) {
		ToyFactory_I496E obj = new ToyFactory_I496E();
		Toy toy = obj.getToy("Dog");
		toy.talk();	// Wow
		toy = obj.getToy("Cat");
		toy.talk();	// Meow
	}
}

/**
 * LintCode #496
 * Factory is a design pattern in common usage. 
 * Please implement a ToyFactory which can generate proper toy based on the given type.
 * ToyFactory tf = ToyFactory();
 * Toy toy = tf.getToy('Dog');
 * toy.talk(); 
 * >> Wow
 * toy = tf.getToy('Cat');
 * toy.talk();
 * >> Meow
 */


Scala

1.	What is Scala Option? Example of it. 
2.	What is a case class in Scala?
3.	What is ‘trait’ in Scala? When can you use traits?
4.	What is Companion object? Example of it in Scala. 
5.	What is difference between IndexedSeq and LinearSeq? 
6.	What is the difference between var and value? 
7.	What is “Type Inference” in Scala? 
8.	What is Null in Scala? What is null in Scala? What is difference between Null and null in Scala? 
9.	What is Unit in Scala? 
10.	List list = new LinkedList() 
list.add(1) 
Integer i = list.iterator().next() 
Do you see any problem with this code? 
11.	What is the super class of all classes in Scala? 
12.	What are implicit parameters in Scala?
13.	What are various Traits and Classes available in Scala collections?
14.	What is HashMap in Scala Collections?
15.	What is recursion tail in Scala?
16.	What is function currying in Scala?
17.	What is a closure in Scala?
18.	What is Scala anonymous function?

 
Python

1.	How would you define a constructor in Python? 
2.	Is it possible to declare a variable as fully private? How? 
3.	How is data class defined in Python? 
4.	Create an employee class with employeeId and employeeName as the variables. 
5.	How to store data in key-value format in python? 
6.	How can you achieve data serialization in python? Name few techniques. 
7.	Write a function to return a value from the dictionary where key starts with "IBM*". Example: dict= {"IBM_ID":"0652C6744", "Name":"John"} 
8.	What would be the output of this?
 >>> x=1 
>>> x,y=x+1,x+1 
>>> x,y
9.	When you exit Python, is all memory deallocated? 
10.	What do you mean by *args and **kwargs? 
11.	When to use Abstract Base Class? Give an example to define it. 
12.	What is yield keyword in Python?

 
Coding Questions

1.	Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

2.	Given a string S, return the substrings of length K with no repeated characters.
Input: S = "havefunonleetcode", K = 5
Output:  'havef','avefu','vefun','efuno','etcod','tcode'

3.	Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases. 
For example, "A man, a plan, a canal: Panama" is a palindrome. "race a car" is not a palindrome.

4.	Return the prime numbers less than a non-negative number, n.
Input: 10
Output: 2, 3, 5, 7
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7

5.	Given a list of non-negative integers, arrange them such that they form the largest number.
Input: [10,2]
Output: "210"

Input: [3,30,34,5,9]
Output: "9534330"

6.	Given a positive integer num, write a function which returns True if num is a perfect square else False. Do not use any built-in library function such as sqrt.
Input: num = 16
Output: true

Input: num = 14
Output: false

7.	Write a function that reverses a string. The input string is given as an array of characters.
Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
Input: ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]

8.	Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
Input: nums = [1,1,1], k = 2
Output: 2

9.	Let us assume a list of Employees containing Name, Department, and Years of Service (YoS). Please implement in your choice of language:
1 - Employee object
2 - Sort a list of employees (assumed to already be filled) on Name
3 - Method (not using any built-in sorting) to sort on Department, YoS, and Name (in that order).
You can use any algorithm you want, but please describe which algorithm you chose, and why?

10.	Write a function to calculate number of prime numbers/odd numbers/even numbers between two input numbers provided as input.


 
Snowflake

1.	Describe High level architecture of Snowflake data warehouse system.
2.	What are the three types of caching and how it impacts performance?
3.	How does table clone work in snowflake? Does it use additional storage?
4.	What are the advantages of micro-partitions and how would to select candidate column for clustering a table?
5.	Have you implemented RBAC in Snowflake? Please provide an example.
6.	When would you use Snowpipe vs Bulk load ( copy ) method and why?
7.	What SQL functions would you use to flatten XML data embedded in JSON? Describe an approach.

Azure

1.	Do you have experience using ADF? If yes, please provide  high-level steps to create a pipeline.
2.	Given a specific scenario of copying data from Azure SQL to Gen2 to Snowflake using ADF, please describe your approach on setting up this pipeline.
3.	How would you parallelize the activities in a pipeline given large number of tables to be replicated?
4.	What would be the authentication mechanism for each source and target give a pair of platforms in the pipeline?
5.	Have you setup alert and monitoring in ADF and how is it done?
6.	Have you done data validation to ensure accuracy from source to target? Please provide details.
7.	Have you implemented Azure functions and integrated with ADF?
8.	Any exposure to Cosmos DB?
9.	Have you called Azure Databricks notebook from ADF? Please provide an example of that functionality.
10.	How would you pass parameters to notebook?



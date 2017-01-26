package com.pace.university;

import java.util.Scanner;
/*
 * UniversityForMeAlgorithm.java is class used to find universities by 
 * id, name, course name or ratings. 
 * @author Ayushi Desai
 * @version 1.0
 */

public class UniversityForMeAlgorithm {
	Node head;
	Node tail;
	int count=0;
	static Scanner n=new Scanner(System.in);
	
	
// linkedlist hashmap	
	public class Node{
		Node head;
		Node tail,next,pre;
		int data;
		String universityName;
		int numberOfCouces;
		String Cources;
		String rating;
		Node(int i,String s, int numberOfCouces, String Cources, String rating){
			data=i;
			universityName=s;
			this.numberOfCouces=numberOfCouces;
			this.Cources=Cources;
			this.rating=rating;
		}
	}
	/**
	 * This method is used to add list universities, ratings and courses to internal hashmaps.
	 * @param i  University Id
	 * @param universityName Name of university
	 * @param numberOfCourses number of courses
	 * @param Courses courses in university passed as comma-delimited string for e.g. "xxx,yyy,zzz"
	 * @param rating passed number of stars for e.g "***"
	 */
	
	public void add(int i, String universityName, int numberOfCourses, String courses, String rating) {
		Node s=head;
		Node n=new Node(i,universityName, numberOfCourses, courses, rating);
		char status=keyValidation(i);
		int size=size();
		if(size==0){
			n.next=head;
			n.pre=null;
			head=n;
			tail=n;
			count++;
		}else{
			if(status=='y'){
				n.next=s;
				n.pre=null;
				head=n;
			}else System.err.println("Key "+i+" already exsist");
		}
	}
	/*
	 * This method is used to show all attributes of all universities.
	 */
	
	public void showAll(){
		Node s=head;
		if(s!=null){ 
			while(s!=null){
				System.out.println("\nUniv ID: "+s.data+", \n\tUniversity Name: "+s.universityName);
				System.out.println("\tTotal number of Courses: "+s.numberOfCouces);
				System.out.println("\tClasses Name in University are: "+s.Cources);
				System.out.println("\tUniversity rating: "+s.rating);
				System.out.println();
				s=s.next;
			}
		}else System.out.println("EMPTY MAP");
		System.out.println("\n");
	}
	/*
	 * this method is used to find highest rated university. 
	 */
	private void highestRating() {
		Node temp=head;
		Node s=head.next;
		int temp2=0;
		Node high = null;
		while(s!=null){

			if(temp.rating.length()>s.rating.length() && temp.rating.length()>temp2 && temp.rating.length()>temp2){

				temp2=temp.rating.length();
				high=temp;
			}
			s=s.next;
			temp=temp.next;
		}
		System.out.println(high.universityName+" has highest RATING and that is "+high.rating);
	}
	/*
	 * this method checks for duplicate key 
	 */
	public char keyValidation(int i) {
		Node s=head;
		char status = 'c';
		while(s!=null){
			if(s.data==i){
				System.out.println();
				status='n';
				break;
			}else status='y'; 
			s=s.next;
		}
		return status;
	}
	/*
	 * This method is used to search the universities by key
	 */
	public void search(int i){
		Node s=head;
		char status='C';
		while(s.data!=i){
			s=s.next;
			if(s==tail && s.data!=i){
				status='N';
				System.err.println("\nID "+i+" is not present in List. Hence, nothing to show.\n");
				break;
			}else status='Y';
		}
		if(status=='Y'){
			System.out.println("\nUniv ID: "+s.data+", \n\tUniversity Name: "+s.universityName);
			System.out.println("\tNumber of Courses university offer: "+s.numberOfCouces);
			System.out.println("\tCourses university offer are: "+s.Cources);
			System.out.println("\tUniversity Rating: "+s.rating);
			System.out.println();
		}
	}
	/*
	 * search university by Name 
	 */
	public void searchByUnivName(){
		Node s=head;
		char status='C';
		Scanner n=new Scanner(System.in);
		String univName=n.nextLine();
		while(s!=null){
			if(s.universityName.contains(univName)){
				System.out.println("Univ ID: "+s.data+", \n\tUniversity Name: "+s.universityName);
				System.out.println("\tNumber of Courses university offer: "+s.numberOfCouces);
				System.out.println("\tCourses university offer are: "+s.Cources);
				status='y';
			}
			s=s.next;
		}
		if(status=='y'){
		}else{
			System.out.println("Please enter correct name (Name is case sensitive)");
		}



		//		Node s=head;
		//		while(s.universityName!=universityName){
		//			s=s.next;
		//		}
		//		System.out.println("Searched Id for "+universityName+": "+s.data+"\n");
	}
	
	/*
	 * this method is used to search universities by key and name
	 */
	public void search(int i, String universityName){
		Node s=head;
		while(s.data!=i && s.universityName!=universityName){
			s=s.next;
		}
		System.out.println("Searched name for "+i+" ID is: "+s.universityName);
	}
	
	/*
	 * This method is used to search universities by course names.
	 */
	public void searchCourse(){

		String courceNameInUniv=n.next();
		Node s=head;
		while(s!=null){
			if(findCourse(s.Cources,courceNameInUniv)){
				System.out.println(courceNameInUniv+" is available in "+s.universityName+""
						+ "\n\t Rating: "+s.rating);
			}
			s=s.next;
		}
	}
	private boolean findCourse(String cources, String courceNameInUniv) {
		boolean status=true;

		if(cources.contains(courceNameInUniv)) status=true;
		else status=false;

		return status;

	}

	public void objectRemove(int i){
		Node s=head;
		Node temp = null;
		if(s.data==i){
			head=s.next;
			System.out.println("\nObject with id "+i+" is removed\n");
		}
		else{ 
			while(s.data!=i){
				temp=s;
				s=s.next;
				if(s==tail && s.data!=i){
					System.err.println("\nID "+i+" is not present in List. Hence, nothing to remove.\n");
					break;
				} else {
				}
			}
			temp.next=s.next;
		}

	}
	public int size(){
		Node s=head;
		int count=0;
		while(s!=null){
			s=s.next;
			count++;
		}
		return count;
	}

	public void clearfindUniversityForMeAlgorithm(){
		head.next=null;
		head.pre=null;
		head=null;
		showAll();
	}
	/*
	 * This method is used to modify name of university using University ID. 
	 */
	private void modifyNameAtKey() {
		System.out.println("Enter University ID whoes name needs to be changed");
		int key=n.nextInt();
		System.out.println("Enter New changed name of University:");
		String mn;
		mn=n.next();
		Node s=head;
		if(s==null)System.out.println("Empty findUniversityForMeAlgorithm");
		else{ 
			while(s.data!=key){
				s=s.next;
			}
			s.universityName=mn;
		}
		showAll();
	}
	/*
	 * Private Method : this method is used to find universities by highest number of courses.
	 */
	private void highestCourseNumber() {

		Node temp=head;
		Node s=head.next;
		int temp2=0;
		Node high = null;
		while(s!=null){

			if(temp.numberOfCouces>s.numberOfCouces && temp.numberOfCouces>temp2 && temp.numberOfCouces>temp2){

				temp2=temp.numberOfCouces;
				high=temp;
			}
			s=s.next;
			temp=temp.next;
		}
		System.out.println(high.universityName+" has highest number of courses and that is "+high.numberOfCouces);
	}
	/*
	 * This is main metho, providing menu of options.
	 */
	public static void main(String[] args) {
		System.out.print("\nThis is an Algorithm to find an University for user:\n\n\tPlease enter your name: ");
		String user=n.nextLine();
		System.out.println("___________________________________________________________________________________________________________________________\n");
		System.out.println("\nWelcome "+user+"... \n\tLets find an University for you");
		UniversityForMeAlgorithm hh=new UniversityForMeAlgorithm();
		int count1=0;
		hh.add(1001,"Pace University", 30, "Algorithm, DBMS, InternetComputing, HTML, CSS, JavaScript, PHP, Python","*");		
		hh.add(1002,"New Jersey Institute of Technology", 29,"JSP, InternetComputing, JavaScript","**");		
		hh.add(1003,"New York Institute of technology", 41,"JS, DBMS, JavaScript, Algorithm","***");		
		hh.add(1004,"Long Iland University", 33,"Php, Python","****");
		hh.add(1005,"Turo University", 100, "HTML, CSS, JavaScript","*****");	
		hh.add(1006,"New York University of polytechnique", 32,"Python, Rubi","**********");
		System.out.println("\nWhich method would you like to go with:"
				+ "\n\t Method 1: Find by Univerity ID"
				+ "\n\t Method 2: Find by University Name"
				+ "\n\t Method 3: Find by Course Name"
				+ "\n\t Method 4: Find univ has highest number of coures"
				+ "\n\t Method 5: Find univ has highest Rating"
				+ "\n\t Method 6: Empty the list of Universities in DataBase"
				+ "\n\t Method 7: Modify the name of University"
				+ "\n\t Method 8: Show all Universities"
				+ "\n\t Method 9: Exit"
				);
		int exit=1;
		while(exit==1){
			if(count1==0){
				System.out.print("\n\t Please enter method number: ");
				System.out.println("\n___________________________________________________________________________________________________________________________\n");
				count1++;
			}else{
				System.out.println("___________________________________________________________________________________________________________________________\n");
				System.out.print("Want to Search Again...\n\tEnter Method Number: ");
			}
			int metNo=n.nextInt();
			switch (metNo) {
			case 1:  {
				System.out.print("Please enter University ID: ");
				int id=n.nextInt();
				hh.search(id);
			}
			break;
			case 2: {
				System.out.println("Please enter University Name: ");
				hh.searchByUnivName();
			}
			break;
			case 3: {
				System.out.println("Please enter Course you want");
				hh.searchCourse();
			}
			break;
			case 4:  
				hh.highestCourseNumber();
				break;
			case 5:  
				hh.highestRating();
				break;
			case 6:  
				hh.clearfindUniversityForMeAlgorithm();
				break;
			case 7:  
				hh.modifyNameAtKey();
				break;
			case 8:  
				hh.showAll();
				break;
			case 9:{  
				exit=100;
				System.out.println("Thank You for using Ayushi's Algorithm to find University"
						+ "\n\tThe Program is Terminated....");
				System.out.println("\n___________________________________________________________________________________________________________________________\n");
			}
			break;
			default: System.out.println("Invalid Entry");
			break;
			}
		}
	}
}


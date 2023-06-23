package practice;

import java.util.Scanner;

public class Prime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a num:");
		int num=sc.nextInt();
		int temp=0;
		for(int i=1;i<=num;i++) {
			if(num%i==0) {
				temp++;
			}
		}
			if(temp==2) {
				System.out.println(num+" is a prime num");
			}
			else {
				System.out.println(num+"is not a prime num");
			}
			
		}

	}



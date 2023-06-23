package practice;

import java.util.Scanner;

public class Prime_num {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a num:");
		int num=sc.nextInt();
		int temp;
		for(int i=2;i<=num;i++) {
			temp=0;
		
			for(int j=2;j<=i/2;j++) {
				if(i%j==0) {
			
				temp++;
				break;
			}
				
			}
			if(temp==0) {
				System.out.println(i);
			}	
				
		}
		}
	}

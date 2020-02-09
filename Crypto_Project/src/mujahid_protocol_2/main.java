package mujahid_protocol_2;

import java.text.ParseException;
import java.util.concurrent.TimeUnit;
import java.math.BigInteger;

public class main {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		reader r = new reader();
		tag t1 = new tag();
		r.change(t1.getIDS(t1), 1);
		r.Getk1k2();
		t1.change(r.getk1(r),3);
		t1.change(r.getk2(r),4);
		BigInteger ch = new BigInteger("-1");
		//System.out.println("here1");
		r.calculatek11k22();
		if(((r.getk1(r))==ch)||((r.getk2(r))==ch))
		{
			System.out.println("IDS not found, protocol session terminated"+" "+r.getk1(r)+" "+r.getk2(r));
		}
		else
		{	
			//System.out.println("here2");
			r.calculateABC();
			t1.change(r.geta(r), 0);
			t1.change(r.getb(r), 1);
			t1.change(r.getc(r), 2);
			t1.calculaten1n2();
			t1.calculateSeed();
			t1.calculatek11k22();
			t1.calculateC1();
			//System.out.println("here3");
			//if(r.getc(r)==t1.getc1(t1))
			//{
				t1.calculateD();
				r.change(t1.getd(t1),0);
			//}
			//else
			//{
			//	System.out.println("Illegimate Reader");
			//}
		}
		long stopTime = System.nanoTime();
		System.out.println("Execution time: "+((stopTime - startTime)/(Math.pow(10, 6)) + " ms"));
		
	}
	
}


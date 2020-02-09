package proposed_protocol;

import java.math.BigInteger;
import java.util.Random;

public class reader {
	public String mess;
	private Random rand = new Random();
	private BigInteger t = new BigInteger(96, rand);
//	private int t = rand.nextInt((int)(Math.pow(2.0, 30.0)));
	private BigInteger tHW = hammingWt(t);
	private BigInteger a,b,c,d;
	private BigInteger IDS, k;
	

	
	void change(BigInteger k, int id) {
		if(id == 0)
		{
			a = k;
		}
		else if(id == 1)
		{
			b = k;
		}
		else if(id == 2)
		{
			c = k;
		}
		else if(id == 3)
		{
			d = k;
		}
		else
		{
			System.out.println("Invalid id!! Try again.");
		}
		
	}
	
	private BigInteger hammingWt(BigInteger n) {
		BigInteger l = new BigInteger("0");
		while(n.compareTo(new BigInteger("0"))==1)
		{
			if(n.and(new BigInteger("1")).equals((new BigInteger("1"))))
				l = l.add(new BigInteger("1"));
			n = n.divide(new BigInteger("2"));
		}
		return l;
	}
	
	BigInteger gett(reader r) {
//		System.out.println(t);
		return r.t;
	}
	BigInteger geta(reader r)
	{
		return r.a;
	}
	BigInteger getb(reader r)
	{
		return r.b;
	}
	BigInteger getIDS(reader r)
	{
		return r.IDS;
	}
	BigInteger getk(reader r)
	{
		return r.k;
	}
	BigInteger getc(reader r)
	{
		return r.c;
	}
	BigInteger getd(reader r)
	{
		return r.d;
	}
	
	
	void updateIDSk(BigInteger a, BigInteger b)
	{
		IDS = a;
		k = b;
	}
	void updateCD(BigInteger a, BigInteger b)
	{
		c = a;
		d = b;
//		System.out.println(c + " " + d);
	}
	
}

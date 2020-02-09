package proposed_protocol;

import java.math.BigInteger;
import java.util.Random;

public class node {
	private BigInteger a,b,t;
	private BigInteger c,d;
	private BigInteger IDS, k;
	private Random rand = new Random();
	private BigInteger z = new BigInteger(96, rand);
	private BigInteger nHW = new BigInteger("0"), nHW1, tHW, kHW;
	private BigInteger IDSHW;
	BigIntWrapper wrap = new BigIntWrapper();
	StringUtil sha = new StringUtil();
	private String hash;
	
	BigInteger hammingWt(BigInteger n) {
		BigInteger l = new BigInteger("0");
		while(n.compareTo(new BigInteger("0"))==1)
		{
			if((n.and(new BigInteger("1"))).equals((new BigInteger("1"))))
			{
				l = l.add(new BigInteger("1"));
//				System.out.println(n.and(new BigInteger("1")));
			}
			n = n.divide(new BigInteger("2"));
		}
		return l;
	}
	
	void change(BigInteger k, int id) {
		if(id == 0)
		{
			a = k;
//			System.out.println(a);
		}
		else if(id == 1)
		{
			b = k;
//			System.out.println(b);
		}
		else if(id == 2)
		{
			c = k;
		}
		else if(id == 3)
		{
			d = k;
		}
		else if(id == 4)
		{
			t = k;
//			System.out.println(t);
		}
		else
		{
			System.out.println("Invalid id!! Try again.");
		}
				
	}
	
	BigInteger geta(node n)
	{
		return n.a;
	}
	
	BigInteger getb(node n)
	{
		return n.b;
	}
	BigInteger getIDS(node n)
	{
		return n.IDS;
	}
	BigInteger getk(node n)
	{
		return n.k;
	}
	BigInteger gett(node n)
	{
		return n.t;
	}
	BigInteger getc(node n)
	{
		return n.c;
	}
	BigInteger getd(node n)
	{
		return n.d;
	}
	BigInteger getnHW(node n)
	{
		return n.nHW1;
	}
	BigInteger getz(node n)
	{
		return n.z;
	}
	
	
	void updateIDSk(BigInteger a, BigInteger b)
	{
		IDS = a;
		k = b;
	}
	
	void calculateCD()
	{
//		c = Integer.rotateLeft(t, IDSHW^kHW) ^ Integer.rotateLeft(z, kHW);
		c = wrap.rotateLeft(t, IDSHW.xor(kHW).intValue()).xor(wrap.rotateLeft(z, kHW.intValue()));
//		d = Integer.rotateLeft(z, IDSHW) ^ Integer.rotateLeft(t, kHW);
		d = wrap.rotateLeft(z, IDSHW.intValue()).xor(wrap.rotateLeft(t, kHW.intValue()));
//		System.out.println(c + " " + d);
	}
	
	void print1()
	{
		System.out.println(IDS);
		System.out.println(IDSHW);
	}
	
	void updateHW(BigInteger a, BigInteger b, BigInteger c)
	{
		tHW = a;
		IDSHW = b;
		kHW = c;
	}
	void updatenHW(BigInteger a)
	{
		nHW1 = a;
	}
	void register_hash()
	{
		hash = sha.applySha256(IDS.toString() + k.toString() + nHW1.toString());
//		System.out.println(hash);
	}
	void authenticate()
	{
		int flag = 0;
		for(;;nHW = nHW.add(new BigInteger("1")))
		{
//			System.out.println(sha.applySha256(IDS.toString() + k.toString() + nHW.toString()) + " " + sha.applySha256(IDS.toString() + k.toString() + nHW1.toString()));
			if(sha.applySha256(IDS.toString() + k.toString() + nHW.toString()).equals(sha.applySha256(IDS.toString() + k.toString() + nHW1.toString())))
			{
				flag = 1;
				break;
			}
		}
		System.out.println("node authentication successful");
	}
}

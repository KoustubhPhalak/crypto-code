package mujahid_protocol_1;

import java.util.Random;
import java.math.BigInteger;
import java.lang.Math;

public class reader {
	public String mess;
	private Random rand = new Random();
	private BigInteger n1 = new BigInteger(96, rand);
	private BigInteger n2 = new BigInteger(96, rand);
	private BigInteger k1,k2,a,b,c,d,IDS;
	private BigInteger seed=(hammingWt((n1.xor(n2))));
	private BigInteger k11;
	private BigInteger k22;
	BigIntWrapper wrap = new BigIntWrapper();
	node n = new node();

	void change(BigInteger k, int id) {
		if(id == 0)
		{
			d = k;
		}
		else if(id == 1)
		{
			IDS = k;
		}
		else
		{
			System.out.println("Invalid id!! Try again.");
		}
		
	}
	
	void Getk1k2()
	{
		k1 = n.getK1_1(IDS);
		k2 = n.getK2_1(IDS);
		//System.out.println(k1 + " " + k2);
	}

	BigInteger geta(reader r)
	{
		return r.a;
	}
	BigInteger getb(reader r)
	{
		return r.b;
	}
	BigInteger getc(reader r)
	{
		return r.c;
	}
	BigInteger getk1(reader r)
	{
		return r.k1;
	}
	BigInteger getk2(reader r)
	{
		return r.k2;
	}
	

	BigInteger kasamicode(BigInteger ll)
	{
		//System.out.println(seed+" "+ll );
		BigInteger y = wrap.rotateLeft(ll,Math.abs(seed.intValue()));
		//System.out.println(y.toString(2));
		//System.out.println(ll.toString(2));
		//System.out.println(ll.xor(y).toString(2));
		return ll.xor(y);
	}
	

	void calculatek11k22(){
		//System.out.println(k1 + " " + k2 + " " + n1 + " " + n2);
		BigInteger k10 = kasamicode(k1);
		BigInteger n10 = kasamicode(n1);
		BigInteger k20 = kasamicode(k2);
		BigInteger n20 = kasamicode(n2);
		//System.out.println(k10 + " " + n10 + " "+ k20 + " "+ n20);
		k11=wrap.rotateLeft(k10,Math.abs(n10.intValue())).xor(k2);
		k22=wrap.rotateLeft(k20,Math.abs(n20.intValue())).xor(k1);
	

	}

	void calculateABC() {
		a = wrap.rotateLeft(wrap.rotateLeft(n1.xor(k2), Math.abs((IDS.xor(k1)).intValue())), Math.abs(k2.intValue()));
		b = wrap.rotateLeft(wrap.rotateLeft(n2.xor(k1), Math.abs((k2.xor(IDS)).intValue())), Math.abs((k1.xor(n1)).intValue()));
		c=wrap.rotateLeft(wrap.rotateLeft(kasamicode(n1), Math.abs((kasamicode(k22).xor(kasamicode(n2))).intValue())), Math.abs((kasamicode(k11).xor(n2)).intValue()));
		//System.out.println(n1+" "+n2);
	
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
		
}

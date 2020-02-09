package mujahid_protocol_1;

import java.util.Random;
import java.math.BigInteger;
import java.lang.Math;

public class tag 
{
	private BigInteger a,b,c,d,p,n1,n2,c1,k11,k22;
	private BigInteger IDS = new BigInteger("5");
	private BigInteger k1;
	private BigInteger k2;
	BigIntWrapper wrap = new BigIntWrapper();
	
	void change(BigInteger k, int id)
	{
					
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
			k1 = k;
		}
		else if(id == 4)
		{
			k2 = k;
		}
		else
		{
			System.out.println("Invalid id!! Try again.");
		}

	}

	
	BigInteger getd(tag t)
	{
		return t.d;
	}
	BigInteger getIDS(tag t)
	{
		return t.IDS;
	}
	BigInteger getc1(tag t)
	{
		return t.c1;
	} 

	
	void calculaten1n2()
	{
		n1=wrap.rotateRight(wrap.rotateRight(a,Math.abs(k2.intValue())),Math.abs((IDS.xor(k1)).intValue())).xor(k2);
		//n2=wrap.rotateRight(wrap.rotateRight(b,Math.abs(k1.xor(n1)).intValue())),Math.abs((IDS.xor(k2)).intValue())).xor(k1);
		n2=wrap.rotateRight(wrap.rotateRight(b, Math.abs(k1.xor(n1).intValue())), Math.abs(IDS.xor(k2).intValue())).xor(k1);
		//System.out.println(n1+" "+ n2);
	}

	private BigInteger seed;
	
	void calculateSeed(){
	
		seed = (hammingWt((n1.xor(n2)))); 

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
	

	void calculatek11k22()
	{
		//System.out.println(k1 + " " + k2 + " " + n1 + " " + n2);
		BigInteger k10 = kasamicode(k1);
		BigInteger n10 = kasamicode(n1);
		BigInteger k20 = kasamicode(k2);
		BigInteger n20 = kasamicode(n2);
		//System.out.println(k10 + " " + n10 + " "+ k20 + " "+ n20);
		k11=wrap.rotateLeft(k10,Math.abs(n10.intValue())).xor(k2);
		k22=wrap.rotateLeft(k20,Math.abs(n20.intValue())).xor(k1);
	}

	void calculateC1() {
		//System.out.println(n2+" "+k11+" "+k22+" "+n1);
		//System.out.println(k1+" "+k2);
		c1=wrap.rotateLeft(wrap.rotateLeft(kasamicode(n1), Math.abs((kasamicode(k22).xor(kasamicode(n2))).intValue())), Math.abs((kasamicode(k11).xor(n2)).intValue()));
		
	}

	void calculateD()
	{
		d=wrap.rotateLeft(wrap.rotateLeft(kasamicode(IDS).xor(kasamicode(n1)),Math.abs((kasamicode(IDS).xor(kasamicode(k1))).intValue())),Math.abs((kasamicode(k2)).intValue()));
	}
	
	//void updateIDSk1k2()
	//{
	//	IDS= Integer.rotateLeft(kasamicode(IDS)^n1,kasamicode(n2));
	//	k1=kasamicode(Integer.rotateLeft(kasamicode(k1),kasamicode(n1))^k2);
	//	k2=kasamicode(Integer.rotateLeft(kasamicode(k2),kasamicode(n2))^k1);
	//}
	
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
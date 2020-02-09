package proposed_protocol;

import java.math.BigInteger;
import java.util.Random;

public class tag {
	private Random rand = new Random();
	private BigInteger n = new BigInteger(96, rand);
	private BigInteger nHW = hammingWt(n);
	private BigInteger a,b,c,d,t,z, z1;
	private BigInteger tHW;
	private BigInteger k = new BigInteger(96, rand);
	private BigInteger kHW = hammingWt(k);
	private BigInteger IDS = new BigInteger(96, rand);
	private BigInteger IDSHW = hammingWt(IDS);
	BigIntWrapper wrap = new BigIntWrapper();
	
	
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
		else if(id == 4)
		{
			t = k;
		}
		else
		{
			System.out.println("Invalid id!! Try again.");
		}
		
	}
	
	
	BigInteger hammingWt(BigInteger n) {
		BigInteger l = new BigInteger("0");
		while(n.compareTo(new BigInteger("0"))==1)
		{
			if(n.and(new BigInteger("1")).equals((new BigInteger("1"))))
				l = l.add(new BigInteger("1"));
			n = n.divide(new BigInteger("2"));
		}
		return l;
	}
	
	void calculateAB() {
//		a = Integer.rotateLeft(IDS ^ t, nHW);
//		b = Integer.rotateLeft(k ^ t, nHW) ^ Integer.rotateLeft(IDS, tHW);
		tHW = hammingWt(t);
		a = wrap.rotateLeft(IDS.xor(t), nHW.intValue());
		b = wrap.rotateLeft(k.xor(t),nHW.intValue()).xor(wrap.rotateLeft(IDS, tHW.intValue())); 
		
//		System.out.println(nHW);
	}
	
	BigInteger geta(tag t)
	{
		return t.a;
	}
	
	BigInteger getb(tag t)
	{
		return t.b;
	}
	BigInteger getIDS(tag t)
	{
		return t.IDS;
	}
	BigInteger getk(tag t)
	{
		return t.k;
	}
	BigInteger gett(tag t)
	{
		return t.t;
	}
	BigInteger getnHW(tag t)
	{
		return t.nHW;
	}
	
	void updateCDz(BigInteger a, BigInteger b, BigInteger c)
	{
		c = a;
		d = b;
		z = c;
//		System.out.println(c + " " + d);
	}
	void authenticatez()
	{
		int flag = 0;
		z1 = wrap.rotateRight(d.xor(wrap.rotateLeft(t, kHW.intValue())), IDSHW.intValue());
		if(z1.equals(z))
			flag = 1;
		System.out.println("tag authentication successful");
		
	}
		
}

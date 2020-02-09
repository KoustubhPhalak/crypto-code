package tewari_gupta_protocol;

import java.math.BigInteger;

public class BigIntWrapper {

	public BigInteger rotateRight(BigInteger a, int amount)
	{
//		int[] shift = new int[amount];
		int n = a.bitLength();
		amount = amount%96;
//		System.out.println(n);
		BigInteger temp = a.shiftLeft(amount);
//		System.out.println(temp.toString(2));
		BigInteger temp1 = a.shiftRight(96-amount);
//		System.out.println(temp1.toString(2));
		for(int i=96;i<96+amount;i++)
		{
			temp = temp.clearBit(i);
		}
//		System.out.println(temp.toString(2));
		for(int i=0;i<amount;i++)
		{
			temp = temp.setBit(i);
		}
		for(int i=amount;i<96;i++)
		{
			temp1 = temp1.setBit(i);
		}
//		System.out.println(temp.toString(2));
//		System.out.println(temp1.toString(2));
		temp = temp.and(temp1);
		return temp;
	}
	
	public BigInteger rotateLeft(BigInteger a, int amount)
	{
		int n = a.bitLength();
		amount = amount%96;
//		System.out.println(n);
		BigInteger temp = a.shiftLeft(amount);
		BigInteger temp1 = a.shiftRight(96-amount);
		for(int i=96;i<96+amount;i++)
		{
			temp = temp.clearBit(i);
		}
		for(int i=0;i<amount;i++)
		{
			temp = temp.setBit(i);
		}
		for(int i=amount;i<96;i++)
		{
			temp1 = temp1.setBit(i);
		}
		temp = temp.and(temp1);
		return temp;
	}
	
}

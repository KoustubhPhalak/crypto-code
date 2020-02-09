package mujahid_protocol_2;

import java.util.Random;
import java.math.BigInteger;

public class node {

			Random rand = new Random();
			 private BigInteger[] IDS = {new BigInteger("1"), new BigInteger("2"), new BigInteger("3"), new BigInteger("4"), new BigInteger("5"), new BigInteger("6"), new BigInteger("7"), new BigInteger("8"), new BigInteger("9"), new BigInteger("10")};
			 private BigInteger[] k1 = {new BigInteger(96, rand), new BigInteger(96, rand), new BigInteger(96, rand), new BigInteger(96, rand), new BigInteger(96, rand), new BigInteger(96, rand), new BigInteger(96, rand), new BigInteger(96, rand), new BigInteger(96, rand), new BigInteger(96, rand)};
			 private BigInteger[] k2 = {new BigInteger(96, rand), new BigInteger(96, rand), new BigInteger(96, rand), new BigInteger(96, rand), new BigInteger(96, rand), new BigInteger(96, rand), new BigInteger(96, rand), new BigInteger(96, rand), new BigInteger(96, rand), new BigInteger(96, rand)};
			
	BigInteger[] DatabaseCheck(BigInteger k)
	{
		System.out.println(k);
		BigInteger[] ans = new BigInteger[2];
		for(int i=0;i<10;i++)
		{
			System.out.println(IDS[i]);
			if(k.equals(IDS[i]))
			{
				ans[0]=k1[i];
				ans[1]=k2[i];
				return ans;
			}
		}
		ans[0]= new BigInteger("-1");
		ans[1]=new BigInteger("-1");
		//ans[0]= new BigInteger("5");
		//ans[1]=new BigInteger("5");
		return ans;
	}


	BigInteger getK1_1(BigInteger ID)
	{
		for(int i=0;i<10;i++)
		{
			if(ID.equals(IDS[i]))
			{
				return k1[i];
			}

		}
	
		return new BigInteger("-1");

	}

	BigInteger getK2_1(BigInteger ID)
	{
		for(int i=0;i<10;i++)
		{
			if(ID.equals(IDS[i]))
			{
				return k2[i];
			}

		}
	
		return new BigInteger("-1");

	}


}


package tewari_gupta_protocol;

import java.util.Random;
import java.math.BigInteger;
import java.lang.Math;

public class reader {
	public String mess = "hello";
	Random rand = new Random();
	private BigInteger p,q,r,r1;
	private BigInteger IDS, K;
	private BigInteger m = new BigInteger(96, rand);
	private BigInteger n = new BigInteger(96, rand);
	private BigInteger s, s1;
	BigIntWrapper wrap = new BigIntWrapper();
	
	void calculatepqr() {
//		p = (IDS^m)^n;
		p = (IDS.xor(m)).xor(n);
//		q = K^n;
		q = K.xor(n);
//		r = Integer.rotateLeft(Integer.rotateLeft(K^n, IDS), K^m);
//		System.out.println((K.xor(m).intValue() + " " + Math.abs(K.xor(m).intValue())));
		r = wrap.rotateLeft(wrap.rotateLeft(K.xor(n), Math.abs(IDS.intValue())), Math.abs((K.xor(m)).intValue()));
//		System.out.println(K.xor(m).intValue());
	}
	
	BigInteger getp(reader r)
	{
		return r.p;
	}
	BigInteger getq(reader r)
	{
		return r.q;
	}
	BigInteger getr(reader r)
	{
		return r.r;
	}
	BigInteger getIDS(reader r)
	{
		return r.IDS;
	}
	BigInteger getK(reader r)
	{
		return r.K;
	}
	BigInteger gets(reader r)
	{
		return r.s;
	}
	BigInteger gets1(reader r)
	{
		return r.s1;
	}
	BigInteger getm(reader r)
	{
		return r.m;
	}
	BigInteger getn(reader r)
	{
		return r.n;
	}
	
	void updateIDSK(BigInteger a, BigInteger b) {
		IDS = a;
		K = b;
	}
	
	void updates(BigInteger a)
	{
		s = a;
	}
	
	void calculates1()
	{
//		s1 = Integer.rotateLeft(Integer.rotateLeft(IDS^m, K), r^n);
		s1 = wrap.rotateLeft(wrap.rotateLeft(IDS.xor(m), Math.abs(K.intValue())), Math.abs((r.xor(n)).intValue()));
//		System.out.println(s1);
	}
	
	void mutual_authentication()
	{
		if(s1.equals(s))
			System.out.println("mutual authentication successful...");
	}
	void finalizeIDSK()
	{
//		IDS = Integer.rotateLeft(Integer.rotateLeft(IDS^n, K^n), IDS ^ m);
		IDS = wrap.rotateLeft(wrap.rotateLeft(IDS.xor(n), Math.abs(K.xor(n).intValue())), Math.abs(IDS.xor(m).intValue()));
//		K = Integer.rotateLeft(r^n, IDS^m);
		K = wrap.rotateLeft(r.xor(n), Math.abs(IDS.xor(m).intValue()));
	}
}

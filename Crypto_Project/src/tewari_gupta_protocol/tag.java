package tewari_gupta_protocol;

import java.util.Random;
import java.math.BigInteger;

public class tag {
	public String mess;
	Random rand = new Random();
	private BigInteger IDS  = new BigInteger(96, rand), K  = new BigInteger(96, rand);
	private BigInteger p,q,r, r1;
	private BigInteger m,n;
	private BigInteger s;
	BigIntWrapper wrap = new BigIntWrapper();
	

	void calculatemnr1() {
//		n = q^K;
		n = q.xor(K);
//		m = (p^n)^IDS;
		m = (p.xor(n)).xor(IDS);
//		r1 = Integer.rotateLeft(Integer.rotateLeft(K^n, IDS), K^m);
		r1 = wrap.rotateLeft(wrap.rotateLeft(K.xor(n), Math.abs(IDS.intValue())), Math.abs(K.xor(m).abs().intValue()));
	}
	
	BigInteger getp(tag t)
	{
		return t.p;
	}
	BigInteger getq(tag t)
	{
		return t.q;
	}
	BigInteger getr(tag t)
	{
		return t.r;
	}
	BigInteger getIDS(tag t)
	{
		return t.IDS;
	}
	BigInteger getK(tag t)
	{
		return t.K;
	}
	BigInteger getr1(tag t)
	{
		return t.r1;
	}
	BigInteger gets(tag t)
	{
		return t.s;
	}
	BigInteger getm(tag t)
	{
		return t.m;
	}
	BigInteger getn(tag t)
	{
		return t.n;
	}
	
	void updatepqr(BigInteger a, BigInteger b, BigInteger c)
	{
		p = a;
		q = b;
		r = c;
	}
	
	void calculates()
	{
//		s = Integer.rotateLeft(Integer.rotateLeft(IDS^m, K), r1^n);
		s = wrap.rotateLeft(wrap.rotateLeft(IDS.xor(m), Math.abs(K.intValue())), Math.abs(r1.xor(n).intValue()));
//		System.out.println(s);
	}
	
	void finalizeIDSK()
	{
//		IDS = Integer.rotateLeft(Integer.rotateLeft(IDS^n, K^n), IDS ^ m);
		IDS = wrap.rotateLeft(wrap.rotateLeft(IDS.xor(n), Math.abs(K.xor(n).intValue())), Math.abs(IDS.xor(m).intValue()));
//		K = Integer.rotateLeft(r^n, IDS^m);
		K = wrap.rotateLeft(r.xor(n), Math.abs(IDS.xor(m).intValue()));
	}
	
	void receive_message(String m)
	{
		mess = m;
	}
}

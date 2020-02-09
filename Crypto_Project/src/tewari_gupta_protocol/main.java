package tewari_gupta_protocol;

import java.math.BigInteger;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = System.nanoTime();
		tag t = new tag();
		reader r = new reader();
		Server s = new Server();
		t.receive_message(r.mess);
		r.updateIDSK(t.getIDS(t), t.getK(t));
		s.updateIDSK(t.getIDS(t),t.getK(t));
		s.authenticate(t.getIDS(t));
//		System.out.println(r.getIDS(r) + " " + t.getIDS(t));
//		System.out.println(r.getK(r) + " " + t.getK(t));
		r.calculatepqr();
		t.updatepqr(r.getp(r), r.getq(r), r.getr(r));
//		System.out.println(r.getp(r) + " " + t.getp(t));
//		System.out.println(r.getq(r) + " " + t.getq(t));
//		System.out.println(r.getr(r) + " " + t.getr(t));
		t.calculatemnr1();
//		System.out.println(t.getr(t) + " " + t.getr1(t));
		t.calculates();
		r.updates(t.gets(t));
//		System.out.println(t.gets(t) + " " + r.gets(r)); 
		r.calculates1();
		r.mutual_authentication();
//		System.out.println(r.gets(r) + " " + r.gets1(r));
		r.finalizeIDSK();
		t.finalizeIDSK();
//		System.out.println(r.getIDS(r) + " " + t.getIDS(t));
//		System.out.println(r.getK(r) + " " + t.getK(t));
		long stopTime = System.nanoTime();
		System.out.println("Execution time: "+((stopTime - startTime)/(Math.pow(10, 6)) + " ms"));
	}

}

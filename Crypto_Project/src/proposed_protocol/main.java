package proposed_protocol;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

public class main {

	public static void main(String[] args) {
		long startTime1 = System.nanoTime();
		reader r = new reader();
		tag t1 = new tag();
		node n = new node();
		t1.change(r.gett(r), 4);
		t1.calculateAB();
		r.change(t1.geta(t1), 0);
		r.change(t1.getb(t1), 1);
		long stopTime1 = System.nanoTime();
		r.updateIDSk(t1.getIDS(t1), t1.getk(t1));
		long startTime2 = System.nanoTime();
		n.change(r.gett(r), 4);
		n.change(r.geta(r), 0);
		n.change(r.getb(r), 1);
		long stopTime2 = System.nanoTime();
		n.updateIDSk(r.getIDS(r), r.getk(r));
		n.updatenHW(t1.getnHW(t1));
//		long stopTime1 = System.nanoTime();
//		System.out.println(n.getnHW(n));
		n.register_hash();
		long startTime3 = System.nanoTime();
		n.authenticate();
		n.updateHW(n.hammingWt(n.gett(n)), n.hammingWt(n.getIDS(n)),n.hammingWt(n.getk(n)));
		n.calculateCD();
		r.updateCD(n.getc(n), n.getd(n));
		t1.updateCDz(r.getc(r), r.getd(r), n.getz(n));
		t1.authenticatez();
		long stopTime3 = System.nanoTime();
		System.out.println("Execution time: "+((stopTime1 - startTime1 + stopTime2 - startTime2 + stopTime3 - startTime3)/(Math.pow(10, 6)) + " ms"));
		
		
	}
	
}


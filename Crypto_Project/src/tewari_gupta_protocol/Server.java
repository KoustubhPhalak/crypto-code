package tewari_gupta_protocol;

import java.math.BigInteger;

public class Server {
	
	private BigInteger IDS, K;
	
	void updateIDSK(BigInteger a, BigInteger b) {
		IDS = a;
		K = b;
	}
	
	void authenticate(BigInteger i)
	{
		if(IDS.equals(i))
			System.out.println("authentication successful...");
	}

}

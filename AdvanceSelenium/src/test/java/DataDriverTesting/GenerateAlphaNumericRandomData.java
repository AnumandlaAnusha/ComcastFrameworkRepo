package DataDriverTesting;

public class GenerateAlphaNumericRandomData {

	public static void main(String[] args) {
		int n=20;
	//choose a random character from this string
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder sb = new StringBuilder(n);
		for(int i=0;i<n;i++)
		{
			int index=(int)(AlphaNumericString.length()* Math.random());
			sb.append(AlphaNumericString.charAt(index));
		}
		System.out.println(sb);
		
		
		

	}

}

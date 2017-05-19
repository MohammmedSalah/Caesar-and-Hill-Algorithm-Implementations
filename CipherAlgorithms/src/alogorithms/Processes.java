package alogorithms;

public class Processes {

	public static int keyMat_2x2[][] = new int[][] { { 1, 2 }, { 6, 13 } };
	public static int InvKeyMat_2x2[][] = new int[][] { { 13, -2 }, { -6, 1 } };

	public static int keyMat_3x3[][] = new int[][] { { 1, 2, 1 }, { 2, 3, 2 }, { 2, 2, 1 } };
	public static int InvKeyMat_3x3[][] = new int[][] { { -1, 0, 1 }, { 2, -1, 0 }, { -2, 2, -1 } };

	public static String key = "ABCDEFGHIJKLMNOPQRSTUVWXYZ~ abcdefghijklmnopqrstuvwxyz123456789";

	public static String encryptProcess_2_2(String input) throws IndexOutOfBoundsException {
		String output = "";
		if (input.length() % 2 != 0)
			input += "~";

		System.out.println("final String\t" + input);

		for (int i = 0; i < input.length(); i += 2)
			output += encrypt(input.charAt(i), input.charAt(i + 1));

		System.out.println("result text\t" + output);

		return output;
	}

	public static String decrypt_2_2(String input) throws IndexOutOfBoundsException {
		System.out.println("final String\t" + input);
		String output = "";

		for (int i = 0; i < input.length(); i += 2)
			output += decrypt(input.charAt(i), input.charAt(i + 1));

		System.out.println("result text\t" + output);
		return output;
	}

	public static String encryptProcess_3x3(String input) throws IndexOutOfBoundsException {
		String output = "";
		int n = input.length() % 3;
		if (n != 0) {
			for (int i = 1; i <= (3 - n); i++) {
				input += '~';
			}
		}

		System.out.println("final String\t" + input);

		for (int i = 0; i < input.length(); i += 3)
			output += encrypt(input.charAt(i), input.charAt(i + 1), input.charAt(i + 2));

		return output;
	}

	public static String decrypt_3_3(String input) throws IndexOutOfBoundsException {
		System.out.println("final String\t" + input);
		String output = "";

		for (int i = 0; i < input.length(); i += 3)
			output += decrypt(input.charAt(i), input.charAt(i + 1), input.charAt(i + 2));

		System.out.println("result text\t" + output);
		return output;
	}

	public static String encrypt(char a, char b) throws IndexOutOfBoundsException {
		int posa = key.indexOf(a), posb = key.indexOf(b);

		System.out.println("posa " + posa + "\tposb " + posb);
		int av = (keyMat_2x2[0][0] * posa + keyMat_2x2[0][1] * posb) ;
		int bv = (keyMat_2x2[1][0] * posa + keyMat_2x2[1][1] * posb) ;
		
		while (av < 0)
			av += key.length();
		while (bv < 0)
			bv += key.length();
		
		while (av >= 63)
			av %= key.length();
		while (bv >= 63)
			bv %= key.length();
		
		System.out.println("av " + av + "\tbv " + bv);

		return key.charAt(av) + "" + key.charAt(bv);
	}

	public static String decrypt(char a, char b) throws IndexOutOfBoundsException {
		int posa = key.indexOf(a), posb = key.indexOf(b);

		System.out.println("posa " + posa + "\tposb " + posb);
		int av = (InvKeyMat_2x2[0][0] * posa + InvKeyMat_2x2[0][1] * posb);
		int bv = (InvKeyMat_2x2[1][0] * posa + InvKeyMat_2x2[1][1] * posb);

		while (av < 0)
			av += key.length();
		while (bv < 0)
			bv += key.length();
		
		while (av >= key.length())
			av %= key.length();
		while (bv >= key.length())
			bv %= key.length();
		
		System.out.println("av " + av + "\tbv " + bv);

		return key.charAt(av) + "" + key.charAt(bv);
	}

	public static String encrypt(char a, char b, char c) throws IndexOutOfBoundsException {
		int posa = key.indexOf(a), posb = key.indexOf(b), posc = key.indexOf(c);

		System.out.println("posa " + posa + "\tposb " + posb + "\tposc " + posc);

		int av = (keyMat_3x3[0][0] * posa + keyMat_3x3[0][1] * posb + keyMat_3x3[0][2] * posc);
		int bv = (keyMat_3x3[1][0] * posa + keyMat_3x3[1][1] * posb + keyMat_3x3[1][2] * posc);
		int cv = (keyMat_3x3[2][0] * posa + keyMat_3x3[2][1] * posb + keyMat_3x3[2][2] * posc);
		
		while (av < 0)
			av += key.length();
		while (bv < 0)
			bv += key.length();
		while (cv < 0)
			cv += key.length();
		
		while (av >= key.length())
			av %= key.length();
		while (bv >= key.length())
			bv %= key.length();
		while (cv >= key.length())
			cv %= key.length();
		
		
		System.out.println("av " + av + "\tbv " + bv + "\tcv " + cv);

		return key.charAt(av) + "" + key.charAt(bv) + key.charAt(cv);
	}

	public static String decrypt(char a, char b, char c) throws IndexOutOfBoundsException {
		int posa = key.indexOf(a), posb = key.indexOf(b), posc = key.indexOf(c);

		System.out.println("posa " + posa + "\tposb " + posb + "\tposc " + posc);
		int av = (InvKeyMat_3x3[0][0] * posa + InvKeyMat_3x3[0][1] * posb + InvKeyMat_3x3[0][2] * posc) ;
		int bv = (InvKeyMat_3x3[1][0] * posa + InvKeyMat_3x3[1][1] * posb + InvKeyMat_3x3[1][2] * posc) ;
		int cv = (InvKeyMat_3x3[2][0] * posa + InvKeyMat_3x3[2][1] * posb + InvKeyMat_3x3[2][2] * posc) ;

		while (av < 0)
			av += key.length();
		while (bv < 0)
			bv += key.length();
		while (cv < 0)
			cv += key.length();
		
		while (av >= key.length())
			av %= key.length();
		while (bv >= key.length())
			bv %= key.length();
		while (cv >= key.length())
			cv %= key.length();
		

		System.out.println("av " + av + "\tbv " + bv + "\tbv " + bv);

		return key.charAt(av) + "" + key.charAt(bv) + key.charAt(cv);
	}
	
	////////////////////////////////
	
	
	public static String ceasarEncrypt(String input , int key_sh){
		String output = "";
		int posChar=0;
		for(int i=0 ; i<input.length() ; i++){
			posChar = key.indexOf(input.charAt(i));
			posChar+=key_sh;
			while(posChar >= key.length())
				posChar %=key.length();
			
			output+=key.charAt(posChar);
		}
		
		return output;
	}
	
	public static String ceaserDecrypt(String input , int key_sh){
		String output = "";
		int posChar=0;
		for(int i=0 ; i<input.length() ; i++){
			posChar = key.indexOf(input.charAt(i));
			posChar-=key_sh;
			while(posChar <0)
				posChar +=key.length();
			while(posChar >= key.length())
				posChar %=key.length();
			
			output+=key.charAt(posChar);
		}
		
		return output;
	}

}

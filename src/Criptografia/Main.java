package Criptografia;

public class Main {

	static String plaintext = "Vamos atacá-los hoje a noite"; /* Note null padding */

	public static void main(String[] args) {
		try {

			Criptografia cripto = new Criptografia();
			
			
			System.out.println("plain:   " + plaintext);

			byte[] cipher = cripto.encrypt(plaintext);

			System.out.print("cipher:  ");
			for (int i = 0; i < cipher.length; i++)
				System.out.print(new Integer(cipher[i]) + " ");
			System.out.println("");

			String decrypted = cripto.decrypt(cipher);

			System.out.println("decrypt: " + decrypted);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

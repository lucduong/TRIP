package vn.com.ltv.common;

import java.security.spec.KeySpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;

import android.util.Base64;

public class Decrypter {
	private Cipher dcipher;
	private SecretKey key;
	byte[] vector_value = new byte[] { 0x4D, 0x2A, 0x45, 0x2A, 0x54, 0x2A,
			0x41, 0x2A, 0x54, 0x2A, 0x52, 0x2A, 0x4F, 0x2A, 0x4E };
	byte[] salt = new byte[] { 0x4C, 0x2A, 0x55, 0x2A, 0x43, 0x2A, 0x49, 0x2A,
			0x46, 0x2A, 0x45, 0x2A, 0x52, 0x2A, 0x4F };
	private static final String KEY_ALGORITHM = "AES";
	private static final String SECRET_KEY_ALGORITHM = "PBEWithSHA256And256BitAES-CBC-BC";
	private static final int PBE_ITERATION_COUNT = 1024;
	private static final int PBE_KEY_LENGTH = 10;
	private static final String PASSWORD = "T9r8i7p6!5@4#312213";

	public Decrypter() throws Exception {
		String password = PASSWORD;
		SecretKeyFactory factory = SecretKeyFactory
				.getInstance(SECRET_KEY_ALGORITHM);
		KeySpec spec = new PBEKeySpec(password.toCharArray(), salt,
				PBE_ITERATION_COUNT, PBE_KEY_LENGTH);
		SecretKey tmp = factory.generateSecret(spec);
		key = new SecretKeySpec(tmp.getEncoded(), KEY_ALGORITHM);
		dcipher = Cipher.getInstance(KEY_ALGORITHM);
	}

	/**
	 * Encrypt data with Base64
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public String encrypt(String data) throws Exception {
		dcipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] utf8EncryptedData = dcipher.doFinal(data.getBytes());
		String base64EncryptedData = Base64.encodeToString(utf8EncryptedData,
				Base64.DEFAULT);
		System.out.println("IV " + base64EncryptedData);
		System.out.println("Encrypted Data " + base64EncryptedData);
		return base64EncryptedData;
	}

	/**
	 * Decrypt data with Base64
	 * 
	 * @param base64EncryptedData
	 * @return
	 * @throws Exception
	 */
	public String decrypt(String base64EncryptedData) throws Exception {
		dcipher.init(Cipher.DECRYPT_MODE, key,
				new IvParameterSpec(vector_value));
		byte[] decryptedData = Base64.decode(base64EncryptedData,
				Base64.DEFAULT);
		byte[] utf8 = dcipher.doFinal(decryptedData);
		return new String(utf8, "UTF8");
	}
}
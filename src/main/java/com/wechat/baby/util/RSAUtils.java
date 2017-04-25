package com.wechat.baby.util;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.util.Assert;

/**
 * Utils - RSA加密/解密
 * 
 * 微信平台
 * @version 1.0
 */
public final class RSAUtils {

	/** 密钥算法 */
	private static final String KEY_ALGORITHM = "RSA";

	/** 签名算法 */
	private static final String SIGNATURE_ALGORITHM = "MD5withRSA";

	/** 加密/解密算法 */
	private static final String TRANSFORMATION = "RSA/ECB/PKCS1Padding";

	/** 安全服务提供者 */
	private static final Provider PROVIDER = new BouncyCastleProvider();

	/**
	 * 不可实例化
	 */
	private RSAUtils() {
	}

	/**
	 * 生成密钥对
	 * 
	 * @param keySize
	 *            密钥大小
	 * @return 密钥对
	 */
	public static KeyPair generateKeyPair(int keySize) {
		Assert.state(keySize > 0);
		try {
			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM, PROVIDER);
			keyPairGenerator.initialize(keySize);
			return keyPairGenerator.generateKeyPair();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 生成私钥
	 * 
	 * @param encodedKey
	 *            私钥编码
	 * @return 私钥
	 */
	public static PrivateKey generatePrivateKey(byte[] encodedKey) {
		Assert.notNull(encodedKey);
		try {
			KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM, PROVIDER);
			return keyFactory.generatePrivate(new PKCS8EncodedKeySpec(encodedKey));
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		} catch (InvalidKeySpecException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 生成公钥
	 * 
	 * @param encodedKey
	 *            公钥编码
	 * @return 公钥
	 */
	public static PublicKey generatePublicKey(byte[] encodedKey) {
		Assert.notNull(encodedKey);
		try {
			KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM, PROVIDER);
			return keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		} catch (InvalidKeySpecException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 生成签名
	 * 
	 * @param privateKey
	 *            私钥
	 * @param data
	 *            数据
	 * @return 签名
	 */
	public static byte[] sign(PrivateKey privateKey, byte[] data) {
		Assert.notNull(privateKey);
		Assert.notNull(data);
		try {
			Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM, PROVIDER);
			signature.initSign(privateKey);
			signature.update(data);
			return signature.sign();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		} catch (InvalidKeyException e) {
			throw new RuntimeException(e);
		} catch (SignatureException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 验证签名
	 * 
	 * @param publicKey
	 *            公钥
	 * @param sign
	 *            签名
	 * @param data
	 *            数据
	 * @return 是否验证通过
	 */
	public static boolean verify(PublicKey publicKey, byte[] sign, byte[] data) {
		Assert.notNull(publicKey);
		Assert.notNull(sign);
		Assert.notNull(data);
		try {
			Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM, PROVIDER);
			signature.initVerify(publicKey);
			signature.update(data);
			return signature.verify(sign);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		} catch (InvalidKeyException e) {
			throw new RuntimeException(e);
		} catch (SignatureException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 加密
	 * 
	 * @param publicKey
	 *            公钥
	 * @param data
	 *            数据
	 * @return 密文
	 */
	public static byte[] encrypt(PublicKey publicKey, byte[] data) {
		Assert.notNull(publicKey);
		Assert.notNull(data);
		try {
			Cipher cipher = Cipher.getInstance(TRANSFORMATION, PROVIDER);
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			return cipher.doFinal(data);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		} catch (NoSuchPaddingException e) {
			throw new RuntimeException(e);
		} catch (InvalidKeyException e) {
			throw new RuntimeException(e);
		} catch (IllegalBlockSizeException e) {
			throw new RuntimeException(e);
		} catch (BadPaddingException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 解密
	 * 
	 * @param privateKey
	 *            私钥
	 * @param data
	 *            数据
	 * @return 明文
	 */
	public static byte[] decrypt(PrivateKey privateKey, byte[] data) {
		Assert.notNull(privateKey);
		Assert.notNull(data);
		try {
			Cipher cipher = Cipher.getInstance(TRANSFORMATION, PROVIDER);
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			return cipher.doFinal(data);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		} catch (NoSuchPaddingException e) {
			throw new RuntimeException(e);
		} catch (InvalidKeyException e) {
			throw new RuntimeException(e);
		} catch (IllegalBlockSizeException e) {
			throw new RuntimeException(e);
		} catch (BadPaddingException e) {
			throw new RuntimeException(e);
		}
	}

}
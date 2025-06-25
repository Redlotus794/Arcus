package com.rdlts.arcus.identity.user.domian.domainservice;

public class PasswordEncryptDomainService {

    // 示例代码
//    // 生成随机盐值
//    public static String generateSalt() {
//        byte[] salt = new byte[16];
//        new SecureRandom().nextBytes(salt);
//        return Base64.getEncoder().encodeToString(salt);
//    }
//
//    // 使用 PBKDF2 算法加密密码
//    public static String hashPassword(String password, String salt) throws Exception {
//        int iterations = 65536;
//        int keyLength = 256;
//        char[] passwordChars = password.toCharArray();
//        byte[] saltBytes = Base64.getDecoder().decode(salt);
//
//        PBEKeySpec spec = new PBEKeySpec(passwordChars, saltBytes, iterations, keyLength);
//        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
//
//        byte[] hash = factory.generateSecret(spec).getEncoded();
//        return Base64.getEncoder().encodeToString(hash);
//    }
//
//    // 简单测试
//    public static void main(String[] args) throws Exception {
//        String password = "userInputPassword";
//        String salt = generateSalt();
//        String hashedPassword = hashPassword(password, salt);
//
//        System.out.println("盐值: " + salt);
//        System.out.println("哈希密码: " + hashedPassword);
//    }
}

package Package;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;

public class FloderEncryption {
	  private static final String ALGORITHM = "AES";
	    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";
	    private static final String SECRET_KEY = "VotreCleScrete"; // Clé secrète utilisée pour le chiffrement
	    private static final String IV_PARAMETER = "VotreIVParameter"; // Paramètre IV (vecteur d'initialisation) pour le chiffrement

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  String folderPath = "Chemin/vers/dossier";
	        String encryptedFolderPath = "Chemin/vers/dossier/crypté";
	        String password = "VotreMotDePasse";

	        try {
	            encryptFolder(folderPath, encryptedFolderPath, password);
	            System.out.println("Dossier Crypté avec sucess.");
	        } catch (Exception e) {
	            System.err.println("Erreur lord du cryptage: " + e.getMessage());
	        }

	}
	public static void encryptFolder(String folderPath, String encryptedFolderPath, String password) throws Exception {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        if (files != null) {
            // Créer le dossier de destination chiffré s'il n'existe pas déjà
            File encryptedFolder = new File(encryptedFolderPath);
            encryptedFolder.mkdir();

            // Convertir le mot de passe en clé secrète
            SecretKeySpec secretKey = new SecretKeySpec(password.getBytes(), ALGORITHM);

            // Créer l'instance du chiffreur
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(IV_PARAMETER.getBytes()));

            for (File file : files) {
                if (file.isFile()) {
                    // Lire le contenu du fichier
                    FileInputStream inputStream = new FileInputStream(file);
                    byte[] inputBytes = new byte[(int) file.length()];
                    inputStream.read(inputBytes);
                    inputStream.close();

                    // Chiffrer le contenu du fichier
                    byte[] outputBytes = cipher.doFinal(inputBytes);

                    // Créer le fichier chiffré dans le dossier de destination
                    String encryptedFilePath = encryptedFolderPath + File.separator + file.getName();
                    FileOutputStream outputStream = new FileOutputStream(encryptedFilePath);
                    outputStream.write(outputBytes);
                    outputStream.close();
                }
            }
        }
    }
}

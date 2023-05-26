# FloderEncryption

Il s'agit d'un programme Java qui permet de crypter un dossier avec un mot de passe en utilisant l'algorithme de chiffrement AES en mode CBC.

#Prérequis
JDK (Java Development Kit) installé
Compréhension basique de la programmation Java
Utilisation
Configurez les valeurs des variables suivantes :

folderPath : Chemin vers le dossier que vous souhaitez crypter.
encryptedFolderPath : Chemin où le dossier crypté sera créé.
password : Mot de passe utilisé pour le chiffrement.
Exécutez la méthode main de la classe FolderEncryption.

#Explication du code
Le programme utilise l'algorithme de chiffrement AES en mode CBC avec le padding PKCS5.
La méthode encryptFolder prend en paramètres le chemin du dossier, le chemin du dossier crypté et le mot de passe.
Elle crée le dossier crypté s'il n'existe pas déjà.
Le mot de passe est converti en une clé secrète en utilisant l'algorithme AES.
L'instance de Cipher est initialisée avec le mode de chiffrement, la clé secrète et le paramètre IV.
Pour chaque fichier dans le dossier, le programme lit son contenu, le chiffre à l'aide du chiffreur et écrit le contenu chiffré dans un nouveau fichier dans le dossier crypté.
Remarque : Assurez-vous de remplacer les espaces réservés "YourSecretKey" et "YourIVParameter" par les valeurs appropriées de clé secrète et de paramètre IV.

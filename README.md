# TPX_DAR2025
commit ajout des fichiers:
    etape 3:
    Je suis un serveur en attente la connexion d'un client
    etape 4:
    Je suis un client pas encore connecté
    Je suis un client connecté
commit_2:
    Pour la partie 2 du TP1, j’ai traité un nombre envoyé par le client. Le serveur le multiplie par 5, puis le renvoie au client en utilisant les classes InputStream et OutputStream.Cependant, un problème est survenu lors du traitement des nombres négatifs, car InputStream et OutputStream lisent les données bit par bit, ce qui rend difficile la gestion des entiers signés.Pour résoudre ce problème, j’ai utilisé DataInputStream et DataOutputStream, qui permettent de lire et d’écrire directement des valeurs numériques (y compris négatives).Enfin, pour répéter ce processus plusieurs fois, j’ai utilisé une boucle do...while, avec la condition que le nombre soit différent de zéro.

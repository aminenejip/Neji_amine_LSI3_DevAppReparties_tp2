# Neji_amine_LSI3_DevAppReparties_tp
commit tp2-1:
J’ai repris le code du TP1-2, puis j’ai ajouté la méthode effectuerOperation, qui demande à l’utilisateur de saisir une équation. Cette méthode vérifie ensuite si l’opération saisie est dans le format correct. Si c’est le cas, elle renvoie l’équation.

Ensuite, la méthode envoyerOperation envoie cette équation au serveur à l’aide d’un socket et de la classe DataOutputStream.
Une fois que le serveur a traité la requête et renvoyé le résultat, le client le lit grâce à DataInputStream avec la méthode readInt, puis l’affiche.
Le processus se répète tant que l’utilisateur le souhaite (c’est-à-dire tant qu’il saisit 1 pour répondre oui).

Côté serveur, celui-ci reçoit une chaîne de caractères représentant l’opération. Il découpe ensuite cette opération en plusieurs parties, convertit nb1 et nb2 (les valeurs numériques) en entiers, identifie l’opérateur à l’aide de la variable operateur pour déterminer le type d’équation, effectue le traitement, puis renvoie le résultat au client à l’aide de la méthode writeInt suivie de flush.
commit tp2-2:
J’ai repris le code du TP1-2 et corrigé la logique pour utiliser des flux d’objets au lieu de DataInputStream/DataOutputStream. Le client se connecte au serveur, demande à l’utilisateur de saisir une opération (par exemple 5*3), vérifie que le format est correct, puis crée un objet Operation contenant les deux nombres et l’opérateur. Cet objet est envoyé au serveur via ObjectOutputStream. Le serveur reçoit l’objet, identifie l’opérateur, effectue le calcul et renvoie le résultat sous forme d’un Integer via ObjectOutputStream. Le client lit ce résultat avec ObjectInputStream et l’affiche. Le processus se répète tant que l’utilisateur saisit 1 pour continuer. Cette approche corrige les problèmes de protocole rencontrés auparavant (comme les erreurs de flux corrompu) en créant les flux une seule fois par connexion et en utilisant la sérialisation pour échanger des objets.
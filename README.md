# Neji_amine_LSI3_DevAppReparties_tp
commit tp2-1:
J’ai repris le code du TP1-2, puis j’ai ajouté la méthode effectuerOperation, qui demande à l’utilisateur de saisir une équation. Cette méthode vérifie ensuite si l’opération saisie est dans le format correct. Si c’est le cas, elle renvoie l’équation.

Ensuite, la méthode envoyerOperation envoie cette équation au serveur à l’aide d’un socket et de la classe DataOutputStream.
Une fois que le serveur a traité la requête et renvoyé le résultat, le client le lit grâce à DataInputStream avec la méthode readInt, puis l’affiche.
Le processus se répète tant que l’utilisateur le souhaite (c’est-à-dire tant qu’il saisit 1 pour répondre oui).

Côté serveur, celui-ci reçoit une chaîne de caractères représentant l’opération. Il découpe ensuite cette opération en plusieurs parties, convertit nb1 et nb2 (les valeurs numériques) en entiers, identifie l’opérateur à l’aide de la variable operateur pour déterminer le type d’équation, effectue le traitement, puis renvoie le résultat au client à l’aide de la méthode writeInt suivie de flush.
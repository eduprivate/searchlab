- Indexação
Criei um indice invertido rudimentar . Rudimentar porque não me preocupei 
em distribuir em 'database file' dos indices com controle de concorrência e tudo mais. Ao invés disso criei um mecaniscmo de persistência simples em disco que guarda os tokens e seus 'documentos'. 
O programa cria uma lista de movies que passa pela fase pelo Normalizer para retirada de caracteres especiais e aplica lowercase.
 
- Busca
Para a busca o programa lê o arquivo em disco e recria estrutura de dados em memória para realizar as buscas 

### Altere os paths para seus cenários!
- Requisitos:
JRE - Java 8

- Build:
$ mvn clean package install

- Indexação 
$ cd targed
$ java -jar indexer.jar -indexPath <PATH_TO_MOVIES_FOLDER>

- Busca
$ java -jar search.jar -query "walt disney"

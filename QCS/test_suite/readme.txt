O test-suite é composto por 3 tipos de testes diferentes:
    -> pasta casoslimite - contém 17 casos de teste limite:
            . caso_1 e caso_2: ficheiros apenas com múltiplos parágrafos, espaços e tabulações
            . caso_3: ficheiro com múltiplos parágrafos, espaços e tabulações e com uma frase cheia de erros no fim.
            . caso_4: ficheiro com múltiplos parágrafos, espaços e tabulações e com uma frase em inglês correto no fim.
            . caso_5: ficheiro com um formato diferente (ficheiro pdf)
            . caso_6: ficheiro com um formato diferente (ficheiro png)
            . caso_7: ficheiro com um formato diferente (ficheiro zip)
            . caso_8: ficheiro com um formato diferente (ficheiro jpg)
            . caso_9: ficheiro corrupto
            . caso_10: ficheiro com um desenho com caracteres ASCII
            . caso_11: ficheiro codificado com UTF-16 LE em vez de UTF-8
            . caso_12: ficheiro codificado com CP 866 LE em vez de UTF-8
            . caso_13: ficheiro só com sinais de pontuação
            . caso_14: ficheiro com texto hebraico
            . caso_15: ficheiro com texto russo
            . caso_16: ficheiro com texto russo
            . caso_17: ficheiro com texto português


    -> pasta tamanho - contém 18 casos de teste com diferente número de palavras e com alguns erros gerados aleatóriamente (a frequência dos erros tende a ser proporcional à quantidade de palavras no ficheiro)




    -> pasta erros - contém 18 casos de teste. São usados 3 textos com diferentes dimensões. Para cada um desses três textos, vários casos de teste fazem variar a percentagem de erros contidos no mesmo texto.

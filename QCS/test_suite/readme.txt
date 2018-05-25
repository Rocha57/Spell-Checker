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
            . caso_18: ficheiro com longa coluna de palavras sem significado

    -> pasta tamanho - contém 20 casos de teste com diferentes número de palavras e com alguns erros gerados aleatoriamente
    (a frequência dos erros tende a ser proporcional à quantidade de palavras no ficheiro):
            . caso_1: 801 caracteres - Pequeno
            . caso_2: 1595 caracteres - Pequeno
            . caso_3: 3773 caracteres - Pequeno
            . caso_4: 5296 caracteres - Pequeno
            . caso_5: 9518 caracteres - Pequeno
            . caso_6: 10390 caracteres - Médio
            . caso_7: 10725 caracteres - Médio
            . caso_8: 17618 caracteres - Médio
            . caso_9: 24854 caracteres - Médio
            . caso_10: 46864 caracteres - Médio
            . caso_11: 133311 caracteres - Grande
            . caso_12: 148053 caracteres - Grande
            . caso_13: 155693 caracteres - Grande
            . caso_14: 161022 caracteres - Grande
            . caso_15: 333906 caracteres - Grande
            . caso_16: 338131 caracteres - Grande
            . caso_17: 423340 caracteres - Grande
            . caso_18: 939426 caracteres - Muito Grande
            . caso_19: 1077876 caracteres - Muito Grande
            . caso_20: 1087520 caracteres - Muito Grande

    -> pasta erros - contém 18 casos de teste. São usados 2 textos: um com dimensão média (sample_9 - 24296 caracteres) e outro dimensão grande (sample_12 - 142325 caracteres).
    Para cada um desses dois textos existe a possibilidade de: não haver erros, ou 12.5%, 25%, 50% ou 100% das palavras contidas nele terem erro.
    Faz-se ainda variar o número de erros injetados por palavra (1 ou 4 erros). Se a palavra em questão por exemplo só tiver 3 caracteres, em vez de se injetar 4 erros, injetam-se 3.
            . caso_1: Sem erros (sample_9 - Médio)
            . caso_2: Sem erros (sample_12 - Grande)
            . caso_3: 12.5% de palavras com erro, 1 erro por palavra (sample_9 - Médio)
            . caso_4: 12.5% de palavras com erro, 1 erro por palavra (sample_12 - Grande)
            . caso_5: 12.5% de palavras com erro, 4 erros por palavra (sample_9 - Médio)
            . caso_6: 12.5% de palavras com erro, 4 erros por palavra (sample_12 - Grande)
            . caso_7: 25% de palavras com erro, 1 erro por palavra (sample_9 - Médio)
            . caso_8: 25% de palavras com erro, 1 erro por palavra (sample_12 - Grande)
            . caso_9: 25% de palavras com erro, 4 erros por palavra (sample_9 - Médio)
            . caso_10: 25% de palavras com erro, 4 erros por palavra (sample_12 - Grande)
            . caso_11: 50% de palavras com erro, 1 erro por palavra (sample_9 - Médio)
            . caso_12: 50% de palavras com erro, 1 erro por palavra (sample_12 - Grande)
            . caso_13: 50% de palavras com erro, 4 erros por palavra (sample_9 - Médio)
            . caso_14: 50% de palavras com erro, 4 erros por palavra (sample_12 - Grande)
            . caso_15: 100% de palavras com erro, 1 erro por palavra (sample_9 - Médio)
            . caso_16: 100% de palavras com erro, 1 erro por palavra (sample_12 - Grande)
            . caso_17: 100% de palavras com erro, 4 erros por palavra (sample_9 - Médio)
            . caso_18: 100% de palavras com erro, 4 erros por palavra (sample_12- Grande)

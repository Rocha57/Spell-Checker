# -*- coding: utf-8 -*-

misspellsPerWord = 1
frequencyError = 4  #every each 4 words, a misspell is injected
englishAlphabet = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",  "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"]

from random import randint

import os
filename = 'C:\Users\Joel Pires\Documents\projs\qcs\Spell-Checker\QCS\\test_suite\erros\\'
directory = os.path.join("c:\\","Users\Joel Pires\Documents\projs\qcs\Spell-Checker\QCS\\test_suite\erros\\")
for root,dirs,files in os.walk(directory):
    for file in files:
        frequency = 4   #random start of the errors
        if file.endswith(".txt"):
            filename = filename + file
            f = open(filename, 'r')
            finalWords = []
            for line in f:
                words = line.split(' ')
                for word in words:
                    flag = 0
                    if(frequency %4 == 0 and len(word) > 1):
                        flag = 1
                        realWord = word.strip()
                        if(misspellsPerWord > len(realWord)):
                            misspellsPerWord = len(realWord)
                        for i in range(misspellsPerWord):
                            indexWord = randint(0, len(realWord)-1) #chose a random index of the word
                            indexAlpha = randint(0, 25)
                            replacement = (englishAlphabet[indexAlpha]).lower()
                            while(replacement == (realWord[indexWord]).lower()):   #WE NEED TO BE SURE THAT WE ARE INSERTING A DIFFERENT
                                indexAlpha = randint(0, 25)
                                replacement = (englishAlphabet[indexAlpha]).lower()

                            aux = list(realWord)
                            aux[indexWord] = replacement #INSERT THE misspell
                            realWord = "".join(aux)
                    frequency += 1
                    if(flag):
                        reconstructed = realWord + word[len(realWord):]
                        finalWords.append(reconstructed)
                    else:
                        finalWords.append(word)
            with open(filename,'w') as fid:
                total = " ".join(finalWords)
                fid.write(total)
            fid.close()
            f.close()

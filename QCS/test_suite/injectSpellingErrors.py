# -*- coding: utf-8 -*-

from __future__ import print_function
import io
import sys

reload(sys)  
sys.setdefaultencoding('utf8')

misspellsPerWord = 1
englishAlphabet = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",  "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"]

from random import randint

import os
#path = 'C:\Users\Joel Pires\Documents\projs\qcs\Spell-Checker\QCS\\test_suite\e\\'
#directory = os.path.join("c:\\","Users\Joel Pires\Documents\projs\qcs\Spell-Checker\QCS\\test_suite\erros\\")
#print(os.getcwd())
directory = os.getcwd() + "/erros/"
#print(directory)
files = ["sample_11.txt", "sample_19.txt", "sample_3.txt", "sample_7.txt"]
for file in files:
    frequency = 4   #could have a random start
    if file.endswith(".txt"):
        #filename = path + file
        filename = directory + file
        print(filename)
        f = open(filename, 'r')
        finalWords = []
        for line in f:
            words = line.split(' ')
            for word in words:
                flag = 0
                if(len(word) > 1):
                    flag = 1
                    realWord = word.strip()
                    initial = realWord
                    if realWord.isalpha():
                        if(misspellsPerWord > len(realWord)):
                            misspellsPerWord = len(realWord)
                        for i in range(0,misspellsPerWord):
                            indexWord = randint(0, len(realWord)-1) #chose a random index of the word
                            indexAlpha = randint(0, 25)
                            replacement = (englishAlphabet[indexAlpha]).lower()
                            while(replacement == (realWord[indexWord]).lower()):   #WE NEED TO BE SURE THAT WE ARE INSERTING A DIFFERENT
                                indexAlpha = randint(0, 25)
                                replacement = (englishAlphabet[indexAlpha]).lower()

                            aux = list(realWord)
                            aux[indexWord] = replacement #INSERT THE misspell
                            realWord = "".join(aux)
                        misspellsPerWord = 1
                        error = realWord + " -> " + initial + "\n"
                        #error = error.encode('utf-8')
                        try:
                            with open(filename[:-4]+"erros.txt", "a+") as ferros:
                                ferros.write(error)
                        except:
                            with open(filename[:-4]+"erros.txt", "a+") as ferros:
                                ferros.write("\"" + error)
                    #print(realWord + " -> " + initial)
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

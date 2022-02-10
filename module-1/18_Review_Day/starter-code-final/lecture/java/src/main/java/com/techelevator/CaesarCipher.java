package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CaesarCipher {

    /**
     * This method will open for reading the original File name, and write the encrypted version to the encryptedFile name
     * @param originalFileName - the file to encrypt
     * @param encryptedFileName - the name of the new file that containst the encryption
     * @param shift - the shfit
     * @return - true if the encryption was done successful, false if there was an error opening either file
     */
    public boolean encryptFile(String originalFileName, String encryptedFileName, int shift){
        //open the orignal file for reading
        File originalFile = new File(originalFileName);
        //create and opne the encrypted file for writing
        try(Scanner readOriginal = new Scanner(originalFile); PrintWriter writer = new PrintWriter(encryptedFileName)){
            // while the original file ahs lines left ot read
            while(readOriginal.hasNextLine()) {
                //   read teh line, encrypt it, write it to the encrypted file
                String line = readOriginal.nextLine();
                String lineEncrypted = encrypt(line,shift);
                writer.println(lineEncrypted);
            }

        } catch (FileNotFoundException e) {
            return false;
        }
        return true;
    }

    public boolean decryptFile(String fileToDecrypt, String results, int shift){
        return encryptFile(fileToDecrypt,results,-shift);
    }

    public String encrypt(String original, int shift){
        //take every letter of teh original string and shift it shift characters
        String encrypted = "";

        for(int i=0; i<original.length(); i++){
            char charToEncrypt = original.charAt(i);
            //take the charEncrypt add the shift and then do mod 128
           // char encryptedChar = (char) (((int)charToEncrypt + shift) % 128);
            char encryptedChar = (char) (((int)charToEncrypt + shift) );
            encrypted+=encryptedChar;
        }

        return encrypted;
    }

    public String decrypt(String encrypted, int shift){
        return encrypt(encrypted,-shift);
    }
}

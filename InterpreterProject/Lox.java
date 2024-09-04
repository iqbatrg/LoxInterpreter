package com.craftinginterpreters.lox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;



public class Lox {

    //runFile method that is used to run text files passed to lox
    private static void runFile(String path) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        run(new String(bytes, Charset.defaultCharset()));
    }


    private static void run(String source){
        Scanner scanner = new Scanner(source);
        List<Token> tokens = scanner.scanTokens();

        //printing tokens?
        for(Token token : tokens)
        {
            System.out.println(token);
        }
    }


    //runPrompt function that runs code in the interactive interface
    private static void runPrompt() throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input); //

        for(;;) {
            System.out.print(">"); //forever loop
            String line = reader.readLine();
            if(line == null) break;
            run(line);
        }
    } 
    //lox main method for running lox
    public static void main(String[] args) throws IOException {
        if(args.length > 1) { //what to do if the arguement is invalid
            System.out.println("Usage: Jlox [script]");
            System.exit(64);
        } else if (args.length) { //what to do if the argument is a filepath leading to a file with code
            runFile(args[0]);
        }
        else{
            runPrompt();
        }

     }
    
 }
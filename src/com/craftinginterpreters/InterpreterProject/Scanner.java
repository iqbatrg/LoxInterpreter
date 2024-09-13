package com.craftinginterpreters.InterpreterProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static com.craftinginterpreters.InterpreterProject.TokenType.*; //this is bad practice since tokentype is static, you can just put token type in the code directly


public class Scanner {
    private final String source;
    private final List<Tokens> tokens = new ArrayList<>();

    Scanner(String source) {
        this.source = source;
    }

    List<Token> scanTokens() {
        while(!isAtEnd()) {
            start = current;
            scanToken();
        }

        tokens.add(new Token(EOF, "", null, line));
        return tokens;
    }
}

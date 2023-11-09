package com.wangrui.Lox;

import java.util.ArrayList;
import java.util.List;

import static com.wangrui.Lox.TokenType.EOF;

public class Scanner {
    private final String source;
    private final List<Token> tokens = new ArrayList<>();

    // 添加下面三行代码
    private int start = 0;
    private int current = 0;
    private int line = 1;

    public Scanner(String source) {
        this.source = source;
    }

    List<Token> scanTokens(){
        while (!isAtEnd()){
            start = current;
            scanToken();
        }
        tokens.add(new Token(EOF,"",null,line));
        return tokens;
    }


}

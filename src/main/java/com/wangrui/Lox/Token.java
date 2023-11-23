package com.wangrui.Lox;

public class Token {
    final TokenType type;  //词素类型
    final String lexeme;  //词素的值
    final Object literal;  // 字面量
    final int line;  //当前行

    public Token(TokenType type, String lexeme, Object literal, int line) {
        this.type = type;
        this.lexeme = lexeme;
        this.literal = literal;
        this.line = line;
    }

    public String toString() {
        return type + " " + lexeme + " " + literal;
    }

}

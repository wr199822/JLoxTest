package com.wangrui.Lox;

public class RpnPrinter implements Expr.Visitor<String>{
    String print(Expr expr) {
        return expr.accept(this);
    }

    @Override
    public String visitBinaryExpr(Expr.Binary expr) {
        return parenthesize(expr.operator.lexeme,
                expr.left, expr.right);
    }

    @Override
    public String visitGroupingExpr(Expr.Grouping expr) {
        return parenthesize(null, expr.expression);
    }

    @Override
    public String visitLiteralExpr(Expr.Literal expr) {
        if (expr.value == null) return "nil";
        return expr.value.toString();
    }

    @Override
    public String visitUnaryExpr(Expr.Unary expr) {
        return parenthesize(expr.operator.lexeme, expr.right);
    }

    private String parenthesize(String name, Expr... exprs) {
        StringBuilder builder = new StringBuilder();

        for (Expr expr : exprs) {
            if (exprs.length==1){
                builder.append(name);
            }
            builder.append(expr.accept(this));
            builder.append(" ");
        }
        if (exprs.length==2){
            builder.append(name);
        }

        return builder.toString();
    }


    public static void main(String[] args) {
        Expr expression = new Expr.Binary(
                new Expr.Binary(
                        new Expr.Literal("1"),
                        new Token(TokenType.PLUS,"+",null,1),
                        new Expr.Unary(new Token(TokenType.MINUS, "-", null, 1),
                                new Expr.Literal(123))
                ),
                new Token(TokenType.STAR,"*",null,1),
                new Expr.Binary(
                        new Expr.Literal("3"),
                        new Token(TokenType.MINUS,"-",null,1),
                        new Expr.Literal("4")
                )
        );

        System.out.println(new RpnPrinter().print(expression));
    }
}

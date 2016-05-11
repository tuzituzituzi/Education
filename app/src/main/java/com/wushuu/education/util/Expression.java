package com.wushuu.education.util;

/**
 * Created by root on 16-5-11.
 */
public class Expression {
    private String question;
    private int result;

    public Expression(String question, int result){
        this.question = question;
        this.result = result;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Expression{" +
                "question='" + question + '\'' +
                ", result=" + result +
                '}';
    }
}

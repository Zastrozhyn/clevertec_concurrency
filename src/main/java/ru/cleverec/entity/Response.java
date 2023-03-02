package ru.cleverec.entity;

public class Response {
    private int value;

    public int getValue(){
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }

    @Override
    public String toString(){
        return "Response{" +
                "value=" + value +
                '}';
    }
}

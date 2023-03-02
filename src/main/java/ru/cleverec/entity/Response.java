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
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Response response = (Response) o;

        return value == response.value;
    }

    @Override
    public int hashCode(){
        return value;
    }

    @Override
    public String toString(){
        return "Response{" +
                "value=" + value +
                '}';
    }
}

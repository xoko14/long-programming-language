package com;

import java.util.Objects;

public class Variable {
    public int id;
    public String val;

    Variable(int id, String val){
        this.id=id;
        this.val=val;
    }
    Variable(int id){
        this.id = id;
    }

    public static Variable fromId(int id){
        return new Variable(id);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Variable)) {
            return false;
        }
        Variable variable = (Variable) o;
        return id == variable.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

package com;

import java.util.ArrayList;

public class VariableList {
    private ArrayList<Variable> variables;

    VariableList(){
        variables = new ArrayList<>();
    }

    public void set(Variable var){
        if(this.find(var.id)<0) variables.add(var);
        else variables.set(this.find(var.id), var);
    }

    private int find(int id){
        for(int i=0;i<variables.size();i++){
            if(variables.get(i).id == id) return i;
        }
        return -1;
    }

    public Variable get(int id){
        if(this.find(id)<0) return null;
        return variables.get(this.find(id));
    }
}

package org.techtown.todolist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class Todo {
    private  String todoName;

    //생성자
    public  Todo(String todoName){
        this.todoName = todoName;
    }

    //getter
    public String getTodoName(){
        return todoName;
    }


}

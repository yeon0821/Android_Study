package org.techtown.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> {

    private ArrayList<Todo> mData; // Todo라는 객체를 가진 ArrayList 생성

    public TodoAdapter(ArrayList<Todo> mData) {
        this.mData = mData;
    }

    //item View 를 저장하는 뷰홀더 클래스
    public class ViewHolder extends RecyclerView.ViewHolder {

        protected TextView textView_todo_item;
        protected ImageButton deleteBt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.textView_todo_item = itemView.findViewById(R.id.textview_todo_item);
            this.deleteBt = itemView.findViewById(R.id.button_todo_item);


            //ArrayList 삭제버튼
            deleteBt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition(); //현재 어뎁터가 다루고 있는 리스트의 포지션을 가져온다,.

                    if (position != RecyclerView.NO_POSITION) {//삭제된 포지션이 아닌경우
                        mData.remove(position); //ArrayList<Todo> 타입의 리스트에서 해당 포지션의 item을 제거.
                        notifyDataSetChanged(); //어뎁터에게  데이터셋이 변경되었음을 알림.
                    }
                }
            });
        }
    }


    //onCreateViewHolde() - 아이템 뷰를 위한 뷰홀더 객체를 생성하여 리턴. 이해하기 어려움
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.recyclerview_item, parent, false);
        ViewHolder vh = new ViewHolder(view);

        return vh;
    }

    //onBindViewHolder() - position에 해당하는 데이터를 뷰홀더에 의 아이템 뷰에 표시.
    @Override
    public void onBindViewHolder(TodoAdapter.ViewHolder holder, int position) {
        holder.textView_todo_item.setText(mData.get(position).getTodoName());   //직접적으로 binding 해주는 것
        //textView-todo_item.setText("할 일을 적으세요"); 동일
    }


    //getItemCount() - 전체 데이터 수 갯수 리턴
    @Override
    public int getItemCount() {
        return mData.size();
    }
}

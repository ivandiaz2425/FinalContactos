package com.example.jonmid.contactosbasededatos.Views;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.jonmid.contactosbasededatos.Adapters.CommentAdapter;
import com.example.jonmid.contactosbasededatos.Helpers.SqliteHelper;
import com.example.jonmid.contactosbasededatos.Models.Comment;
import com.example.jonmid.contactosbasededatos.R;

import java.util.ArrayList;
import java.util.List;

public class ListCommentActivity extends AppCompatActivity {

    RecyclerView recyclerViewComment;
    CommentAdapter commentAdapter;
    List<Comment> commentList = new ArrayList<>();
    SqliteHelper sqliteHelper;

    Integer idContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_comment);

        recyclerViewComment = (RecyclerView) findViewById(R.id.id_rv_comments);
        sqliteHelper = new SqliteHelper(this, "db_contacts", null, 1);

        idContact = getIntent().getExtras().getInt("id");

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewComment.setLayoutManager(linearLayoutManager);

        listComments();
    }

    public void listComments(){
        SQLiteDatabase db = sqliteHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select id,title,comment,id_user from comments where id_user = "+idContact+" order by id desc", null);

        while (cursor.moveToNext()){
            Comment comment = new Comment();
            comment.setId(cursor.getInt(0));
            comment.setTitle(cursor.getString(1));
            comment.setComment(cursor.getString(2));
            comment.setId_user(cursor.getInt(3));
            commentList.add(comment);
        }

        cursor.close();

        if (commentList.size() != 0){
            processData();
        }else{
            Toast.makeText(this, "Lista vacia", Toast.LENGTH_SHORT).show();
        }
    }

    public void processData(){
        commentAdapter = new CommentAdapter(commentList, getApplicationContext());
        recyclerViewComment.setAdapter(commentAdapter);
    }
}

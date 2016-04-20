package usingfirebase.orcaella.com.testingfirebase.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.ui.FirebaseRecyclerAdapter;

import usingfirebase.orcaella.com.testingfirebase.R;
import usingfirebase.orcaella.com.testingfirebase.model.UserModel;

public class MainActivity  extends BaseActivity implements View.OnClickListener{

    private RecyclerView recyclerViewMain;
    private FirebaseRecyclerAdapter<UserModel, viewHolder> adapter;
    private Button addUser_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewMain = (RecyclerView) findViewById(R.id.recycleview_main);
        addUser_button = (Button) findViewById(R.id.main_add_user_button);
        recyclerViewMain.setHasFixedSize(true);
        recyclerViewMain.setLayoutManager(new LinearLayoutManager(this));

        addUser_button.setOnClickListener(this);
        adapter = new FirebaseRecyclerAdapter<UserModel, viewHolder>(
                UserModel.class,
                R.layout.item_list,
                viewHolder.class,
                mRefChildUser
        ) {
            @Override
            protected void populateViewHolder(viewHolder viewHolder, UserModel userModel, int i) {
                viewHolder.fullnameUser.setText(userModel.getFullname());
                viewHolder.emailUser.setText(userModel.getEmail());
                viewHolder.sexUser.setText(userModel.getGender());
                viewHolder.phoneUser.setText(userModel.getPhone());
            }
        };

        recyclerViewMain.setAdapter(adapter);


    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.cleanup();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_add_user_button:
                startActivity(new Intent(this, AddUserActivity.class));
                break;
        }
    }

    static class viewHolder extends RecyclerView.ViewHolder {
        TextView fullnameUser;
        TextView emailUser;
        TextView sexUser;
        TextView phoneUser;

        viewHolder(View view) {
            super(view);
            fullnameUser = (TextView) view.findViewById(R.id.fullname);
            emailUser = (TextView) view.findViewById(R.id.email);
            sexUser = (TextView) view.findViewById(R.id.jeniskelamin);
            phoneUser = (TextView) view.findViewById(R.id.phone);
        }
    }
}

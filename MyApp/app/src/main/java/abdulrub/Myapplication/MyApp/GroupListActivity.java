package abdulrub.Myapplication.MyApp;

import androidx.appcompat.app.AppCompatActivity;
//import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.cometchat.pro.core.CometChat;
import com.cometchat.pro.core.GroupsRequest;
import com.cometchat.pro.exceptions.CometChatException;
import com.cometchat.pro.models.Group;

import java.util.List;

import abdulrub.Myapplication.MyApp.adapters.GroupsAdapter;

public class GroupListActivity extends AppCompatActivity {
    public static void start(Context context) {
        Intent starter = new Intent(context, GroupListActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grouplist);

        getGroupList();
    }
    public void getGroupList(){
        GroupsRequest groupsRequest = new GroupsRequest.GroupsRequestBuilder().build();
        groupsRequest.fetchNext(new CometChat.CallbackListener<List<Group>>() {
            @Override
            public void onSuccess(List<Group> list) {
                updateUI(list);
            }
            @Override
            public void onError(CometChatException e) {
            }
        });


    }

    private void updateUI(List<Group> list) {
        RecyclerView groupsRecyclerView = findViewById(R.id.groupsRecyclerView);
        groupsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        GroupsAdapter groupsAdapter = new GroupsAdapter(list, this);
        groupsRecyclerView.setAdapter(groupsAdapter);
    }
}
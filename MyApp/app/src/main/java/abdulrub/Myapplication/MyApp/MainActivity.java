package abdulrub.Myapplication.MyApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.cometchat.pro.core.CometChat;
import com.cometchat.pro.exceptions.CometChatException;
import com.cometchat.pro.models.User;

import abdulrub.Myapplication.MyApp.utils.Constants;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initCometChat();
        initViews();
    }
    private void initViews(){
        EditText userIdEditText = findViewById(R.id.userIdEditText);
        Button submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(view -> CometChat.login(userIdEditText.getText().toString(), Constants.APP_KEY, new CometChat.CallbackListener<User>() {
            @Override
            public void onSuccess(User user) {
                redirectToGroupListScreen();
            }
            @Override
            public void onError(CometChatException e) {
            }
        }));
    }
    private void redirectToGroupListScreen(){
//        Context context;
        GroupListActivity.start(this);
    };
    private void initCometChat(){
        CometChat.init(this, Constants.APP_ID, new CometChat.CallbackListener<String>() {
            @Override
            public void onSuccess(String successMessage) {
//                Log.d(TAG, "Initialization completed successfully");
            }
            @Override
            public void onError(CometChatException e) {
//                Log.d(TAG, "Initialization failed with exception: " + e.getMessage());
            }
        });
    }
}
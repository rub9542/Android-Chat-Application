package abdulrub.Myapplication.MyApp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cometchat.pro.models.Group;

import java.util.List;

import abdulrub.Myapplication.MyApp.ChatActivity;
import abdulrub.Myapplication.MyApp.GroupListActivity;
import abdulrub.Myapplication.MyApp.R;

public class GroupsAdapter  extends RecyclerView.Adapter<GroupsAdapter.GroupViewHolder> {

    private List<Group> groups;
    private GroupListActivity context;
    public GroupsAdapter(List<Group> groups, GroupListActivity context){
        this.groups =groups;
        this.context=context;
    }

    @NonNull
    @Override
    public GroupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GroupViewHolder(LayoutInflater.from(context).inflate(R.layout.group_layout,parent,false));
    }

    public void onBindViewHolder(@NonNull GroupViewHolder holder, int position){
        holder.bind(groups.get(position));
    }
    public int getItemCount(){return  groups.size();}
    class GroupViewHolder extends RecyclerView.ViewHolder{
        TextView groupNameTextView;
        LinearLayout containerLayout;

        public GroupViewHolder (@NonNull View itemView){
            super(itemView);
            groupNameTextView = itemView.findViewById((R.id.groupNameTextView));
            containerLayout =itemView.findViewById(R.id.containerLayout);
        }
        public void bind(Group group){
            groupNameTextView.setText((group.getName()));
            containerLayout.setOnClickListener((view -> ChatActivity.start(context, group.getGuid())));
        }


        }
    }


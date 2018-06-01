package suku.com.meenasunrise.feature.contactlist;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import suku.com.meenasunrise.R;
import suku.com.meenasunrise.feature.common.AdapterItemClickListener;
import suku.com.meenasunrise.model.DirectoryCategoryModel;
import suku.com.meenasunrise.storage.database.entity.UserDetails;

public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.ViewHolder> {

    private AdapterItemClickListener clickListener;
    private List<UserDetails> modelList;

    public ContactListAdapter(List<UserDetails> modelList){
        this.modelList = modelList;
    }

    public void setItemClickListner(AdapterItemClickListener clickListener){
            this.clickListener = clickListener;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_view_contactlist, parent, false);
        ContactListAdapter.ViewHolder holder = new ContactListAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        UserDetails userDetails = modelList.get(position);
        holder.tvType.setText(userDetails.getFlatId());
        holder.tvName.setText(userDetails.getUserName());
        holder.tvPhNo.setText(userDetails.getUserPhNo());
        holder.tvEmail.setText(userDetails.getUserEmail());
        holder.itemPosition = position;
    }

    @Override
    public int getItemCount() {
        if(modelList != null){
            return modelList.size();
        }else{
            return 0;
        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tvType)
        TextView tvType;
        @BindView(R.id.tvName)
        TextView tvName;
        @BindView(R.id.tvPhNo)
        TextView tvPhNo;
        @BindView(R.id.tvEmail)
        TextView tvEmail;

        int itemPosition;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(clickListener != null){
                        clickListener.onAdapterItemClick(v,itemPosition,modelList.get(itemPosition));
                    }
                }
            });
        }
    }
}

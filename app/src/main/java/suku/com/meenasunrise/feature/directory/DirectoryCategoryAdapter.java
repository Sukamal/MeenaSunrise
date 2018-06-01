package suku.com.meenasunrise.feature.directory;

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

public class DirectoryCategoryAdapter extends RecyclerView.Adapter<DirectoryCategoryAdapter.CategoryViewHolder> {

    private AdapterItemClickListener clickListener;
    private List<DirectoryCategoryModel> modelList;

    public DirectoryCategoryAdapter(List<DirectoryCategoryModel> modelList){
        this.modelList = modelList;
    }

    public void setItemClickListner(AdapterItemClickListener clickListener){
            this.clickListener = clickListener;
    }
    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_view_directory, parent, false);
        DirectoryCategoryAdapter.CategoryViewHolder holder = new DirectoryCategoryAdapter.CategoryViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {

        DirectoryCategoryModel categoryModel = modelList.get(position);
        holder.tvCategory.setText(categoryModel.getCategoryName());
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

    public class CategoryViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.cvItem)
        CardView cvItem;
        @BindView(R.id.tvCategory)
        TextView tvCategory;
        @BindView(R.id.ivCategoryImage)
        ImageView ivCategoryImage;
        @BindView(R.id.tvCategoryDesc)
        TextView tvCategoryDesc;

        int itemPosition;

        public CategoryViewHolder(View itemView) {
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

package com.example.lesson32.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lesson32.databinding.FragmentBoardBinding;
import com.example. lesson32.models.viewpager_model.ViewPagerModel;
import com.example.lesson32.utils.interfaces.OnPagerClickListener;

import java.util.ArrayList;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewPagerHolder> {
    ArrayList<ViewPagerModel> list = new ArrayList<>();
    OnPagerClickListener onPagerClickListener;

    public ViewPagerAdapter(ArrayList<ViewPagerModel> list, OnPagerClickListener onPagerClickListener) {
        this.list = list;
        this.onPagerClickListener = onPagerClickListener;
    }

    @NonNull
    @Override
    public ViewPagerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewPagerHolder(FragmentBoardBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerHolder holder, int position) {
        holder.onBind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();


    }

    public class ViewPagerHolder extends RecyclerView.ViewHolder {
        private FragmentBoardBinding binding;

        public ViewPagerHolder(@NonNull FragmentBoardBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(ViewPagerModel viewPagerModel) {
            binding.tvTitle.setText(viewPagerModel.getTitle());
            binding.tvDescription.setText(viewPagerModel.getDescription());
            binding.imImage.setImageResource(viewPagerModel.getImage());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onPagerClickListener.onClick(viewPagerModel);

                }
            });
        }
    }
}

package com.example.asm.ui.chi;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.asm.R;
import com.example.asm.adapter.ItemClickListener;
import com.example.asm.adapter.LoaiChiRecyclerviewAdapter;
import com.example.asm.adapter.LoaiThuRecyclerViewAdapter;
import com.example.asm.dialog.LoaiChiDetailDialog;
import com.example.asm.dialog.LoaiChiDialog;
import com.example.asm.dialog.LoaiThuDetailDialog;
import com.example.asm.dialog.LoaiThuDialog;
import com.example.asm.entity.LoaiChi;
import com.example.asm.entity.LoaiThu;
import com.example.asm.ui.thu.LoaiThuFragment;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class LoaiChiFragment extends Fragment {
    private RecyclerView mrecyclerView;
    private LoaiChiRecyclerviewAdapter mAdapter;
    private LoaiChiViewModel mViewModel;

    public static LoaiChiFragment newInstance() {
        return new LoaiChiFragment();
    }

    public LoaiChiViewModel getViewModel(){
        return mViewModel;
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.loai_chi_fragment, container, false);
    }
    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mrecyclerView = view.findViewById(R.id.recyclerViewLoaiChi);
        mAdapter = new LoaiChiRecyclerviewAdapter(getActivity());
        mrecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mrecyclerView.setAdapter(mAdapter);
        final LoaiChiFragment loaiThuFragment = this;
        mAdapter.setOnItemEditClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int position) {
                LoaiChi loaiThu =mAdapter.getItem(position);
                LoaiChiDialog dialog = new LoaiChiDialog(getActivity(),loaiThuFragment, loaiThu);
                dialog.show();
            }
        });
        mAdapter.setOnItemViewClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int position) {
                LoaiChi loaiThu =mAdapter.getItem(position);
                LoaiChiDetailDialog dialog = new LoaiChiDetailDialog(getActivity(),loaiThuFragment,loaiThu);
                dialog.show();
            }
        });
        ItemTouchHelper Helper =new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                LoaiChi lt = mAdapter.getItem(position);

                Toast.makeText(getActivity(), "xóa thành công",Toast.LENGTH_SHORT).show();
                mViewModel.delete(lt);
            }
        });
        Helper.attachToRecyclerView(mrecyclerView);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(LoaiChiViewModel.class);
        mViewModel.getAllLoaiThu().observe(getActivity(), new Observer<List<LoaiChi>>() {
            @Override
            public void onChanged(List<LoaiChi> loaiThus) {
                mAdapter.setMlisst(loaiThus);
            }
        });
    }

}
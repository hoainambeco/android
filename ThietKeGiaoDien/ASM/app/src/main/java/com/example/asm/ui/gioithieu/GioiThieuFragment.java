package com.example.asm.ui.gioithieu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.asm.R;

public class GioiThieuFragment extends Fragment {
    ListView lvgt;
    private ArrayAdapter arrayAdapter;

//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    public GioiThieuFragment() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment GioiThieuFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static GioiThieuFragment newInstance(String param1, String param2) {
//        GioiThieuFragment fragment = new GioiThieuFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gioi_thieu, container, false);
        lvgt=view.findViewById(R.id.lvgt);

        String[] values = new String[] { "Loại Bài: Assigment Thiết kế giao diện android", "Tên Bài: Quản Lý Chi tiêu", "ngày xuất bản: 02/08/2021","Lớp: CP16302","Mã sinh Viên: PH14161","Tác Giả: Nguyễn Hoài Nam","Email: namnhph14161@fpt.edu.vn"};
        arrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, values);
        lvgt.setAdapter(arrayAdapter);
        return view;
    }
}
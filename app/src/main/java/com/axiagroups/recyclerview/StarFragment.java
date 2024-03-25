package com.axiagroups.recyclerview;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StarFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Activity referenceActivity;
    View parentHolder;

    public StarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment star_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StarFragment newInstance(String param1, String param2) {
        StarFragment fragment = new StarFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        referenceActivity = getActivity();
        parentHolder = inflater.inflate(R.layout.fragment_star, container,
                false);

//        backBtn = (Button) parentHolder.findViewById(R.id.back_btn);

        PieChart pieChart = parentHolder.findViewById(R.id.pie_chart);

        ArrayList<PieEntry> entries = new ArrayList<>();

        entries.add(new PieEntry(80, "Achived"));
        entries.add(new PieEntry(20, "Remaining"));

        PieDataSet pieDataSet = new PieDataSet(entries, "Target");
//        pieDataSet.setColor(ColorTemplate.MATERIAL_COLORS);
        int [] colors={ Color.rgb(100,221,23), Color.rgb(128,0,128)};
        pieDataSet.setColors(colors);
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.getDescription().setEnabled(false);
        pieChart.animateY(1000);
        pieChart.invalidate();








//        return inflater.inflate(R.layout.fragment_star_fragment, container, false);
        return parentHolder;
    }

}
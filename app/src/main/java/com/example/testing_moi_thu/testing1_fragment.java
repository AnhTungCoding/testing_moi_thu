package com.example.testing_moi_thu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link testing1_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class testing1_fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public testing1_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment testing1_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static testing1_fragment newInstance(String param1, String param2) {
        testing1_fragment fragment = new testing1_fragment();
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

    ListView jars_list_listview;
    ArrayList<CJarlist> arrayList;
    Cjarlist_listAdapter cjarlistListAdapter;

    BarChart moneyFlowChart;

    BarDataSet set1, set2;
    ArrayList barEntries;

    String[] days = new String[]{"mon", "tue", "wen", "thu", "fri", "sat", "sun"};
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_testing1_fragment, container, false);
        jars_list_listview = (ListView) view.findViewById(R.id.jars_list_listview);

        //-----------------------------------------------------------------------------------
        moneyFlowChart = view.findViewById(R.id.moneyFlow_barchart);
        set1 = new BarDataSet(entries1(), "Chi");
        set1.setColor(ColorTemplate.rgb("0E6655"));
        set2 = new BarDataSet(entries2(), "Thu");
        set2.setColor(ColorTemplate.rgb("E74C3C"));

        BarData data = new BarData(set1, set2);
        moneyFlowChart.setData(data);
        //code duoi day dc lay tu geeksforgeeks

        // below line is to remove description
        // label of our bar chart.
        moneyFlowChart.getDescription().setEnabled(false);

        // below line is to get x axis
        // of our bar chart.
        XAxis xAxis = moneyFlowChart.getXAxis();

        // below line is to set value formatter to our x-axis and
        // we are adding our days to our x axis.
        xAxis.setValueFormatter(new IndexAxisValueFormatter(days));

        // below line is to set center axis
        // labels to our bar chart.
        xAxis.setCenterAxisLabels(true);

        // below line is to set position
        // to our x-axis to bottom.
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        // below line is to set granularity
        // to our x axis labels.
        xAxis.setGranularity(1);

        // below line is to enable
        // granularity to our x axis.
        xAxis.setGranularityEnabled(true);

        // below line is to make our
        // bar chart as draggable.
        moneyFlowChart.setDragEnabled(true);

        // below line is to make visible
        // range for our bar chart.
        moneyFlowChart.setVisibleXRangeMaximum(3);

        // below line is to add bar
        // space to our chart.
        float barSpace = 0.1f;

        // below line is use to add group
        // spacing to our bar chart.
        float groupSpace = 0.5f;

        // we are setting width of
        // bar in below line.
        data.setBarWidth(0.15f);

        // below line is to set minimum
        // axis to our chart.
        moneyFlowChart.getXAxis().setAxisMinimum(0);

        // below line is to
        // animate our chart.
        moneyFlowChart.animate();

        // below line is to group bars
        // and add spacing to it.
        moneyFlowChart.groupBars(0, groupSpace, barSpace);

        // below line is to invalidate
        // our bar chart.
        moneyFlowChart.invalidate();



        //-----------------------------------------------------------------------------------
        arrayList = CJarlist.jarlist();
        cjarlistListAdapter = new Cjarlist_listAdapter(getActivity(), R.layout.jarlist_layout_mainpage, arrayList);
        jars_list_listview.setAdapter(cjarlistListAdapter);

        return view;
    }

    private  ArrayList<BarEntry> entries1(){
        barEntries = new ArrayList<>();

        barEntries.add(new BarEntry(300f, 0));


        return barEntries;
    }

    private ArrayList<BarEntry> entries2(){
        barEntries = new ArrayList<>();

        barEntries.add(new BarEntry(500f, 0));

        return barEntries;
    }


}
package com.axiagroups.recyclerview;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.axiagroups.recyclerview.adapter.ContactAdapter;
import com.axiagroups.recyclerview.model.Contact;
import com.axiagroups.recyclerview.util.Util;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AllContactFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AllContactFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Activity referenceActivity;
    View parentHolder;

    List<Contact> conactList;

    private RecyclerView recyclerView;
    private ContactAdapter contactAdapter;

    public AllContactFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AllContactFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AllContactFragment newInstance(String param1, String param2) {
        AllContactFragment fragment = new AllContactFragment();
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
        parentHolder = inflater.inflate(R.layout.fragment_all_contact, container, false);


        conactList = Util.getNameList();

        recyclerView = parentHolder.findViewById(R.id.allContacts);
        recyclerView.setLayoutManager(new LinearLayoutManager(referenceActivity));

        contactAdapter = new ContactAdapter(referenceActivity, conactList);
        recyclerView.setAdapter(contactAdapter);

        return parentHolder;
    }
}
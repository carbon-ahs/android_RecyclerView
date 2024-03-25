package com.axiagroups.recyclerview;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.axiagroups.recyclerview.adapter.ContactAdapter;
import com.axiagroups.recyclerview.model.Contact;
import com.axiagroups.recyclerview.util.Util;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Activity referenceActivity;
    View parentHolder;
    private RecyclerView recyclerView;
    private ContactAdapter contactAdapter;
    private SearchView searchView;
    List<Contact> conactList;

    public SearchFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SearchFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchFragment newInstance(String param1, String param2) {
        SearchFragment fragment = new SearchFragment();
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
        referenceActivity = getActivity();
        parentHolder = inflater.inflate(R.layout.fragment_search, container, false);


        conactList = Util.getNameList();

        searchView = parentHolder.findViewById(R.id.searchbar_searchFragment);
        Log.d("TAG", "onCreateView: " + searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                contactAdapter = new ContactAdapter(referenceActivity, conactList);
                Util.filteredList(referenceActivity , newText, conactList, contactAdapter);
                recyclerView = parentHolder.findViewById(R.id.recyclerView_searchFragment);
                recyclerView.setLayoutManager(new LinearLayoutManager(referenceActivity));

                recyclerView.setAdapter(contactAdapter);
                return true;
            }
        });

//        recyclerView = parentHolder.findViewById(R.id.recyclerView_searchFragment);
//        recyclerView.setLayoutManager(new LinearLayoutManager(referenceActivity));
//
//        contactAdapter = new ContactAdapter(referenceActivity, conactList);
//        recyclerView.setAdapter(contactAdapter);

        return parentHolder;
    }
}
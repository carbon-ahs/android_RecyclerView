package com.axiagroups.recyclerview;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.axiagroups.recyclerview.adapter.ContactAdapter;
import com.axiagroups.recyclerview.model.Contact;
import com.axiagroups.recyclerview.util.Util;

import java.util.List;

public class AllContactsActivity extends AppCompatActivity {
    private TextView textView;
    private RecyclerView recyclerView;
    private ContactAdapter contactAdapter;
    private SearchView searchView;
    List<Contact> conactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_allcontacts);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.drawer_layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        conactList = Util.getNameList();
        Log.d("TAG", "onCreate: " + conactList);
        searchView = findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Util.filteredList(AllContactsActivity.this , newText, conactList, contactAdapter);
                return true;
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        contactAdapter = new ContactAdapter(this, conactList);
        recyclerView.setAdapter(contactAdapter);
    }

}
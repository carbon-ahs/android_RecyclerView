package com.axiagroups.recyclerview.adapter;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.axiagroups.recyclerview.MainActivity;
import com.axiagroups.recyclerview.R;
import com.axiagroups.recyclerview.SingleContact;
import com.axiagroups.recyclerview.model.Contact;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHoder> {
    private Context context;
    private List<Contact> contactList;

    public ContactAdapter(Context context, List<Contact> contactList) {
        this.context = context;
        this.contactList = contactList;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_row, parent,false);
        return new ViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, int position) {
        Contact contact = contactList.get(position);
        holder.nameTV.setText(contact.getName());
        holder.addressTV.setText(contact.getAddress());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context.getApplicationContext(), SingleContact.class);
//                Intent i = new Intent(this.context, SingleContact.class);
//                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("name",contact.getName());
                i.putExtra("address",contact.getAddress());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder {
        private TextView nameTV, addressTV;
        public ViewHoder(@NonNull View itemView) {
            super(itemView);
            nameTV = itemView.findViewById(R.id.row_nameTV);
            addressTV = itemView.findViewById(R.id.row_addressTV);

        }
    }

    public void setContactList(List<Contact> newContactList){
        this.contactList = newContactList;
        notifyDataSetChanged();
    }
}

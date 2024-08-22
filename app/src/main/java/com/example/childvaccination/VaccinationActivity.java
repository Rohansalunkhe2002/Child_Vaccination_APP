package com.example.childvaccination;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class VaccinationActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    VaccinationAdapter vaccinationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccination2);
        getSupportActionBar().setTitle("Vaccination List");
        recyclerView =(RecyclerView)findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<VaccinationModel>options= new FirebaseRecyclerOptions.Builder<VaccinationModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Vaccinations"),VaccinationModel.class).build();
        vaccinationAdapter = new VaccinationAdapter(options);
        recyclerView.setAdapter(vaccinationAdapter);
    }
    @Override
    protected void onStart() {
        super.onStart();
        vaccinationAdapter.startListening();
    }
    @Override
    protected void onStop() {
        super.onStop();
        vaccinationAdapter.stopListening();
    }
}

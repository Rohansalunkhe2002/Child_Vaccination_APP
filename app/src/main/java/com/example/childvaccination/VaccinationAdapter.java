package com.example.childvaccination;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class VaccinationAdapter extends FirebaseRecyclerAdapter<VaccinationModel,VaccinationAdapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public VaccinationAdapter(@NonNull FirebaseRecyclerOptions<VaccinationModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull VaccinationModel model) {
        holder.Age.setText(model.getAge());
        holder.Vaccination.setText(model.getVaccination());
        holder.Gender.setText(model.getGender());

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vaccination_item,parent,false);
        return new myViewHolder(view);
    }
    class myViewHolder extends RecyclerView.ViewHolder{
        TextView Age,Vaccination,Gender;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            Age = (TextView)itemView.findViewById(R.id.Age);
            Vaccination =(TextView)itemView.findViewById(R.id.vaccination);
            Gender =(TextView) itemView.findViewById(R.id.Gender);
        }
    }
}

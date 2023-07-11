package com.alfonsusjericho_202102286.login_mahasiswa_forex_cuaca.mahasiswa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alfonsusjericho_202102286.login_mahasiswa_forex_cuaca.R;

import java.util.List;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaViewHolder> {
    private List<MahasiswaModel> _mahasiswaModelList;
    public MahasiswaAdapter(List<MahasiswaModel> mahasiswaModelList){
        this._mahasiswaModelList = mahasiswaModelList;
    }
    @NonNull
    @Override
    public MahasiswaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.list_mahasiswa,parent,false);
        return new MahasiswaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaViewHolder holder, int position) {
        MahasiswaModel mm = _mahasiswaModelList.get(position);
        holder._jkimageview.setImageResource(R.drawable.boy);
        if (mm.getJenisKelamin().toLowerCase().equals("perempuan")){
            holder._jkimageview.setImageResource(R.drawable.girl);
        }

        holder._nimtextview.setText(mm.getNIM());
        holder._namatextview.setText(mm.getNama());
        holder._jktextview.setText(mm.getJenisKelamin());

        String jp = mm.getJP();
        jp = jp.substring(0,2);
        holder._jptextview.setText(jp);
    }

    @Override
    public int getItemCount() {
        int count = 0;
        if (_mahasiswaModelList != null){
            count = _mahasiswaModelList.size();
        }
        return count;
    }
}

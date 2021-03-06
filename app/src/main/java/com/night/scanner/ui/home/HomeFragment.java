package com.night.scanner.ui.home;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.night.scanner.R;
import com.night.scanner.model.QrCode;

import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private Radapter radapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);

        final View root = inflater.inflate(R.layout.fragment_home, container, false);

        radapter = new Radapter(requireContext(),requireActivity().getApplication());
        RecyclerView recycler = root.findViewById(R.id.recycler);
        Button buttonScan = root.findViewById(R.id.button_scan);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new  LinearLayoutManager(requireContext()));
        recycler.setAdapter(radapter);

        homeViewModel.getAllQrCodes().observe(getViewLifecycleOwner(), new Observer<List<QrCode>>() {
            @Override
            public void onChanged(List<QrCode> qrCodes) {
                radapter.setQrCodes(qrCodes);
            }
        });
        buttonScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO::
            }
        });
        return root;
    }
    private class Mtask extends AsyncTask<Void,Void,Void>{
        @Override
        protected Void doInBackground(Void... voids) {
            homeViewModel.insert(new QrCode("fafa"));
            return null;
        }
    }
}

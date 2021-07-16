package com.example.keephealty.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.keephealty.LoginActivity;
import com.example.keephealty.MainActivity;
import com.example.keephealty.R;
import com.example.keephealty.SessionManager;
import com.example.keephealty.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
private FragmentHomeBinding binding;

    TextView etname;
    String name;
    SessionManager sessionManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        //      Session Name
        sessionManager = new SessionManager(getContext());

        etname = view.findViewById(R.id.etMainname);

        name = (String) sessionManager.getUserDetail().get(SessionManager.NAME);

        etname.setText(name);
        //      End Session name

        return view;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
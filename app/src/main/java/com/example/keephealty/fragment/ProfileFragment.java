package com.example.keephealty.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.keephealty.LoginActivity;
import com.example.keephealty.R;
import com.example.keephealty.SessionManager;
import com.example.keephealty.adapter.ProfileAdapter;
import com.example.keephealty.model.Profile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_profile);
        TextView tv_name = view.findViewById(R.id.tv_name);
        TextView tv_address = view.findViewById(R.id.tv_address);
        Button btn_logout = view.findViewById(R.id.btn_logout);

        List<Profile> profileList = new ArrayList<>();

        SessionManager sessionManager = new SessionManager(getActivity());
        HashMap<String, String> hashMap = sessionManager.getUserDetail();

        tv_name.setText(hashMap.get(SessionManager.NAME));
        tv_address.setText(hashMap.get(SessionManager.ALAMAT));

        profileList.add(new Profile(R.drawable.ic_name, hashMap.get(SessionManager.NAME)));
        profileList.add(new Profile(R.drawable.ic_email, hashMap.get(SessionManager.EMAIL)));
        profileList.add(new Profile(R.drawable.ic_alamat, hashMap.get(SessionManager.ALAMAT)));
        profileList.add(new Profile(R.drawable.ic_nomor, hashMap.get(SessionManager.NOMOR)));

        ProfileAdapter adapter = new ProfileAdapter(getActivity(), profileList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManager.logoutSession();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
    }
}
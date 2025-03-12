package com.sanda.androidcourse.chapter05;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.sanda.androidcourse.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RightFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RightFragment extends Fragment {

    private static final String ARG_TEXT = "arg_text";
    private String text;

    public static RightFragment newInstance(String text) {
        RightFragment fragment = new RightFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TEXT, text);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            text = getArguments().getString(ARG_TEXT);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chapter5_fragment_right, container, false);
        TextView textView = view.findViewById(R.id.textView);
        textView.setText(text);
        return view;
    }
}
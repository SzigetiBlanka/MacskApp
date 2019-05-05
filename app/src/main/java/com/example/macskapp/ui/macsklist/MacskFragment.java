package com.example.macskapp.ui.macsklist;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.macskapp.MacskAppApplication;
import com.example.macskapp.R;
import com.example.macskapp.model.Cat;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MacskFragment extends Fragment implements MacskListScreen {
    @Inject
    MacskListPresenter macskListPresenter;

    private List<Cat> catList;
    private Cat cat;
    private ListAdapter catsAdapter;
    private RecyclerView recyclerViewCats;

    public MacskFragment(){
        MacskAppApplication.injector.inject(this);
    }

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);
        macskListPresenter.attachScreen(this);
    }

    @Override
    public void onDetach() {
        macskListPresenter.detachScreen();
        super.onDetach();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cats, container, false);
        recyclerViewCats = view.findViewById(R.id.cats_recycler_view);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewCats.setLayoutManager(llm);

        catList = new ArrayList<>();
        catsAdapter= new ListAdapter(getContext(), catList);
        recyclerViewCats.setAdapter(catsAdapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        //TODO!!
        macskListPresenter.refreshCats("");
    }

    public void showCats() {

        catList.clear();
        if(Cat.listAll(Cat.class) != null) {
            catList.addAll(Cat.listAll(Cat.class));
        }
        catsAdapter.notifyDataSetChanged();

        if (catList.isEmpty()) {
            recyclerViewCats.setVisibility(View.GONE);
        } else {
            recyclerViewCats.setVisibility(View.VISIBLE);
        }
    }

    public void showCat(Cat cat) {

        catList.clear();
        catList.add(cat);
        if(cat.getCatName() != null && cat.findWithQuery(Cat.class, "Select * from CAT where catname = ?", cat.getCatId()).size() == 0) {
            cat.save();
        }
        catsAdapter.notifyDataSetChanged();
        if (catList.isEmpty()) {
            recyclerViewCats.setVisibility(View.GONE);
        } else {
            recyclerViewCats.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showNetworkError(String errorMsg) {
        Toast.makeText(getContext(), errorMsg, Toast.LENGTH_LONG).show();
    }

}

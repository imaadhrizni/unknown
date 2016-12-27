package com.imaadhrizni.unknown.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imaadhrizni.unknown.Model.Product;
import com.imaadhrizni.unknown.Adapters.RecyclerViewAdapter;
import com.imaadhrizni.unknown.R;
import com.imaadhrizni.unknown.ShoppingCart.ProductListContract;
import com.imaadhrizni.unknown.ShoppingCart.ProductPresenter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Category1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Category1Fragment extends Fragment implements ProductListContract.View {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private View mRootView;
    private ProductListContract.Actions mPresenter;

    ///////
    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    //////


    public Category1Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Category1Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Category1Fragment newInstance(String param1, String param2) {
        Category1Fragment fragment = new Category1Fragment();
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
        onButtonPressed(null);
        mRootView = inflater.inflate(R.layout.fragment_category1, container, false);

        //Instantiate the Presenter
        mPresenter = new ProductPresenter(this);

        initRecyclerView();

        // specify an adapter (see also next example)
        showProducts(new ArrayList<Product>());

        return mRootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String data) {
        if (mListener != null) {
            mListener.onFragmentInteraction("CATEGORY1", data);
        }
    }

    private void initRecyclerView() {
        mAdapter = new RecyclerViewAdapter(new ArrayList<Product>());

        mRecyclerView = (RecyclerView) mRootView.findViewById(R.id.my_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onResume() {
        super.onResume();
        //Ask the Presenter to load the list of products
        mPresenter.loadProducts();
    }

    @Override
    public void showProducts(List<Product> products) {
        //The Presenter returns the list of products here
        //call the replace data method in the Adapter
        mAdapter.replaceData((ArrayList<Product>) products);
    }

    @Override
    public void showAddProductForm() {
        //startActivity(new Intent(Add Product Activity or Fragment))
    }

    @Override
    public void showEditProductForm(Product product) {
        //startActivity(new Intent(Edit Product Activity or Fragment))
        //Pass in the product to be edited
    }

    @Override
    public void showDeleteProductPrompt(Product product) {

    }

    @Override
    public void showGoogleSearch(Product product) {

    }


    @Override
    public void showEmptyText() {
        //Hide RecyclerView
        //Show a TextView showing not items in the list
    }

    @Override
    public void hideEmptyText() {
        //Hide the TextView showing no items in the list
        //Show RecyclerView
    }

    @Override
    public void showMessage(String message) {
        //Show a Toast or Snackbar with the message from the
        //Presenter such as Item added, item deleted, etc
    }
}

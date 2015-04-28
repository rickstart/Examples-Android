package com.mobintum.girlsfragment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PictureFragment.OnPictureFragmentCallbacks} interface
 * to handle interaction events.
 * Use the {@link PictureFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PictureFragment extends Fragment implements View.OnClickListener {


    private static final String ARG_PARAM1 = "param1";
    private int position;
    private OnPictureFragmentCallbacks mCallbacks;
    private ImageView pictureImgView;
    private Button btnUrl;
    private Intent intent;
    private String URL;


    public static PictureFragment newInstance(int position) {
        PictureFragment fragment = new PictureFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, position);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            position = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_picture, container, false);

        pictureImgView = (ImageView) rootView.findViewById(R.id.pictureImgView);
        btnUrl = (Button) rootView.findViewById(R.id.btnUrl);
        btnUrl.setOnClickListener(this);

        loadGirl(position);

        btnUrl.setText(URL);
        return rootView;
    }

    public void loadGirl(int position){
        switch (position) {
            case 0:
                pictureImgView.setImageDrawable(getResources().getDrawable(R.mipmap.emma_watson));
                URL = "https://www.facebook.com/emmawatson";

                break;
            case 1:
                pictureImgView.setImageDrawable(getResources().getDrawable(R.mipmap.alexis_texas));
                URL = "http://teamtexass.com/";
                break;
            case 2:
                pictureImgView.setImageDrawable(getResources().getDrawable(R.mipmap.jennifer_lawrence));
                URL = "https://www.facebook.com/JenniferLawrence/timeline";
                break;
            case 3:
                pictureImgView.setImageDrawable(getResources().getDrawable(R.mipmap.jennifer_love_hewitt));
                URL = "https://www.facebook.com/JLHOfficial?fref=ts";
                break;
            case 4:
                pictureImgView.setImageDrawable(getResources().getDrawable(R.mipmap.cuddy));
                URL = "https://www.facebook.com/LisaEdelstein?fref=ts";
                break;
        }


    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallbacks = (OnPictureFragmentCallbacks) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnPictureFragmentCallbacks");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }

    @Override
    public void onClick(View v) {



        intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse(URL));
        startActivity(intent);

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnPictureFragmentCallbacks {
        // TODO: Update argument type and name
        public void onGirlSelected(int position);
    }

}

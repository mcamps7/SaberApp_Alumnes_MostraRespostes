package com.example.android.saberAppMostraRespostes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.saberAppMostraRespostes.content.RespostesUtils;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PreguntaDetailFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PreguntaDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PreguntaDetailFragment extends Fragment {


    // SongItem includes the song title and detail.
    public RespostesUtils.Pregunta mPregunta;

    public PreguntaDetailFragment() {
        // Required empty public constructor
    }

    /**
     * This method loads the content specified by the fragment arguments.
     *
     * @param savedInstanceState Bundle with recent saved state.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey(RespostesUtils.PREGUNTA_ID_KEY)) {
            // Load the content specified by the fragment arguments.
            mPregunta = RespostesUtils.PREGUNTA_ITEMS.get(getArguments()
                    .getInt(RespostesUtils.PREGUNTA_ID_KEY));
        }
    }

    /**
     * This method inflates the fragment's view and shows the pregunta
     * detail information.
     *
     * @param inflater LayoutInflater object to inflate views
     * @param container ViewGroup that the fragment's UI should be attached to
     * @param savedInstanceState Bundle containing previous state
     * @return Fragment view
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.pregunta_detail,
                container, false);

        // Show the detail information in a TextView.
        if (mPregunta != null) {
            ((TextView) rootView.findViewById(R.id.pregunta_detail))
                    .setText(mPregunta.details);
        }

        return rootView;
    }

    /**
     * This method sets up a bundle for the arguments to pass
     * to a new instance of this fragment.
     *
     * @param selectedPregunta Integer position of selected pregunta in pregunta list
     * @return fragment
     */
    public static PreguntaDetailFragment newInstance (int selectedPregunta) {
        PreguntaDetailFragment fragment = new PreguntaDetailFragment();
        // Set the bundle arguments for the fragment.
        Bundle arguments = new Bundle();
        arguments.putInt(RespostesUtils.PREGUNTA_ID_KEY, selectedPregunta);
        fragment.setArguments(arguments);
        return fragment;
    }

}

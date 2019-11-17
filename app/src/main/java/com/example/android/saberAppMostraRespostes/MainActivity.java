/*
 * Copyright (C) 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.saberAppMostraRespostes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.saberAppMostraRespostes.content.RespostesUtils;

import java.util.List;

/**
 * An activity representing a list of preguntes titles (items). When one is
 * touched in vertical orientation (single pane), an intent starts
 * {@link PreguntaDetailActivity} representing pregunta details. When one is
 * touched in horizontal orientation on a tablet screen (two panes),
 * the activity shows a fragment.
 */
public class MainActivity extends AppCompatActivity {

    // Default layout is one pane, not two.
    private boolean mTwoPane = false;

    /**
     * Sets up a pregunta list as a RecyclerView, and determines
     * whether the screen is wide enough for two-pane mode.
     * The pregunta_detail_container view for MainActivity will be
     * present only if the screen's width is 900dp or larger,
     * because it is defined only in the "pregunta_listlist.xml (w900dp).xml"
     * layout, not in the default "pregunta_list.xml" layout for smaller
     * screen sizes. If this view is present, then the activity
     * should be in two-pane mode.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntes_list);

        // Set the toolbar as the app bar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        // Get the pregunta list as a RecyclerView.
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.preguntes_list);
        recyclerView.setAdapter
                (new SimpleItemRecyclerViewAdapter(RespostesUtils.PREGUNTA_ITEMS));

        // Is the container layout available? If so, set mTwoPane to true.
        if (findViewById(R.id.pregunta_detail_container) != null) {
            mTwoPane = true;
        }
    }

    /**
     * The RecyclerView for the pregunta list.
     */
    class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter
            <SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final List<RespostesUtils.Pregunta> mValues;

        SimpleItemRecyclerViewAdapter(List<RespostesUtils.Pregunta> items) {
            mValues = items;
        }

        /**
         * This method inflates the layout for the pregunta list.
         * @param parent ViewGroup into which the new view will be added.
         * @param viewType The view type of the new View.
         * @return A new ViewHolder
         */
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.pregunta_list_content, parent, false);
            return new ViewHolder(view);
        }

        /**
         * This method implements a listener with setOnClickListener().
         * When the user taps a pregunta title, the code checks if mTwoPane
         * is true, and if so uses a fragment to show the pregunta detail.
         * If mTwoPane is not true, it starts PreguntaDetailActivity
         * using an intent with extra data about which pregunta title was selected.
         *
         * @param holder   ViewHolder
         * @param position Position of the pregunta in the array.
         */
        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mItem = mValues.get(position);
            holder.mIdView.setText(String.valueOf(position + 1));
            holder.mContentView.setText(mValues.get(position).pregunta_title);
            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mTwoPane) {
                        // Get selected pregunta position in pregunta list.
                        int selectedPregunta = holder.getAdapterPosition();
                        // Create new instance of fragment and add it to
                        // the activity using a fragment transaction.
                        PreguntaDetailFragment fragment =
                                PreguntaDetailFragment.newInstance(selectedPregunta);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.pregunta_detail_container, fragment)
                                .addToBackStack(null)
                                .commit();
                    } else {
                        // Send an intent to the PreguntaDetailActivity
                        // with intent extra of the selected pregunta position.
                        Context context = v.getContext();
                        Intent intent = new Intent(context,
                                PreguntaDetailActivity.class);
                        intent.putExtra(RespostesUtils.PREGUNTA_ID_KEY,
                                holder.getAdapterPosition());
                        context.startActivity(intent);
                    }
                }
            });
        }

        /**
         * Get the count of pregunta list items.
         * @return Integer count
         */
        @Override
        public int getItemCount() {
            return mValues.size();
        }

        /**
         * ViewHolder describes an item view and metadata about its place
         * within the RecyclerView.
         */
        class ViewHolder extends RecyclerView.ViewHolder {
            final View mView;
            final TextView mIdView;
            final TextView mContentView;
            RespostesUtils.Pregunta mItem;

            ViewHolder(View view) {
                super(view);
                mView = view;
                mIdView = (TextView) view.findViewById(R.id.id);
                mContentView = (TextView) view.findViewById(R.id.content);
            }
        }
    }
}
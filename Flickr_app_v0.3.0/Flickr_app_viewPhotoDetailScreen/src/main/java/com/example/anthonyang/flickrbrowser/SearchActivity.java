package com.example.anthonyang.flickrbrowser;

import android.app.SearchManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

public class SearchActivity extends BaseActivity {

    private SearchView mSearchView;

    /*
        right click package name -> new -> activity -> basic activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_search);
        activateToolbarWithHomeEnabled();

        /*comment the below code whenever a new blank activity is created.*/
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override //add additional option in the tool bar
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
        final MenuItem searchItem = menu.findItem(R.id.search_view); //Return the menu item with a particular identifier
        mSearchView = (SearchView) searchItem.getActionView(); //Returns the currently set action view for this menu item

        /*
            Use with getSystemService() to retrieve a android.app.SearchManager} for handling searches.
         */
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        mSearchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName())); //Sets the SearchableInfo for this SearchView
        mSearchView.setIconified(false);

        /*
            setOnQueryTextListener() -> Sets a listener for user actions within the SearchView. eg: clicking on buttons or typing a query
            SearchView -> A widget that provides a user interface for the user to enter a search query and submit a request to a search provider.
            OnQueryTextListener() -> Callbacks for changes to the query text.
         */
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) { //user finish typing

                /* *
                    Interface for accessing and modifying preference data returned by {@link
                    Context#getSharedPreferences}.  For any particular set of preferences,
                    there is a single instance of this class that all clients share.

                    Gets a SharedPreferences instance that points to the default file that is
                    used by the preference framework in the given context.*/
                SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());//stored user input (will be retrieved from main activity)
                sharedPref.edit().putString(FLICKR_QUERY, query).commit(); //make modifications to the data in the preferences and atomically commit those changes back to the SharedPreferences object.
                mSearchView.clearFocus();
                finish();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) { //for every one char typed on keyboard ("change")
                return true;
            }
        });

        //Sets a listener to inform when the user closes the SearchView.
        mSearchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                finish(); //Call this when your activity is done and should be closed.
                return false;
            }
        });
        return true;
    }


}

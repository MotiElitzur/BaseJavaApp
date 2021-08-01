package base.java.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

import android.os.Bundle;

import java.util.List;

import base.java.R;
import base.java.databinding.ActivityMainBinding;
import base.java.viewModel.UsersViewModel;

/**
 * The main app activity with the users list.
 */
public class MainActivity extends AppCompatActivity {

    // region constants

    // The users permission code (the number does not really matter).
    private static final int CONTACTS_PERMISSION_CODE = 100;

    // endregion

    // region Data Members

    // The main activity binding.
    private ActivityMainBinding _mainBinding;

    // The users adapter.
    private UsersAdapter _usersAdapter;

    // endregion

    // region Life Cycle Methods

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the main binding from main layout.
        _mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // Initialize the activity.
        initUsers();
    }

    // endregion

    // region Private Methods

    /**
     * Initialize the activity with the view model.
     */
    private void initUsers(){

        UsersViewModel usersViewModel = new UsersViewModel(this);

        // Set the view model to the adapter.
        _usersAdapter = new UsersAdapter(usersViewModel);

        // Add the users adapter to the main activity.
        _mainBinding.setUsersAdapter(_usersAdapter);

        // Start listening when the user live list updated.
        usersViewModel.getUsersList().observe(this, new Observer<List<base.java.model.User>>() {
            @Override
            public void onChanged(List<base.java.model.User> users) {

                // Notify the users adapter that the users list updated.
                _usersAdapter.notifyDataSetChanged();
            }
        });

        // Start to read the users.
        usersViewModel.startReadUsers();
    }

    // endregion
}
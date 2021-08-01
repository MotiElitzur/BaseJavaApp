package base.java.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import base.java.R;
import base.java.databinding.UserDetailsBinding;
import base.java.model.User;

/**
 * The user details activity that contains the user details layout.
 */
public class UserDetailsActivity extends AppCompatActivity {

    // region Life Cycle Methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the user details binding.
        UserDetailsBinding activityBinding =
                DataBindingUtil.setContentView(this, R.layout.user_details);

        // Get the user.
        User user = (User) getIntent().getSerializableExtra(User.class.getSimpleName());

        // Set the user to user details binding.
        activityBinding.setUser(user);
    }

    // endregion
}
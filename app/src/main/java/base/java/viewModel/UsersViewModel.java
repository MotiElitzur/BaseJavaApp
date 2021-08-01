package base.java.viewModel;

import android.content.Context;
import android.content.Intent;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import base.java.model.User;
import base.java.model.UsersRepository;
import base.java.view.UserDetailsActivity;

/**
 *  The users view model that hold the users list and operations when it's change .
 */
public class UsersViewModel extends ViewModel {

    // region Data Members

    // The main context.
    private Context _context;

    // The users list.
    private MutableLiveData<List<User>> _usersList;

    // The user repository.
    private UsersRepository _usersRepository;

    // endregion

    // region Constructor

    public UsersViewModel(Context context){

        _context = context;
        _usersRepository = new UsersRepository();

        // Get the users live data list.
        _usersList = _usersRepository.getUsersLiveData();
    }

    // endregion

    // region Properties

    public MutableLiveData<List<User>> getUsersList() {
        return _usersList;
    }

    public void setUsersList(MutableLiveData<List<User>> usersList) {
        this._usersList = usersList;
    }

    // endregion

    // region Public Methods

    /**
     * Start to read the users.
     */
    public void startReadUsers(){

        // Call the users repository to start to read the users.
        _usersRepository.getUsers(_context);
    }

    /**
     * This function called when a user pressed and open an activity with user details.
     *
     * @param user The user that pressed.
     */
    public void onUserPressed(User user){

        // Pass the user to user details activity.
        Intent intent = new Intent(_context, UserDetailsActivity.class);
        intent.putExtra(User.class.getSimpleName(), user);

        // start user details activity.
        _context.startActivity(intent);
    }

    // endregion
}
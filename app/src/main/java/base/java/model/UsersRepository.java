package base.java.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;

/**
 * This class handles the users list and get the users.
 */
public class UsersRepository {
    
    // region Data Members

    // The Users list.
    private List<User> _usersList = new ArrayList<>();

    // The user live data list.
    private MutableLiveData<List<User>> _usersLiveData =  new MutableLiveData<>();

    // endregion

    // region Constructor

    public UsersRepository() {

    }

    // endregion

    // region Properties

    public MutableLiveData<List<User>> getUsersLiveData() {
        return _usersLiveData;
    }

    public void setUsersLiveData(MutableLiveData<List<User>> usersLiveData) {
        this._usersLiveData = usersLiveData;
    }

    // endregion

    // region Public Methods

    /**
     * This function start to read and add the users from the user source.
     *
     * @param context Context to get the users from the source.
     */
    public void getUsers(Context context){

        // Run on another thread in order to not interrupt the ui.
        new Thread(() -> {

            int offset = 0;

            // Get the first users list.
            List<User> userList = new ArrayList<>();

            // Set an example users.
            for (int i = 0; i < 100; i++) {

                userList.add(new User(String.valueOf(i), "User", "1234"));
            }

            // Add the new users list part to our users list.
            addUsersList(userList);

        }).start();
    }

    // endregion

    // region Private Methods


    /**
     * Receive a users list and add it to our user list.
     *
     * @param users The users list to add.
     */
    private void addUsersList(List<User> users){

        // Add the new users list to our user list.
        _usersList.addAll(users);

        // Update the users live list.
        fetchLiveList();
    }

    /**
     * Receive a user and add it to our user list.
     *
     * @param user The user to add.
     */
    private void addUser(User user){

        // Add the new user to our user list.
        _usersList.add(user);

        // Update the users live list.
        fetchLiveList();
    }

    /**
     * Update the users live list with our users list.
     */
    private void fetchLiveList(){

        // Update the users live list with our users list.
        _usersLiveData.postValue(_usersList);
    }

    // endregion
}
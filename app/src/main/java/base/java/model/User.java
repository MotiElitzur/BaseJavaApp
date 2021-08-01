package base.java.model;

import java.io.Serializable;

/**
 * This class contains the user details and properties.
 */
public class User implements Serializable {

    // region Data Members

    // The user id.
    private String _id;

    // The user name.
    private String _name;

    // The user phone number.
    private String _phoneNumber;

    // endregion

    // region Constructor

    public User(String id, String name, String phoneNumber) {

        this._id = id;
        this._name = name;
        this._phoneNumber = phoneNumber;
    }

    // endregion

    // region Properties

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public String getPhoneNumber() {
        return _phoneNumber;
    }

    // endregion
}
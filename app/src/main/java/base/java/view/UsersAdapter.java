package base.java.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import base.java.BR;
import base.java.R;
import base.java.viewModel.UsersViewModel;

/**
 * This class contains the users recycler view.
 */
public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserViewHolder> {

    // region Data Members

    // The users view model.
    private UsersViewModel _usersViewModel;

    // The users list.
    private MutableLiveData<List<base.java.model.User>> _userList;

    // endregion

    // region Constructor

    public UsersAdapter(UsersViewModel usersViewModel) {

        _usersViewModel = usersViewModel;
        _userList = usersViewModel.getUsersList();
    }

    // endregion

    // region RecyclerView Adapter

    @Override
    public int getItemCount() {
        return _userList == null || _userList.getValue() == null ? 0 : _userList.getValue().size();
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.bind(_userList.getValue().get(position), _usersViewModel);
    }

    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Get the user view binding.
        ViewDataBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.user_view, parent, false);

        return new UserViewHolder(binding);
    }

    // endregion

    // region User View Holder

    /**
     * The user view holder to bind the user in user view.
     */
    public class UserViewHolder extends RecyclerView.ViewHolder {

        // region Data Members

        // The user binding.
        private final ViewDataBinding binding;

        // endregion

        // region Constructor

        public UserViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        // endregion

        // region Public Methods

        /**
         * Receive a user and bind it to user view binding.
         *
         * @param user The user to bind.
         *
         * @param usersViewModel UsersViewModel, to do more action from users view binding.
         */
        public void bind(base.java.model.User user, UsersViewModel usersViewModel) {

            // bind the user.
            binding.setVariable(BR.user, user);
            binding.setVariable(BR.userViewModel, usersViewModel);

            binding.executePendingBindings();
        }

        // endregion
    }

    // endregion
}
package com.limitlessvirtual.droidsembla.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ListView;

import com.limitlessvirtual.droidsembla.R;
import com.limitlessvirtual.droidsembla.adapters.UserAdapter;
import com.limitlessvirtual.droidsembla.repository.UserRepository;


/**
 * Created by keith on 2015/02/06.
 */
public class ProjectActivity extends Activity {
    private ListView usersList;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        usersList = (ListView) this.findViewById(R.id.users_list);
        userAdapter = new UserAdapter(getApplicationContext());
        usersList.setAdapter(userAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        super.onStart();
        userAdapter.updateData(UserRepository.getAllUsers(getApplicationContext()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.box_list_menu, menu);
        return true;
    }
}

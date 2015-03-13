package com.limitlessvirtual.droidsembla.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.limitlessvirtual.droidsembla.R;
import com.limitlessvirtual.droidsembla.models.User;
import com.limitlessvirtual.droidsembla.repository.UserRepository;


/**
 * Created by keith on 2015/02/13.
 */
public class ProfileActivity extends Activity{
    private TextView userName;
    private TextView userId;
    private TextView email;
    private TextView projects;
    private TextView tickets;
    private TextView completedTickets;

    private Button viewProjectsBtn;
    private Button viewUsers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        userName = (TextView) findViewById(R.id.name);
        userId = (TextView) findViewById(R.id.userId);
        email = (TextView) findViewById(R.id.email);
        tickets = (TextView) findViewById(R.id.number_of_tickets);
        projects = (TextView) findViewById(R.id.number_of_project);
        completedTickets = (TextView) findViewById(R.id.completed_tickets);

        updateProfile();

        viewProjectsBtn = (Button) findViewById(R.id.viewProjectsBtn);
        viewUsers = (Button) findViewById(R.id.viewUsers);

        viewUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent userIntent = new Intent(getApplicationContext(), UserActivity.class);
                startActivity(userIntent);
            }
        });

        viewProjectsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ProjectActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void updateProfile()
    {
        User profile = UserRepository.getUserOfId(getApplicationContext(), 0);
        userName.setText("Hi, "+profile.getName());
        userId.setText(profile.getLoginId());
        email.setText(profile.getEmail());
        projects.setText(profile.getProjects().size()+" Projects");
    }
}

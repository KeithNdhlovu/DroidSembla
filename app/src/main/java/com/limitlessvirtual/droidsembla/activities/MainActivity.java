package com.limitlessvirtual.droidsembla.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.limitlessvirtual.droidsembla.R;
import com.limitlessvirtual.droidsembla.models.Project;
import com.limitlessvirtual.droidsembla.models.User;
import com.limitlessvirtual.droidsembla.repository.ProjectRepository;
import com.limitlessvirtual.droidsembla.repository.UserRepository;


import java.util.UUID;

public class MainActivity extends Activity {
    private Button startDroid;
    private Button skipSync;
    private ProgressDialog pDialog;
    private User owner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        startDroid = (Button) this.findViewById(R.id.startDroidBtn);
        skipSync = (Button) this.findViewById(R.id.skipSync);

        pDialog = new ProgressDialog(MainActivity.this);
        pDialog.setMessage("Loading the DroidSembla ....");

        skipSync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent);
            }
        });
        startDroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pDialog.show();

                createRandomUser();
                createRandomProject();

                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent);

                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void createRandomUser() {

        for(int i=0; i < 5; i++) {

            User user = new User();
            user.setId((long) i);
            user.setLoginId(String.valueOf(UUID.randomUUID()));
            user.setName("kevin" + i);

            //Make the 1st person inserted int the DB the owner of the app
            if(i == 0)
                user.setType("Owner");
            else
                user.setType("Normal");

            user.setEmail(user.getName()+"@example.com");
            UserRepository.insertOrUpdate(MainActivity.this, user);
        }

    }

    private void createRandomProject() {

        owner = UserRepository.getUserOfId(MainActivity.this, 0);

        for(int i=0; i < 5; i++) {

            Project project = new Project();
            project.setId((long) i);
            project.setName("Project: " + i);
            project.setDescription("This is a Project Descroption #" + i);

            project.setUserId(owner.getId());
            // project.setUser(owner);
            ProjectRepository.insertOrUpdate(getApplicationContext(), project);

            pDialog.dismiss();
        }

    }
}

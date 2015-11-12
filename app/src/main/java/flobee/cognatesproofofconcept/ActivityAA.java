package flobee.cognatesproofofconcept;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityAA extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.starting_activity);
    final ImageView indigoDot = (ImageView)findViewById(R.id.indigo_dot);
    setupWindowAnimations();
    indigoDot.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent i = new Intent(ActivityAA.this, ActivityBB.class);

        View sharedView = indigoDot;

        ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(ActivityAA.this, sharedView, "dot_transition");
        startActivity(i, transitionActivityOptions.toBundle());
      }
    });
    final TextView bottomText = (TextView)findViewById(R.id.bottom_text);
    bottomText.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent i = new Intent(ActivityAA.this, ActivityBB.class);

        View sharedView = indigoDot;

        ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(ActivityAA.this, sharedView, "dot_transition");
        startActivity(i, transitionActivityOptions.toBundle());
      }
    });
  }

  private void setupWindowAnimations() {
    // Re-enter transition is executed when returning to this activity
    Slide slideTransition = new Slide();
    slideTransition.setSlideEdge(Gravity.LEFT);
    slideTransition.setDuration(600);
    getWindow().setReenterTransition(slideTransition);
    getWindow().setExitTransition(slideTransition);
  }



  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}

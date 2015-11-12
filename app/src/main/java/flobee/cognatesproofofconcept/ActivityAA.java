package flobee.cognatesproofofconcept;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ActivityAA extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.starting_activity);
    final TextView startingTopTextView = (TextView)findViewById(R.id.starting_top);
    setupWindowAnimations();
    startingTopTextView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent i = new Intent(ActivityAA.this, ActivityBB.class);

        View sharedView = startingTopTextView;

        ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(ActivityAA.this, sharedView, "transition_from_top_to_bottom");
        startActivity(i, transitionActivityOptions.toBundle());
      }
    });
  }

  private void setupWindowAnimations () {
    //Fade fade = new Fade();
    //fade.setDuration(5000);
    //getWindow().setSharedElementEnterTransition(fade);
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

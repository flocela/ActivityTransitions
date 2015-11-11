package flobee.cognatesproofofconcept;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.util.Log;
import android.view.Gravity;
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

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(ActivityAA.this);
        Intent i = new Intent(ActivityAA.this, ActivityBB.class);

        //View sharedView = startingTopTextView;

        //ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(ActivityAA.this, sharedView, "transition_from_top_to_bottom");
        startActivity(i, options.toBundle());
      }
    });
  }

  private void setupWindowAnimations() {
    Slide slideLeft = new Slide();
    slideLeft.setDuration(500);
    slideLeft.setSlideEdge(Gravity.LEFT);
    getWindow().setExitTransition(slideLeft);

    Slide slideRight = new Slide();
    slideRight.setDuration(500);
    slideRight.setSlideEdge(Gravity.RIGHT);
    getWindow().setReturnTransition(slideRight);

    Fade fade = new Fade();
    fade.setDuration(1000);
    getWindow().setEnterTransition(fade);
    getWindow().setReenterTransition(fade);

    Log.i("TAG", "in AA: enterTransition:   " + getWindow().getEnterTransition());
    Log.i("TAG", "in AA: ReenterTransition: " + getWindow().getReenterTransition());
    Log.i("TAG", "in AA: ExitTransition:    " + getWindow().getExitTransition());
    Log.i("TAG", "in AA: ReturnTranstion:   " + getWindow().getReturnTransition());
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

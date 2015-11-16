package flobee.cognatesproofofconcept;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;

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
  }

  private void setupWindowAnimations() {
    // Re-enter transition is executed when returning to this activity
    Slide slideTransition = new Slide();
    slideTransition.setSlideEdge(Gravity.LEFT);
    slideTransition.setDuration(500);
    getWindow().setReenterTransition(slideTransition);
    getWindow().setExitTransition(slideTransition);
  }

}

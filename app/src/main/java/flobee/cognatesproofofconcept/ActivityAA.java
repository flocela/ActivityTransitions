package flobee.cognatesproofofconcept;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Slide;
import android.util.Pair;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;

public class ActivityAA extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.aa_layout);
    final ImageView indigoDot = (ImageView)findViewById(R.id.indigo_dot);
    setupWindowAnimations();
    indigoDot.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent i = new Intent(ActivityAA.this, ActivityBB.class);
        ActivityOptions transitionActivityOptions =
          ActivityOptions.makeSceneTransitionAnimation(
            ActivityAA.this,
            new Pair<View, String>(indigoDot, "dot_transition"));
        startActivity(i, transitionActivityOptions.toBundle());
      }
    });
  }

  private void setupWindowAnimations() {
    Slide slideTransition = new Slide();
    slideTransition.setSlideEdge(Gravity.LEFT);
    slideTransition.setDuration(500);
    slideTransition.excludeTarget(android.R.id.statusBarBackground, true);
    slideTransition.excludeTarget(android.R.id.navigationBarBackground, true);
    slideTransition.excludeTarget(getResources().
      getIdentifier("action_bar_container", "id", "android"), true);
    getWindow().setEnterTransition(slideTransition);
    getWindow().setExitTransition(slideTransition);
  }

}

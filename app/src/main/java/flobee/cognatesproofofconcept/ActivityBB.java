package flobee.cognatesproofofconcept;

import android.animation.Animator;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityBB extends Activity {

  private Interpolator interpolator;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.ending_activity);
    final TextView endingBottomTextView = (TextView)findViewById(R.id.more_info_from_bottom);
    setupWindowAnimations();
    endingBottomTextView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent i = new Intent(ActivityBB.this, ActivityAA.class);

        View sharedView = endingBottomTextView;

        ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(ActivityBB.this, sharedView, "transition_from_top_to_bottom");
        startActivity(i, transitionActivityOptions.toBundle());
      }
    });
  }

  private void setupWindowAnimations() {
    interpolator = AnimationUtils.loadInterpolator(this, android.R.interpolator.linear_out_slow_in);
    setupEnterAnimations();
    setupExitAnimations();
  }


  private void setupEnterAnimations () {
    Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.changebounds_with_arcmotion);
    getWindow().setSharedElementEnterTransition(transition);
    transition.addListener(new Transition.TransitionListener() {
      @Override
      public void onTransitionEnd(Transition transition) {
        transition.removeListener(this);
        ImageView circle = (ImageView) findViewById(R.id.top_dot);
        View rootView = findViewById(R.id.root_view);
        animateRevealShow(rootView, circle);
      }

      @Override
      public void onTransitionStart(Transition transition) {
      }

      @Override
      public void onTransitionCancel(Transition transition) {
      }

      @Override
      public void onTransitionPause(Transition transition) {
      }

      @Override
      public void onTransitionResume(Transition transition) {
      }

    });
  }

  private void setupExitAnimations() {
    Fade returnTransition = new Fade();
    getWindow().setReturnTransition(returnTransition);
    returnTransition.setDuration(300);
    returnTransition.setStartDelay(300);
    returnTransition.addListener(new Transition.TransitionListener() {
      @Override
      public void onTransitionStart(Transition transition) {
        transition.removeListener(this);
      }

      @Override
      public void onTransitionEnd(Transition transition) {
      }

      @Override
      public void onTransitionCancel(Transition transition) {
      }

      @Override
      public void onTransitionPause(Transition transition) {
      }

      @Override
      public void onTransitionResume(Transition transition) {
      }
    });
  }




  private void animateRevealShow(View rootView, View circle) {
    int cx = (circle.getLeft() + circle.getRight())/2;
    int cy = (circle.getTop() + circle.getBottom())/2;
    int finalRadius = Math.max(rootView.getWidth(), rootView.getHeight());

    Animator anim = ViewAnimationUtils.createCircularReveal(rootView, cx, cy, 0, finalRadius);
    rootView.setVisibility(View.VISIBLE);
    anim.setDuration(1000);
    anim.setInterpolator(new AccelerateInterpolator());
    anim.start();
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

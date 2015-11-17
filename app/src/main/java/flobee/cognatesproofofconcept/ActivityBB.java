package flobee.cognatesproofofconcept;

import android.animation.Animator;
import android.app.Activity;
import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateInterpolator;

public class ActivityBB extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.bb_layout);
    setupWindowAnimations();
  }

  private void setupWindowAnimations() {
    setupEnterAnimations();
    setupExitAnimations();
  }

  private void setupEnterAnimations () {
    /*Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.changebounds_with_arcmotion);
    getWindow().setSharedElementEnterTransition(transition);
    transition.addListener(new Transition.TransitionListener() {
      @Override
      public void onTransitionEnd(Transition transition) {
       transition.removeListener(this);
       ImageView dot = (ImageView) findViewById(R.id.top_dot);
       View rootView = findViewById(R.id.root_view);
       animateRevealShow(rootView, dot);
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
    });*/
  }

  private void setupExitAnimations() {
    Fade returnTransition = new Fade();
    returnTransition.setDuration(500);
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

}

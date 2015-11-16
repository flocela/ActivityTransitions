package flobee.cognatesproofofconcept;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StartActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.start);
    final TextView yellowTextView  = (TextView)findViewById(R.id.yellow);
    final TextView blueTextView    = (TextView)findViewById(R.id.blue);
    setupWindowAnimations();
    yellowTextView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent i = new Intent(StartActivity.this, EndActivity.class);
        startActivity(i);
      }
    });
  }

  private void setupWindowAnimations () {
    /*Slide slideLeft = new Slide();
    slideLeft.setDuration(500);
    slideLeft.setSlideEdge(Gravity.LEFT);
    getWindow().setEnterTransition(slideLeft);
    getWindow().setExitTransition(slideLeft);
    */
    /*(slideLeft.excludeTarget(android.R.id.statusBarBackground, true);
    slideLeft.excludeTarget(android.R.id.navigationBarBackground, true);
    slideLeft.excludeTarget(getResources().getIdentifier("action_bar_container", "id", "android"), true);*/

  }
}

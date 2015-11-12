package flobee.cognatesproofofconcept;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Slide;
import android.view.View;
import android.widget.TextView;

public class StartActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.start_ex2);
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
    Slide slide = new Slide();
    slide.setDuration(3000);
    getWindow().setExitTransition(slide);
  }
}

package flobee.cognatesproofofconcept;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.widget.TextView;

public class EndActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.end_ex2);
    final TextView yellowTextView = (TextView)findViewById(R.id.yellow);
    final TextView blueTextView   = (TextView)findViewById(R.id.blue);
    setupWindowAnimations();
    yellowTextView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent i = new Intent(EndActivity.this, StartActivity.class);
        startActivity(i);
      }
    });
  }

  private void setupWindowAnimations () {
    Fade fade = new Fade();
    fade.setDuration(3000);
    getWindow().setEnterTransition(fade);
  }
}

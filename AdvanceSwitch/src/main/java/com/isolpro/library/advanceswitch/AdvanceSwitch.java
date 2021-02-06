package com.isolpro.library.advanceswitch;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;

public class AdvanceSwitch extends SwitchCompat {

  private boolean toHandleOnChange = true;

  public AdvanceSwitch(@NonNull Context context) {
    super(context);
  }

  public AdvanceSwitch(@NonNull Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public AdvanceSwitch(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  public void setCheckedManually(boolean checked) {
    if (isChecked() != checked) toHandleOnChange = false;
    super.setChecked(checked);
  }

  public void toggleManually() {
    setCheckedManually(!isChecked());
  }

  public void setOnCheckedChangeListener(@Nullable OnCheckedChangeListener listener) {
    super.setOnCheckedChangeListener((buttonView, isChecked) -> {
      if (toHandleOnChange && listener != null)
        listener.onCheckedChanged(buttonView, isChecked);

      toHandleOnChange = true;
    });
  }
}

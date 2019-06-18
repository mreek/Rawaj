package
        customfonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public
class
TextViewSFProDisplayBold
extends
android.support.v7.widget.AppCompatTextView
{




public
TextViewSFProDisplayBold(Context
context,
AttributeSet
attrs,
int
defStyle)
{








super(context,
attrs,
defStyle);








init();




}





public
TextViewSFProDisplayBold(Context
context,
AttributeSet
attrs)
{








super(context,
attrs);








init();




}





public
TextViewSFProDisplayBold(Context
context)
{








super(context);








init();




}





private
void
init()
{








if
(!isInEditMode())
{












setTypeface(Typeface.createFromAsset(getContext().getAssets(),
"fonts/ride_rewrite_bungee.ttf"));








}




}
}
